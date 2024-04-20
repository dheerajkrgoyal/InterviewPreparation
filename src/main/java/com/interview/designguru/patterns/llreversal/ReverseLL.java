package com.interview.designguru.patterns.llreversal;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new
 * head of the reversed LinkedList.
 */
public class ReverseLL {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null){
            ListNode nextHead = head.next;
            head.next = prev;
            prev = head;
            head = nextHead;
        }
        return prev;
    }
}
