import java.util.List;
import java.util.ArrayList;

public class PrintMetrixInSpiral {

    //matrix[y][x]
    //I think it should be goover the prelimary and doing it recursively.
    public List<Integer> convert(int[][] matrix, int xStart, int xEnd, int yStart, int yEnd, List<Integer> result) {

        if (xStart > xEnd && yStart > yEnd) {
            return result;
        }
        for (int i = xStart; i < xEnd; i++) {
            result.add(matrix[yStart][i]);
        }
        for (int i = yStart + 1; i < yEnd - 1; i++) {
            result.add(matrix[i][xEnd-1]);
        }

        for (int i = xEnd -1; i >= xStart; i--) {
            result.add(matrix[yEnd-1][i]);
        }
         for (int i = yEnd - 2; i > yStart; i --) {
             result.add(matrix[i][xStart]);
         }
         return convert(matrix, xStart + 1, xEnd -1, yStart + 1, yEnd -1, result);
    }


    public static void main(String[] args) {

        PrintMetrixInSpiral print = new PrintMetrixInSpiral();
        List<Integer> result = new ArrayList<Integer>();

        int[][] matrix = new int[][]{
            {1,2,3,4,5},
            {5,6,7,8,5},
            {9,10,11,12,5},
            {13,14,15,16,5}
        };

        print.convert(matrix, 0, matrix[0].length, 0, matrix.length, result);

        System.out.println(result);
    }
}