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
    private int front;
    private int[] ququeArray;

    public static void main(String[] args) {
        IntArrayQueue quque = new IntArrayQueue();
        System.out.println(quque);
        quque.enquque(2);
        System.out.println(quque);
        quque.enquque(3);
        System.out.println(quque);
        System.out.println("dequque: " + quque.dequque());
        System.out.println("dequque: " + quque.dequque());
        System.out.println("dequque: " + quque.dequque());
        System.out.println(quque.end + " " + quque.front);
        System.out.println(quque);
    }

    public IntArrayQueue(){
        ququeArray = new int[MAX_SIZE];
        end = -1;
        front = 0;
    }

    public void enquque(int value){
        if(isFull()){
            System.out.println("Enquque failed due to maximal capacity reached");
        }else{
            ququeArray[++end] = value;
            end %= ququeArray.length;
        }
    }

    public int dequque(){
        int val = -1;
        if(front <= end){
            val = ququeArray[front++];
            front %= ququeArray.length;
        }
        return val;
    }

    public boolean isFull(){
        return end == MAX_SIZE;
    }

    /**
     * Returns a String representation of this Quque as < ... < with the front of the quque
     * where the array heads point towards.
     * 
     * @return The String representation of this Stack.
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("< ");
        if(end >= 0){
            for(int i = front; i != end; i = (i + 1) % ququeArray.length){
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
