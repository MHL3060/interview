public class LongestIncreaseSeq {


  public static void main(String[] args) {
    int[] numbers = new int[]{
      1,2,3,4,5,6,7,8,10,
      1,2,3,4,5,6,7,8,9,10,11,
      1,2,3
    };
    LongestIncreaseSeq lSeq = new LongestIncreaseSeq();
    System.out.println(lSeq.longestIncreaseSeq(numbers));
  }


  private int longestIncreaseSeq(int[] numbers) {
    int currentMaxSeq = 1;
    int previousMax = 0;
    int previousValue = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
      if ( numbers[i] >= previousValue) {
        currentMaxSeq++;
      } else {
        if (currentMaxSeq > previousMax) {
          previousMax = currentMaxSeq;
        }
        currentMaxSeq = 1;
      }
      previousValue = numbers[i];
    }

    return previousMax;
  }
}
