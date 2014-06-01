/**
 * Main.java
 *
 * Main class to solve labyrinth problem.
 *
 * Created by Elizabeth Shashkova
 */


public class Main {

    public static int solveLab(String fileName, boolean showInfo) {
        try {
            int ans;
            if (showInfo) {
                Reader reader = new Reader(fileName);
                Lab labIn = reader.readLab();
                System.out.println("------------------");
                System.out.println("Input Labyrinth:");
                System.out.println("------------------");
                labIn.showLab();
                Solver solver = new Solver(labIn);
                ans = solver.solve();
                if (ans < 0) {
                    System.out.println("Finish point is not reachable from start point");
                } else {
                    System.out.println("-----------------------------");
                    System.out.print("The shortest path length: ");
                    System.out.println(ans);
                    System.out.println("The shortest path:");
                    System.out.println("-----------------------------");
                    labIn.setAnswer(solver.findPath());
                    labIn.showLabWithAnswer();
                }
            } else {
                Reader reader = new Reader(fileName);
                Lab labIn = reader.readLab();
                Solver solver = new Solver(labIn);
                ans = solver.solve();
            }
            return ans;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Problem solving failed\n");
            return 0;
        }
    }

    public static void main(String[] args) {
        solveLab("input/lab1.in", true);
    }

}
