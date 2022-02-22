/**
 * Defines a driver class to compare a self-made recursive insertion sort to 
 * the interative version to determine which is quicker
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class QuickSort {
    
    /**
     * Calls the private helper method to recursively quick sort the specified int array.
     * Prints out the time elapsed.
     * 
     * @param array The int array to be recursively quick sorted.
     */    
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length);
    }

    /**
     * Helper method to recursively quick sort the specified int array from the specified bounds
     * from start to end.
     * 
     * @param array The int array to be recursively quick sorted.
     * @param start The beginning index (inclusive) of the partition for a pivot to be chosen from.
     * @param end The end index (not inclusive) of the partition for a pivot to be chosen from.
     */    
    private static void quickSort(int[] array, int start, int end){
        int pivot;
        if(end - start > 2){
            choosePivot(array, start, end);
            pivot = partition(array, start, end);
            quickSort(array, start, pivot);
            quickSort(array, pivot + 1, end);
        }else{
            if(end - start == 2 && array[start] > array[end - 1]){
                int swap = array[start];
                array[start] = array[end - 1];
                array[end - 1] = swap;
            }
        }
    }
    
    /**
     * Chooses a pivot by chosing the median of the specified start, end, and middle index
     * between start and end.  Swaps the selected pivot to the specified start index.
     * 
     * @param array The array for a pivot to be chosen from.
     * @param start The beginning index (inclusive) of the partition for a pivot to be chosen from.
     * @param end The end index (not inclusive) of the partition for a pivot to be chosen from.
     */
    private static void choosePivot(int[] array, int start, int end){
        int mid = start + (end - start)/2;
        // System.out.println(mid);
        int pivot = medianOfThree(array, start, mid, end-1);
        System.out.println(pivot);
        int pivotSwap = array[pivot];
        array[pivot] = array[start];
        array[start] = pivotSwap;
    } 
 
    /**
     * Partitions the specified array from the specified start to end by moving all the elements
     * larger than the pivot to the right of the pivot and leaving the elements smaller to the left
     * of the pivot.  Returns the final position of the pivot after the partition is complete.
     * 
     * @param array The array to be partitioned.
     * @param start The beginning index (inclusive) of the region of the array to be partitioned.
     * @param end The end index (not inclusive) of the region of the array to be partitioned.
     * @return The final position of the pivot after the partition is complete.
     */
    private static int partition(int[] array, int start, int end){
        int current;
        int pivot = array[start];
        int bigStart = start + 1;
        for(current = start + 1; current < end; current++){
            if(array[current] < pivot){
                int smallSwap = array[current];
                array[current] = array[bigStart];
                array[bigStart] = smallSwap;
                bigStart++;
            }
        }
        array[start] = array[bigStart - 1];
        array[bigStart - 1] = pivot;
        System.out.println(arrayToString(array));
        return bigStart - 1;
    }
    
    /**
     * Returns the median of the three integers in an array define by their specified indexes.
     * 
     * @param array The array where the specified indexes will be used to retrieve integers from it.
     * @param a The position of the first element in the array.
     * @param b The position of the second element in the array.
     * @param c The position of the third element in the array.
     * @return The median of the three integers in an array define by their specified indexes.
     */
    private static int medianOfThree(int[] array, int a, int b, int c){
        int median = 0;
        if(array[a] == array[b] && array[b] != array[c]){
            median = a;
        }else if(array[c] == array[b] && array[b] != array[a]){
            median = c;
        }
        int max = Math.max(Math.max(array[a],array[b]),array[c]);
        int min = Math.min(Math.min(array[a],array[b]),array[c]);
        if(array[a] < max && array[a] > min){
            median = a;
        }else if(array[b] < max && array[b] > min){
            median = b;
        }else if(array[c] < max && array[c] > min){
            median = c;
        }
        return median;
    }    
}
