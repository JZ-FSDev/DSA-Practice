/**
 * Defines a industry-standard quick sort.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class QuickSort {

    /**
     * Calls the private helper method to recursively quick sort the specified int
     * array.
     * 
     * @param array The int array to be recursively quick sorted.
     */
    public static void quickSort(int[] array) {
        if (array != null && array.length > 1) {
            if (array.length == 2) {
                if (array[0] > array[1]) {
                    swap(array, 0, 1);
                }
            } else {
                quickSort(array, 0, array.length);
            }
        }
    }

    /**
     * Helper method to recursively quick sort the specified int array from the
     * specified bounds of start (inclusive) to end (not inclusive) by picking a
     * pivot between start and end and partitioning the region. Calls the method
     * again on the region to the left and right of the partition (if one exists)
     * until the array is sorted.
     * 
     * @param array The int array to be recursively quick sorted.
     * @param start The beginning index (inclusive) of the partition for a pivot to
     *              be chosen from.
     * @param end   The end index (not inclusive) of the partition for a pivot to be
     *              chosen from.
     */
    private static void quickSort(int[] array, int start, int end) {
        if (end - start > 2) {
            medianOfThreePivot(array, start, end);
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot);
            quickSort(array, pivot + 1, end);
        } else {
            if (end - start == 2 && array[start] > array[end - 1]) {
                swap(array, start, end - 1);
            }
        }
    }

    /**
     * Partitions the specified array from the specified start (inclusive) to end
     * (not inclusive) by arranging all the elements less than the pivot to the
     * left of the pivot and leaving the elements greater or equal to the right of
     * the pivot. Returns the final position of the pivot after the partition is
     * complete.
     * 
     * @param array The array to be partitioned.
     * @param start The beginning index (inclusive) of the region of the array to be
     *              partitioned.
     * @param end   The end index (not inclusive) of the region of the array to be
     *              partitioned.
     * @return The final position of the pivot after the partition is complete.
     */
    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int bigStart = start + 1;

        for (int i = start + 1; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, bigStart);
                bigStart++;
            }
        }
        array[start] = array[bigStart - 1];
        array[bigStart - 1] = pivot;
        return bigStart - 1;
    }

    /**
     * Chooses a pivot by chosing the median of the specified start (inclusive), end
     * (not inclusive), and middle index between start and end. Swaps the selected
     * pivot with the element at the specified start index.
     * 
     * @param array The array to have the pivot picked.
     * @param start The beginning index (inclusive) of the region of array to have a
     *              pivot picked.
     * @param end   The end index (not inclusive) of the region of array to have a
     *              pivot picked.
     */
    private static void medianOfThreePivot(int[] array, int start, int end) {
        if (end - start > 2) {
            int mid = (start + end) / 2;
            if (array[end - 1] > array[mid]) {
                swap(array, end - 1, mid);
            }
            if (array[end - 1] > array[start]) {
                swap(array, end - 1, start);
            }
            if (array[mid] > array[start]) {
                swap(array, mid, start);
            }
            swap(array, mid, start);
        }
    }

    /**
     * Swaps the two elements of their specified positions in the specified int
     * array with each other.
     * 
     * @param array The array to have the swap performed.
     * @param pos1  The index of the first element to be swapped with the second
     *              element.
     * @param pos2  The index of the second element to be swapped with the first
     *              element.
     */
    private static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];

        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
