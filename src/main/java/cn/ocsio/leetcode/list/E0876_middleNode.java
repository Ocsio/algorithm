package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/middle-of-the-linked-list/
public class E0876_middleNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5)))));
        E0876_middleNode e = new E0876_middleNode();
        ListNode ans = e.middleNode(head);
        System.out.println("ans = " + ans);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        // 一定是 fast 先到头
        // 注意 fast != null && fast.next != null 求的是下中点
        // 若要求上中点则为 fast.next != null && fast.next.next != null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast 到头了, 此时 slow 就是中间位置
        return slow;
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
