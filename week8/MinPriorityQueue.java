package week8;

import java.util.ArrayList;
import java.util.List;

public class MinPriorityQueue {
    private List<Integer> a;
    private int n;

    public MinPriorityQueue() {
        a = new ArrayList<>();
        n = 0;
        a.add(0);
    }

    private void swap(int x, int y) {
        int temp = a.get(x);
        a.set(x, a.get(y));
        a.set(y, temp);
    }

    private void swim(int k) {
        while (k > 1 && a.get(k/2) > a.get(k)) {
            swap(k/2, k);
            k = k/2;
        }
    }

    public void insert(int k) {
        a.add(k);
        n++;
        swim(n);
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && a.get(j) > a.get(j + 1)) j++;
            if (a.get(k) <= a.get(j)) break;
            swap(k, j);
            k = j;
        }
    }

    public int delMin() {
        int min = a.get(1);
        swap(1, n);
        n--;
        sink(1);
        a.remove(n + 1);
        return min;
    }

    public void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    public int getMin() {
        return a.get(1);
    }
    
    public int size() {
        return n;
    }
}
