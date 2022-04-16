public class Heap {

    private static final int DEFAULT_SIZE = 100;
    private int[] heap;
    private int heapSize;

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(5);
        heap.insert(10);
        heap.insert(30);
        heap.insert(20);
        heap.insert(0);
        heap.insert(35);
        heap.insert(25);
        heap.print();
        System.out.println(heap.isValid(0));
    }

    public Heap() {
        heap = new int[DEFAULT_SIZE];
        heapSize = 0;
    }

    public void insert(int item) {
        heap[heapSize] = item;
        int index = heapSize;
        heapSize++;

        while (index > 0) {
            int oldIndex = index;
            index = (int) Math.floor((index - 1) / 2);
            if (item > heap[index]) {
                swap(index, oldIndex);
            }
        }
    }

    public int deleteMax() {
        int max = Integer.MIN_VALUE;

        return max;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public boolean isValid(int parentIndex){
        boolean valid = true;
        if(valid){
            if(2 * parentIndex + 1 < heapSize){
                if(heap[parentIndex] < heap[2 * parentIndex + 1]){
                    valid = false;
                }else{
                    valid = isValid(2 * parentIndex + 1); // left child
                }
            }
            if(2 * parentIndex + 2 < heapSize){
                if(heap[parentIndex] < heap[2 * parentIndex + 2]){
                    valid = false;
                }else{
                    valid = isValid(2 * parentIndex + 2); // right child
                }
            }
        }
        return valid;
    }
}
