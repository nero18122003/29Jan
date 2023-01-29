package sumPair;
import java.io.*;
import java.util.ArrayList;
 import java.util.*;

class Node {
 
    int data;
    Node left, right;
 
    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
 
class BinarySearchTree {
 
    
    Node root;
 
    
    BinarySearchTree() { root = null; }
    void insert(int key) { root = insertRecord(root, key); }
 
   
    Node insertRecord(Node root, int data){
 
  
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        if (data < root.data)
            root.left = insertRecord(root.left, data);
        else if (data > root.data)
            root.right = insertRecord(root.right, data);
 
        return root;
    }
   
    boolean isPairThere(Node root, Node t, int sumTarget){
        if (t == null)
            return false;
 
        return search(root, t, sumTarget - t.data) 
        		|| isPairThere(root, t.left, sumTarget)
            || isPairThere(root, t.right, sumTarget);
        //recursive function
    }
 
    boolean search(Node root, Node t, int k){
 
        if (root == null)
            return false;
 
        Node c = root;
        boolean flag = false;
        while (c != null && flag != true) {
            if (c.data == k && t != c) {
                flag = true;
                System.out.println("Pair Found: " + c.data + " + " + t.data);
                return true;
            }
            else if (k < c.data)
                c = c.left;
            else
                c = c.right;
        }
 
        return false;
    }
 
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
         Scanner sc=new Scanner(System.in);
         System.out.println("enter the number of nodes");
         int limit=sc.nextInt();
         for(int i=0;i<limit;i++)
         {
        	 System.out.println("Enter the node");
        	 int number=sc.nextInt();
        	 tree.insert(number);
         }
       System.out.println("Enter the sum");
       int sum=sc.nextInt();
        boolean test
            = tree.isPairThere(tree.root, tree.root, sum);
        if (!test)
            System.out.println("No such values are found!");
    }
}