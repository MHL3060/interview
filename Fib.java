import java.math.BigDecimal;

public class Fib {


  public static void main(String[] args) {
    Fib f = new Fib();
    System.out.println(f.fib(10000));
  }


  private BigDecimal fib(int i ) {
    if (i <= 1) {
      return new BigDecimal(i);
    }else {
      return fib(i-1).add( fib(i -2));
    }
  }
}
