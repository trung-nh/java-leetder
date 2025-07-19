package neet_code.linked_list;

public class _143_ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        // step 1: use slow and fast pointers to locate the middle node (pointed by slow)
        // 1 2 3 4   --> mid = slow = 2
        // 1 2 3 4 5 --> mid = slow: 3
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: reverse the 2nd list starting from <slow.next> to end
        ListNode prev = null;
        ListNode current = slow.next;
        // disconnect the 2 groups
        slow.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // step 3: merge the 2 lists alternately
        ListNode head1 = head;
        ListNode head2 = prev;
        while (head2 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
}