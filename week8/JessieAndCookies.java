package week8;

import java.util.ArrayList;
import java.util.List;

public class JessieAndCookies {
    public static int cookies(int k, List<Integer> A) {
    // Write your code here
        MinPriorityQueue pq = new MinPriorityQueue();
        for (int i = 0; i < A.size(); i++) {
            pq.insert(A.get(i));
        }
    
        int count = 0;
        while (pq.size() > 1 && pq.getMin() < k) {
            int x = pq.delMin();
            int y = pq.delMin();
            pq.insert(x + 2*y);
            count++;
        }
        
        if (pq.getMin() < k) return -1;
        else return count;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            a.add(1);
        }

        int k = 105823341;
        System.out.println(cookies(k, a));
    }
}
