
import java.util.*;
public class QuickSort {
  public static void main(String[] args) {

    QuickSort sort = new QuickSort();

    int[] array= new int[]{6,5,4,9,100, 7,2,1,9};
    sort.sort(array, 0, array.length);

    System.out.println(Arrays.toString(array));
  }


  /**
   * the quicksort is to choose a element as a comparision pivot. 
   * 
   * for example.  let say a list contains [4,1,2,5,3]
   * we choose the last one '3' as the pivot.
   * we scan the list from the begin
   * if the element is greater than the pivot. swap
   * if the element is not. choose a element prior the pivot
   * 
   * in this case 
   * [4,1,2,5,3]
   *          |
   * [3,1,2,5,4]
   *        |
   * [3,1,2,4,5]
   *      |
   * [2,1,3,4,5]
   *    |
   * [1,2,3,4,5]
   *  |
   * 
   * @param array
   * @param start
   * @param endx
   */


  private void sort(int [] array, int start, int endx) {
    int comparator = array[endx-1];
    int partition = start;
    for ( int i = start; i < endx -1; i++) {
      // 
      //
      if ( array[i] < comparator) {
        // 
        // 
        swap(array, partition, i);
        partition++;
      };
    }
    if (partition < endx){
      swap(array, endx-1, partition);
    }
    if (partition -1 > start) {
      sort(array, start, partition);
    }
    if (partition < endx) {
      sort(array, partition +1, endx);

    }
  }
  private void swap(int[] array, int first, int second) {
    if (first == second) {
      return;
    }
    int[] index = new int[array.length];
    for ( int i = 0; i < index.length; i++){
      index[i] = i;
    }
    System.out.println("swap " + first + " to " + second + " in " +Arrays.toString(array));

    System.out.println("swap " + first + " to " + second + " in " +Arrays.toString(index));
        System.out.println("");
    int temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }
}
