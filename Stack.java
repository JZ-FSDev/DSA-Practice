public class IntArrayStack {
    private static final int MAX_SIZE = 100;

    private int top;
    private int[] stackArray;

    public static void main(String[] args) {
        Stack stack = new Stack();
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

    public Stack(){
        stackArray = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int i){
        stackArray[++top] = i;
    }

    public int top(){
        return stackArray[top];
    }

    public int pop(){
        int i = stackArray[top];
        top--;
        return i;
    }

    public boolean isEmpty(){
        return top == -1;
    }

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
