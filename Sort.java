import java.util.*;
public class Sort {


  public static void main(String[] args) {

    Sort sort = new Sort();
    int[] array = new int[]{5,4,6,8,2,1};
    int[] result = sort.mergeSort(array);

    System.out.println(Arrays.toString(result));
  }
  private int[] copy(int[] collections, int start, int end) {
      int size = end - start;
      int[] result = new int[size];
      int pivot = 0;
      for (int i = start; i < end; i++) {
          result[pivot] = collections[i];
          pivot++;
      }
      return result;
  }
  public int[] mergeSort(int[] collection) {
        int sizeOfCollection = collection.length;
        if (sizeOfCollection > 2) {
            int[] leftSub = copy(collection, 0, sizeOfCollection/2);
            int[] left = mergeSort(leftSub);
            int[] rightSub = copy(collection, sizeOfCollection/2, sizeOfCollection);
            int[] right = mergeSort(rightSub);
            int result[] = new int[sizeOfCollection];
            int position = 0;
            int rightPosition = 0;
            for (int i= 0; i < left.length; i++) {
                for(int j = rightPosition; j < right.length; j++ ) {
                    if (right[j] < left[i]){
                        result[position] = right[j];
                        position++;
                        rightPosition++;
                    }else {
                        break;
                    }
                }
                result[position] = left[i];
                position++;
            }
            for (int i = rightPosition; i < right.length; i++) {
                result[position] = right[i];
                position++;
            }
            return result;
        }else if (collection.length == 1) {
            return collection;
        }else {
            if (collection[0] > collection[1]) {
                int temp = collection[0];
                collection[0] = collection[1];
                collection[1] = temp;
                return collection;
            }else {
                return collection;
            }
        }
    }
}
