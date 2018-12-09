import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum {

    public List<Pair> findPairs(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int index = map.get(array[i]);
                pairs.add(new Pair(i, index));
            } else {
                int diff = sum - array[i];
                map.put(diff, i);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] array = new int[]{
            1,2,3,4,5,6,7,8,9,5
        };
        Sum sum = new Sum();
        List<Pair> pairs = sum.findPairs(array, 10);

        pairs.forEach((e) -> {
            System.out.print(e.index2 + ", " + e.index1);
            System.out.println(" " + array[e.index1] + " + " + array[e.index2]);
        });
    
    }

    public class Pair {
        private int index1;
        private int index2;
        public Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
        public int getFirstIndex() {
            return this.index1;
        }
        public int getSecondIndex() {
            return this.index2;
        }

    }

}