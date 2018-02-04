import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class BreathFirstTreeTraveral {


  public static void main(String[] args) {
    Node node = new Node(1);
    node.setLeft(new Node(2));
    node.setRight(new Node(3));
    node.getLeft().setLeft(new Node(4));
    node.getLeft().setRight(new Node(5));
    node.getRight().setLeft(new Node(6));
    node.getRight().setRight(new Node(7));


    BreathFirstTreeTraveral bft = new BreathFirstTreeTraveral();
    List<Node> list = new ArrayList<>();
    list.add(node);
    List<Integer> result = new ArrayList();
    int level = 0;
    bft.breathFirstTraveral(list, result, level);

    result.forEach( s -> System.out.print(s + " "));
    result.clear();
    bft.depthFirstTraveral(node, result);
    System.out.println("");
    result.forEach( s -> System.out.print(s + " "));

    bft.breathFirstTraveral(node);
  }
  private void depthFirstTraveral(Node node, List<Integer> values ) {

    if (node.getLeft() != null) {

      depthFirstTraveral(node.getLeft(), values);
    }
    if (node.getRight() != null) {
      depthFirstTraveral(node.getRight(), values);
    }
     values.add(node.getValue());

  }

  private boolean isTreeMirror(List<Node> nodes) {

    if (nodes.size()> 1) {
      for (int i = 0; i < nodes.size()/2; i++) {
        int lastIndex = nodes.size() -1;
        if (nodes.get(i).getValue() != nodes.get(lastIndex -i).getValue()) {
          return false;
        }
      }
    }
    return true;
  }

  private void breathFirstTraveral(Node node) {
    if (node != null) {
      System.out.print(node.getValue());
       breathFirstTraveral(node.getLeft());
        breathFirstTraveral(node.getRight());
    }

  }
  private void breathFirstTraveral(List<Node> nodes, List<Integer> values, int level) {
    List<Node> children = new ArrayList<>();
    for (Node n : nodes) {
      values.add(n.getValue());
      if (n.getLeft() != null) {
        children.add(n.getLeft());
      }
      if (n.getRight() != null) {
        children.add(n.getRight());
      }
    }
    if ( children.size() > 0) {
      level = level++;
       breathFirstTraveral(children, values, level);
    }
  }
}
