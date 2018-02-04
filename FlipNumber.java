public class FlipNumber {


  public static void main(String[] args) {

    FlipNumber fn = new FlipNumber();
    System.out.println(" is 666 flippable " + fn.isFlippable(666));
  }

  private boolean isFlippable(int number) {
    String s = ""+ number;
    s = reverse(s);
    for ( int i = 0; i < s.length(); i++) {
      if ("01689".contains("" + s.charAt(i)) == false ) {
        return false;
      }
    }
    System.out.println(s);
    s = s.replaceAll("6", "9");
    s = s.replaceAll("9", "6");
    System.out.println(s);
    if (Integer.parseInt(s) == number) {
      return true;
    }else {
      return false;
    }
  }
  private String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for ( int i = 0; i < s.length()/2; i++ ) {
      char temp = chars[i];
      chars[i] = chars[s.length() - i -1];
      chars[s.length() -i -1] = temp;
    }
    return String.valueOf(chars);
  }

}
