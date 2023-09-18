package week3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.List;
import java.util.ArrayList;

public class ClosestNumber {
    public static void main(String[] args) {
        int n = StdIn.readInt();

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(StdIn.readInt());
        }

        a.sort(null);

        List<Integer> ans = res(a);
        for (int i = 0; i < ans.size(); i++) {
            StdOut.print(ans.get(i) + " ");
        }
    }

    public static List<Integer> res(List<Integer> a) {
        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < a.size() - 1; i++) {
            if (min > a.get(i + 1) - a.get(i)) min = a.get(i + 1) - a.get(i);
        }

        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i + 1) - a.get(i) == min) {
                res.add(a.get(i));
                res.add(a.get(i + 1));
            }
        }

        return res;
    }

}
