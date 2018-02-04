import java.util.Objects;

public class DetectCycleLinkList {

  public static void main(String[] args) {

    Node list = new Node(1);
    list.setLeft(new Node(2));
    list.getLeft().setLeft(new Node(3));
    list.getLeft().getLeft().setLeft(new Node(4));
    list.getLeft().getLeft().getLeft().setLeft(new Node(5));
    list.getLeft().getLeft().getLeft().getLeft().setLeft(new Node(6));
    list.getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new Node(7));
    list.getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new Node(8));
    list.getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new Node(9));
    // list.getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(new Node(10));
    list.getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().getLeft().setLeft(list.getLeft().getLeft().getLeft());

    DetectCycleLinkList l = new DetectCycleLinkList();


    System.out.println(l.isCycleLinkList(list));


  }


  private boolean isCycleLinkList(Node node) {

    Node valueOfFirst  = node;
    Node valueOfSecond = node;
    boolean isCycle = false;
    while(true) {

      valueOfFirst = next(valueOfFirst, 1);
      valueOfSecond = next(valueOfSecond, 3);

      if (valueOfFirst == null || valueOfSecond == null) {
        isCycle = false;
        break;
      }
      if(Objects.equals(valueOfFirst, valueOfSecond)) {
        isCycle = true;
        break;
      }

    }
    return isCycle;
  }

  private Node next(Node node, int jump) {
    Node p = node;
    for (int i = 0; i < jump; i++) {
      p = p.getLeft();
      if (p == null ) {
        break;
      }
    }
    return p;
  }
}
