public class LcaTree {

  public static void main(String[] args) {
    LcaTree t = new LcaTree();
    Node tree = new Node(1);
    tree.setLeft(new Node(2));
    tree.setRight(new Node(3));
    tree.getLeft().setLeft(new Node(4));
    tree.getLeft().setRight(new Node(5));
    tree.getRight().setLeft( new Node(6));
    tree.getRight().setRight( new Node(7));
    System.out.println(t.findLCA(tree, 4, 5).getValue());
    System.out.println(t.findLCA(tree, 4, 6).getValue());
  }
  private Node findLCA(Node node, int value1, int value2) {
    if (node == null) {
      return null;
    }
    if ( node.getValue() == value1 || node.getValue() == value2) {
      return node;
    }

    Node left = findLCA(node.getLeft(), value1, value2);
    Node right = findLCA(node.getRight(), value1, value2);

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
}
