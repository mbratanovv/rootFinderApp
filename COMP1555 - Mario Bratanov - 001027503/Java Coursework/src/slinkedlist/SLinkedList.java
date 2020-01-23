package slinkedlist;

import java.util.*;


/**
 *
 * @author ic01
 */
public class SLinkedList {
    
    public static doubleValueNode head;
    public  SLinkedList() {
        head = new doubleValueNode();
    }

    //add a new node to the head of the list
    public void addFirst(Double newtonRaphson) {
        // make variable head point to new node
        head = new doubleValueNode(0.0,head);
    }

    public void addLast(Double newtonRaphson) {
        doubleValueNode tail;
        tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
            }
        //insert new node at end of list
        tail.setNext( new doubleValueNode(newtonRaphson,null));
    }

    //add a new node after position of curnode
    public void addMid(Double newtonRaphson, Double entryafter) {
        doubleValueNode curnode;
        curnode = head;
        //go to last node and remember previous node at all times
        while (curnode != null && !curnode.getNewtonRaphson().equals(entryafter)) {
            curnode = curnode.getNext();
            }
        //if first occurrence of element entryafter was located then insert new node
        if (curnode != null) {
            doubleValueNode newnode = new doubleValueNode(0.0,curnode.getNext());
            curnode.setNext(newnode);
            }
    }

    public boolean isEmpty() {
        return  head == null;
    }

    public void removeFirst() {
        doubleValueNode oldhead;
        oldhead = head;
        //remove first node from linked list
        if (head != null) {
           head = head.getNext();
           oldhead.setNext(null);
           }
        else {
           throw new NoSuchElementException();
           }
    }

    public void removeLast() {
        doubleValueNode temp, previous;
        temp = head;
        previous = temp;
        //go to last node and remember previous node at all times
        while (temp != null && temp.getNext() != null) {
            previous = temp;
            temp = temp.getNext();
            }
        if (previous != null) {
           //remove last node
           previous.setNext(null);
           }
        else {
           throw new NoSuchElementException();
           }
    }

    //very similar to removeLast except we are looking for element i
    public void removeMid(Double newtonRaphson) {
        doubleValueNode temp, previous;
        temp = head.getNext();
        previous = null;
        //go to node containing element and rermember previous node at all times
        while (temp.getNext() != null && !temp.getNewtonRaphson().equals(newtonRaphson)) {
            previous = temp;
            temp = temp.getNext();
            }
        if (previous != null && temp.getNext() != null) {
           //not first or last node so we can remove node defined by temp. 
           // set the previous node to that after temp
           previous.setNext(temp.getNext());
           temp.setNext(null);
        }
        else {
           throw new NoSuchElementException();
           }
    }
    public static void printList(SLinkedList thelist) {
        doubleValueNode temp;
        if(thelist.isEmpty())
            System.out.println("List is empty");
        else {
            temp = thelist.head;
            while (temp != null) {
               System.out.print(temp.getNewtonRaphson()+" ");
               temp = temp.getNext();
            }
            System.out.println();
        }
    }
    
    public static int LinkedListCount(SLinkedList linkedL) {
        doubleValueNode currNode = head;
        int counter = 0;

        while (currNode != null) {
            counter++;
            currNode = currNode.getNext();
        }
        return counter;
    }

}
