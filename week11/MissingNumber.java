package week11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MissingNumber {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        // HashMap<Integer, Integer> table = new HashMap<>();
        // HashSet<Integer> temp = new HashSet<>();
        // List<Integer> res = new ArrayList<>();

        // for (int i : arr) {
        //     table.put(i, table.getOrDefault(i, 0) + 1);
        // }

        // for (int i : brr) {
        //     if (table.containsKey(i)) {
        //         table.put(i, table.get(i) - 1);
        //         if (table.get(i) == 0) table.remove(i);
        //     } else {
        //         temp.add(i);
        //     }
        // }

        // for (int i : temp) {
        //     res.add(i);
        // }
        // res.sort(Comparator.naturalOrder());
        // return res;
        arr.sort(Comparator.naturalOrder());
        brr.sort(Comparator.naturalOrder());
        
        List<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        while (i < arr.size() && j < brr.size()) {
            if (arr.get(i).equals(brr.get(j))) {
                j++;
                i++;
            } else {
                res.add(brr.get(j));
                j++;
            }
        }
        
        i = 0;
        while (i < res.size() - 1) {
            while (res.get(i) == res.get(i + 1)) res.remove(i);
            i++;
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        List<Integer> a1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            a1.add(scanner.nextInt());
        }

        int n2 = scanner.nextInt();
        List<Integer> a2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            a2.add(scanner.nextInt());
        }

        List<Integer> res = missingNumbers(a1, a2);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
