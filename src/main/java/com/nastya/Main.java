package com.nastya;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;


public class Main {
    public static int[] array = { 1 , 2 , 4 , 4 , 2 , 3 , 4 , 1 , 7 };
    public static int[] array1 = { 1 , 1 , 1 , 4 , 4 , 1 , 4 , 4 };

    public static void main ( String[] args ) {

        firstArray ( array );
        secondArray ( array1 );
        System.out.println (secondArray ( array1 ) );

    }

    public static int[] firstArray ( int @NotNull [] arr ) {
        int indicator = 0;
        int[] arrayNew = new int[0];
        for ( int i = arr.length - 1 ; i >= 0 ; i-- ) {
            if ( arr[ i ] == 4 ) {
                arrayNew = new int[ arr.length - i - 1 ];
                for ( int a = 0 ; a < arrayNew.length ; a++ ) {
                    arrayNew[ a ] = arr[ i + 1 ];
                    i++;
                }
                System.out.println ( Arrays.toString ( arrayNew ) );
                return arrayNew;
            }



        }
        if ( indicator == 0 ) {
            throw new RuntimeException ( );}


        return arrayNew;
    }

    public static boolean secondArray ( int @NotNull [] arr1 ) {
        int count1 = 0;
        int count4 = 0;
        for ( int i : arr1 ) {
            if ( i != 1 && i != 4 ) {
                return false;
            }
            if ( i == 1 ) {
                count1++;
            }
            if ( i == 4 ) {
                count4++;

            }
        }
           // return count1==4 &&count4==4 ; //если в задании имеется в виду количество четверок и единиц
          return count1!=0 &&count4!=0 ; //если в задании имеется в виду, что массив должен состоять только из  четверок и единиц

    }

}

