package com.company.bst;
import java.util.Scanner;
public class SumOfLeafNodes {
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    public Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        } else {
            if (key <= root.key) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }
        }
        return root;
    }
    static int sum;
    static void leafSum(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
          sum += root.key;
        leafSum(root.left);
        leafSum(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfLeafNodes tree = new SumOfLeafNodes();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        leafSum(root);
        System.out.println(sum);
    }
}
