import java.util.ArrayList;
import java.util.List;

public class FindAllStringPermutation {

    public void permutation(String perm, String word, List<String> combinations)  {
        // abc bac bca,
        //cba, cab,
        //acb,
        // recursive.
        // abc, acb
        // bac bca
        // cab cba

        //  
        // | 
        if (word.isEmpty()) {
             combinations.add(perm + word);
             //return combinations;
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()), combinations);
            }
        }
    }

    public void permutation()

    public static void main(String[] args) {
        FindAllStringPermutation perm = new FindAllStringPermutation();
        List<String> result = new ArrayList<String>();

        perm.permutation("", "abc", result);

        result.forEach(e -> System.out.print(e + " ") );
    }
}