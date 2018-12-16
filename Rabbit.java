import java.util.ArrayList;
import java.util.List;

public class HungryRabbit {

    //if the rabbit visit the location. set it to 0.
    
    public int eatCarrot(int[][] matrix, int x, int y) {
        
        
        
    }

    public Location[] getNeighbors(Location location, int matrixRowSize, int matrixColumnSize) {

        List<Location> items = new ArrayList<Location>();
        int previousRow = location.row - 1;
        int previousColumn = location.row - 1;
        int nextRow = location.row + 1;
        int nextColumn = location.column + 1;
        
        for (int i = previousRow; i <= nextRow; i++) {
            for (int j = previousColumn; j <= nextColumn; j++) {
                if (i >= 0 && j >=0 && i < matrixRowSize && j < matrixColumnSize && i != location.row && j != location.column) {
                    items.add(new Location(i, j));
                }
            }
        }
        return items.toArray();
    }

    private Location findDropLocation(int[][] matrix) {

        int rowLenght = matrix.length;
        int columnLength = matrix[0].length;
        
        if (rowLength % 2 == 0) {
            if (column % 2 == 0) {

            } else {
                int row = matrix[rowLenght/2][columnLength/2 + 1] > matrix[rowLength/2+1][columnLength/2 + 1] ? rowLength/2 : rowLength/2 + 1; 
                return new Location(row ,columnLength/2 + 1);
            }
        } else {
    
        }
    }

    

    

    private class Location {
        private int row;
        private int column;
        public Locaiton(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return this.row;
        }
        public int getColumn() {
            return this.column;
        }
    }
    
    
}