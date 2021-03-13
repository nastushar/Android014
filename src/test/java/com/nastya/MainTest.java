package com.nastya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void init () {
        Main main = new Main ( );
    }

    private static Stream<Arguments> trueFirstArray() {
        List<Arguments> data = new ArrayList<> ();
        data.add( Arguments.arguments(new int[] {1, 2, 3,4,5,6,7,8,9}, new int[] {5,6,7,8,9}));
        data.add(Arguments.arguments(new int[] {9,8,7,6,5,4,3,2,1}, new int[] {3,2,1}));
        data.add(Arguments.arguments(new int[] {2,2,2,2,2,2,2,2,2,4,4,4,1,1,1,1,1,1}, new int[] {1,1,1,1,1,1}));
        data.add(Arguments.arguments(new int[] {1, 2,3,4,5}, new int[] {5}));
        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("trueFirstArray")
    void trueFirstArrayTest (int[] arr1 , int[] arr2) {
        Assertions.assertArrayEquals ( arr2, main.firstArray ( arr1) );
    }


    private static Stream<Arguments> falseFirstArray() {
        List<Arguments> data = new ArrayList<> ();
        data.add( Arguments.arguments(new int[] {1, 2, 3,4,5,6,7,8,9}, new int[] {1, 2, 3}));
        data.add(Arguments.arguments(new int[] {9,8,7,6,5,4,3,2,1}, new int[] {4,3,2,1}));
        data.add(Arguments.arguments(new int[] {2,2,2,2,2,2,2,2,2,4,4,4,1,1,1,1,1,1}, new int[] {4,4,1,1,1,1,1,1}));
        data.add(Arguments.arguments(new int[] {1, 2,3,4,5}, new int[] {3,4}));
        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("falseFirstArray")
    void falseFirstArrayTest (int[] arr1 , int[] arr2) {
        Assertions.assertArrayEquals ( arr2, main.firstArray ( arr1) );
    }

    
    private static Stream<Arguments> trueSecondArray() {
        List<Arguments> data = new ArrayList<> ();
        data.add( Arguments.arguments(new int[] {1,4,4,4,4,4,4}, true));
        data.add(Arguments.arguments(new int[] {1,4,1,4,1,4,1,4,4,1}, true));
        data.add(Arguments.arguments(new int[] {4,4,4,4,4,4,4,4,4,1,1,1,1,1,1}, true));
        data.add(Arguments.arguments(new int[] {4,4,4,4,4,4,4,4,1}, true));
        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("trueSecondArray")
    void trueSecondArray (int[] arr1 , boolean result) {
        Assertions.assertEquals ( result, main.secondArray (arr1) );
    }



    private static Stream<Arguments> falseSecondArray() {
        List<Arguments> data = new ArrayList<> ();
        data.add( Arguments.arguments(new int[] {2,2,2,2,2,2,2}, false));
        data.add(Arguments.arguments(new int[] {4,4,4,4,4,4,4},false));
        data.add(Arguments.arguments(new int[] {1,1,1,1,1,1},false));
        data.add(Arguments.arguments(new int[] {1, 2,4,4,4,1,1,1,1},false));
        return data.stream();
    }

    @ParameterizedTest
    @MethodSource("falseSecondArray")
    void falseSecondArrayTest (int[] arr1 , boolean result) {
        Assertions.assertEquals ( result, main.secondArray (arr1) );
    }
}