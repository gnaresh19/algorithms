import java.util.Arrays;

public class SelectionSort {

  public static void sort(int[] numbers){
    int sortedIndex = -1;
    
    while(sortedIndex < numbers.length-1) {
        int index = sortedIndex +1;
        for (int i = index + 1; i < numbers.length; i++) {
          if (numbers[index] > numbers[i]) {
              index = i;
          }
        }
        
        System.out.println(Arrays.toString(numbers));
        //swap
        int temp = numbers[index];
        numbers[index] = numbers[sortedIndex + 1];
        numbers[sortedIndex + 1] = temp;
        
        sortedIndex++;
        
    }
  }
  
  public static void main(String[] args){
    int[] numbers = {2,5,8, 1, 20, 4, 6};
    sort(numbers);
    System.out.println(Arrays.toString(numbers));
  }
}
