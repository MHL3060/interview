import java.util.Iterator;
import java.util.LinkedHashSet;

public class FindLongestUniqueSubstring {

    public int lengthOfLongestUniqueSubstring(String s) {
        int maxLength = 0;
        
        int currentMaxLength = 0;
        LinkedHashSet set = new LinkedHashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i)) == false) {
                set.add(s.charAt(i));
                currentMaxLength++;
            } else {
                if (currentMaxLength > maxLength) {
                    maxLength = currentMaxLength;
                }
                // we need to find out the index of the duplicate.
               
                for(Iterator<Character> iterator = set.iterator(); iterator.hasNext();) {
                    if (iterator.next() != s.charAt(i)) {
                        iterator.remove();
                    } else {
                        iterator.remove();
                        break;
                    }
                }
               
                currentMaxLength = set.size();
            }
        }
        if (currentMaxLength > maxLength) {
            maxLength = currentMaxLength;
        }
        return maxLength;
    }
    public static void main(String[] args) {  
        FindLongestUniqueSubstring find = new FindLongestUniqueSubstring();
        String s = "abcdefgc";
        System.out.println(find.lengthOfLongestUniqueSubstring(s));
        String d = "abcdefg";
        System.out.println(find.lengthOfLongestUniqueSubstring(d));
        String f = "aaaaaaaa";
        System.out.println(find.lengthOfLongestUniqueSubstring(f));
    }

}