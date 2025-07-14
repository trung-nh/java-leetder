package daily._2025_07;

public class _1290_ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {

    }

    public class ListNode {
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

    public int getDecimalValue(ListNode head) {
        int result = head.val;

        while (head.next != null) {
            result = (result >> 1) | head.next.val;
            head = head.next;
        }

        return result;
    }
}
