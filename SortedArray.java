import java.util.*;
public class SortedArray {

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray();
    }

    public SortedArray() {
        int[] array1 = new int[]{1, 5, 8, 9, 11};
        int[] array2 = new int[] {2, 12, 24, 44};
        int[] result = merge(array1, array2);
        for (int i = 0; i < result.length; i++) {
          System.out.print(result[i] + " ");
        }
    }

    private int[] merge(int[]array1, int[] array2) {

        int secondPivot = 0;
        int resultPosition = 0;
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {

            for (int j = secondPivot; j< array2.length; j++){
                if (array1[i] > array2[j]) {
                    result[resultPosition] = array2[j];
                    resultPosition++;
                    secondPivot++;
                }else {
                    break;
                }
            }

            result[resultPosition] = array1[i];
            resultPosition++;
        }
        while (secondPivot < array2.length) {
            result[resultPosition] = array2[secondPivot];
            secondPivot++;
            resultPosition++;
        }
        return result;
    }
}
