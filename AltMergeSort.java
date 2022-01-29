public class AltMergeSort {

    public static void main(String[] args) {
        int[] array = {5,6,7,1,2,3,4,8,9,10};
        int[] merged = new int[array.length];
        merge(array, 0, 2, 4, 7, 9, merged);
        System.out.println(arrayToString(array));
        System.out.println(arrayToString(merged));
    }


    /**
     * Fills the specified array with positive integers up to the specified max.
     * 
     * @param array The array to be filled.
     * @param max The maximum value any of the elements in the array can be filled as.
     */
    public static void fillArray(int[] array, int max){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random()*max) + 1;
        }
    }

    /**
     * Returns a String representation of the elements in the specified int array,
     * printing only the first and last twenty elements if the array is larger than twenty elements.
     * 
     * @param array The array to be represented as a String.
     * @return The String representation of the int array.
     */
    public static String arrayToString(int[] array){
        String s = "";
        if(array.length <= 20){
            for(int i = 0; i < array.length; i++){
                s += array[i] + " ";
            }
        }else{
            for(int i = 0; i < 10; i++){
                s += array[i] + " ";
            }
            s += ". . . ";
            for(int i = array.length - 10; i < array.length; i++){
                s += array[i] + " ";
            }
        }
        return s;
    }

     /**
     * Checks if the specified int array is already sorted in ascending order.
     * 
     * @param array The int array to be checked.
     * @return Returns true if the int arrray is sorted in ascending order.
     */
    public static boolean isSorted(int[] array){
        boolean sorted = true;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                sorted  = false;
            }
        }
        return sorted;
    }

    public static void merge(int[] array, int lo, int mid1, int mid2, int mid3, int hi, int[] temp){
        int a = lo, b = mid1+1, c = mid2+1, d = mid3+1;
        int pos = 0;
        while(pos < temp.length){
            int min = -1;
            boolean aPast = false, bPast = false, cPast = false, dPast = false;
            if(a == mid1+1) aPast = true;
            if(b == mid2+1) bPast = true;
            if(c == mid3+1) cPast = true;
            if(d == hi+1) dPast = true;
            
            if(aPast && bPast && cPast){
                min = array[d];
            }else if(aPast && bPast && dPast){
                min = array[c];
            }else if(aPast && cPast && dPast){
                min = array[b];
            }else if(bPast && cPast && dPast){
                min = array[a];
            }else if(aPast && bPast){
                min = Math.min(array[c], array[d]);
            }else if(aPast && cPast){
                min = Math.min(array[b], array[d]);
            }else if(aPast && dPast){
                min = Math.min(array[b], array[c]);
            }else if(bPast && cPast){
                min = Math.min(array[a], array[d]);
            }else if(bPast && dPast){
                min = Math.min(array[a], array[c]);
            }else if(cPast && dPast){
                min = Math.min(array[a], array[b]);
            }else if(aPast){
                min = Math.min(Math.min(array[b], array[c]), array[d]);
            }else if(bPast){
                min = Math.min(Math.min(array[a], array[c]), array[d]);
            }else if(cPast){
                min = Math.min(Math.min(array[a], array[b]), array[d]);
            }else if(dPast){
                min = Math.min(Math.min(array[a], array[b]), array[c]);
            }

            System.out.println(min);

            if(min == array[a] && a < mid1+1){
                a++;
            }else if(min == array[b] && b < mid2){
                b++;
            }else if(min == array[c] && c < mid3){
                c++;
            }else if(min == array[d] && d < hi+1){
                d++;
            }
            temp[pos++] = min;
        }
    }
}
