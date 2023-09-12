package week2;

import edu.princeton.cs.algs4.*;
import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) {
        In in = new In("week2\\test2Sum.txt");
        int a[] = in.readAllInts();
        
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            if (a[low] + a[high] == 0) StdOut.println(a[low] + " " + a[high]);
            if ((Math.abs(a[low])) > Math.abs(a[high])) low++;
            else high--;
        }
    }
}
