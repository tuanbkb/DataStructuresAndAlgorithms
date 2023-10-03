package week5;

public class SelectionSort {
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int pos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    pos = j;
                }
            }

            int temp = a[i];
            a[i] = a[pos];
            a[pos] = temp;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] a = {1, 5, 7, 2, 9};
        selectionSort(a);
        print(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
