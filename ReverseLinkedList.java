public class ReverseLinkedList {

    
    public Node reverse1(Node head) {

        Node tail = head;
        while (head.next != null) {
            tail = head.next;
        }
        tail.next = head;

        
    }
    public Node reverse(Node node) {
        if ( node.next != null) {
            Node remaining = reverse(node.next); //5
           
            node.next.next = node; // 4
            node.next = null;
           
            return remaining;
        } else {
            node.next = null;
            return node;
        }
        /*
        if ( node != null && node.next != null) {
             reverse(node.next).next = node;
        }
        if (node != null && node.next == null) {
            node.next = node;
            return node;
        } else {
            return node;
        }*/
    }

    public static void main(String[] args) {
        
        Node five = new Node(5);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        
        Node node = new Node( 1, two);
        ReverseLinkedList list = new ReverseLinkedList();
        list.reverse(node);
        Node reverse = five;
        while(node != null) {
            System.out.println(node.value + " ");
            node = node.next;
        }
        
    }

    public static class Node {
        public Node next;
        public int value;
        
        public Node(int currentValue) {
            this.value = currentValue;
        }
        public Node(int currentValue, Node next ) {
            this.next = next;
            this.value = currentValue;
        }
    }

    
}

