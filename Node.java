public class Node {


  private Node leftNode;
  private Node rightNode;

  private int value;

  private int level;
  private char key;
  public Node(char c) {
    this.key = c;
  }

  public Node(char key, int value) {
    this.key = key;
    this.value = value;
  }

  public void setKey(char key) {
    this.key = key;
  }
  public char getKey() {
    return key;
  }
  public Node(int value) {
    this.value = value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  public Node(int value, Node left, Node right, int level) {
    this.value = value;
    this.leftNode = leftNode;
    this.rightNode = rightNode;
    this.level = level;
  }


  public void setLeft(Node node) {
    this.leftNode = node;
  }
  public void setRight(Node right) {
    this.rightNode = right;
  }
  public int getValue() {
    return value;
  }
  public Node getLeft() {
    return leftNode;
  }
  public Node getRight() {
    return rightNode;
  }
  public int getLevel() {
    return level;
  }
}
