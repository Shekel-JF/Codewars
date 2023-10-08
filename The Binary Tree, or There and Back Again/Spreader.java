package com.codewars.solution;
public class Spreader
{   
    public Node rotateRight(Node root)
    {
        if(root == null || root.left == null)
        {
            return root;
        }
      
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
            
        return newRoot;
    }

    public Node rotateLeft(Node root)
    {
        if(root == null || root.right == null)
        {
            return root;
        }
      
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
            
        return newRoot;
    }
}