package week11;

public class node {
    public int data;
    public node next;

    node(int a) {
        this.data = a;
        this.next = null;
    }

    node() {
    }

    public void print() {
        node cur = this;
        while (cur != null) {
            System.out.print(cur.data + " ");
        }

        System.out.println();
    }
}
