/*Import Junit test.
 */
import static org.junit.Assert.*;
import org.junit.Test;

import javax.swing.*;

public class TestArrayDequeGold {

    @Test
    public void testRandomly() {
        /**
         * @source: StudentArrayDequeLauncher.java
         */
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();
        StringBuilder steps = new StringBuilder();
        for (int i = 0; i < 100; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                sol1.addLast(i);
                steps.append("addLast(").append(i).append(")\n");
                int actual = sad1.get(sad1.size() - 1);
                int expected = sol1.get(sad1.size() - 1);
                assertEquals(steps.toString(), expected, actual);
            } else if (numberBetweenZeroAndOne < 0.5 && numberBetweenZeroAndOne > 0.25) {
                sad1.addFirst(i);
                sol1.addFirst(i);
                steps.append("addFirst(").append(i).append(")\n");
                int actual = sad1.get(0);
                int expected = sol1.get(0);
                assertEquals(steps.toString(), expected, actual);
            } else if (numberBetweenZeroAndOne < 0.75 && numberBetweenZeroAndOne > 0.5) {
                if (sol1.size() != 0) {
                    //sad1.removeFirst();
                    //sol1.removeFirst();
                    int actual = sad1.removeFirst();
                    int expected = sol1.removeFirst();
                    steps.append("removeFirst()\n");
                    assertEquals(steps.toString(), expected, actual);
                } else {
                    sad1.addFirst(i);
                    sol1.addFirst(i);
                    steps.append("addFirst(").append(i).append(")\n");
                    int actual = sad1.get(0);
                    int expected = sol1.get(0);
                    assertEquals(steps.toString(), expected, actual);
                }
            } else {
                if (sol1.size() != 0) {
                    int actual = sad1.removeLast();
                    int expected = sol1.removeLast();
                    steps.append("removeLast()\n");
                    assertEquals(steps.toString(), expected, actual);
                } else {
                    sad1.addLast(i);
                    sol1.addLast(i);
                    steps.append("addLast(").append(i).append(")\n");
                    int actual = sad1.get(sad1.size() - 1);
                    int expected = sol1.get(sol1.size() - 1);
                    assertEquals(steps.toString(), expected, actual);
                }
            }
        }
    }
}
