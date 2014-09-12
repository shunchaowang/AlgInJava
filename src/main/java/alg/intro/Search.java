package alg.intro;

import java.util.Scanner;

/**
 * Class for search methods.
 */
public class Search {
    
    /**
     * Binary Search.
     * @param array search target
     * @param l lower index of array for search
     * @param h higher index of array for search
     * @param v the element searched

     * @return index of the target, -1 if not found
     */
    public static int binarySearch(int[] array, int l, int h, int v) {
        
        if(l > h) {
            return -1;
        }

        int mid = (l + h) / 2;
        if(v == array[mid]) {
            return mid;
        }
        else if(v < array[mid]) {
            return binarySearch(array, l, mid - 1, v);
        }
        else if(v > array[mid]) {
            return binarySearch(array, mid + 1, h, v);
        }
        return -1;
    }

}
