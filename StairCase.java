
public class StairCase {


    public void print(int n) {

        for (int i = n; i >=0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = i; k < n; k++){
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StairCase sc = new StairCase();
        sc.print(100);
    }
}