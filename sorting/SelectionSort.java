import java.util.Arrays;

public class SelectionSort {

  public static void sort(Comparable[] items){
    int sortedIndex = -1;
    
    while(sortedIndex < items.length-1) {
        int index = sortedIndex +1;
        for (int i = index + 1; i < items.length; i++) {
          if (items[index].compareTo(items[i]) > 0) {
              index = i;
          }
        }
        
        System.out.println(Arrays.toString(items));
        //swap
        Comparable temp = items[index];
        items[index] = items[sortedIndex + 1];
        items[sortedIndex + 1] = temp;
        
        sortedIndex++;
        
    }
  }
  
  public static void main(String[] args){
    Integer[] numbers = {2,5,8, 1, 20, 4, 6};
    sort(numbers);
    System.out.println(Arrays.toString(numbers));
  }
}
