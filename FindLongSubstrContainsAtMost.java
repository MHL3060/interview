import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindLongSubstrContainsAtMost {
    public static void main(String[] args) {
       find("karappa", 2); 
       find("abbbbbbbbbbbbbbc", 1);
    }

    public static void find(String s, int j) {

        
        Map<Character, Integer> unique = new HashMap<>();
        int start = 0;
        char startChar = s.charAt(0);
        int maxSize = 0;
        int maxStart = 0;
        int currentSize = 1;
        
        unique.put(startChar,1);
        for (int i = 1; i < s.length(); i++ ) {
           char c = s.charAt(i);
           if (unique.keySet().contains(c) == false) {
               //need to be one less as
               if(unique.size() <j) {
                    Integer occurance = unique.getOrDefault(c, 0);
                    unique.put(c, occurance+1);
                    currentSize++;
               }else {
                   if (currentSize > maxSize) {
                        maxSize = currentSize;
                        maxStart = start;
                   }
                    //remove and add
                    Integer occurance = 0;
                    //find the one that has only one occurance and start from there. 
                    //otherwiese we cannot add.
                    do {
                        char sc = s.charAt(start);
                        occurance = unique.get(sc);
                        if (occurance > 1) {
                            unique.put(sc, occurance-1);
                            start++;
                        }else {
                            unique.remove(sc);
                            start++;
                        }
                        currentSize--;
                    } while(occurance != 1);
                    occurance = unique.getOrDefault(c, 0);
                    unique.put(c, occurance+1);
                    currentSize++;  
               }
           } else {
                Integer occurance = unique.getOrDefault(c, 0);
                unique.put(c, occurance+1);
               currentSize++;
           }
        }
        //that means the whole string is unique.
        if (currentSize > maxSize) {
            maxStart = start;
            maxSize = currentSize;
        }
        System.out.println(String.format("max unique string is from index %s and the substring is %s", maxStart, s.substring(maxStart, maxStart+maxSize)));
    }
}