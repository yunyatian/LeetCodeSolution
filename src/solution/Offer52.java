package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * //TODO 题意未能理解，故这里写的测试main方法里构建的ListNode存在问题，所以测试数据不准
 * */
public class Offer52 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode attachA1 = new ListNode(1);
        ListNode attachA2 = new ListNode(8);
        ListNode attachA3 = new ListNode(4);
        ListNode attachA4 = new ListNode(5);
        headA.next = attachA1;
        attachA1.next = attachA2;
        attachA2.next = attachA3;
        attachA3.next = attachA4;
        ListNode headB = new ListNode(5);
        ListNode attachB1 = new ListNode(0);
        ListNode attachB2 = new ListNode(1);
        ListNode attachB3 = new ListNode(8);
        ListNode attachB4 = new ListNode(4);
        ListNode attachB5 = new ListNode(5);
        headB.next = attachB1;
        attachB1.next = attachB2;
        attachB2.next = attachB3;
        attachB3.next = attachB4;
        attachB4.next = attachB5;
        System.out.println(getIntersectionNode(headA,headB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
