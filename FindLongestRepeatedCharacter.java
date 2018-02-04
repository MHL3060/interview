public class FindLongestRepeatedCharacter {


  public static void main(String[] args){


    String s = "12345666666664443333";

    FindLongestRepeatedCharacter flrc = new FindLongestRepeatedCharacter();
    System.out.println(flrc.findLongestRepeatString(s));
    String a = "ffgggtvshjsdhjfffffffhvjbjcharu";
    System.out.println(flrc.findLongestRepeatString(a));
  }


  private String findLongestRepeatString(String in) {
    int maxSize = 1;

    int currentSize = 1;
    if ( in.length() <= 1) {
      return in;
    }
    char currentC = in.charAt(0);
    char maxC = currentC;
    for (int i =1; i < in.length(); i++) {

      if (currentC == in.charAt(i)) {
        currentSize++;
      }else if (currentSize > maxSize) {
        maxSize = currentSize;
        maxC = currentC;
        currentC = in.charAt(i);
        currentSize = 1;
      }else {
        currentC = in.charAt(i);
        currentSize= 1;

      }

    }
    String result = "";
    for (int i = 0; i < maxSize; i++) {
      result += maxC;
    }
    return result;
  }
}
