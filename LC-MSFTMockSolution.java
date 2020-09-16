class MSFTMockSolution{
    
   // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        int low = 0, high = nums.length - 1;
        int mid = low + ((high - low) / 2);
        
        // int mid = low + ( (high - low) / 2)
        
        if(nums.length == 0){return null;}

        TreeNode ans = new TreeNode(nums[mid], leftTree(nums, low, mid -1), rightTree(nums, mid + 1, high)); 
        return ans;
        
    }

    public TreeNode rightTree(int[] nums, int aLow, int aHigh){
        if(aLow > aHigh){
            return null;
        }
        return new TreeNode(nums[aHigh], rightTree(nums, aLow, aHigh - 1), null);
    }

    public TreeNode leftTree(int[] nums, int aLow, int aHigh){
        if(aLow > aHigh){
            return null;
        }

        return new TreeNode(nums[aHigh], leftTree(nums, aLow, aHigh - 1), null);
    }

    public TreeNode sortTree(int[] nums, TreeNode aTree, int begNums, int endNums){
        if(begNums <= endNums){
            return aTree;
        }


        return aTree;
    }
    

    public static void main(String[] args){
        MSFTMockSolution classObj = new MSFTMockSolution();
        

    }
}

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Example:

// Given the sorted array: [-10,-3,0,5,9],

// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

//       0
//      / \
//    -3   9
//    /   /
//  -10  5

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */