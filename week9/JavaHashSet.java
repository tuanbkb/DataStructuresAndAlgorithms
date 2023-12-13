package week9;

import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        HashSet<String> pair = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            pair.add(line);
            System.out.println(pair.size());
        }
    }
}
