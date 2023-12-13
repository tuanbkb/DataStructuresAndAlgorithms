package week10;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class IsThisABST {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static boolean checkBST(Node root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1)) return false;
        }

        return true;
    }

    public static void inorderTraversal(Node root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.data);
        else {
            inorderTraversal(root.left, res);
            res.add(root.data);
            inorderTraversal(root.right, res);
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean ans = checkBST(root);
        System.out.println(ans);
    }	
}