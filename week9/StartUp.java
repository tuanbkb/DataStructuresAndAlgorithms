package week9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class StartUp {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long sum = 0;

        Queue<Element> pq = new PriorityQueue<>();
        // Queue<Long> res = new PriorityQueue<>();

        int decider;
        for (int i = 0; i < n - 1; i++) {
            decider = scanner.nextInt();
            if (decider == 1) {
                long u = scanner.nextLong();
                Element a = new Element(i, u);
                pq.offer(a);
                sum += u;
            } else if (decider == 2) {
                int v = scanner.nextInt();
                while (pq.size() >= v) {
                    sum -= pq.poll().getData();
                }
            }
        }

        scanner.nextInt();
        int v = scanner.nextInt();
        if (pq.size() < v) System.out.println(-1);
        else {
            List<Integer> pos = new ArrayList<>();
            System.out.println(sum);
            for (Element e : pq) {
                pos.add(e.getPos() + 1);
            }

            pos.sort(null);
            for (int i : pos) {
                System.out.print(i + " ");
            }
        }
    }

    public static class Element implements Comparable<Element> {
        private int pos;
        private long data;

        public Element(int pos, long data) {
            this.pos = pos;
            this.data = data;
        }

        public int getPos() {
            return pos;
        }

        public long getData() {
            return data;
        }

        @Override
        public int compareTo(Element e) {
            return Long.compare(this.data, e.getData());
        }
    }
}


// class Element implements Comparable<Element> {
//     private int pos;
//     private long data;

//     public Element(int pos, long data) {
//         this.pos = pos;
//         this.data = data;
//     }

//     public int getPos() {
//         return pos;
//     }

//     public long getData() {
//         return data;
//     }

//     @Override
//     public int compareTo(Element e) {
//         return Long.compare(this.data, e.getData());
//     }
// }
