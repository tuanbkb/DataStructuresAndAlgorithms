package week3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

/**
 * binarySearch
 */
public class binarySearchExercise {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int a[] = new int[N];

        StdOut.print("Your array is: ");
        for (int i = 0; i < N; i++) {
            a[i] = (int)(Math.random() * 1000 + 1);
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
        
        StdOut.print("Type your number to find: ");
        int number = StdIn.readInt();
        StdOut.println();
        Arrays.sort(a);

        int res = binarySearch(a, number);
        if (res == -1) StdOut.println("No number in array.");
        else StdOut.print("Your number is the " + res);
        if (res % 10 == 1 && res % 100 != 11) StdOut.print("st in the array");
        else if (res % 10 == 2 && res % 100 != 12) StdOut.print("nd in the array");
        else if (res % 10 == 3 && res % 100 != 13) StdOut.print("rd in the array");
        else StdOut.print("th in the array"); 
    }

    public static int binarySearch(int a[], int number) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (a[mid] == number) return mid;
            if (a[mid] < number) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}