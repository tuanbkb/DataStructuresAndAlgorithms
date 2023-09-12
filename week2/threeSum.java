package week2;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class threeSum {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        In in = new In("week2\\test3Sum.txt");
        int a[] = in.readAllInts();
        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length - 1; j++) {
                int k = binarySearch(a, -(a[i] + a[j]), i, j, 0, a.length - 1);
                if (k != -1) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
            }
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        StdOut.println("Run time = " + runTime + " milliseconds");
    }

    public static int binarySearch(int a[], int key, int i, int j, int left, int right) {
        while (left < right) {
            int mid = (left + right)/2;

            if (a[mid] == key) return mid;
            if (a[mid] < key) left = mid + 1;
            else right = mid - 1;
            if (left == i || left == j) left++;
            if (right == i || right == j) right--;
        }
        
        return -1;
    }
}
