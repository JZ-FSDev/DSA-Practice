public class QuickSort {
    
    public static void quickSort(int[] a){
        quickSort(a, 0, a.length);
    }

    private static void quickSort(int[] a, int start, int end){
        if(end - start > 2){
            choosePivot(a, start, end);
            int pivot = partition(a, start, end);
            quickSort(a, 0, pivot);
            quickSort(a, pivot + 1, end);
        }else{
            if(start - end == 2 && a[start] > a[end-1]){
                int swap = a[start];
                a[start] = a[end-1];
                a[end-1] = swap;
            }
        }
    }
    
    private static void choosePivot(int[] a, int start, int end){
        int mid = (end-start)/2;
        int pivot = medianOfThree(a, start, mid, end-1);
        int pivotSwap = a[pivot];
        a[pivot] = a[start];
        a[start] = pivotSwap;
    } 
 
    private static int partition(int[] a, int start, int end){
        int current;
        int pivot = a[start];
        int bigStart = start + 1;
        for(current = start + 1; current < a.length; current++){
            if(a[current] < pivot){
                int smallSwap = a[current];
                a[current] = a[bigStart];
                a[bigStart] = smallSwap;
                bigStart++;
            }
        }
        a[start] = a[bigStart - 1];
        a[bigStart - 1] = pivot;
        return bigStart - 1;
    }    
}
