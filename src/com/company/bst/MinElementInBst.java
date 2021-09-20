package com.company.bst;
import java.util.Scanner;
public class MinElementInBst {
    class Node {
        int key;
        Node left, right;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    public void insert(int key) {
        root = insertRec(root, key);
    }
    public Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    public void inOrder() {
        inOrderRec(root);
    }
    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key + " ");
            inOrderRec(root.right);
        }
    }
    public static int findMin(Node root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int res=root.key;
        int lRes=findMin(root.left);
        int rRes=findMin(root.right);
        if(lRes<res){
            res=lRes;
        }
        if(rRes<res){
            res=rRes;
        }
        return res;
    }
    public static void main(String[] args) {
        MinElementInBst node = new MinElementInBst();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int num = scan.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            node.insert(scan.nextInt());
        }
        node.inOrder();
        int res=findMin(node.root);
        System.out.println("The minimum element is:"+res);
    }
}
