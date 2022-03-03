/**
 * Defines fixed size quque implemented using an int array with the basic
 * operations
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class IntArrayQueue {
    
    /** The maximum size each stack can be */
    private static final int MAX_SIZE = 100;

    private int end;
    private int[] ququeArray;

    public static void main(String[] args) {


    }

    public IntArrayQueue(){
        ququeArray = new int[MAX_SIZE];
        end = -1;
    }

    public void enquque(int value){
        if(isFull()){
            System.out.println("Enquque failed due to maximal capacity reached");
        }else{
            ququeArray[++end] = value;
        }
    }

    public int dequque(){
        int val = -1;
        if(end != -1){
            val = ququeArray[0];
            for(int i = 1; i <= end; i++){
                ququeArray[i - 1] = ququeArray[i];
            }
            end--;
        }
        return val;
    }

    public boolean isFull(){
        return end == MAX_SIZE;
    }

    /**
     * Returns a String representation of this Stack with [ as the bottom of the stack
     * and > as the top of the stack.
     * 
     * @return The String representation of this Stack.
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("< ");
        if(end >= 0 ){
            for(int i = 0; i <= end; i++){
                stringBuilder.append(ququeArray[i]);
                if(i != end){
                    stringBuilder.append(",");
                }
            }
        }
        stringBuilder.append(" <");
        return stringBuilder.toString();
    }
}
