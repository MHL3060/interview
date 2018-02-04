public class Divide {

  public static void main(String[] args) {
    Divide d = new Divide();

    System.out.println(d.divide(10, 5));
    System.out.println(d.divide(10, 3));
    System.out.println(d.divide(10, 4));
    System.out.println(d.divide(100, 2));
    System.out.println(d.divide(2, 3));
    System.out.println("bit shift =" + d.divideUsingBitShift(9, 3));
  }

  private int divide(int nominator, int denominator) {
    if (nominator < denominator) {
      return 0;
    }else {
     return divide(nominator - denominator, denominator) + 1;
    }
  }

  private int divideUsingBitShift(int nominator, int denominator) {
    return (nominator >> denominator)<< 1;
  }
}
