import java.lang.StringBuilder;

/**
 * Defines a driver class to compare a self-made recursive insertion sort to 
 * the interative version to determine which is quicker
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class InsertionSort{
    
    /** The size of the array to be generated for sorting. */
    private final static int ARRAY_SIZE = 100;
    /** The maximum value of any of the elements in the array to be generated for sorting. */
    private final static int MAX_VALUE = 1000;

    /**
     * Generates two identical randomly generated int arrays and sorts them interatively and recursively
     * to compare the time it takes to complete the sorting.
     * Prints out the before and after results along with the time elapsed for both sorting styles.
     */
    public static void main(String[] args) {
        System.out.println("Array before sorting:");
        int[] arr = new int[ARRAY_SIZE];
        fillArray(arr, MAX_VALUE);
        int[] arrCopy = cloneArray(arr);
        System.out.println(arrayToString(arr));
        recursiveInsertionSort(arr);
        iterativeInsertionSort(arrCopy);
        System.out.println("Array after sorting:");
        System.out.println(arrayToString(arr));
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
     * @param max The maximum value any of the elements in the array can be filled as.
     */
    public static void fillArray(int[] array, int max){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*max) + 1;
        }
    }

    /**
     * Returns a String representation of the elements in the specified int array,
     * printing only the first and last twenty elements if the array is larger than twenty elements.
     * 
     * @param array The array to be represented as a String.
     * @return The String representation of the int array.
     */
    public static String arrayToString(int[] array){
        StringBuilder stringBuilder = new StringBuilder();
        if(array.length <= 20){
            for(int i = 0; i < array.length; i++){
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
        }else{
            for(int i = 0; i < 10; i++){
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
            stringBuilder.append(". . . ");
            for(int i = array.length - 10; i < array.length; i++){
                stringBuilder.append(array[i]);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Checks if the specified int array is already sorted in ascending order.
     * 
     * @param array The int array to be checked.
     * @return Returns true if the int arrray is sorted in ascending order.
     */
    private static boolean isSorted(int[] array){
        boolean sorted = true;
        for(int i = 0; i < array.length-1 && sorted; i++){
            if(array[i] > array[i+1]){
                sorted  = false;
            }
        }
        return sorted;
    }

    /**
     * Calls the private helper method to recursively sort by insertion the specified int array.
     * Prints out the time elapsed.
     * 
     * @param array The int array to be recursively sorted.
     */
    public static void recursiveInsertionSort(int[] array){
        long startTime = System.nanoTime();
        if(array != null && array.length > 1){
            recursiveInsertionSort(array, array.length-1);
        }
        long endTime = System.nanoTime();
        System.out.println("Recursive insertion sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    /**
     * Helper method to recursively sort by insertion the specified int array.
     * 
     * @param array The int array to be recursively sorted.
     * @param pos The position of the element to be sifted to the correct sorted position.
     */
    private static void recursiveInsertionSort(int[] array, int pos){
        if(pos > -1){
            siftUp(array, pos);
            recursiveInsertionSort(array, --pos);
        }
    }

    /**
     * Interatively sorts by insertion the specified int array.
     * 
     * @param a The array to be iteratively sorted.
     */
    public static void iterativeInsertionSort( int[] a ){
        long startTime = System.nanoTime();
        for ( int i = a.length-2; i >= 0; i-- ){
            siftUp( a, i );
        }
        long endTime = System.nanoTime();
        System.out.println("Iterative insertion sort time elapsed: " + (endTime - startTime) + " nanoseconds");
    }

    /**
     * Interatively sorts by insertion the specified int array.
     * 
     * @param a The array to be iteratively sorted.
     * @param pos The position of the element to be sifted to the correct sorted position.
     */
    private static void siftUp( int[] a, int pos ) {
        int siftItem = a[pos];
        int i;
        for ( i = pos+1; i < a.length && a[i] < siftItem ; i++ ) {
            a[i-1] = a[i];
        }
            a[i-1] = siftItem;
    }
}
