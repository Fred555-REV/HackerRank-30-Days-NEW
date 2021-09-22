package solution;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        Tree tree = new Tree();

        // System.out.println("Enter amount of nodes");
        int amount = scan.nextInt();
        for(int i=0; i < amount ; i++){
            // System.out.println("Enter data of node to enter");
            int data = scan.nextInt();
            tree.addNode(data);
        }
        System.out.println(tree.getHeight(tree.root));

    }
}
class Tree {
    Node root;

    Tree(){
        root=null;
    }
    public void addNode(int data){
        if(root==null){
            root = new Node(data);
        } else {
            Node current = root;
            searchTree(current,data);
        }
    }

    public void searchTree(Node current,int data){
        if(data > current.data){
            if(current.right==null){
                current.right = new Node(data);
            } else {
                searchTree(current.right,data);
            }
        } else {
            if(current.left==null){
                current.left = new Node(data);
            } else {
                searchTree(current.left,data);
            }
        }
    }

    public int getHeight(Node root){
        int heightL = 0;
        int heightR = 0;

        if(root.left!=null){
            heightL = getHeight(root.left) + 1;
        }

        if(root.right!=null){
            heightR = getHeight(root.right) + 1;
        }

        if(heightL>heightR){
            return heightL;
        } else {
            return heightR;
        }

    }

}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
    }
}