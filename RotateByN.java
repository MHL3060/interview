public class RotateByN {


    public Node rotateRight(Node node, int k) {

       
        Node previous = null;
        Node head = node;
        while(node != null) {
            previous = node;
            node = node.next;
        }
        previous.next = head;
    
        while(k > 0) {
            previous = head;
            head = head.next;
            k--;
        }
        previous.next = null;
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        RotateByN rotate = new RotateByN();
        Node n = rotate.rotateRight(head, 12);

        while(n != null) {
            System.out.println(n.value + " ");
            n = n.next;
        }
    }
    public static class Node {
        public Node next;
        public int value;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        public Node(int value) {
            this.value = value;
        }
    }
}