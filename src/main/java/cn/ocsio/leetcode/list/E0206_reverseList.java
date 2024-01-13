package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/reverse-linked-list/
public class E0206_reverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(
                1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
        );
        E0206_reverseList e = new E0206_reverseList();
        ListNode ans = e.reverseList(l1);
        System.out.println("ans = " + ans);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        head.next = cur.next;
        while (cur.next != null) {
            cur.next = pre;
            pre = cur;
            cur = head.next;
            head.next = cur.next;
        }
        cur.next = pre;
        return cur;
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
