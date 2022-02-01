/**
 * Defines a driver class to compare a self-made alternate version of a merge sort that divides
 * a given array into four partitions rather than the standard two in the regular merge sort.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class AltMergeSort {

    /** The size of the array to be generated for sorting. */
    private final static int ARRAY_SIZE = 10000;
    /** The maximum value of any of the elements in the array to be generated for sorting. */
    private final static int MAX_VALUE = 5000;

    /**
     * Generates two identical randomly generated Integer arrays and sorts them with the standard
     * merge sort and the alternative four partition alternative merge sort.
     * Prints out the before and after results along with the time elapsed for both sorting styles.
     */
    public static void main(String[] args) {
        Integer[] array = new Integer[ARRAY_SIZE];
        fillArray(array, MAX_VALUE);
        Integer[] array2 = cloneArray(array);
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
    public static Integer[] cloneArray(Integer[] array) {
        Integer[] toClone = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            toClone[i] = array[i];
        }
        return toClone;
    }

    /**
     * Fills the specified array with positive integers up to the specified max.
     * 
     * @param array The array to be filled.
     * @param max   The maximum value any of the elements in the array can be filled as.
     */
    public static void fillArray(Integer[] array, int max) {
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
    public static String arrayToString(Integer[] array) {
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
     * Checks if the specified Integer array is already sorted in ascending order.
     * 
     * @param array The Integer array to be checked.
     * @return Returns true if the Integer arrray is sorted in ascending order.
     */
    public static boolean isSorted(Integer[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
            }
        }
        return sorted;
    }

    /**
     * Calls the recursive private helper alternative four partition merge sort on the specified array. 
     * 
     * @param array The array to be sorted.
     */
    public static void altMergeSort(Integer[] array) {
        long startTime = System.nanoTime();
        int n = array.length;
        Integer[] temp = cloneArray(array);
        // System.out.println("lo: " + lo + ", mid1: " + (lo + n / 4) + ", mid2: " + (lo + 2 * n / 4) + ", mid3: " + (lo + 3 * n / 4) + ", hi: " + hi);
        altMergeSort(array, 0, n / 4, 2 * n / 4, 3 * n / 4, array.length, temp);
        long endTime = System.nanoTime();
        System.out.println("Alternative merge sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    /**
     * Recursively performs an alternate merge sort on the specified Integer array by separation 
     * into four partitions then merges them in ascending order by calling the private helper merge method.
     * 
     * @param toSort The array to be sorted.
     * @param lo     The beginning index of the first sorted partition.
     * @param mid1   The beginning index of the second sorted partition.
     * @param mid2   The beginning index of the third sorted partition.
     * @param mid3   The beginning index of the forth sorted partition.
     * @param hi     The last index + 1 of the forth sorted partition.
     * @param temp   The temporary Integer array to contain the fully sorted final array.
     */
    private static void altMergeSort(Integer[] toSort, int lo, int mid1, int mid2, int mid3, int hi, Integer[] temp) {
        int n = (hi - lo) / 4 + 1;

        if (1 < hi - lo) {
            // System.out.println("lo: " + lo + ", mid1: " + (lo + n / 4) + ", mid2: " + (lo + 2 * n / 4) + ", mid3: " + (lo + 3 * n / 4) + ", hi: " + mid1);
            altMergeSort(toSort, lo, lo + n / 4, lo + 2 * n / 4, lo + 3 * n / 4, mid1, temp);

            // System.out.println("lo: " + (mid1) + ", mid1: " + (mid1 + n / 4) + ", mid2: " + (mid1 + 2 * n / 4) + ", mid3: " + (mid1 + 3 * n / 4) + ", hi: " + mid2);
            altMergeSort(toSort, mid1, mid1 + n / 4, mid1 + 2 * n / 4, mid1 + 3 * n / 4, mid2, temp);

            // System.out.println("lo: " + (mid2) + ", mid1: " + (mid2 + n / 4) + ", mid2: " + (mid2 + 2 * n / 4) + ", mid3: " + (mid2 + 3 * n / 4) + ", hi: " + mid3);
            altMergeSort(toSort, mid2, mid2 + n / 4, mid2 + 2 * n / 4, mid2 + 3 * n / 4, mid3, temp);

            // System.out.println("lo: " + (mid3) + ", mid1: " + (mid3 + n / 4) + ", mid2: " + (mid3 + 2 * n / 4) + ", mid3: " + (mid3 + 3 * n / 4) + ", hi: " + hi);
            altMergeSort(toSort, mid3, mid3 + n / 4, mid3 + 2 * n / 4, mid3 + 3 * n / 4, hi, temp);

            merge(toSort, lo, mid1, mid2, mid3, hi, temp);
        }
    }

    /**
     * Merges four sorted partitions defined by the specified bound of a single Integer array into
     * one that is fully sorted based on all the elements from the four sorted partitions.
     * 
     * @param array The array that is in four sorted partitions.
     * @param lo    The beginning index of the first sorted partition.
     * @param mid1  The beginning index of the second sorted partition.
     * @param mid2  The beginning index of the third sorted partition.
     * @param mid3  The beginning index of the forth sorted partition.
     * @param hi    The index of the last element in the array.
     * @param temp  The temporary Integer array to contain the fully sorted final array.
     */
    private static void merge(Integer[] array, int lo, int mid1, int mid2, int mid3, int hi, Integer[] temp) {
        int i = lo, j = mid1, k = mid2, l = mid3, m = lo;
        // System.out.println("Merge: i = " + i + " , j = " + j + " , k = " + k + " , l = " + l);
        while ((i < mid1) && (j < mid2) && (k < mid3) && (l < hi)){
            if (array[i].compareTo(array[j]) < 0){
                if (array[i].compareTo(array[k]) < 0){
                    if(array[i].compareTo(array[l]) < 0){
                        temp[m++] = array[i++];
                    }else{
                        temp[m++] = array[l++];
                    }
                }else{
                    if(array[k].compareTo(array[l]) < 0){
                        temp[m++] = array[k++];
                    }else{
                        temp[m++] = array[l++];
                    }
                }
            }else{
                if (array[j].compareTo(array[k]) < 0){
                    if(array[j].compareTo(array[l]) < 0){
                        temp[m++] = array[j++];
                    }else{
                        temp[m++] = array[l++];
                    }
                }else{
                    if(array[k].compareTo(array[l]) < 0){
                        temp[m++] = array[k++];
                    }else{
                        temp[m++] = array[l++];
                    }
                }
            }
        }
        // case where first and second and third ranges have remaining values
        while ((i < mid1) && (j < mid2) && (k < mid3)) {
            if (array[i].compareTo(array[j]) < 0){
                if (array[i].compareTo(array[k]) < 0){
                    temp[m++] = array[i++];
                }else{
                    temp[m++] = array[k++];
                }
            }else{
                if (array[j].compareTo(array[k]) < 0){
                    temp[m++] = array[j++];
                }else{
                    temp[m++] = array[k++];
                }
            }
        }
  
        // case where first and second and forth ranges have remaining values
        while ((i < mid1) && (j < mid2) && (l < hi)) {
            if (array[i].compareTo(array[j]) < 0){
                if (array[i].compareTo(array[l]) < 0){
                    temp[m++] = array[i++];
                }else{
                    temp[m++] = array[l++];
                }
            }else{
                if (array[j].compareTo(array[l]) < 0){
                    temp[m++] = array[j++];
                }else{
                    temp[m++] = array[l++];
                }
            }
        }
  
        // case where first and third and forth ranges have remaining values
        while ((i < mid1) && (k < mid3) && (l < hi)) {
            if (array[i].compareTo(array[k]) < 0){
                if (array[i].compareTo(array[l]) < 0){
                    temp[m++] = array[i++];
                }else{
                    temp[m++] = array[l++];
                }
            }else{
                if (array[k].compareTo(array[l]) < 0){
                    temp[m++] = array[k++];
                }else{
                    temp[m++] = array[l++];
                }
            }
        }

        // case where second and third and forth ranges have remaining values
        while ((j < mid2) && (k < mid3) && (l < hi)) {
            if (array[j].compareTo(array[k]) < 0){
                if (array[j].compareTo(array[l]) < 0){
                    temp[m++] = array[j++];
                }else{
                    temp[m++] = array[l++];
                }
            }else{
                if (array[k].compareTo(array[l]) < 0){
                    temp[m++] = array[k++];
                }else{
                    temp[m++] = array[l++];
                }
            }
        }
  
        // case where first and second remaining values
        while ((i < mid1) && (j < mid2)) {
            if (array[i].compareTo(array[j]) < 0){
                temp[m++] = array[i++];
            }else{
                temp[m++] = array[j++];
            }
        }
        
        // case where first and third remaining values
        while ((i < mid1) && (k < mid3)) {
            if (array[i].compareTo(array[k]) < 0){
                temp[m++] = array[i++];
            }else{
                temp[m++] = array[k++];
            }
        }   

        // case where first and forth remaining values
        while ((i < mid1) && (l < hi)) {
            if (array[i].compareTo(array[l]) < 0){
                temp[m++] = array[i++];
            }else{
                temp[m++] = array[l++];
            }
        }   
        
        // case where second and third remaining values
        while ((j < mid2) && (k < mid3)) {
            if (array[j].compareTo(array[k]) < 0){
                temp[m++] = array[j++];
            }else{
                temp[m++] = array[k++];
            }
        }   
        
        // case where second and forth remaining values
        while ((j < mid2) && (l < hi)) {
            if (array[j].compareTo(array[l]) < 0){
                temp[m++] = array[j++];
            }else{
                temp[m++] = array[l++];
            }
        } 
        
        // case where third and forth remaining values
        while ((k < mid3) && (l < hi)) {
            if (array[k].compareTo(array[l]) < 0){
                temp[m++] = array[k++];
            }else{
                temp[m++] = array[l++];
            }
        }  

        // copy remaining values from the first range
        while (i < mid1) temp[m++] = array[i++];
  
        // copy remaining values from the second range
        while (j < mid2) temp[m++] = array[j++];
  
        // copy remaining values from the third range
        while (k < mid3) temp[m++] = array[k++];

        // copy remaining values from the forth range
        while (l < hi) temp[m++] = array[l++];

        //replace the elements in the given array with the elements from the temporary array
        for(int u = 0 ; u < temp.length; u++){
            array[u] = temp[u];
        }
    }

    /**
     * Calls the recursive merge sort private helper method to perform the merge sort on the specified array.
     * 
     * @param toSort The array to be sorted.
     */
    public static void mergeSort(Integer[] toSort) {
        long startTime = System.nanoTime();
        Integer[] temp = new Integer[toSort.length]; // used when merging the two sorted halves
        mergeSort(toSort, 0, toSort.length, temp);
        long endTime = System.nanoTime();
        System.out.println("Standard merge sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    /**
     * Recursively performs merge sort on the specified Integer array by separation into two partitions
     * then merges them in ascending order by calling the private helper merge method.
     * 
     * @param toSort The array to be sorted.
     * @param start The beginning index of the array to be sorted.
     * @param end The length of the array (last index + 1) to be sorted.
     * @param temp The temporary Integer array to contain the fully sorted final array.
     */
    private static void mergeSort(Integer[] toSort, int start, int end, Integer[] temp) {
        int mid;
        if (1 < end - start) { // recursive case: if more than 1 item
            mid = start + (end - start) / 2;
            mergeSort(toSort, start, mid, temp);
            mergeSort(toSort, mid, end, temp);
            merge(toSort, start, mid, end, temp);
        }
    }

    /**
     * Merges two sorted partitions defined by the specified bounds of a single Integer array into
     * one that is fully sorted based on all the elements from the two sorted partitions.
     * 
     * @param toMerge The array to be merged.
     * @param start The beginning index of the first sorted partition.
     * @param mid The beginning index of the second sorted partition.
     * @param end The length of the array (last index + 1) to be merged.
     * @param temp The temporary Integer array to contain the fully sorted final array.
     */
    private static void merge(Integer[] toMerge, int start, int mid, int end, Integer[] temp) {
        int currL = start;
        int currR = mid;
        int currT;
        for (currT = start; currT < end; currT++) {
            if (currL < mid && (currR >= end || toMerge[currL] < toMerge[currR])) {
                temp[currT] = toMerge[currL];
                currL++;
            } else {
                temp[currT] = toMerge[currR];
                currR++;
            }
        }
        for (currT = start; currT < end; currT++)
            toMerge[currT] = temp[currT];
    }
}
