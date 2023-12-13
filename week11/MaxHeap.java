package week11;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;
    
    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public int parent(int i) {
        return (i - 1)/2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return (i + 1) * 2;
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int a) {
        heap.add(a);

        int curIndex = heap.size() - 1;
        while (heap.get(curIndex) > heap.get(parent(curIndex))) {
            swap(curIndex, parent(curIndex));
            curIndex = parent(curIndex);
        }
    }

    public void print() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
