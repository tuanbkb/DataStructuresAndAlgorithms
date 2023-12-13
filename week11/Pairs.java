package week11;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import java.util.ArrayList;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        HashSet<Integer> a = new HashSet<>();

        int count = 0;

        for (int i : arr) {
            a.add(i);
        }

        for (int i : arr) {
            if (a.contains(i + k)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        System.out.println(pairs(k, a));
    }
}