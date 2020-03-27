// LC Medium
// https://leetcode.com/problemset/top-amazon-questions/?search=tree

import java.awt.List;

class Solution {
    
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) { 
        List<Integer> solList = new List<Integer>();
        return boundaryPrime(root, solList, true);

    }

    public List<Integer> boundaryPrime (TreeNode curTree, List<Integer> aList, boolean canBeBoundary){
        
        // leaf
        if(curTree.left == null && curTree.Right == null){
            aList.add(curTree.val);
            return aList;
        }
        else if(true) {

        } 

        return aList;
    }

    public static void main(String[] args) {
        Solution classObj = new Solution();
        List<Integer> ans = classObj.boundaryOfBinaryTree();
        System.out.println("boundary output is: " + ans);

    }
}