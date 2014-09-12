package alg.intro;

import alg.intro.Sort;
import alg.intro.Search;

import java.util.Scanner;

public class Mainer {

    private static final int LIMIT = 100;

    private static int scanInt() {
        System.out.println("Please input an integer: ");
        int value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextInt();
        return value;
    }

    private static int[] scanArray() {

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

        int[] retArray = new int[i];
        for(int j = 0; j < i; j++) {
            retArray[j] = array[j];
        }

        return retArray;
    }

    private static void printArray(int[] array) {

        for(int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        System.out.println("Running InsertionSort.");

        int[] array = scanArray();
        System.out.print("Input: ");
        printArray(array);
        Sort.insertionSort(array);
        System.out.print("Sorted: ");
        printArray(array);
        
        System.out.println("Running MergeSort.");

        array = scanArray();
        System.out.print("Input: ");
        printArray(array);
        Sort.mergeSort(array);
        System.out.print("Sorted: ");
        printArray(array);

        // search from array
        int target = scanInt();
        System.out.print("Searching " + target + " from array ");
        printArray(array);
        int pos = Search.binarySearch(array, 0, array.length - 1, target);
        System.out.print(target + " is at position " + pos + " of array ");
        printArray(array);
    }

}
