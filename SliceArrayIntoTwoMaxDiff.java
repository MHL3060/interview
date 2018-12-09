
public class SliceArrayIntoTwoMaxDiff {



    public static void main(String[] args) {
        SliceArrayIntoTwoMaxDiff diff = new SliceArrayIntoTwoMaxDiff();

        int d =diff.maxDiff(new int[]{
           3,1,3-3
        });
        System.out.println("max diff =" + d);
    }

    public int maxDiff(int[] array) {

        int[] rMax = new int[array.length];
        int[] lMax = new int[array.length];
        lMax[0] = array[0];
        rMax[0] = array[array.length -1];
        for (int i = 1; i < array.length; i++) {
            lMax[i] = Math.max(array[i], lMax[i-1]);
        }
        for (int i = array.length-2; i >=0; i--) {
            rMax[i] = Math.max(rMax[i+1], array[i]);
        }
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxDiff = Math.abs(Math.max(lMax[i] - rMax[i], maxDiff));
        }

        return maxDiff;
    }



}