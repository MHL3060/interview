import java.util.concurrent.ForkJoinPool;

public class LongestCommonSeq {

    static int complexity = 0;

    private String findMaxLengthFromPosition(String first, String second, int position) {
        String result = "";
        
        int secondPosition = 0;
        for (int i = position; i < first.length(); i++) {
        
            for (int j = secondPosition; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    result += first.charAt(i);
                    secondPosition = j + 1;
                    complexity++;
                    break;
                }
                complexity++;
            }
        }
        return result;
    }

    public String find(String first, String second) {
        String max = "";

        for (int i = 0; i < first.length(); i++) {
            String result = this.findMaxLengthFromPosition(first, second, i);
            if (result.length() > max.length()) {
                max = result;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSeq seq = new LongestCommonSeq();
        String first = "AGGTAB";
        String second = "GXTXAYB";

        String s = seq.find(first, second);
        System.out.println(s);
        System.out.println("steps " + complexity );
    }
}