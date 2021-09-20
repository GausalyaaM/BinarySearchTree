package com.company.bst;

import java.util.Scanner;

public class LevelOrderToBst {
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
            this.left  = null;
            this.right = null;
        }
    };
    static Node root;
    static void  preorderTraversal(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    static Node getNode(int data)
    {
        Node node = new Node(data);
        return node;
    }
    static Node LevelOrder(Node root, int data)
    {
        if (root == null)
        {
            root = getNode(data);
            return root;
        }
        if (data <= root.data)
            root.left = LevelOrder(root.left, data);
        else
            root.right = LevelOrder(root.right, data);
        return root;
    }
    static Node constructBst(int []arr, int n)
    {
        if (n == 0)
            return null;
        root = null;
        for(int i = 0; i < n; i++)
            root = LevelOrder(root, arr[i]);
        return root;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int size = scan.nextInt();
        System.out.println("Enter the array elements:");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        //Node root = constructBst(arr, size);
        root = constructBst(arr, size);
        preorderTraversal(root);
    }
    }

