import java.io.*;
import java.util.*;

public class SegmentTreeEx {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        
        // SegmentTree st = new SegmentTree(a);
        // long[] tree = new long[2*n];
        // build(a, tree, 1, 0, n - 1);
        
        int q = scanner.nextInt();
        int max = Long.MIN_VALUE;
        int prevL;
        int prevR;
        for (int t = 0; t < q; t++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            // System.out.println(max(tree, 1, 0, n - 1, l, r));
            prevL = l;
            prevR = r;
            
            
        }

        scanner.close();
    }

    public static void build(long[] a, long[] tree, int node, int left, int right) {
        if (left == right) {
            tree[node] = a[left];
            return;
        }
        
        int mid = (left + right) / 2;
        build(a, tree, node * 2, left, mid);
        build(a, tree, node * 2 + 1, mid + 1, right);
        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }

    public static long max(long[] tree, int node, int start, int end, int l, int r) {
        if (r < start || l > end) return Integer.MIN_VALUE;
        if (l <= start && r >= end) return tree[node];
            
        int mid = (start + end) / 2;
        long maxLeft = max(tree, 2 * node, start, mid, l, r);
        long maxRight = max(tree, 2 * node + 1, mid + 1, end, l, r);
        return Math.max(maxLeft, maxRight);
    }
    
    // public static class SegmentTree {
    //     private int n;
    //     private int[] tree;
        
    //     public SegmentTree(int[] a) {
    //         this.n = a.length;
    //         this.tree = new int[this.n * 2];
    //         build(a, 1, 0, n - 1);
    //     }
        
    //     public void build(int[] a, int node, int left, int right) {
    //         if (left == right) {
    //             tree[node] = a[left];
    //             return;
    //         }
            
    //         int mid = (left + right) / 2;
    //         build(a, node * 2, left, mid);
    //         build(a, node * 2 + 1, mid + 1, right);
    //         tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    //     }
        
    //     public int maxQuery(int l, int r) {
    //         return max(1, 0, n - 1, l, r);
    //     }
        
    //     public int max(int node, int start, int end, int l, int r) {
    //         if (r < start || l > end) return Integer.MIN_VALUE;
    //         if (l <= start && r >= end) return tree[node];
            
    //         int mid = (start + end) / 2;
    //         int maxLeft = max(2 * node, start, mid, l, r);
    //         int maxRight = max(2 * node + 1, mid + 1, end, l, r);
    //         return Math.max(maxLeft, maxRight);
    //     }
    // }
}