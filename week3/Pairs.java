package week3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Pairs {
    public static void main(String[] args) {
        int n = StdIn.readInt();

        int k = StdIn.readInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }

        Arrays.sort(a);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (binarySearch(a, a[i] + k)) count++;
        }


        StdOut.println(count);
    }

    public static boolean binarySearch(int a[], int n) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (a[mid] == n) return true;
            if (a[mid] < n) low = mid + 1;
            else high = mid - 1;
        }

        return false;

    }
}
