package week5;

import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;

public class TextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        
        String res = "";
        Stack<Integer> lastAction = new Stack<>();
        Stack<String> lastString = new Stack<>();
        int currentState = 0;
        while (currentState < q) {
            int state = scanner.nextInt();
            if (state == 1) {
                String insert = scanner.nextLine();
                insert = insert.substring(1);
                lastAction.push(new Integer(1));
                lastString.push(insert);
                res += insert;
            }
            else if (state == 2) {
                int num = scanner.nextInt();
                lastAction.push(new Integer(2));
                lastString.push(res.substring(res.length() - num));
                if (res.length() == num) res = "";
                else res = res.substring(0, res.length() - num);
            }
            else if (state == 3) {
                int place = scanner.nextInt();
                System.out.println(res.charAt(place - 1));
            }
            else {
                if (lastAction.peek() == 1) {
                    if (res.length() == lastString.peek().length()) res = "";
                    else res = res.substring(0, res.length() - lastString.peek().length());
                }
                else if (lastAction.peek() == 2) {
                    res += lastString.peek();
                }
                lastString.pop();
                lastAction.pop();
            }
            currentState++;
        }
    }
}
