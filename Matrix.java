import java.util.stream.IntStream;
import java.util.*;
public class Matrix {

  public static void main(String[] args) {
    Matrix m = new Matrix();

    m.rotate90();
  }


  public void transpose() {

    int size = 3;
    int value = 1;
    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = value;
        value++;
      }
    }
    for (int i = 0; i < matrix.length; i++){
        System.out.println(" --------------------matrix" + Arrays.toString(matrix[i]));
      }
    transpose(matrix);
  }


  public int[][] generateMatrix(int size) {
    int value = 1;
    int[][] matrix = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = value;
        value++;
      }
    }
    for (int i = 0; i < matrix.length; i++){
      System.out.println(" generated matrix" + Arrays.toString(matrix[i]));
    }
    System.out.println();
    return matrix;
  }
  public void rotate90() {

    int[][] result = generateMatrix(25);
    for (int row = 0; row < result.length; row++) {
      for( int column = 0; column < result.length - row ; column++) {
        int pivot = result[row][column];
        int oppositePositionRow = result.length -1 - column;
        int oppositePositionColumn = result.length -1 - row;
        result[row][column] = result[oppositePositionRow][oppositePositionColumn];
        result[oppositePositionRow][oppositePositionColumn] = pivot;
      }
    }
    for ( int row = 0; row < result.length/2; row++) {
      for(int column = 0; column < result.length; column++) {
        int pivot = result[row][column];
        int rowToSwap = result.length -row -1;
        result[row][column] = result[rowToSwap][column];
        result[rowToSwap][column] = pivot;
      }
    }
    for (int i = 0; i < result.length; i++){
      System.out.println(Arrays.toString(result[i]));
    }

  }
  public void transpose(int[][] matrix) {

      int size = matrix[0].length;
      int[][] transpose = new int[size][size];

      for (int i =0; i < size; i++) {
        for (int j =0; j < size; j++) {
          if (i + j == size -1) {
            transpose[i][j] = 1;
          }else {
            transpose[i][j] = 0;
          }
        }
      }
      for (int i = 0; i < transpose.length; i++){
        System.out.println("transpose matrix" + Arrays.toString(transpose[i]));
      }
      int[][] result = transpose(matrix, transpose);
      for(int i = 0; i < size; i++) {
        System.out.println(Arrays.toString(result[i]));
      }
    }
    /**
     * [i,j,   i,j+1]
     * [i+1,j, i+1,j+1]
     *
     *
     */

    private int[][] transpose(int[][] first, int[][] second) {

      int size = first[0].length;
      int[][] result = new int[size][size];
      for (int i = 0; i < size; i++ ) {
        for (int j = 0; j < size; j++) {
          result[i][j] = sum(first, i, second, j);
        }
      }
/*
      for (int i = 0; i <= size/2; i++) {
        int temp = result[i][i];
        result[i][i] = result[size-1-i][size-1-i];
        result[size-1-i][size-1-i] = temp;
      }
*/
      return result;
    }
/*
  [wfwef][fwefwef][fewfew]

  [wfef]
  [ewfewf]
  [wefef]
*/
    private int sum(int[][] matrix,int matrixRow, int[][] secondMatrix, int secondMatrixColumn) {
      int sum = 0;
      for (int i = 0; i < matrix[matrixRow].length; i++) {
        sum = sum +  matrix[matrixRow][i] * secondMatrix[i][secondMatrixColumn];
      }
      return sum;

    }

  }

