package com.company.bst;
import java.util.Scanner;
public class TrimBst {
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
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    private static Node removeOutsideRange(Node root, int min, int max) {
        if (root == null) {
            return null;
        }
        root.left = removeOutsideRange(root.left, min, max);
        root.right = removeOutsideRange(root.right, min, max);
        if (root.key < min) {
            Node rchild = root.right;
            root = null;
            return rchild;
        }
        if (root.key > max) {
            Node lchild = root.left;
            root = null;
            return lchild;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrimBst tree = new TrimBst();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.print("Inorder Traversal of " +
                "the given tree is: ");
        tree.inOrderRec(root);
        System.out.println("Enter the value of node1");
        int node1 = sc.nextInt();
        System.out.println("Enter the vaue of node2");
        int node2 = sc.nextInt();
       root = removeOutsideRange(root,node1,node2);
       System.out.print("\nInorder traversal of the modified tree: ");
        tree.inOrderRec(root);
    }
}
