import java.util.EmptyStackException;

/**
 * Defines fixed size stack implemented using an int array with the basic
 * operations
 *
 * @author JZ-FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class IntArrayStack {

    /** The maximum size each stack can be */
    private static final int MAX_SIZE = 100;

    private int top;
    private int[] stackArray;

    /**
     * Tests the functionality of the stack.
     */
    public static void main(String[] args) {
        IntArrayStack stack = new IntArrayStack();
        stack.push(9);
        stack.push(8);
        System.out.println(stack.top());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }

    /**
     * Constructs a new Stack.
     */
    public IntArrayStack(){
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    /**
     * Pushes the specified int onto the stack.
     * 
     * @param value The value to be pushed onto the stack.
     */
    public void push(int value){
        if(isFull()){
            System.out.println("Push failed due to maximal capacity reached");
        }else{
            stackArray[++top] = value;
        }
    }

    /**
     * Returns the int at the top of this stack.
     * 
     * @return The int at the top of this stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public int top() throws EmptyStackException{
        if(top == -1){
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    /**
     * Removes and returns the int at the top of this stack.
     * 
     * @return The int at the top of this stack after its removal.
     * @throws EmptyStackException If the stack is empty.
     */
    public int pop() throws EmptyStackException{
        if(top == -1){
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     * 
     * @return True if this stack is empty and false otherwise.
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * Returns true if this stack is full and false otherwise.
     * 
     * @return True if this stack is full and false otherwise.
     */
    public boolean isFull(){
        return top == MAX_SIZE - 1;
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
        stringBuilder.append("[ ");
        if(top >= 0 ){
            for(int i = 0; i <= top; i++){
                stringBuilder.append(stackArray[i]);
                if(i != top){
                    stringBuilder.append(",");
                }

            }
        }
        stringBuilder.append(" >");
        return stringBuilder.toString();
    }
}
