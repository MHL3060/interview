import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class FindIndiceForTarget {


    public static void main(String[] args) {
        int target = 12;
        int[] result = solution(
            new int[]{
                4,5,6,7,8,9
            }, target
        );

        System.out.println(String.format("The element of indices %s and %s added up to %s",
         result[0], result[1], target));
    }
    private static int[] solution(int[] array, int target) {
        
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int remain = target - array[i];
            if (remain >=0 && hash.get(remain) != null) {
                return new int[]{i, hash.get(remain)};
            }
            hash.put(array[i], i);
        }
        return new int[]{-1, -1};
    }
}