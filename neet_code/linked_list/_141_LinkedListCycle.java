package neet_code.linked_list;

public class _141_LinkedListCycle {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode tortoise = head.next;
        ListNode hare = head.next.next;

        while (hare != tortoise) {
            if (hare == null || hare.next == null) {
                return false;
            }
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
}
