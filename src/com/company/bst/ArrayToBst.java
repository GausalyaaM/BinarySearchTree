package com.company.bst;
import java.util.Scanner;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class ArrayToBst {
    static Node root;
    static Node sortedArrToBst(int[] arr,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        Node node=new Node(arr[mid]);
        node.left = sortedArrToBst(arr, start, mid - 1);
        node.right = sortedArrToBst(arr, mid + 1, end);
        return node;
    }
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void main(String[] args){
        ArrayToBst tree=new ArrayToBst();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int size = scan.nextInt();
        System.out.println("Enter the array elements:");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }
        root=sortedArrToBst(arr,0,size-1);
        System.out.println("Preorder traversal of bst:");
        tree.preOrder(root);
    }


}
