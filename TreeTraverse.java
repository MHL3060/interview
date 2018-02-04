import java.util.ArrayList;
import java.util.List;
public class TreeTraverse {

  public static void main(String[] args) {

     Node tree = new Node(1);
    tree.setLeft(new Node(2));
    tree.setRight(new Node(3));
    tree.getLeft().setLeft(new Node(4));
    tree.getLeft().setRight(new Node(5));
    tree.getLeft().getRight().setLeft(new Node(8));
    tree.getLeft().getRight().setRight(new Node(9));
    tree.getRight().setLeft( new Node(6));
    tree.getRight().setRight( new Node(7));

    List<Integer> preOrder = new ArrayList<Integer>();

    TreeTraverse tt = new TreeTraverse();
    tt.preOrder(tree, preOrder);
    System.out.print("preOrder ");
    preOrder.forEach((e) -> {
      System.out.print(" "+ e);
    });

    List<Integer> inOrder = new ArrayList<Integer>();
    tt.inOrder(tree, inOrder);
    System.out.print("\n inOrder ");
    inOrder.forEach((e) -> {
      System.out.print(" "+ e);
    });

    List<Integer> postOrder = new ArrayList<Integer>();
    tt.postOrder(tree, postOrder);
    System.out.print("\n postOrder ");
    postOrder.forEach((e) -> {
      System.out.print(" "+ e);
    });
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

}
