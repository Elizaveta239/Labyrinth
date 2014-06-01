import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by elizabeth
 */


public class MainTest {

    static String testDir = "input/";
    static Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void solving1Test() throws Exception {
        int ans = Main.solveLab(testDir + "lab1.in", false);
        assertEquals(ans, 26);
    }

    @Test
    public void solving2Test() throws Exception {
        int ans = Main.solveLab(testDir + "lab2.in", false);
        assertEquals(ans, 19);
    }

    @Test
    public void solving3Test() throws Exception {
        int ans = Main.solveLab(testDir + "lab3.in", false);
        assertEquals(ans, 6);
    }

    @Test
    public void solving4Test() throws Exception {
        int ans = Main.solveLab(testDir + "lab4.in", false);
        assertEquals(ans, 26);
    }

    @Test
    public void solving5Test() throws Exception {
        int ans = Main.solveLab(testDir + "lab5.in", false);
        assertEquals(ans, -1);
    }
}