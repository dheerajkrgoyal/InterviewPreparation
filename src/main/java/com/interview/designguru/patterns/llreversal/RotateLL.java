package com.interview.designguru.patterns.llreversal;

/**
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 *
 * Example: [1, 2, 3, 4, 5, 6] k=3
 * Output: [4, 5, 6, 1, 2, 3]
 *
 * Example: [1, 2, 3, 4, 5] k=8
 * Output: [3, 4, 5, 1, 2]
 */
public class RotateLL {
    public ListNode rotate(ListNode head, int rotations) {
        int length = findLength(head);
        rotations %= length;

        if(rotations == 0){
            return head;
        }

        int startIndex = length - rotations;
        int i = 0;
        ListNode previous = null;
        ListNode current = head;

        while(i != startIndex){
            previous = current;
            current = current.next;
            i++;
        }

        previous.next = null;
        ListNode previousHead = head;
        head = current;
        while(current != null){
            previous = current;
            current = current.next;
        }

        previous.next = previousHead;
        return head;
    }

    private int findLength(ListNode head){
        ListNode current = head;
        int i = 0;
        while(current != null){
            current = current.next;
            i++;
        }

        return i;
    }
}
