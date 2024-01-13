package cn.ocsio.leetcode.list;

public class E0160_getIntersectionNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l6.next = l7;
        l7.next = l8;
        l8.next = l3;
        E0160_getIntersectionNode e = new E0160_getIntersectionNode();
        ListNode ans = e.getIntersectionNode(l1, l6);
        System.out.println("ans = " + ans);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 若链表 A 和链表 B 中有一个为空链表则不可能相交
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        return pa;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
