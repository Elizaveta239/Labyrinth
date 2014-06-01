/**
 * Reader.java
 *
 * Read labyrinth from file.
 *
 * Created by Elizabeth Shashkova
 */

import java.io.*;
import java.util.Scanner;

public class Reader {

    private Scanner in;
    private String fileIn;

    public Lab readLab() throws Exception {
        try {
            int w = in.nextInt();
            if (w <= 0) {
                throw new Exception();
            }
            int h = in.nextInt();
            if (h <= 0) {
                throw new Exception();
            }
            int start_x = in.nextInt() - 1;
            int start_y = in.nextInt() - 1;
            Point ps = new Point(start_x, start_y, 0, null);
            int finish_x = in.nextInt() - 1;
            int finish_y = in.nextInt() - 1;
            Point pf = new Point(finish_x, finish_y, w * h, null);
            boolean[][] f = new boolean[h][w];
            for (int i = 0; i < h; ++i) {
                String s = in.next();
                for (int j = 0; j < w; ++j) {
                    char c = s.charAt(j);
                    if (c == '1') {
                        f[i][j] = true;
                    } else if (c != '0') {
                        throw new IOException();
                    }
                }
            }
            return new Lab(w, h, f, ps, pf);
        } catch (Exception e) {
            throw new IOException("Wrong input file format\n", e);
        }
    }

    Reader(String fileName) throws IOException {
        try {
            fileIn = fileName;
            in = new Scanner(new File(fileIn));
        } catch (IOException e) {
            throw new IOException("File not found\n", e);
        }
    }

}
