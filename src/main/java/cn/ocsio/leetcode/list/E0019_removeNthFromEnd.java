package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
public class E0019_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        E0019_removeNthFromEnd e = new E0019_removeNthFromEnd();
        int n = 2;
        ListNode ans = e.removeNthFromEnd(head, n);
        System.out.println("ans = " + ans);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = n; i > 0; i--) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
