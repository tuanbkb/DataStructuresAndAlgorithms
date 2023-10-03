package week5;

import week5.LinkedStack;
import java.lang.String;
import java.util.Stack;

public class BalancedBracket {
    public static boolean isMatching(char a,char b){
        return (a=='(' && b==')') ||
                (a=='[' && b==']') ||
                (a=='{' && b=='}');
    }

    public static String isBalanced(String s) {
    // Write your code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                stack.push(current);
            }
            else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                else if (!isMatching(stack.peek(), current)) {
                    return "NO";
                }
                else stack.pop();
            }
        }
            
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        String test1 = "{[((()()))][]}{}";
        String test2 = "{[()]]}";
        String test3 = "[{[([])]}]";

        System.out.println(isBalanced(test1));
    }
}
