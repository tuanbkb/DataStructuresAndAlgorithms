package week11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import edu.princeton.cs.algs4.In;

public class RunningMedian {
    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        List<Double> res = new ArrayList<>();
        TreeSet<Node> temp = new TreeSet<>();

        for (int i = 0; i < a.size(); i++) {
            temp.add(new Node(i, a.get(i)));
            res.add(findMedian(temp));
        }

        return res;
    }

    public static class Node implements Comparable<Node> {
        private int index;
        private int data;

        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public int getData() {
            return data;
        }

        @Override
        public int compareTo(Node other) {
            if (this.data != other.data) return Integer.compare(this.data, other.data);
            return Integer.compare(this.index, other.index);
        }
    }

    public static double findMedian(TreeSet<Node> treeSet) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        for (double i : runningMedian(a)) {
            System.out.print(i + " ");
        }
    }
}
