package week4;

public class linkedList {
    public node head;

    linkedList() {
        this.head = null;
    }

    public void insertNode(int data) {
        node newNode = new node(data);

        if (head == null) {
            this.head = newNode;
        }
        else {
            node currentNode = this.head;
            while (currentNode != null) {
                currentNode = currentNode.next;
            }
            currentNode = newNode;
        }
    }
}
