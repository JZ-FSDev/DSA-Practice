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
        heap.deleteMax();
        heap.print();
        
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
        if(heapSize == 1){
            max = heap[0];
            heapSize--;
        }else if(heapSize > 1){
            max = heap[0];
            heap[0] = heap[heapSize - 1];
            int parent = 0;
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            while(leftChild < heapSize || rightChild < heapSize){
                if(leftChild < heapSize && rightChild < heapSize){
                    if(heap[leftChild] > heap[rightChild] && heap[leftChild] > heap[parent]){
                        swap(parent, leftChild);
                        parent = leftChild;
                    }else if(heap[rightChild] > heap[leftChild] && heap[rightChild] > heap[parent]){
                        swap(parent, rightChild);
                        parent = rightChild;
                    }
                }else if(leftChild < heapSize){
                    if(heap[leftChild] > heap[rightChild] && heap[leftChild] > heap[parent]){
                        swap(parent, leftChild);
                        parent = leftChild;
                    }
                }else{
                    if(heap[rightChild] > heap[leftChild] && heap[rightChild] > heap[parent]){
                        swap(parent, rightChild);
                        parent = rightChild;
                    }
                }
                leftChild = 2 * parent + 1;
                rightChild = 2 * parent + 2;
            }
            heapSize--;
        }
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
        System.out.println();
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

    private void increaseHeapSize(){
        int[] temp = new int[(int)(heapSize * 1.5)];
        for(int i = 0; i < heapSize; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }
}
