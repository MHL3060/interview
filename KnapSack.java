import java.util.Arrays;

public class KnapSack {


  public static void main(String[] args) {
    int[] weights = new int[]{3,4,5,6};
    int[] values = new int[]{50,40,10, 30};
    int maxWeight = 10;
    KnapSack ks = new KnapSack();
    int[][] result = ks.initialize(weights, values, maxWeight);
    for (int i =0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }

  private int[] solve(int[][] result, int[] weights, int[] values) {
    int maxValue = 0;
    int[] coordinate = new int[2];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        if (result[i][j] > maxValue) {
          maxValue = result[i][j];
          coordinate[0]=i;
          coordinate[1]=j;
        }
      }
    }
  }

  private int[] findComposite(int[][] result) {

  }



  private int[][] initialize(int[] weights, int[] values, int maxWeight) {

    int[][] combinations = new int[weights.length][maxWeight+1];

    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j <= maxWeight; j++) {
        if (weights[i] > j) {
          if (i > 0) {
            combinations[i][j] = combinations[i -1][j];
          }else {
            combinations[i][j] = 0;
          }
        } else {
          if (i > 0) {
            combinations[i][j] = Math.max(values[i] + combinations[i-1][j - weights[i]], combinations[i-1][j]);
          }else {
            combinations[i][j] = values[i];
          }
        }
      }
    }
    return combinations;
  }
}
