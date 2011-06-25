package com.laurent.binarychop;

import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.xml.internal.fastinfoset.util.ValueArray;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: laurent
 * Date: 6/25/11
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class IterativeBinaryChop implements BinaryChop {
    @Override
    public int search(int[] sortedArray, int searchParameter) {

        int startIndex = sortedArray.length / 2;
        int base =0;
        int actualIndex = 0;
        while (sortedArray.length > 1) {

            if (searchParameter < sortedArray[startIndex]) {
                sortedArray = Arrays.copyOfRange(sortedArray, 0, startIndex);
                startIndex = sortedArray.length / 2;
                actualIndex = base + startIndex;

            } else if (searchParameter > sortedArray[startIndex]) {
                sortedArray = Arrays.copyOfRange(sortedArray, startIndex + 1, sortedArray.length);

                base = startIndex;
                startIndex = sortedArray.length / 2;
                actualIndex = base + startIndex;

            } else if (searchParameter == sortedArray[startIndex]) {
                return actualIndex;
            }
        }
        return actualIndex;
    }
}
