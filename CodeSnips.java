/**
 * A repository of random methods written for practice.
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class CodeSnips {

    /**
     * Test the methods.
     */
    public static void main(String[] args) {
        // printLine('x', 5);
        int[] arr = { 3, 4, 5, 6, 7 };
        System.out.println(addLess(arr, 6));
        System.out.println(raiseIntToPower(4, 4));
    }

    /**
     * Recursive method to print a line of a specified char of specified length.
     * 
     * @param c The char to be printed to form the line.
     * @param i The length of the line to be printed.
     */
    private static void printLine(char c, int i) {
        if (i > 0) {
            System.out.print(c);
            printLine(c, i - 1);
        }
    }

    /**
     * Recursive method to raise a given int n to the power of specified int k.
     * 
     * @param n The int to be raised to the power of int k.
     * @param k The power to raise int n to.
     * @return The product of n raised to k.
     */
    private static int raiseIntToPower(int n, int k) {
        int result = n;
        if (k == 0) {
            result = 1;
        } else if (k > 1) {
            result *= raiseIntToPower(n, k - 1);
        }
        return result;
    }

    /**
     * Calls the private method to count the number of odd ints in the specified int
     * array.
     * 
     * @param nums The array to have the number of odd ints determined.
     * @return The count of odds in the specified array.
     */
    public static int countOdd(int[] nums) {
        return countOdd(nums, nums.length - 1);
    }

    /**
     * Recursively counts the number of odd ints in the specified int array from the
     * specified index to index 0.
     * 
     * @param nums  The int array to have its number of odd ints determined.
     * @param index The index to begin the count from.
     * @return The count of odds in the specified array.
     */
    private static int countOdd(int[] nums, int index) {
        int count = 0;
        if (index >= 0) {
            if (nums[index] % 2 == 1) {
                count++;
            }
            count += countOdd(nums, index - 1);
        }
        return count;
    }

    /**
     * Calls the private method to sum all the ints in the specified array that are
     * less than the
     * specified key.
     * 
     * @param nums The int array to have the sum determined.
     * @param key  The value that the ints in the array must be less than to be
     *             summated.
     * @return The sum of all the ints in the specified array that are less than the
     *         specified key.
     */
    public static int addLess(int[] nums, int key) {
        return addLess(nums, key, 0);
    }

    /**
     * Calls the private method to sum all the ints in the specified array that are
     * less than the specified key.
     * 
     * @param nums  The int array to have the sum determined.
     * @param key   The value that the ints in the array must be less than to be
     *              summated.
     * @param index The index to begin the count from.
     * @return The sum of all the ints in the specified array that are less than the
     *         specified key.
     */
    private static int addLess(int[] nums, int key, int index) {
        int sum = 0;
        if (index < nums.length) {
            if (nums[index] < key) {
                sum += nums[index];
            }
            sum += addLess(nums, key, index + 1);
        }
        return sum;
    }
}
