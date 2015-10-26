package com.company;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sslebedev on 26.10.2015.
 */
public class MainTest extends TestCase {

    final int[] sequenceSample = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946};
    final int Count = sequenceSample.length;
    final int[] sequenceDynamic = new int[Count];


    @Test
    public void testFibDynamic(){
        Arrays.parallelSetAll(sequenceDynamic, n -> Main.FibDynamic(n)); // IntUnaryOperator
        assert(Arrays.equals(sequenceSample, sequenceDynamic));
    }

    @Test
    public void testFibFunctional(){
        Arrays.parallelSetAll(sequenceDynamic, n -> Main.FibFunctional(n)); // IntUnaryOperator
        assert(Arrays.equals(sequenceSample, sequenceDynamic));
    }
}