import java.util.Arrays;

public class Rotation {

    public void rotate(int[] array, int numOfRotation) {
       if (numOfRotation > 0) {
            int temp = array[0];
            for (int i = 1; i < array.length; i++) {
                array[i - 1] = array[i]; 
            }
            array[array.length -1] = temp;
            rotate(array, numOfRotation -1);
        }

    }


    public static void main(String[] args) {
        int[] array = {
            1,2,3,4,5
        };

        Rotation rotation = new Rotation();
        rotation.rotate(array, 4);
        System.out.println(Arrays.toString(array));
    }
}