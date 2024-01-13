package cn.ocsio.leetcode.list;

// https://leetcode.cn/problems/design-linked-list/
public class E0707_MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println("myLinkedList = " + myLinkedList);
        int ans1 = myLinkedList.get(1);
        System.out.println(ans1);
        myLinkedList.deleteAtIndex(1);
        int ans2 = myLinkedList.get(1);
        System.out.println("myLinkedList = " + myLinkedList);
        System.out.println(ans2);
    }

    public static class MyLinkedList {
        Node dummy;
        int size;

        public MyLinkedList() {
            dummy = new Node(-1);
            size = 0;
        }

        public int get(int index) {
            int count = 0;
            for (Node cur = dummy.next; cur != null; cur = cur.next, count++) {
                if (count == index) {
                    return cur.val;
                }
            }
            return -1;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            size++;
            Node pre = getIndexPre(index);
            pre.next = new Node(val, pre.next);
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            Node pre = getIndexPre(index);
            pre.next = pre.next.next;
        }

        // 获取逻辑索引为 index 的节点的前一个节点
        public Node getIndexPre(int index) {
            Node pre = dummy;
            int count = 0;
            while (count < index) {
                pre = pre.next;
                count++;
            }
            return pre;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node cur = dummy.next;
            while (cur != null) {
                sb.append(cur.val).append(", ");
                cur = cur.next;
            }
            return sb.toString();
        }

        public static class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node(int val) {
                this.val = val;
            }
        }
    }
}
