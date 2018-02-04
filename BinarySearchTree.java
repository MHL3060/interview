public class BinarySearchTree {




  public static void main(String[] args) {
    char[] string = new char[]{
      'D', 'I', 'D', 'I'
    };

    BinarySearchTree bst = new BinarySearchTree();
    Node root = new Nod('0', 1);
    Node node = root;
    for ( int i = 1; i < string.length; i++) {
      node =  bst.insert(node, string[i-1], i+1);
    }

      


  }


  public node insert(Node node, char key, int value) {

    Node n = new Node(key, value);
    if (key == 'D') {
      node.setLeft(n);
    }else {
      node.setRight(n);
    }
    return n;
  }

  private void preOrder(Node node, List<Integer> result) {

    if (node != null) {
      result.add(node.getValue());
    }else {
      return;
    }
    preOrder(node.getLeft(), result);
    preOrder(node.getRight(), result);
  }

  private void inOrder(Node node, List<Integer> result) {
    if (node.getLeft() != null) {
      inOrder(node.getLeft(), result);

    }
    result.add(node.getValue());
    if (node.getRight() != null) {
      inOrder(node.getRight(), result);
    }
  }

  private void postOrder(Node node, List<Integer> result) {
    if(node.getLeft() != null) {
      postOrder(node.getLeft(), result);
    }
    if(node.getRight() != null) {
      postOrder(node.getRight(), result);
    }
    result.add(node.getValue());
  }

  private void rotateLeft(Node node) {


  }

  private void rotateRight(Node node) {

  }

  public class KeyValueNode extends Node {

    public KeyValue()
  }

}

