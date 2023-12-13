/**
 * UnionFind
 */
public class UnionFind {

    private int[] a;
    private int[] sz;

    public UnionFind(int n) {
        a = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int u) {
        while (u != a[u]) {
            a[u] = a[a[u]];
            u = a[u];
        }

        return u;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        if (sz[p] > sz[q]) {
            a[p] = q;
            sz[q] += sz[p];
        } else {
            a[q] = p;
            sz[p] += sz[q];
        }
    }

    public boolean check(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(1, 2);
        uf.union(2, 3);
        System.out.println(uf.check(1, 3) + " " + uf.check(0, 1));
    }
}