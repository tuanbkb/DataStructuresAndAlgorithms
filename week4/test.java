package week4;

import java.util.*;

public class test {
    public static void main(String[] args) {
        linkedList a = new linkedList();

        // a.insertTail(1);
        // a.insertHead(2);
        // // a.deleleNode(1);
        // a.insertTail(3);
        // a.insertTail(4);
        // a.print();
        // a.reversePrint();
        // a.reverse();
        // a.print();

        linkedList b = new linkedList();

        a.insertTail(2);
        a.insertTail(4);
        a.insertTail(3);
        b.insertTail(5);
        b.insertTail(6);
        b.insertTail(4);

        Set<Character> x = new HashSet<>();

        x.add('a');
        x.add('b');
        x.add('a');
        x.remove('a');
        System.out.println(x.size());

        // node x = new node();
        // System.out.println(x.data);

        // insertTailTwoNumbers(a.head, b.head).print();

    }

    // public static node insertTailTwoNumbers(node l1, node l2) {
    //     if (l1.data = 0 && l1.next == null)

    //     node c1 = l1;
    //     node c2 = l2;
    //     node head = new node();
    //     int mem = 0;

    //     while (c1 != null && c2 != null) {
    //         int sum = c1.data + c2.data + mem;
    //         mem = 0;
    //         if (sum > 9) {
    //             sum = sum % 10;
    //             mem = 1;
    //         }
    //         node newNode = new node(sum);
    //         if (head == null) {
    //             head = newNode;
    //         } else {
    //             node cur = head;
    //             while (cur.next != null) cur = cur.next;
    //             cur.next = newNode;
    //         }
            
    //         c1 = c1.next;
    //         c2 = c2.next;
    //     }

    //     while (c1 != null) {
    //         node newNode;
    //         if (c1.data + mem <= 9) {
    //             newNode = new node(c1.data + mem);
    //             mem = 0;
    //         } else {
    //             newNode = new node(0);
    //             mem = 1;
    //         }

    //         if (head == null) {
    //             head = newNode;
    //         } else { 
    //             node cur = head;
    //             while (cur.next != null) cur = cur.next;
    //             cur.next = newNode;
    //         }
    //         c1 = c1.next;
    //     }

    //     while (c2 != null) {
    //         node newNode;
    //         if (c2.data + mem <= 9) {
    //             newNode = new node(c1.data + mem);
    //             mem = 0;
    //         } else {
    //             newNode = new node(0);
    //             mem = 1;
    //         }

    //         if (head == null) {
    //             head = newNode;
    //         } else {
    //             node cur = head;
    //             while (cur.next != null) cur = cur.next;
    //             cur.next = newNode;
    //         }
    //         c2 = c2.next;
    //     }

    //     return head;
    // }
}
