public class Number {


  public static void main(String[] args) {
    Number n = new Number();

    System.out.println("12 + 2  = " +  n.add(12, 2));
    System.out.println("12 - 2  = " + n.substract(12, 2));
    System.out.println("12 * 2  = " + n.multiply(12, 2));
    System.out.println("12 / 2  = " + n.devide(12, 2));
  }

  public int add(int x, int y) {
    while(y != 0) {
      int carry = x & y;
      x = x ^ y;
      y = carry << 1;
    }
    return x;
  }
  private int substract(int x, int y) {
    int m = add(~y, 1);
    int result = add(x, m);
    return result;
  }
  private int multiply(int x, int y) {
    int result = x;
    for (int i = 0; i < y -1 ; i++) {
      result = add(result, x);
    }
    return result;
  }

  private int devide(int x, int y) {
    if (x >= y) {
      return devide(substract(x, y), y) + 1 ;
    }else {
      return 0;
    }
  }
}
