package com.interview.designguru.patterns.llreversal;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from
 * position ‘p’ to ‘q’.
 *
 * Example:
 * [1,2,3,4,5] p=2 q=4
 * Output: [1,4,3,2,5]
 *
 * Example:
 * [1,2,3,4,5,6] p=1 q=4
 * Output: [4,3,2,1,5,6]
 *
 * Example:
 * [1,2,3,4,5,6,7] p=3 q=6
 * Output: [1,2,6,5,4,3,7]
 */
public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        if(p == q){
            return head;
        }

        int i = 1;
        ListNode previous = null;
        ListNode current = head;

        while(i != p){
            previous = current;
            current = current.next;
            i++;
        }

        ListNode firstNodeNonReverseList = previous;
        ListNode lastNodeReverseList = current;

        previous = null;

        while(i != q+1){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        ListNode lastNodeNonReverseList = current;
        ListNode firstNodeReverseList = previous;
        if(firstNodeNonReverseList != null){
            firstNodeNonReverseList.next = firstNodeReverseList;
        }
        else{
            head = firstNodeReverseList;
        }

        lastNodeReverseList.next = lastNodeNonReverseList;

        return head;
    }
}
