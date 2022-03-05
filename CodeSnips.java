public class CodeSnips {

    /**
     * Test the methods.
     */
    public static void main(String[] args) {
        printLine('x', 5);
    }

    /**
     * Recursive method to print a line of a specified char of specified length.
     * 
     * @param c The char to be printed to form the line.
     * @param i The length of the line to be printed.
     */
    private static void printLine(char c, int i){
        if(i > 0){
            System.out.print(c);
            printLine(c, i - 1);
        }
    }

    
}
