import java.util.Arrays;
import java.util.Random;

public class QuickSort{
    
    
    private static void sort(Comparable[] arr) {
        //StdRandom.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }
    
    private static void sort(Comparable[] arr, int low, int high){
        if (high <= low) return;
        
        int pivot = partition(arr, low, high);
        
        sort(arr, low, pivot-1);
        sort(arr, pivot+1, high);
    }
    
    private static int partition(Comparable[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        
        while(true) {
            
            while(arr[++i].compareTo(arr[low]) < 0) {
                if (i == high) break;
            }
            
            while(arr[j--].compareTo(arr[low]) > 0) {
                if (j == low) break;
            }
            
            if (i >= j) {
                break;
            }
            
            Comparable temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        
        Comparable temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        
        return j;
    }
    
    public static void main(String[] args) {
        Comparable[] numbers = new Comparable[] {20,8,3,9,2,22,5,4,1,16,3,9,19,0,44,29,14,7};
        sort(numbers);
        
        System.out.println(Arrays.toString(numbers));
    }
}
