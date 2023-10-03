package week5;

import java.io.*;
import java.util.*;

public class QueueTwoStack {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        LinkedList stack = new LinkedList();
        int currentState = 0;
        while (currentState < q) {
            int state = scanner.nextInt();
            if (state == 1) {
                int number = scanner.nextInt();
                stack.enqueue(number);
            }
            else if (state == 2) {
                stack.dequeue();
            }
            else if (state == 3){
                stack.printFirst();
            }
            currentState++;
        }
    }
    
    
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    public LinkedListNode first;
    
    public LinkedList() {
        this.first = null;
    }
    
    public void enqueue(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (this.first == null) {
            this.first = newNode;
        }
        else {
            LinkedListNode curNode = this.first;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
    }
    
    public void dequeue() {
        if (this.first != null) {
            this.first = this.first.next;
        }
    }
    
    public void printFirst() {
        System.out.println(this.first.data);
    }
}
