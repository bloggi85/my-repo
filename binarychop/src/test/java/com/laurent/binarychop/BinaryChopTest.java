package com.laurent.binarychop;

import com.sun.xml.internal.fastinfoset.util.ValueArray;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: laurent
 * Date: 6/25/11
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryChopTest extends TestCase {

    private int[] sortedArray;
    private BinaryChop binaryChop;

    @Test
    public void testSmallestValue() {
        initialiseBinaryChop();
        int index = binaryChop.search(sortedArray, 0);

        assertEquals(0, index);
    }

    @Test
    public void testGreatestValue() {
        initialiseBinaryChop();
        int index = binaryChop.search(sortedArray, 100);

        assertEquals(10, index);
    }


    @Test
    public void testMedianValue() {
        initialiseBinaryChop();
        int index = binaryChop.search(sortedArray, 50);

        assertEquals(5, index);
    }

    @Test
    public void testSecondLowestValue() {
        initialiseBinaryChop();
        int index = binaryChop.search(sortedArray, 30);

        assertEquals(3, index);
    }


    public void testAllValues() {
        initialiseBinaryChop();

        for (int i = 0; i < sortedArray.length; i++) {
            int[] testArray = Arrays.copyOf(sortedArray, sortedArray.length);
            int index = binaryChop.search(testArray, testArray[i]);

            assertEquals(i, index);

        }
    }


    private void initialiseBinaryChop() {
        binaryChop = new IterativeBinaryChop();
        sortedArray = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    }
}
