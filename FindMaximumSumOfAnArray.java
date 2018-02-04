public class FindMaximumSumOfAnArray {

  public static void main(String[] args) {

    int[] array = new int[]{3,-4,3,4,5};
    FindMaximumSumOfAnArray find = new FindMaximumSumOfAnArray();

    System.out.println("max sum =" + find.maxSumOfSubArray(array));

  }

  private int maxSumOfSubArray(int[] array) {

    int maxInHere = array[0];
    int maxSoFar = array[0];
    for ( int i = 1; i < array.length; i++) {
      maxInHere = maxInHere + array[i];
      maxInHere = Math.max(maxInHere, array[i]);
      if (maxInHere >= maxSoFar) {
        maxSoFar = maxInHere;
      }
    }

    return maxSoFar;
  }
}
