package week9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class WhoIsInTheMiddle {
    // public static void sort(List<Long> a) {
    //     if (a == null || a.size() == 0) return;

    //     quickSort(a, 0, a.size() - 1);
    // }

    // public static void quickSort(List<Long> a, int left, int right) {
    //     if (left < right) {
    //         int pivotPos = partition(a, left, right);
    //         quickSort(a, left, pivotPos - 1);
    //         quickSort(a, pivotPos + 1, right);
    //     }
    // }

    // public static int partition(List<Long> a, int left, int right) {
    //     long pivot = a.get(right);
    //     int i = left - 1;
    //     for (int j = left; j < right; j++) {
    //         if (a.get(j) <= pivot) {
    //             i++;
    //             swap(a, i, j);
    //         }
    //     }
    //     swap(a, i + 1, right);
    //     return i + 1;
    // }

    // public static void swap(List<Long> a, int x, int y) {
    //     long temp = a.get(x);
    //     a.set(x, a.get(y));
    //     a.set(y, temp);
    // }

    // public static int binarySearch(List<Long> a, long k) {
    //     int low = 0;
    //     int high = a.size() - 1;
    //     while (low <= high) {
    //         int mid = (low + high)/2;
    //         if (a.get(mid) == k) return mid;
    //         else if (a.get(mid) > k) high = mid - 1;
    //         else low = mid + 1;
    //     }
    //     return low;
    // }
    

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Queue<Long> max = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Long> min = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long u = scanner.nextLong();
            if (max.isEmpty() || u <= max.peek()) max.offer(u);
            else min.offer(u);

            if (max.size() > min.size() + 1) min.offer(max.poll());
            else if (min.size() > max.size()) max.offer(min.poll());
        }

        int event;
        for (int i = 0; i < m; i++) {
            event = scanner.nextInt();
            if (event == 1) {
                long u = scanner.nextLong();
                if (max.isEmpty() || u <= max.peek()) max.offer(u);
                else min.offer(u);

                if (max.size() > min.size() + 1) min.offer(max.poll());
                else if (min.size() > max.size()) max.offer(min.poll());
            } else if (event == 2) {
                if (!max.isEmpty()) {
                    max.poll();
                    if (max.size() < min.size()) max.offer(min.poll());
                }
            } else if (event == 3) {
                if (!max.isEmpty()) {
                    System.out.println(max.peek());
                } else System.out.println(0);
            }
        }
    }
}
