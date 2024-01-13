package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/swap-nodes-in-pairs/
public class E0024_swapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        E0024_swapPairs e = new E0024_swapPairs();
        ListNode ans = e.swapPairs(head);
        System.out.println("ans = " + ans);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 引入哨兵节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            cur.next = next.next;
            pre.next = next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
            if (cur != null) {
                next = cur.next;
            }
        }
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

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
