package leeco.nums;

/**
 * 计算两个琏表表示的数的和
 *
 * @author: liuxuan
 * @date: 2022-10-22 10:18
 **/
public class TwoLinkNumSum {

    public static void main(String[] args) {
        // 构造链表
        ListNode listNode1 = ListNode.inputList(1, 2, 3);
        ListNode.printList(listNode1);
        ListNode.printList(ListNode.reverseList(listNode1));
        ListNode l1 = ListNode.inputList(2, 4, 3);
        ListNode l2 = ListNode.inputList(5, 6, 4);
        Solution s = new Solution();
        ListNode sum = s.addTwoNumbers(l1, l2);
        ListNode.printList(sum);
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 定义pre节点，保证头节点也参与循环
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry != 0) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        /** 向队尾添加节点 */
        private void addNode(ListNode newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }
        /** 使用方法可变参数把一串数字变成链表 */
        public static ListNode inputList(int ...data) {
            ListNode listHead = null;
            for (int temp : data) {
                ListNode newNode = new ListNode(temp);
                if (listHead == null) {
                    listHead = newNode;
                } else {
                    listHead.addNode(newNode);
                }
            }
            return listHead;
        }
        /** 打印链表 */
        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.println();
        }
        /** 翻转链表 */
        public static ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
