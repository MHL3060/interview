import java.math.BigDecimal;

public class SumWithGreaterNode {


  public static void main(String[] args) {
    Node node = new Node(7);
    node.setLeft(new Node(3));
    node.setRight(new Node(9));
    node.getLeft().setLeft(new Node(1));
    node.getLeft().setRight(new Node(5));
    node.getRight().setLeft(new Node(8));
    node.getRight().setRight(new Node(10));

    SumWithGreaterNode sum = new SumWithGreaterNode();
    sum.bst(node, null);
  }

  private void dst(Node node, Node previous) {
    if ( node.getLeft() != null) {
      dst(node.getLeft(), node);
    }
    if (node.getRight() != null) {
      dst(node.getRight(), null);
    }
  }
  public void bst(Node node, Node previous) {
    System.out.print("before sum " + node.getValue());
    replacedWithSumOfGreater(node, previous);
    System.out.println(" after sum " + node.getValue());
    previous = node;
    BigDecimal
    if ( node.getLeft() != null) {
      bst(node.getLeft(), previous);
    }
    if (node.getRight() != null) {
      bst(node.getRight(), previous);
    }

  }
  public void replacedWithSumOfGreater(Node node, Node previous) {
    int value = node.getValue();
    if(node.getRight() != null) {
      value += sum(node.getRight());
    }
    if (previous != null) {
      value += previous.getValue();
    }
    node.setValue(value);
  }

  public int sum(Node node) {
    int sum = 0;
    if (node == null) {
      return sum;
    }else {
      sum = node.getValue();

      if (node.getLeft() != null) {
        sum += sum(node.getLeft());
      }
      if (node.getRight() != null) {
        sum += sum(node.getRight());
      }
      return sum;
    }
  }
}
