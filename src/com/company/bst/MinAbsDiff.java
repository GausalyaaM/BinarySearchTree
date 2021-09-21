package com.company.bst;

import java.util.Scanner;

public class MinAbsDiff {
    class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }

    static Node root;

    MinAbsDiff() {
        root = null;
    }

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

    /*static void inOrder() {
        inOrderRec(root);
    }

    static void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }*/

    static Node prev;
    static int ans;
    static void inOrder(Node curr)
    {
        if (curr == null)
            return;
        inOrder(curr.left);
        if (prev != null)
            ans = Math.min(curr.key -
                    prev.key, ans);
        prev = curr;
        inOrder(curr.right);
    }


    static int minDiff(Node root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        inOrder(root);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinAbsDiff tree = new MinAbsDiff();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println(minDiff(root));
    }
}