package com.company.bst;

import java.util.Scanner;

public class SumOfK{
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    public Node insert(Node root, int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        else {
            if (key <= root.key) {
                root.left = insert(root.left, key);
            } else {
                root.right = insert(root.right, key);
            }
        }
        return root;
    }
    static int count=0;
    public static int kSmallestElementSumRec(Node root,int k){
        if(root==null){
            return 0;
        }
        if(count>k){
            return 0;
        }
        int res=kSmallestElementSumRec(root.left,k);
        if(count>=k){
            return res;
        }
        res+= root.key;
        count++;
        if(count>=k){
            return res;
        }
        return res+kSmallestElementSumRec(root.right,k);
    }
    public  static int kSmallestElementSum(Node root,int k){
        int res=kSmallestElementSumRec(root,k);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfK tree = new SumOfK();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        int count=kSmallestElementSum(root,k);
        System.out.println("count is:"+count);
    }
}
