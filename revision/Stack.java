public class Stack {
    private LinkedList stack;

    public Stack() {
        stack = new LinkedList();
    }

    public void add(int data) {
        stack.addLast(data);
    }

    public int poll() {
        return stack.getAndRemoveLast();
    }
}
