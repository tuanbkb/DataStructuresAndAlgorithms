package week2;

import java.util.Scanner;

public class UFClient1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        UF uf = new UF(N);
        while (scanner.hasNextInt()) { 
            int p = scanner.nextInt();
            int q = scanner.nextInt(); 
            if (!uf.connected(p, q)) { 
                uf.union(p, q); System.out.println(p + " " + q); 
            } 
        }
    }
}
