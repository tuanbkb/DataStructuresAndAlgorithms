public class LinkedList {
    private static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node root;

    public LinkedList() {
        this.root = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        newNode.next = root;
        root = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node curNode = root;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = newNode;
    }

    public int getAndRemoveLast() {
        if (root == null) return Integer.MIN_VALUE;
        if (root.next == null) {
            int res = root.data;
            root = null;
            return res;
        }

        Node curNode = root;
        while (curNode.next.next != null) {
            curNode = curNode.next;
        }

        int res = curNode.next.data;
        curNode.next = null;
        return res;
    }

    public void print() {
        Node curNode = root;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(1);
        ll.print();
        ll.getAndRemoveLast();
        ll.print();
    }
}
