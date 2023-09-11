package week2;
public class UF {
    private int id[];
    private int sz[];
    private boolean allUnion = false;

    public UF(int N) {
        id = new int[N];
        sz = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            if (sz[j] == id.length) allUnion = true;
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
            if (sz[i] == id.length) allUnion = true;
        }
    }

    public int find(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return (find(p) == find(q));
    }

    public boolean checkAllUnion() {
        return allUnion;
    }
}
