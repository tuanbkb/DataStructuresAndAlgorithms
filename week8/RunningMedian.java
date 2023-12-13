package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunningMedian {
    public static int binarySearch(List<Integer> a, int k) {
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (a.get(mid) == k) return mid;
            else if (a.get(mid) > k) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void print(List<Double> a) {
        for (double i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            a.add(binarySearch(a, k), k);
            int s = a.size();
            if (s % 2 == 0) {
                System.out.println((double)(a.get(s/2 - 1) + a.get(s/2))/2.0);
            } else {
                System.out.println(a.get(s/2));
            }
        }
    }
}
