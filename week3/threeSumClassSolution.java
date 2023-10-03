package week3;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class threeSumClassSolution {
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
        for (int i = 0; i < a.length - 2; i++) {
            int j = i + 1;
            for (int k = a.length - 1; k > i; k--) {
                while (j < k) {
                    if (a[i] + a[j] + a[k] == 0) {StdOut.println(a[i] + " " + a[j] + " " + a[k]); j++;}
                    else if (a[i] + a[j] + a[k] < 0) j++;
                    else break;
                }
            }
        }
    }
}
