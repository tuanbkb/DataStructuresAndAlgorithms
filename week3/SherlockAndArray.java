package week3;

import edu.princeton.cs.algs4.*;

public class SherlockAndArray {
    public static void main(String[] args) {
        int T = StdIn.readInt();
        for (int i = 0; i < T; i++) {
            int n = StdIn.readInt();
            int a[] = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = StdIn.readInt();
            }
            if (findDivider(a) != -1) StdOut.println("YES");
            else StdOut.println("NO");
        }
    }

    public static int findDivider(int a[]) {
        int sumArray[] = new int[a.length];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            sumArray[i] = sum;
        }

        return binarySearchSumArray(sumArray);
    }

    public static int binarySearchSumArray(int sumArray[]) {
        if (sumArray.length == 1) return 0;
        if (sumArray.length == 2) {
            if (sumArray[0] == 0 || sumArray[1] == 0) return 0;
            else return -1; 
        }  
        int left = 0;
        int right = sumArray.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (mid == 0 && sumArray[right] - sumArray[mid] == 0) return 0;
            if (mid == sumArray.length - 1 && sumArray[mid - 1] == 0) return mid;
            if (sumArray[mid - 1] == (sumArray[sumArray.length - 1] - sumArray[mid])) return mid;
            if (sumArray[mid - 1] < (sumArray[sumArray.length - 1] - sumArray[mid])) left = mid + 1;
            else right = mid - 1; 
        }
        return -1;
    }
}
