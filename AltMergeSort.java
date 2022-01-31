public class AltMergeSort {

    /** The size of the array to be generated for sorting. */
    private final static int ARRAY_SIZE = 16;
    /**
     * The maximum value of any of the elements in the array to be generated for
     * sorting.
     */
    private final static int MAX_VALUE = 5000;

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        fillArray(array, MAX_VALUE);
        int[] array2 = cloneArray(array);
        System.out.println("Alt Array: " + arrayToString(array));
        System.out.println("Reg Array: " + arrayToString(array2));
        altMergeSort(array);
        mergeSort(array2);
        System.out.println("Alt Array: " + arrayToString(array));
        System.out.println("Reg Array: " + arrayToString(array2));
        System.out.println("Is Alt Array Sorted? " + isSorted(array));
        System.out.println("Is Reg Array Sorted? " + isSorted(array2));
    }

    /**
     * Returns a deep copy of the specified int array.
     * 
     * @param array The array to be cloned.
     * @return The cloned int array.
     */
    public static int[] cloneArray(int[] array){
        int[] toClone = new int[array.length];
        for(int i = 0; i < array.length; i++){
            toClone[i] = array[i];
        }
        return toClone;
    }

    /**
     * Fills the specified array with positive integers up to the specified max.
     * 
     * @param array The array to be filled.
     * @param max   The maximum value any of the elements in the array can be filled
     *              as.
     */
    public static void fillArray(int[] array, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * max) + 1;
        }
    }

    /**
     * Returns a String representation of the elements in the specified int array,
     * printing only the first and last twenty elements if the array is larger than
     * twenty elements.
     * 
     * @param array The array to be represented as a String.
     * @return The String representation of the int array.
     */
    public static String arrayToString(int[] array) {
        String s = "";
        if (array.length <= 20) {
            for (int i = 0; i < array.length; i++) {
                s += array[i] + " ";
            }
        } else {
            for (int i = 0; i < 10; i++) {
                s += array[i] + " ";
            }
            s += ". . . ";
            for (int i = array.length - 10; i < array.length; i++) {
                s += array[i] + " ";
            }
        }
        return s;
    }

    /**
     * Checks if the specified int array is already sorted in ascending order.
     * 
     * @param array The int array to be checked.
     * @return Returns true if the int arrray is sorted in ascending order.
     */
    public static boolean isSorted(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
            }
        }
        return sorted;
    }

    /**
     * Merges four sorted partitions defined by the specified bound of a single int
     * array into
     * one that is fully sorted based on all the elements from the four sorted
     * partitions.
     * 
     * @param array The array that is in four sorted partitions.
     * @param lo    The beginning index of the first sorted partition.
     * @param mid1  The beginning index of the second sorted partition.
     * @param mid2  The beginning index of the third sorted partition.
     * @param mid3  The beginning index of the forth sorted partition.
     * @param hi    The index of the last element in the array.
     * @param temp  The int array to contain the fully sorted final array.
     */
    public static void merge(Integer[] array, int lo, int mid1, int mid2, int mid3, int hi, Integer[] temp) {
        int i = lo, j = mid1, k = mid2, l = mid3, m = lo;
        while ((i < mid1) && (j < mid2) && (k < mid3) && (l < hi)){
            if (array[i].compareTo(array[j]) < 0){
                if (array[i].compareTo(array[k]) < 0)
                    temp[l++] = array[i++];
                    if (array.[i].compareTo(array[l]) < 0){

                    }
                else
                    destArray[l++] = gArray[k++];
            }
            else
            {
                if (gArray[j].compareTo(gArray[k]) < 0)
                    destArray[l++] = gArray[j++];
                else
                    destArray[l++] = gArray[k++];
            }
        }
    }

    public static void altMergeSort(int[] array) {
        long startTime = System.nanoTime();
        int hi = array.length - 1;
        int lo = 0;
        int n = hi - lo + 1;
        int[] temp = new int[array.length];
        altMergeSort(array, lo, lo + n / 4 - 1, lo + 2 * n / 4 - 1, lo + 3 * n / 4 - 1, hi, temp);
        long endTime = System.nanoTime();
        System.out.println("Alternative merge sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    private static void altMergeSort(int[] array, int lo, int mid1, int mid2, int mid3, int hi, int[] temp) {
        int n = (hi - lo)/4 + 1;
        if (4 <= hi - lo) {
            altMergeSort(array, lo, lo + n / 4 - 1, lo + 2 * n / 4 - 1, lo + 3 * n / 4 - 1, mid1, temp);
            altMergeSort(array, mid1 + 1, mid1 + n / 4 - 1, mid1 + 2 * n / 4 - 1, mid1 + 3 * n / 4 - 1, mid2, temp);
            altMergeSort(array, mid2 + 1, mid2 + n / 4 - 1, mid2 + 2 * n / 4 - 1, mid2 + 3 * n / 4 - 1, mid3, temp);
            altMergeSort(array, mid3 + 1, mid3 + n / 4 - 1, mid3 + 2 * n / 4 - 1, mid3 + 3 * n / 4 - 1, hi, temp);
            merge(array, lo, mid1, mid2, mid3, hi, temp);
        }else{
            merge(array, lo, mid1, mid2, mid3, hi, temp);
        }
    }

    public static void mergeSort(int[] a) {
        long startTime = System.nanoTime();
        int[] temp = new int[a.length]; // used when merging the two sorted halves
        mergeSort(a, 0, a.length, temp);
        long endTime = System.nanoTime();
        System.out.println("Standard merge sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    public static void mergeSort(int[] a, int start, int end, int[] temp) {
        int mid;
        if (1 < end - start) { // recursive case: if more than 1 item
            mid = start + (end - start) / 2;
            mergeSort(a, start, mid, temp);
            mergeSort(a, mid, end, temp);
            merge(a, start, mid, end, temp);
        }
    }

    private static void merge(int[] a, int start, int mid, int end, int[] temp) {
        int currL = start;
        int currR = mid;
        int currT;
        for (currT = start; currT < end; currT++) {
            if (currL < mid && (currR >= end || a[currL] < a[currR])) {
                temp[currT] = a[currL];
                currL++;
            } else {
                temp[currT] = a[currR];
                currR++;
            }
        }
        for (currT = start; currT < end; currT++)
            a[currT] = temp[currT];
    }
}
