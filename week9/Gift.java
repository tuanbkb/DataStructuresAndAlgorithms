package week9;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Gift {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long sum = 0;

        long money;
        Queue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            money = scanner.nextInt();
            pq.add(money);
            sum += money;
            if (pq.size() > k) sum -= pq.poll();
            System.out.print(sum + " ");
        }
    }
}
