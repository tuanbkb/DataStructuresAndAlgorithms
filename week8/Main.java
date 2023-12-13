package week8;

public class Main {
    public static void main(String[] args) {
        // MaxPriorityQueue max = new MaxPriorityQueue();
        MinPriorityQueue min = new MinPriorityQueue();

        // for (int i = 1; i < 10; i++) {
        //     max.insert(i);
        //     min.insert(i);
        // }

        // max.print();
        for (int i = 0; i < 100000; i++) {
            min.insert(1);
        }
        // min.print();

        int k = 105823341;

        int count = 0;
        while (min.size() > 1 && min.getMin() < k) {
            int x = min.delMin();
            int y = min.delMin();
            min.insert(x + 2*y);
            count++;
            // min.print();
        }

        System.out.println(count);
        // min.print();
    }
}
