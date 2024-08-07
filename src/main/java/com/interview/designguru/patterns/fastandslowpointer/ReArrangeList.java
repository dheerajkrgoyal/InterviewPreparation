package com.interview.designguru.patterns.fastandslowpointer;

/**
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the
 * nodes from the second half of the LinkedList are inserted alternately to the nodes from the first
 * half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should use only constant space the input LinkedList should be modified in-place.
 *
 * Example 1:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 * Example 2:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */
public class ReArrangeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        head.display();
        reorder(head);
        head.display();
    }

    public static ListNode reorder(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode slowNext = slow.next;
        slow.next = null;

        ListNode reverseHead = reverse(slowNext);

        ListNode curr = head;
        while(reverseHead != null){
            ListNode currNext = curr.next;
            curr.next = reverseHead;
            ListNode reverseHeadNext = reverseHead.next;
            reverseHead.next = currNext;
            curr = currNext;
            reverseHead = reverseHeadNext;
        }

        return head;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev= null;
        while(head != null){
            ListNode headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }

        return prev;
    }
}
