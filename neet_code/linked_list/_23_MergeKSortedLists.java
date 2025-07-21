package neet_code.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_MergeKSortedLists {
    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode list1 = new ListNode(1);
        ListNode list1b = new ListNode(4);
        ListNode list1c = new ListNode(5);
        list1.next = list1b;
        list1b.next = list1c;

        ListNode list2 = new ListNode(1);
        ListNode list2b = new ListNode(3);
        ListNode list2c = new ListNode(4);
        list2.next = list2b;
        list2b.next = list2c;

        ListNode list3 = new ListNode(2);
        ListNode list3b = new ListNode(6);
        list3.next = list3b;

        mergeKLists(new ListNode[]{list1, list2, list3});
    }

    // approach 1: using min heap
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // pseudo head node
        ListNode result = new ListNode();
        ListNode current = result;

        // find the result list's head node
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // construct the remaining list
        while (!minHeap.isEmpty()) {
            current.next = minHeap.poll();
            current = current.next;
            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }

        return result.next;
    }

    // approach 2: divide and conquer

    // i.e. lists < 0,1,2,3,4,5,6,7 > (n=8)
    // while len = 8
    // lists[0] = merged(0 & 1)
    // lists[1] = merged(2 & 3)
    // lists[2] = merged(4 & 5)
    // lists[3] = merged(6 & 7)

    // while len = 4
    // lists[0] = merged(0 & 1)
    // lists[1] = merged(2 & 3)

    // while len = 2
    // lists[0] = merged(0 & 1) --> result (final remaining 1 list)

    public ListNode mergeKLists_(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;                 // no extra memory, decrease end of lists each time when merge two
        while (len != 1) {
            for (int i = 0; i < len / 2; i++) {
                lists[i] = mergeTwo(lists[i * 2], lists[i * 2 + 1]);
            }
            if (len % 2 == 1) {                   //move the last one
                lists[len / 2] = lists[len - 1];
            }
            len = (len + 1) / 2;                    //decrease to half
        }
        return lists[0];
    }

    private ListNode mergeTwo(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (node1 != null || node2 != null) {
            // "&&" takes precedence over "||" operator
            if (node2 == null || node1 != null && node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
