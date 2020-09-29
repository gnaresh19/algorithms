import java.util.Arrays;

public class MergeSort{
    
    private static void merge(Comparable[] numbers, Comparable[] aux, int startIndex, int mid, int endIndex) {
        for (int i =startIndex;i<=endIndex ;i++){
            aux[i] = numbers[i];
        }
        
        int m = startIndex;
        int n = mid + 1;
        
        for (int i=startIndex;i<=endIndex;i++){
            if(m > mid) numbers[i] = aux[n++];
            else if (n > endIndex) numbers[i] = aux[m++];
            else if(aux[m].compareTo(aux[n]) <=0) numbers[i] = aux[m++];
            else if (aux[m].compareTo(aux[n]) >0) numbers[i] = aux[n++];
        }
    }
    
    
    private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        
        int mid = low + (high - low)/2;
        
        sort(arr, aux, low, mid);
        sort(arr, aux, mid + 1,  high);
        merge(arr, aux, low, mid, high);
    }
    
    
    private static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        
        sort(arr, aux, 0, aux.length -1);
    }
    
    public static void main(String[] args) {
        Comparable[] numbers = new Comparable[] {20,8,3,9,2,22,5,4,1,16,3,9,19,0,44,29,14,7};
        sort(numbers);
        
        System.out.println(Arrays.toString(numbers));
    }
}
