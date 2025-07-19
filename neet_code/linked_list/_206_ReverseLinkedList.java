package neet_code.linked_list;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current  = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev=current;
            current = next;
        }

        return prev;
    }
}
