public class MergeSort {
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    public static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, r);
            merge(a, l, r);
        }
    }

    public static void merge(int[] a, int l, int r) {
        int temp[] = new int[r - l + 1];
        int mid = (l + r) / 2;
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (a[i] > a[j]) {
                temp[k] = a[j];
                j++;
            } else {
                temp[k] = a[i];
                i++;
            }

            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }

        i = 0;
        for (int t = l; t <= r; t++) {
            a[t] = temp[i];
            i++;
        }
    }

    public static void main(String[] args) {
        int a[] = {5, 2, 4, 8, 7, 9, 1, 3, 6, 0};
        mergeSort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
