package neet_code.linked_list;

import java.util.HashMap;
import java.util.Map;

public class _138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        Node a = new Node(11);
        Node b = new Node(11);
        Node c = new Node(11);
        a.next = b;
        b.next = c;

        copyRandomList(a);
    }

    public static Node copyRandomList(Node head) {
        // manipulate interweaving pattern to construct the copied list
        // (A --> B --> C) will be (A --> A' --> --> B --> B' --> C --> C')

        if (head == null) return null;

        Node copiedHead = new Node(head.val);
        Node current = head;
        Node next = head.next;

        current.next = copiedHead;
        copiedHead.next = next;
        current = next;

        // building next pointers
        while (next != null) {
            next = next.next;
            Node newNode = new Node(current.val);
            current.next = newNode;
            newNode.next = next;
            current = next;
        }

        // building random pointers
        current = head;
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        // separate the 2 lists and restore the next pointers pf the initial list
        current = head;
        Node copiedCurrent;

        while (current != null) {
            copiedCurrent = current.next;
            current.next = copiedCurrent.next;
            current = copiedCurrent.next;
            if (copiedCurrent.next != null) {
                copiedCurrent.next = copiedCurrent.next.next;
            }
        }

        return copiedHead;
    }

    public static Node copyRandomList_(Node head) {
        if (head == null) return null;

        Map<String, Node> map = new HashMap<>();
        String headIdentifier = head.toString().split("@")[1];
        Node headNode = new Node(head.val);
        map.put(headIdentifier, headNode);

        while (head != null) {
            String curIdentifier = head.toString().split("@")[1];
            Node curNode = map.getOrDefault(curIdentifier, new Node(head.val));
            if (!map.containsKey(curIdentifier)) {
                map.put(curIdentifier, curNode);
            }

            if (head.next != null) {
                String nextIdentifier = head.next.toString().split("@")[1];
                Node nextNode = map.getOrDefault(nextIdentifier, new Node(head.next.val));
                curNode.next = nextNode;
                if (!map.containsKey(nextIdentifier)) {
                    map.put(nextIdentifier, nextNode);
                }
            } else {
                curNode.next = null;
            }

            if (head.random != null) {
                String randomIdentifier = head.random.toString().split("@")[1];
                Node randomNode = map.getOrDefault(randomIdentifier, new Node(head.random.val));
                curNode.random = randomNode;
                if (!map.containsKey(randomIdentifier)) {
                    map.put(randomIdentifier, randomNode);
                }
            } else {
                curNode.random = null;
            }

            head = head.next;
        }

        return headNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}