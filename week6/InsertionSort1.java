package week6;

import java.util.List;
import java.util.Vector;

public class InsertionSort1 {
    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
        int temp = arr.get(n - 1);
        
        int i = n - 2;
        while (i >= 0 && arr.get(i) > temp) {
            arr.set(i + 1, arr.get(i));
            i--;
            print(n, arr);
        }
        
        arr.set(i + 1, temp);
        print(n, arr);
    }
    
    public static void print(int n, List<Integer> arr) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> arr = new Vector<>(0);

        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(1);

        insertionSort1(10, arr);
    }
}
