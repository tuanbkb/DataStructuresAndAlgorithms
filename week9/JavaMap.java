package week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String temp = scanner.nextLine();
        
        Map<String, String> a = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String phone = scanner.nextLine();
            a.put(name, phone);
        }
        
        while (scanner.hasNext()) {
            String name = scanner.nextLine();
            if (a.get(name) == null) System.out.println("Not found");
            else System.out.println(name + "=" + a.get(name));
        }
    }
}
