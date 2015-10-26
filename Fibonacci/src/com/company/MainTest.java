package com.company;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sslebedev on 26.10.2015.
 */
public class MainTest {

    final int[] sequenceSample = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946};
    final int Count = sequenceSample.length;
    final int[] sequenceTest = new int[Count];


    @Test
    public void testFibDynamic(){
        System.out.println("testFibDynamic()");
        Arrays.parallelSetAll(sequenceTest, Main::FibDynamic); // IntUnaryOperator
        assert(Arrays.equals(sequenceSample, sequenceTest));
    }

    @Test
    public void testFibFunctional(){
        System.out.println("testFibFunctional()");
        Arrays.parallelSetAll(sequenceTest, Main::FibFunctional); // IntUnaryOperator
        assert(Arrays.equals(sequenceSample, sequenceTest));
    }

    @Test
    public void testFibMatrix() throws Exception {
        System.out.println("testFibMatrix()");
        Arrays.parallelSetAll(sequenceTest, Main::FibMatrix); // IntUnaryOperator
        assert(Arrays.equals(sequenceSample, sequenceTest));
    }
}