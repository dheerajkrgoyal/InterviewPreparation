package com.interview.designguru.patterns.fastandslowpointer;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }

    public void display(){
        ListNode node = this;
        while(node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}
