package week9;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        mergeSort(arr);
        
        if (arr.size() <= 1) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        int min = arr.get(1) - arr.get(0);
        for (int i = 1; i < arr.size() - 1; i++) {
            if (min > arr.get(i + 1) - arr.get(i)) min = arr.get(i + 1) - arr.get(i);
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == min) {
                res.add(arr.get(i));
                res.add(arr.get(i + 1));
            }
        }

        return res;
    }

    public static void mergeSort(List<Integer> a) {
        if (a.size() <= 1) return;

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            temp.add(0);
        }

        mergeSort(a, temp, 0, a.size() - 1);
    }

    public static void mergeSort(List<Integer> a, List<Integer> temp, int left, int right) {        
        if (left < right) {
            int mid = left + (right - left)/2;
            mergeSort(a, temp, left, mid);
            mergeSort(a, temp, mid + 1, right);
            merge(a, temp, left, right, mid);
        }
    }

    public static void merge(List<Integer> a, List<Integer> temp, int left, int right, int mid) {
        for (int i = left; i <= right; i++) {
            temp.set(i, a.get(i));
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp.get(i) <= temp.get(j)) {
                a.set(k++, temp.get(i++));
            } else {
                a.set(k++, temp.get(j++));
            }
        }

        while (i <= mid) {
            a.set(k++, temp.get(i++));
        }

        while (j <= right) {
            a.set(k++, temp.get(j++));
        }
    }

    public static void printArray(List<Integer> a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}

public class ClosestNumberWithMergeSort {
    // public static void main(String[] args) throws IOException {
    //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    //     int n = Integer.parseInt(bufferedReader.readLine().trim());

    //     List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
    //         .map(Integer::parseInt)
    //         .collect(toList());

    //     List<Integer> result = Result.closestNumbers(arr);

    //     bufferedWriter.write(
    //         result.stream()
    //             .map(Object::toString)
    //             .collect(joining(" "))
    //         + "\n"
    //     );

    //     bufferedReader.close();
    //     bufferedWriter.close();
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        Result.printArray(Result.closestNumbers(a));
    }
}
