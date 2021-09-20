package com.company.bst;
import java.util.Scanner;
public class LowCommonAnchestor {
    class Node {
        int key;
        Node left, right;
        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
        Node root;
    LowCommonAnchestor(){
        root=null;
    }
    public void insert(int key){
        root=insertRec(root,key);
    }
    public Node insertRec(Node root,int key){
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
    void inOrder(){
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
    public Node lca(Node root,int n1,int n2){
        if(root==null){
            return null;
        }
        if(root.key>n1&&root.key>n2){
            return lca(root.left,n1,n2);
        }
        if(root.key<n1&&root.key<n2){
            return lca(root.right,n1,n2);
        }
        return root;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        LowCommonAnchestor tree=new LowCommonAnchestor();
        System.out.println("Enter the number of elements:");
        int num=scan.nextInt();
        System.out.println("Enter the elements:");
        for(int i=0;i<num;i++)
        {
            tree.insert(scan.nextInt());
        }
        System.out.println("Enter the value of node1:");
        int node1=scan.nextInt();
        System.out.println("Enter the value of node:");
        int node2=scan.nextInt();
        tree.inOrder();
        Node res=tree.lca(tree.root,node1,node2);
        System.out.println(res.key);
    }

}

