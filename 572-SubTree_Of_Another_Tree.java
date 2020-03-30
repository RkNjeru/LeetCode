// https://leetcode.com/problems/subtree-of-another-tree/
// LeetCode 174/176 test cases passed

class SubTreeSolution{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(t == null && s == null){
            return true;
        }
        else if( t == null || s == null) { // if subtree is null
            return false;
        }
        else if(t.val == s.val){
            return (isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) || 
            isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        else if(t.val != s.val){
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        else{
            return false;
        }

    }
    
    public static void main(String[] args){
        SubTreeSolution classObj = new SubTreeSolution();

        TreeNode mainTree = new TreeNode(3);
        mainTree.left = new TreeNode(4);
        mainTree.right = new TreeNode(5);
        mainTree.left.left = new TreeNode(1);
        mainTree.right.left = new TreeNode(2);

        TreeNode subTree = new TreeNode(3);
        subTree.left = new TreeNode(1);
        subTree.right = new TreeNode(2);

        System.out.println(classObj.isSubtree(mainTree, subTree));

    }
}