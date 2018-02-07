import java.util.HashMap;
import java.util.Map;

public class SumEqualsTarget {
  
    public static void main(String[] args) {
        findIndicesThatElementsSumToTarget(new int[]{
            1,2,3,4,5,6, 7
        }, 11);
    }

    public static void findIndicesThatElementsSumToTarget(int[] array, int sum) {
       
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i < array.length; i++) {
            int remain = sum - array[i];
            if (remain >=0 && map.get(remain) != null) {
                System.out.println( String.format("the element can add up to %s are %s and %s ", sum, remain, array[i]));
            }
            map.put(array[i], true);
            
        }

        
    }
}