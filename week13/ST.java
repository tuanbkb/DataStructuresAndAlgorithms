import java.util.Scanner;

public class ST {
    public static long[] tree = new long[600000];

    public static void build(long[] tree, long[] a, int ind, int start, int end) {
        if (start == end) {
            tree[ind] = a[start];
            return;
        }

        int mid = (start + end) / 2;
        build(tree, a, 2 * ind, start, mid);
        build(tree, a, 2 * ind + 1, mid + 1, end);
        tree[ind] = Math.max(tree[ind * 2 + 1], tree[ind * 2]);
    }

    public static long max(long[] tree, int ind, int start, int end, int l, int r) {
        if (r < start || l > end) return Integer.MIN_VALUE;
        if (l <= start && r >= end) return tree[ind];
            
        int mid = (start + end) / 2;
        long maxLeft = max(tree, 2 * ind, start, mid, l, r);
        long maxRight = max(tree, 2 * ind + 1, mid + 1, end, l, r);
        return Math.max(maxLeft, maxRight);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        // tree = new long[n * 2];
        build(tree, a, 1, 0, n - 1);

        int q = scanner.nextInt();
        for (int test = 0; test < q; test++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            System.out.println(max(tree, 1, 0, n - 1, l, r));
        }

        scanner.close();
    }
}
