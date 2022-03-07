/**
 * Defines a recursive radix sort that begins sorting at the most significant 
 * place value.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class MSDRadixSort {
    
     /**
     * Radix sorts the specified int array by beginning with the largest place
     * value and distributing each of the elements into a bucket of the index
     * matching that of the digit of the place value for every element. Any bucket
     * with more than one element after the distribution will be further distributed
     * into a new set of buckets of the next place value to the right if not already
     * at the ones place value. When no more distributions can be made, collects
     * all the elements, preserving ascending order, and replaces the original
     * elements in the bucket of the previous call. This process is repeated until
     * the first set of buckets is reached and then all the elements, preserving
     * ascending order, will replace the elements from the original array, sorting
     * the array.
     * 
     * @param array The int array to be radix sorted.
     */
    public static void radixSort(int[] array) {
        if (array != null && array.length > 1) {
            // The largest number is found in the array to determine the greatest
            // place value to begin the sort with
            int largestNumber = getLargestNumber(array);
            int numDigits = getNumDigits(largestNumber);
            ArrayList<Integer>[] buckets = new ArrayList[10];
            int index = 0;

            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < array.length; i++) {
                buckets[(array[i] / (int) (Math.pow(10, numDigits - 1))) % 10].add(array[i]);
            }
            if (numDigits > 1) {
                for (int i = 0; i < buckets.length; i++) {
                    if (buckets[i].size() > 1) {
                        distributeToBuckets(buckets[i], numDigits - 2);
                    }
                }
            }
            // Copies the now sorted elements from the initial set of buckets and
            // replacing the original elements in the array
            for (int j = 0; j < buckets.length; j++) {
                for (int k = 0; k < buckets[j].size(); k++) {
                    array[index++] = buckets[j].get(k);
                }
            }
        }
    }
    
     /**
     * Distributes all elements from the specified bin of buckets into a new set of
     * buckets with the next place value to the right. Any buckets after this point
     * with more than one element after the distribution will be further distributed
     * into a new set of buckets of the next place value to the right if not already
     * at the ones place value. When no more distributions can be made, collects
     * all the elements, preserving ascending order, and replaces the original
     * elements in the bucket of the previous call.
     * 
     * @param buckets    The array of buckets to be further distributed to new
     *                   buckets.
     * @param fromBucket The bucket from the previous call to be futher distributed.
     * @param exp        The exponent that the number 10 will be raised to to denote
     *                   the place value.
     */
    private static void distributeToBuckets(ArrayList<Integer> bucket, int exp) {
        ArrayList<Integer>[] newBuckets = new ArrayList[10];

        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < bucket.size(); i++) {
            newBuckets[(bucket.get(i) / (int) (Math.pow(10, exp))) % 10].add(bucket.get(i));
        }
        if (exp > 0) {
            for (int i = 0; i < newBuckets.length; i++) {
                if (newBuckets[i].size() > 1) {
                    distributeToBuckets(newBuckets[i], exp - 1);
                }
            }
        }
        // Replaces the elements in the bucket from the previous call with the now
        // sorted elements
        for (int j = 0; j < newBuckets.length; j++) {
            for (int k = 0; k < newBuckets[j].size(); k++) {
                bucket.remove(newBuckets[j].get(k));
                bucket.add(newBuckets[j].get(k));
            }
        }
    }
    
    /**
     * Returns the number of digits from the specified int.
     * 
     * @param number The int to have its number of digits determined.
     * @return The number of digits of the specified int.
     */
    private static int getNumDigits(int number) {
        int numDigits;

        if (number == 0) {
            numDigits = 1;
        } else {
            numDigits = (int) Math.log10(number) + 1;
        }
        return numDigits;
    }    
}
