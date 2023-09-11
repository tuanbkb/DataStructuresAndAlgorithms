package week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFClient2 {
    public static void main(String[] args) { 
        int N = StdIn.readInt(); 
        UF uf = new UF(N); 
        int count = 0;
        while (!StdIn.isEmpty() || !uf.checkAllUnion()) { 
            count++;
            int p = StdIn.readInt(); 
            int q = StdIn.readInt(); 
            if (!uf.connected(p, q)) { 
                uf.union(p, q);
            } 
        } 
        if (uf.checkAllUnion()) StdOut.println(count);
        else StdOut.println("FAILED");
    }
}
