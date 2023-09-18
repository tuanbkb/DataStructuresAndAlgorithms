package week3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class threeSumOptimized {
    public static void main(String[] args) {
        int n = StdIn.readInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdIn.readInt();
        }

        Arrays.sort(a);
        threeSum(a);
    }

    public static void threeSum(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int low = 0;
            int high = a.length - 1;

            while (low < high) {
                if (low == i) low++;
                if (high == i) high--;
                if (a[low] + a[high] == -a[i]) {
                    StdOut.println(a[i] + " " + a[low] + " " + a[high]);
                    low++;
                }
                if (a[low] + a[high] < a[i]) low++;
                else high--;
            }
        }
    }
}
