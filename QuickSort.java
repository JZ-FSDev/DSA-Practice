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
}
