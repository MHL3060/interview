
import java.util.List;
import java.util.ArrayList;
public class BinaryTreeBsf {

    int numberOfNode = 0;

    public static void main(String[] args) {
        new BinaryTreeBsf();
    }
    public BinaryTreeBsf() {
      Node node = new Node(0, 0);
      numberOfNode++;

      for (int i = 1; i < 100; i++) {
        insert(node, i);
      }
     // print(node);
      Node tree = new Node(1);
      tree.left = new Node(2);
      tree.right = new Node(3);
      tree.left.left = new Node(4);
      tree.left.right = new Node(5);
      tree.right.left = new Node(6);
      tree.right.right = new Node(7);
      System.out.println(findLCA(tree, 4, 5).getValue());
      System.out.println(findLCA(tree, 4, 6).getValue());

    }

    private Node findLCA(Node node, int value1, int value2) {
      if (node == null) {
        return null;
      }

      if ( node.value == value1 || node.value == value2) {
        return node;
      }

      Node left = findLCA(node.left, value1, value2);
      Node right = findLCA(node.right, value1, value2);

      if ( left != null && right != null) {
        return node;
      }else {
        if (left != null) {
          return left;
        }else {
          return right;
        }
      }
    }

    private void print(Node root) {
      if (root != null) {
        System.out.println(root.getValue() + ", level "+ root.getLevel());
        print(root.getLeft());
        print(root.getRight());
      }
    }
    private boolean insert(Node root, int value) {
      int numberOfNodeToBeInserted = numberOfNode + 1;
      boolean succeed = false;
      int level = getLevel(numberOfNodeToBeInserted);
      System.out.println("leve " + level);

      List<Node> resultHolder = new ArrayList<Node>();
      findEmptyWithParentLevel(root, level, resultHolder);
      if (resultHolder.isEmpty() == false) {
        Node result = resultHolder.get(0);

        if (result.left == null) {
          result.left = new Node(value, level+1);
          numberOfNode = numberOfNodeToBeInserted;
          succeed = true;
        }else {
          result.right = new Node(value, level+1);
          numberOfNode = numberOfNodeToBeInserted;
          succeed = true;
        }
      }

      return succeed;
    }
    private int getLevel(int numberOfNodeOnceInserted) {
      System.out.println("number of node " + numberOfNodeOnceInserted);
      if (numberOfNodeOnceInserted == 1) {
        return -1;
      }else {
        int result = (int)(Math.log(numberOfNodeOnceInserted)/Math.log(2)) - 1;
        if (result < 0){
          return 0;
        }else {
          return result;
        }
      }
    }
    private void findEmptyWithParentLevel(Node node, int level, List<Node> result) {

      if (node == null) {
        return;
      }else if (node.getLevel() == level) {
        if (node.left == null || node.right == null) {
          result.add(node);
          return;
        }
      }else if (node.getLevel() < level) {
         findEmptyWithParentLevel(node.left,level, result);
         if (result.isEmpty()) {
           findEmptyWithParentLevel(node.right, level, result);
         }
      }else {
        throw new RuntimeException("level does not exist in the tree");
      }
    }

    public class Node {
        private Node left;
        private Node right;
        private int value;
        private int level;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, int level) {
          this.value = value;
          this.level = level;
        }
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public int getValue() {
            return value;
        }
        public int getLevel() {
          return level;
        }
        public void setLevel(int level) {
          this.level = level;
        }
    }
}
