package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/remove-linked-list-elements/
public class E0203_removeElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2, new ListNode(6,
                        new ListNode(3, new ListNode(4,
                                new ListNode(5, new ListNode(6)))))));
        E0203_removeElements e = new E0203_removeElements();
        int val = 6;
        ListNode ans = e.removeElements(head, val);
        System.out.println("ans = " + ans);
    }

    public ListNode removeElements(ListNode head, int val) {
        // 哑元节点（哨兵节点），可以避免处理头节点为 val 的特殊情况
        ListNode dummy = new ListNode(-1, head);
        for (ListNode p = dummy; p != null; p = p.next) {
            while (p.next != null && p.next.val == val) {
                p.next = p.next.next;
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
