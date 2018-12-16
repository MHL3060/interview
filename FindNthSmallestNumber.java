import java.util.Arrays;

public class FindNthSmallestNumber {


    private int partition(int[] array, int n) {
        int pivot = array[array.length -1];
        int comparator = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[comparator];
                array[comparator] = temp;
                comparator++;
            }
        }
        int temp = array[comparator];
        array[comparator] = pivot;
        array[array.length -1] = temp;

        System.out.println(Arrays.toString(array));
        if (n > comparator) {
            return partition(Arrays.copyOfRange(array, comparator, array.length), n - comparator);
        } else if (n < comparator) {
            return partition(Arrays.copyOfRange(array, 0, comparator), n);
        } else {
            return array[comparator];
        }
    }

    public static void main(String[] args) {
        FindNthSmallestNumber find = new FindNthSmallestNumber();
        int[] array = {
            2,5,6,10,11,3,7
        };

        int i = find.partition(array, 4);
        System.out.println(i);
    }
}