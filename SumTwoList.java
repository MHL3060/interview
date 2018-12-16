/* Definition for singly-linked list.
 */
 import java.lang.Math;
 import java.util.List;
 import java.util.ArrayList;

class SumTwoList {
    List<Integer> list = new ArrayList<Integer>();
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        while(l1 != null || l2 != null) {
            int l1Value = 0;
            int l2Value = 0;
            if (l1 != null) {
                l1Value = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Value = l2.val;
                l2 = l2.next;
            }
            list.add(l1Value + l2Value);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * Math.pow(10, i);
        }
        return new ListNode(result);
    }

    public static void main(String[] args) {
        SumTwoList sum = new SumTwoList();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
     
        ListNode second = new ListNode(1);
        second.next = new ListNode(2);


        ListNode result =  sum.addTwoNumbers(first, second);
        System.out.println(result.val);

    }
     static class ListNode {
        int val;
         ListNode next;
         public ListNode(int x) { val = x; }
     }
}


 