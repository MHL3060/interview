import java.util.List;
import java.util.ArrayList;
public class StringManipulation {


  public static void main(String[] args) {
    StringManipulation str = new StringManipulation();
    str.revertString("hello world");

    str.generateWork();
  }

  public void revertString(String msg) {
    char[] text = msg.toCharArray();

    System.out.println(revert(text, 0));

  }

  public String[] generateWork() {
    char[] word1 = "hello".toCharArray();
    char[] word2 = "world".toCharArray();
    int size = word1.length;
    List<String> result = new ArrayList<String>();
    for (int i = 0 ; i < size; i++) {
      for (int j = 0; j < size; j++ ) {
        word1[i] = word2[j];
        word2[i] = word1[j];
        result.add(String.copyValueOf(word1));
        result.add(String.copyValueOf());
      }
    }
    result.forEach(System.out.println);

    return result;
  }
  private String revert(char[] msg, int index) {
    System.out.println(String.copyValueOf(msg));
    if ((msg.length -1)/2 == index) {
      return String.copyValueOf(msg);
    }else {

      int positionToSwap = msg.length -1 - index;
      char temp = msg[index];
      msg[index] = msg[positionToSwap];
      msg[positionToSwap] = temp;
      index= index+1;
      return revert(msg, index);
    }
  }

}
