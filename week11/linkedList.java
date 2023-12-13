package week11;

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

    //Print the elements of a linked list
    public void print() {
        node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    //Insert node at tail of a linked list
    public void insertTail(int data) {
        node newNode = new node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        node curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        
        curNode.next = newNode;
    }

    //Insert node at head of a linked list
    public void insertHead(int data) {
        node newNode = new node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //Insert node at a specific position of a linked list
    public void insertAtPos(int pos, int data) {
        node newNode = new node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        int count = 0;
        node curNode = head;
        while (curNode != null && count < pos - 1) {
            curNode = curNode.next;
            count++;
        }

        newNode.next = curNode.next;
        curNode.next = newNode;
    }

    //Delete a node
    public void deleleNode(int pos) {
        if (head == null) return;

        if (pos == 0) {
            head = head.next;
            return;
        }

        int count = 0;
        node curNode = head;
        while (curNode != null && count < pos - 1) {
            curNode = curNode.next;
            count++;
        }

        if (curNode == null || curNode.next == null) {
            System.out.println("Delete position is bigger than the size of the linked list!");
        } else {
            curNode.next = curNode.next.next;
        }
    }

    //Print in reverse
    public void reversePrint() {
        if (head != null) {
            node currentNode = head;
            int count = 0;
            while (currentNode != null) {
                count++;
                currentNode = currentNode.next;
            }

            while (count > 0) {
                currentNode = head;
                int i = 0;
                while (i < count - 1) {
                    currentNode = currentNode.next;
                    i++;
                }
                System.out.print(currentNode.data + " ");
                count--;
            }

            System.out.println();
        }
    }

    //Reverse a linked list
    public void reverse() {
        if (head != null) {
            node curNode = head;
            int count = 0;
            while (curNode != null) {
                curNode = curNode.next;
                count++;
            }

            node newHead = null;

            while (count >= 0) {
                curNode = head;
                int i = 0;
                while (i < count) {
                    curNode = curNode.next;
                    i++;
                }

                if (newHead == null) {
                    newHead = curNode;                    
                } else {
                    node cur = newHead;
                    while (cur.next != null) cur = cur.next;
                    cur.next = new node(curNode.data);
                }

                count--;
            }

            head = newHead;
        }
    }

    //Compare two linked list
    public boolean compareTo(linkedList a) {
        node cur1 = this.head;
        node cur2 = a.head;

        while (cur1 != null && cur2 != null) {
            if (cur1.data != cur2.data) return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        if (cur1 != null || cur2 != null) return false;
        return true;
    }

    //Merge 2 sorted linked list
    public static linkedList merge(linkedList a, linkedList b) {
        linkedList res = new linkedList();
        node cur1 = a.head;
        node cur2 = b.head;

        while (cur1 != null && cur2 != null) {
            if (cur1.data <= cur2.data) {
                res.insertTail(cur1.data);
                cur1 = cur1.next;
            } else {
                res.insertTail(cur2.data);
                cur2 = cur2.next;
            }
        }

        while (cur1 != null) {
            res.insertTail(cur1.data);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            res.insertTail(cur2.data);
            cur2 = cur2.next;
        }

        return res;
    }

    //
}
