import java.util.*;
public class RotateArray {

  public static void main(String[] args) {
    new RotateArray();
  }
  public RotateArray() {
    int[] array = new int[10];
    for ( int i = 0; i < array.length; i++) {
      array[i] = i;
    }

     int rotate = (int)(Math.random() * 100) % 100;

     for ( int i = 0; i < array.length; i++) {
       array[i] = (rotate + i + array.length) % array.length;
     }


    System.out.println(Arrays.toString(array));
     System.out.println("rotate " + rotate);
    int result = findSmallest(array,0, array.length-1);
    System.out.println("index =" + result);
  }
  private int findSmallest(int[] array, int start, int end) {
    int middleIndex = start + (end - start)/2;
    System.out.println("start =" + start + " middle =" + middleIndex + " end =" + end);
    if(end - start < 2) {
      if (array[end] < array[start]) {
        return end;
      }else {
        return start;
      }
    }else if (array[middleIndex] > array[end]) {
      return findSmallest(array, middleIndex, end);
    }else if (array[middleIndex] < array[end]) {
      return findSmallest(array, start, middleIndex);
    }else {
      return -1;
    }
  }
}
