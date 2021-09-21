package com.company.bst;
import java.util.Scanner;
public class MinDistance {
    class Node {
        int key;
        Node left, right;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    public Node insert(Node root, int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        else{
            if(key<=root.key){
                root.left=insert(root.left,key);
            }
            else{
                root.right=insert(root.right,key);
            }
        }
        return root;
    }
    public static int distanceFromRoot(Node root,int x){
        if(root.key==x){
            return 0;
        }
        else if(root.key>x){
            return 1+distanceFromRoot(root.left,x);
        }
        return 1+distanceFromRoot(root.right,x);
    }
    public static int distanceBetween2(Node root,int node1,int node2){
        if(root==null){
            return 0;
        }
        if(root.key>node1&&root.key>node2){
            return distanceBetween2(root.left,node1,node2);
        }
        if(root.key<node1&&root.key<node2){
            return distanceBetween2(root.right,node1,node2);
        }
        if(root.key>=node1&&root.key<=node2){
            return distanceFromRoot(root,node1)+distanceFromRoot(root,node2);
        }
        return 0;
    }
    public static int findDist(Node root,int node1,int node2){
        int temp=0;
        if(node1>node2){
            temp=node1;
            node1=node2;
            node2=temp;
        }
        return distanceBetween2(root,node1,node2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinDistance tree = new MinDistance();
        System.out.println("Enter the no.of elements");
        int num = sc.nextInt();
        Node root = null;
        System.out.println("Enter the elements:");
        for (int i = 0; i < num; i++) {
            root = tree.insert(root, sc.nextInt());
        }
        System.out.println("Enter the value of node1");
        int node1 = sc.nextInt();
        System.out.println("Enter the vaue of node2");
        int node2 = sc.nextInt();
        System.out.println(findDist(root,node1,node2));
    }
}
