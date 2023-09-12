package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class UFClient2 {
    public static void main(String[] args) { 
        In in = new In("week2\\tinyUF.txt");
        int N = in.readInt(); 
        UF uf = new UF(N); 
        int count = 0;
        while (!in.isEmpty() && !uf.checkAllUnion()) { 
            count++;
            int p = in.readInt(); 
            int q = in.readInt(); 
            if (!uf.connected(p, q)) { 
                uf.union(p, q);
            } 
        } 
        if (uf.checkAllUnion()) StdOut.println(count);
        else StdOut.println("FAILED");
    }
}
