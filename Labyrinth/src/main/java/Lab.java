/**
 * Lab.java
 *
 * Class for labyrinth.
 *
 * Created by Elizabeth Shashkova
 */

public class Lab {
    boolean[][] field;
    boolean[][] answer;
    int width;
    int height;
    Point start;
    Point finish;

    void showLab() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (field[i][j]) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    void showLabWithAnswer() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (field[i][j]) {
                    System.out.print(1);
                } else {
                    if (answer[i][j]) {
                        System.out.print('*');
                    } else {
                        System.out.print(0);
                    }
                }
            }
            System.out.println();
        }
    }

    Lab(int w, int h, boolean[][] f, Point st, Point fin) {
        width = w;
        height = h;
        field = f;
        start = st;
        finish = fin;
    }

    public void setAnswer(boolean[][] ans) {
        answer = ans;
    }
}
