package com.company.bst;

import java.util.Scanner;

public class DeleteNode {
class Node {
    int key;
    Node left,right;
    public Node(int data){
        key=data;
        left=right=null;
    }
}
    Node root;
    DeleteNode(){
       root=null;
    }
    void insert(int key){
        root=insertRec(root,key);
    }
    Node insertRec(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
            if(key<root.key)
                root.left=insertRec(root.left,key);
            else if(key>root.key)
                root.right=insertRec(root.right,key);
            return root;
        }
        void delete(int key){
        root=deleteRec(root,key);
        }
        Node deleteRec(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        if(key<root.key)
            root.left=deleteRec(root.left,key);
        else if(key>root.key)
            root.right=deleteRec(root.right,key);
        else {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.key=minVal(root.right);
            root.right=deleteRec(root.right,root.key);
        }
        return root;
        }
        int minVal(Node root){
        int min=root.key;
        while(root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
        }
    void inOrder()
    {
        inOrderRec(root);
    }
    void inOrderRec(Node root)
    {
        if(root!=null){
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
    public static void main(String[] args) {
        DeleteNode node=new DeleteNode();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int num=scan.nextInt();
        System.out.println("Enter the elements:");
        for(int i=0;i<num;i++)
        {
            node.insert(scan.nextInt());
        }
        System.out.println("Enter the value of key:");
        int key=scan.nextInt();
        node.delete(key);
        node.inOrder();
    }
}
