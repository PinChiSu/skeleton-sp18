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
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                sad1.addLast(i);
                sol1.addLast(i);
                steps.append("addLast(").append(i).append(")\n");
                int actual = sad1.removeLast();
                int expected = sol1.removeLast();
                assertEquals(steps.toString(), expected, actual);
                sad1.addLast(i);
                sol1.addLast(i);
            } else if (numberBetweenZeroAndOne < 0.5 && numberBetweenZeroAndOne > 0.25) {
                sad1.addFirst(i);
                sol1.addFirst(i);
                steps.append("addFirst(").append(i).append(")\n");
                int actual = sad1.removeFirst();
                int expected = sol1.removeFirst();
                assertEquals(steps.toString(), expected, actual);
                sad1.addFirst(i);
                sol1.addFirst(i);
            } else if (numberBetweenZeroAndOne < 0.75 && numberBetweenZeroAndOne > 0.5) {
                if (sol1.size() != 0) {
                    //sad1.removeFirst();
                    //sol1.removeFirst();
                    int actual = sad1.removeFirst();
                    int expected = sol1.removeFirst();
                    steps.append("removeFirst()\n");
                    assertEquals(steps.toString(), expected, 25);
                } else {
                    sad1.addFirst(i);
                    sol1.addFirst(i);
                    steps.append("addFirst(").append(i).append(")\n");
                    int actual = sad1.removeFirst();
                    int expected = sol1.removeFirst();
                    assertEquals(steps.toString(), expected, actual);
                    sad1.addFirst(i);
                    sol1.addFirst(i);
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
                    int actual = sad1.removeLast();
                    int expected = sol1.removeLast();
                    assertEquals(steps.toString(), expected, actual);
                    sad1.addLast(i);
                    sol1.addLast(i);
                }
            }
        }
    }

}