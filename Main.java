
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
    }

    private int totalSize = 50;
  //  private int collection[] = new int[totalSize];
    private int first =0;
    private int pivot =0;
    public Main() {

        /*TreeNode node = new TreeNode();
        populate(node, 0);

        int sum = 0;
        sum = calculate(node, sum);
        System.out.println("" + sum);

        System.out.println("============= populate=============" );
        node = new TreeNode();
        populate2(node, 0);

        sum = calculate(node, 0);
        System.out.println("" + sum);
        for (int i =0; i < 1000; i++) {
            add(i);
            print();
        }

        System.out.println(revertString("hello world"));
        */
        int[] list = new int[100000];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 10000000) %10000000;
        }
       // int[] list = new int[] {12, 40, 39, 88, 43, 8, 47, 96, 97, 84, 34, 42, 26, 1, 13, 67, 78, 65, 89, 99, 43, 77, 72, 86, 77};
        System.out.println("Before answer");
        long start = System.currentTimeMillis();
        mergeSort(list);
        System.out.println("time in milli" + (System.currentTimeMillis() - start));
        printTreeInVertical();

    }


    private void construct(TreeNode node, int left, int right, int level) {
        node.left = new TreeNode(left, level);
        node.right = new TreeNode(right, level);

    }
    private void printTreeInVertical() {

        TreeNode node = new TreeNode(1,0);

        construct(node, 2, 3,1);
        construct(node.left, 4, 5, 2);
        construct(node.right, 6, 7, 2);
        construct(node.right.left, -1, 8,3);
        construct(node.right.right, -1, 9, 3);
        print(node);

    }
    private void print(int value) {
        if (value != -1) {
          System.out.println(value);
        }
    }
    private void print(TreeNode node) {
        List<TreeNode> holder = new ArrayList<TreeNode>();
        int level = 0;
        findLevel(node, level, holder);

        while(holder.isEmpty() ==false) {
          holder.forEach((e)->{this.print(e.value);});
          holder.clear();
          level++;
          findLevel(node, level, holder);
        }
    }

    private void findLevel(TreeNode node, int level, List<TreeNode> holder){
      if (node == null) {
        return;
      }
      if (node.level == level ) {
        holder.add(node);
        return;
      }else if (node.level > level) {
        return;
      }else {
        findLevel(node.left, level, holder);
        findLevel(node.right, level, holder);
      }
    }
    public int[] bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[i] > list[j]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }
    public int[] mergeSort(int[] collection) {
        int sizeOfCollection = collection.length;
        if (sizeOfCollection > 2) {
            int[] leftSub = copy(collection, 0, sizeOfCollection/2);
            int[] left = mergeSort(leftSub);
            int[] rightSub = copy(collection, sizeOfCollection/2, sizeOfCollection);
            int[] right = mergeSort(rightSub);
            int result[] = new int[sizeOfCollection];
            int position = 0;
            int rightPosition = 0;
            for (int i= 0; i < left.length; i++) {
                for(int j = rightPosition; j < right.length; j++ ) {
                    if (right[j] < left[i]){
                        result[position] = right[j];
                        position++;
                        rightPosition++;
                    }else {
                        break;
                    }
                }
                result[position] = left[i];
                position++;
            }
            for (int i = rightPosition; i < right.length; i++) {
                result[position] = right[i];
                position++;
            }
            return result;
        }else if (collection.length == 1) {
            return collection;
        }else {
            if (collection[0] > collection[1]) {
                int temp = collection[0];
                collection[0] = collection[1];
                collection[1] = temp;
                return collection;
            }else {
                return collection;
            }
        }
    }
    private int[] copy(int[] collections, int start, int end) {
        int size = end - start;
        int[] result = new int[size];
        int pivot = 0;
        for (int i = start; i < end; i++) {
            result[pivot] = collections[i];
            pivot++;
        }
        return result;
    }
    private String revertString(String s) {
        if (Objects.isNull(s)) {
            return null;
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() -1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
    }
    private void print(String msg, int[] collection) {
        System.out.println(msg + " "+ Arrays.toString(collection));
    }
    private void print() {
        //System.out.println(Arrays.toString(collection));
    }
/*
    private void add(int value) {
        collection[pivot] = value;
        pivot = (pivot+1) % totalSize;
    }

    public int calculate(TreeNode node, int value) {
        int result = value;
        if ( node != null) {
            System.out.println("node value " + node.value + " value " + result);
            result = value + node.value;
            result = calculate(node.left, result);
            result = calculate(node.right, result);
            return result;
        }else {
           return value;
        }
    }

    public void populate2(TreeNode node, int value) {

        TreeNode left = new TreeNode();
        left.value = value +1;
        node.left = left;

        TreeNode right = new TreeNode();
        right.value = value + 2;
        node.right = right;

        if ( value < 10) {
            populate2(left, value+2);
            populate2(right, value + 2);
        }

    }
    public void populate(TreeNode node, int value) {
        TreeNode leaf = new TreeNode();
        leaf.value = value;
        if (value % 2 == 0) {
            node.left = leaf;
        }else {
            node.right = leaf;
        }
        value = value + 1;


        if ( value == 100) {
            return;
        }else {
            populate(leaf, value);
        }
    }
    */
    public class TreeNode {
        public boolean visit = false;
        public int level;
        public int value;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
        public TreeNode(int value, int level) {
          this.value = value;
          this.level = level;
        }
    }


}




