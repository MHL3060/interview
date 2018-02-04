public class MissingNumber {

  public static void main(String[] args) {
    MissingNumber mn = new MissingNumber();

    int[] numberArray = new int[]{1,2,3,4,5,6,7,8,10};
    System.out.println("missing number is = " + mn.findMissing(numberArray, 0, numberArray.length));
  }

  private int findMissing(int[] array, int start, int end) {
    int halfLength = start + (end - start)/2;
    System.out.println("half length = " + halfLength);
    int middle = array[halfLength];
       // meaning a number is missing at the first half.
      if (middle != halfLength) {
        if (end - start == 1) {
          return halfLength;
        } if (end- start == 2) {
          return halfLength;
        }else {
          System.out.println("index ne from " + start + " end " + halfLength);
          return findMissing(array, start, halfLength);
        }

      }else {

        System.out.println("index from " + halfLength + " end " + end);
        return findMissing(array, halfLength, end);
      }


  }
}
