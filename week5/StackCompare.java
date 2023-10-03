package week5;

import java.util.List;
import java.util.Vector;

public class StackCompare {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;
        
        for (int i = 0; i < h1.size(); i++) {
            height1 += h1.get(i);
        }
        for (int i = 0; i < h2.size(); i++) {
            height2 += h2.get(i);
        }
        for (int i = 0; i < h3.size(); i++) {
            height3 += h3.get(i);
        }
        
        while (height1 != height2 || height2 != height3 || height3 != height1) {
            int max = height1;
            int maxPos = 1;
            if (max < height2) {
                max = height2;
                maxPos = 2;
            }
            if (max < height3) {
                max = height3;
                maxPos = 3;
            }
            
            int min = Math.min(height1, Math.min(height2, height3));
            if (maxPos == 1) {
                while (height1 > min) {
                    height1 -= h1.get(0);
                    h1.remove(0);
                }
            }
            else if (maxPos == 2) {
                while (height2 > min) {
                    height2 -= h2.get(0);
                    h2.remove(0);
                }
            }
            else {
                while (height3 > min) {
                    height3 -= h3.get(0);
                    h3.remove(0);
                }
            }
        
        }
        return height1;
    }

    public static void main(String[] args) {
        List<Integer> a = new Vector<>();
        List<Integer> b = new Vector<>();
        List<Integer> c = new Vector<>();

        a.add(3);
        a.add(2);
        a.add(1);
        a.add(1);
        a.add(1);
        b.add(4);
        b.add(3);
        b.add(2);
        c.add(1);
        c.add(1);
        c.add(4);
        c.add(1);

        System.out.println(equalStacks(a, b, c));
    }
}
