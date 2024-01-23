package org.example;

public class Main {
    public static void main(String[] args) {

        /**
         * 1. Написать метод, возвращающий количество чётных элементов массива.
         * countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
         *  2. Написать функцию, возвращающую разницу между самым большим
         * и самым маленьким элементами переданного не пустого массива.
         * 3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента,
         * с нулевым значением.
         */


        int[] array1 = {2, 1, 2, 3, 4};
        int[] array2 = {2, 0, 2};
        int[] array3 = {1, 3, 5};

        System.out.println("Counting evens numbers method: ");
        System.out.println(countEvens(array1));
        System.out.println(countEvens(array2));
        System.out.println(countEvens(array3));
        System.out.println();
        System.out.println("Different between max and min number: ");
        System.out.println(difMinMax(new int[] {1, 5, 8, 10}));
        System.out.println(difMinMax(new int [] {12, 0, 1, -6}));
        System.out.println();
        System.out.println("Method, checking 2 zeros in pair: ");
        System.out.println(isDoubleZero(new int[] {1, 0, 0, 5, 6, 7}));
        System.out.println(isDoubleZero(new int[] {1, 2, 3, 4, 0}));




    }

    private static boolean isDoubleZero(int[] array) {
        boolean isDoubleZero = false;
        for (int i = 0; i < array.length -1; i++) {
            if(array[i]==0 && array[i+1]==0) {
                isDoubleZero=true;
                break;
            }
        }
        return isDoubleZero;
    }

    private static int difMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]<min) min = array[i];
            if(array[i]>max) max = array[i];
        }
        return max-min;
    }

    private static int countEvens(int[] array) {
        int count = 0;
        for (int num: array
             ) {
            if(num%2==0) count++;
        }
        return count;
    }
}