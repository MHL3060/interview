
public class FindMaximumHourGlass {

    public int findMax(int[][] matrix) {

        int matrixRow = matrix.length;
        int matricColumn = matrix[0].length;
        int totalHourGlassInARow  = matrixRow-3 + 1;
        int totalHourGlassInAColumn = matricColumn-3 + 1;
        int max = 0;
        for (int row = 0; row < totalHourGlassInARow; row++) {
            for (int column = 0; column < totalHourGlassInAColumn; column++) {
                int sum = 0;
                for (int glassRow = row; glassRow < row + 3; glassRow = glassRow + 2){
                    for (int glassColumn = column; glassColumn < column + 3; glassColumn++) {
                        sum += matrix[glassRow][glassColumn];
                    }
                }
                sum += matrix[row+1][column+1];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaximumHourGlass find = new FindMaximumHourGlass();

        int [][] matrix = new int[][]{
            {2,3,0,0,0},
            {0,1,0,0,0},
            {1,1,1,0,0},
            {0,0,2,4,4},
            {0,0,0,2,0}
        };
        System.out.println(find.findMax(matrix));
    }
}