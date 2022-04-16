public class Heap {
    
    private static final int DEFAULT_SIZE = 100;
    private int[] heap;
    private int heapSize;

    public Heap(int size){
        heap = new int[DEFAULT_SIZE];
        heapSize = 0;
    }

    public void insert(int item){
        heap[heapSize] = item;
        int index = heapSize;
        heapSize++;

        if(index > 0){
            while(index >= 0){
                int oldIndex = index;
                index = (int)Math.floor((index - 1) / 2);
                if(item > heap[index]){
                    swap(index, oldIndex);
                }
            }
        }
    }

    public int deleteMax(){
        int max = Integer.MIN_VALUE;

        return max;
    }

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
