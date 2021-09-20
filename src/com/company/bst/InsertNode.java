package com.company.bst;
import java.util.Scanner;
public class InsertNode {
    class Node{
        int key;
        Node left,right;
        public Node(int data){
            key=data;
            left=right=null;
        }
    }
    Node root;
    InsertNode()
    {
        root=null;
    }
    void insert(int key)
    {
        root=insertRec(root,key);
    }
    Node insertRec(Node root,int key)
    {
        if(root==null)
        {
            root=new Node(key);
            //System.out.println(root);
            return root;
        }
        if(key<root.key)
            root.left=insertRec(root.left,key);
        else if(key>root.key)
            root.right=insertRec(root.right,key);
        return root;
        //System.out.println(root);
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
        InsertNode node=new InsertNode();
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
        node.insert(key);
        node.inOrder();
    }
}
