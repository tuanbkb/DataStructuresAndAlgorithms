package week13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    public static class Node implements Comparable<Node> {
        public int v;
        public int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }

    private int n;
    private List<List<Node>> adj;
    private int[] dist;
    private boolean[] checked;

    public Dijkstra(int n) {
        this.n = n;
        dist = new int[n];
        checked = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(checked, false);

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void add(int v, int w, int cost) {
        adj.get(v).add(new Node(w, cost));
        adj.get(w).add(new Node(v, cost));
    }

    public List<Integer> dijkstra(int start) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().v;
            if (!checked[u]) checked[u] = true;
            else continue;
            for (Node a : adj.get(u)) {
                int temp = a.cost + dist[u];
                if (dist[a.v] > temp) {
                    dist[a.v] = temp;
                    pq.add(new Node(a.v, temp));
                }
            }
        }

        for (int i : dist) {
            if (i != 0) {
                if (i == Integer.MAX_VALUE) res.add(-1);
                else res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Dijkstra d = new Dijkstra(n);

        for (int e = 0; e < m; e++) {
            d.add(scanner.nextInt() - 1, scanner.nextInt() - 1, scanner.nextInt());
        }

        int s = scanner.nextInt() - 1;

        for (int i : d.dijkstra(s)) {
            System.out.print(i + " ");
        }
    }
}
