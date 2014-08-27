package alg.intro;

import java.util.Scanner;

/**
 * InsertionSort.java
 * Uses insertion alogrithm to sort an array.
 * InsertionSort is sorted in place.
 * @param array the array to sort
 * @return the array should be sorted in nondeceased order.
 */

public class InsertionSort {
    
    private final int LIMIT = 100;
    private int[] array;

    /**
     * Reads input from the command, terminates by a 0.
     * The maximize input is limited to 100.
     */
    public InsertionSort() {
        int[] array = new int[LIMIT];
        Scanner scanner = new Scanner(System.in);
        int i = 0;

        System.out.println("Please input the array: (terminated by 0)");
        while(i < LIMIT) {
            int input = scanner.nextInt();
            if(input == 0) {
                break;
            }
            array[i] = input;
            ++i;
        }

        System.out.print("Input: ");
        this.array = new int[i];
        for(int j = 0; j < i; j++) {
            this.array[j] = array[j];
            System.out.print(this.array[j] + " ");
        }
        System.out.println();
    }

    public void sort() {
        for(int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i - 1;
            while((j >= 0) && array[j] > k) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = k;
        }
    }

    public void print() {
        System.out.print("Sorted: ");
        for(int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        sort.sort();
        sort.print();
    }

}
