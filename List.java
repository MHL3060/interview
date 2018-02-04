
public class List {

  public List(){
    Node first = constructList(10);
    Node second = constructList(20);
    print(first);
    print(second);
    Node merged = merge(first, second);
    print(merged);
  }
  public Node merge(Node first, Node second) {
    Node pivot = first;
    Node secondPivot = second;
    Node last = pivot;
    while (pivot != null) {

      Node next = pivot.getNext();
      while(secondPivot != null) {
        if (pivot.getValue() >= secondPivot.getValue()) {
          Node t = secondPivot;
          pivot.setNext(t);
          secondPivot = secondPivot.getNext();
          t.setNext(next);
          pivot = pivot.getNext();
        }else {
          break;
        }
      }
      last = pivot;
      pivot = next;
    }
    if (secondPivot != null) {
      last.setNext(secondPivot);
    }
    return first;
  }
  private Node constructList(int length) {
    Node result = new Node(0);
    Node temp = result;
    for (int i =1; i < length; i++) {
      temp.setNext(new Node(i));
      temp = temp.getNext();
    }
    return result;
  }

  private void print(Node node) {
    Node pivot = node;

    while (pivot != null) {
      System.out.print(pivot.getValue() + " ");
      pivot = pivot.getNext();
    }
  }
  public static void main(String[] args) {
    List list = new List();
  }

  public class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node getNext() {
      return next;
    }
    public int getValue(){
      return value;
    }
    public void setNext(Node node){
      this.next = node;
    }
    public boolean hasNext() {
      return next != null;
    }
  }
}
