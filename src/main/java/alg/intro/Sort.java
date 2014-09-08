package alg.intro;

import java.util.Scanner;

/**
 * SortCombo.java
 * Sort an array using insertion sort, merge sort and quick sort.
 * InsertionSort is sorted in place.
 * Merge sort is not sorted in place.
 */

public class Sort {
    
    private final int LIMIT = 100;
    private int[] array;

    /**
     * Reads input from the command, terminates by a 0.
     * The maximize input is limited to 100.
     */
    public Sort() {
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

    /**
     * Insertion sort.
     */
    public void insertionSort() {
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

    /**
     * Merge sort this class.
     */
    public void mergeSort() {
        int l = 0;
        int h = array.length - 1;
        mergeSorting(array, l, h);
    }

    /**
     * Merge sorting.
     * @param l lower index
     * @param h higher index
     * Recursive sorting.
     * If l < h, recursively sorting array[l, (l+h)/2] and 
     * array[(l+h)/2 + 1, h].
     */
    private void mergeSorting(int[] array, int l, int h) {
        // binary search
        int m = (l + h)/2;
        if(l < m) {
            mergeSorting(array, l, m);
            mergeSorting(array, m + 1, h);
        }
        merge(array, l, m, h);
    }

    /**
     * Merge two already sorted array, array[l-m] and array[m+1, h].
     * l <= m < h
     * @param array the targeted array
     * @param l lower index
     * @param m medium index
     * @param h higher index
     */
    private void merge(int[] array, int l, int m, int h) {

        // if m >=h just copy lower part to the result
        // this must be checked!
        if (m >= h || l > m) {
            return;
        }
        // two arrays needs to be created to store the 
        // element of array[l..m] to left one and
        // elements of array[m+1..h] to right one
        // the size of each should be 1 more than normal size to store
        // the maximize element to avoid check if the array is reaching
        // end position
        int lSize = m - l + 1 + 1;
        int rSize = h - m + 1;
        int[] left = new int[lSize];
        int[] right = new int[rSize];
        // copy array[l..m] to left and array[m+1..h] to right
        for(int i = 0; i < lSize-1; i++) {
            left[i] = array[l + i];
        }
        for(int i = 0; i < rSize - 1; i++) {
            right[i] = array[m + 1 + i];
        }

        // make the last element to be the biggest on both left and right
        int max = left[lSize - 2] > right[rSize - 2] ?
            left[lSize - 2] : right[rSize - 2];
        left[lSize - 1] = right[rSize - 1] = max;

        // merge two array
        int lIndex = 0;
        int rIndex = 0;
        for(int i = 0; i < h - l + 1; i++){
            if(left[lIndex] < right[rIndex]) {
                array[l + i] = left[lIndex];
                lIndex++;
            } else {
                array[l + i] = right[rIndex];
                rIndex++;
            }
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
        System.out.println("Running InsertionSort.");
        Sort sort = new Sort();
        sort.insertionSort();
        sort.print();
        System.out.println("Running MergeSort.");
        sort = new Sort();
        sort.mergeSort();
        sort.print();
    }

}
