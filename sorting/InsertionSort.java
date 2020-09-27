import java.util.Arrays;

public class InsertionSort {

  public static void sort(Comparable[] items){
        int i = 0;
        
        while(i < items.length-1){
            for (int j = i+1; j >0; j--){
                if (items[j].compareTo(items[j-1]) == -1) {
                    Comparable temp = items[j];
                    items[j] = items[j-1];
                    items[j-1] = temp;
                } else {
                    break;
                }
        }
        
        i++;
        
    }
}
  
  public static void main(String[] args){
    Integer[] numbers = {2,5,8, 1, 20, 4, 6};
    sort(numbers);
    System.out.println(Arrays.toString(numbers));
  }
}
