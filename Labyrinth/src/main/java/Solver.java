/**
 * Slover.java
 *
 * Class solve problem to find the shortest path from start point to finish point.
 *
 * Created by Elizabeth Shashkova
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point x, Point y) {
        if (x.dist < y.dist) {
            return -1;
        }
        if (x.dist > y.dist) {
            return 1;
        }
        return 0;
    }
}

class Point {
    int x;
    int y;
    int dist;
    Point prev;

    Point(int xIn, int yIn, int d, Point prevPoint) {
        x = xIn;
        y = yIn;
        dist = d;
        prev = prevPoint;
    }

    public boolean equals(Point other) {
        if ((x == other.x) && (y == other.y)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Solver {
    private Lab lab;
    private Point[][] answer;
    private boolean[][] pathAnswer;
    private Point start;
    private Point finish;
    private PriorityQueue<Point> q;
    private int w;
    private int h;
    private int[] xVal = {-1, 0, 0, 1};
    private int[] yVal = {0, -1, 1, 0};

    Solver(Lab l) throws IllegalArgumentException {
        try {
            lab = l;
            w = lab.width;
            h = lab.height;
            isBelongPoint("Start", lab.start);
            isEmpty("Start", lab.start);
            isBelongPoint("Finish", lab.finish);
            isEmpty("Finish", lab.finish);

            start = lab.start;
            finish = lab.finish;
            Comparator<Point> comp = new PointComparator();
            q = new PriorityQueue<Point>(5, comp);
            answer = new Point[h][w];

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void isBelongPoint(String s, Point p) throws IllegalArgumentException {
        if (!isBelong(p.x, p.y)) {
            throw new IllegalArgumentException(s + " point doesn't belong to field");
        }
    }

    private void isEmpty(String s, Point p) throws IllegalArgumentException {
        if (lab.field[p.y][p.x]) {
            throw new IllegalArgumentException(s + " point is wall");
        }
    }

    private boolean isBelong(int x, int y) {
        if ((x >= 0) && (x <= w - 1) && (y >= 0) && (y <= h - 1)) {
            return true;
        }
        return false;
    }

    private void addNeighbours(Point p) {
        int x = p.x;
        int y = p.y;
        for (int k = 0; k < 4; ++k) {
            int i = xVal[k];
            int j = yVal[k];
            int xNew = x + i;
            int yNew = y + j;
            if (isBelong(xNew, yNew) && (!lab.field[yNew][xNew])) {
                if (answer[yNew][xNew] == null) {
                    Point pNew = new Point(xNew, yNew, p.dist + 1, p);
                    answer[yNew][xNew] = pNew;
                    q.add(pNew);
                } else {
                    int distance = answer[yNew][xNew].dist;
                    if (distance > p.dist + 1) {
                        answer[yNew][xNew].dist = p.dist + 1;
                        answer[yNew][xNew].prev = p;
                    }
                }
            }
        }
    }

    public boolean[][] findPath() {
        pathAnswer = new boolean[h][w];
        Point p = answer[finish.y][finish.x];
        pathAnswer[finish.y][finish.x] = true;
        while (!p.equals(start)) {
            p = p.prev;
            pathAnswer[p.y][p.x] = true;
        }
        return pathAnswer;
    }

    public int solve() {
        answer[start.y][start.x] = start;
        q.add(start);
        while (!q.isEmpty()) {
            Point current = q.peek();
            q.remove(current);
            if (current.equals(finish)) {
                return current.dist;
            }
            addNeighbours(current);
        }
        return -1;
    }
}
