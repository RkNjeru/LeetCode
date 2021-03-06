class ValidateBSTSolution{

    public boolean isValidBST(TreeNode root){

        return validate(root, null, null);

    }

    public boolean validate(TreeNode root, Integer max, Integer min){

        if(root == null){
            return true;
        }
        else if(max != null && root.val >= max || min != null && root.val <= min){
            return false;
        }
        else{
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }

    }
    public static void main(String[] args){
        ValidateBSTSolution classObj = new ValidateBSTSolution();
        ValidateBSTSolution.TreeNode ex1 = classObj.new TreeNode(2); // true
        ex1.left = classObj.new TreeNode(1);
        ex1.right = classObj.new TreeNode(3);
        ValidateBSTSolution.TreeNode ex2 = classObj.new TreeNode(5); // false
        ex2.left = classObj.new TreeNode(1);
        ex2.right = classObj.new TreeNode(4);
        ex2.right.left = classObj.new TreeNode(3);
        ex2.right.right = classObj.new TreeNode(6);
        ValidateBSTSolution.TreeNode ex70 = classObj.new TreeNode(10); // false
        ex70.left = classObj.new TreeNode(5);
        ex70.right = classObj.new TreeNode(15);
        ex70.right.left = classObj.new TreeNode(6);
        ex70.right.right = classObj.new TreeNode(20);
        ValidateBSTSolution.TreeNode ex68 = classObj.new TreeNode(3); // false
        ex68.left = classObj.new TreeNode(1);
        ex68.right = classObj.new TreeNode(5);
        ex68.left.left = classObj.new TreeNode(0);
        ex68.left.right = classObj.new TreeNode(2);
        ex68.right.left = classObj.new TreeNode(4);
        ex68.right.right = classObj.new TreeNode(6);
        ex68.left.right.right = classObj.new TreeNode(3);

        ValidateBSTSolution.TreeNode ex62 = classObj.new TreeNode(-59); // true
        ex62.right = classObj.new TreeNode(49);
        ex62.right.right = classObj.new TreeNode(78);

        ValidateBSTSolution.TreeNode ex70B = classObj.new TreeNode(-2147483648); // true
        ex70B.right = classObj.new TreeNode(2147483647);

        ValidateBSTSolution.TreeNode ex70C = classObj.new TreeNode(0);
        ex70C.left = classObj.new TreeNode(Integer.MIN_VALUE);
        ex70C.right = classObj.new TreeNode(Integer.MAX_VALUE);

        // false
        ValidateBSTSolution.TreeNode ex73 = classObj.new TreeNode(10);
        ex73.left = classObj.new TreeNode(5);
        ex73.right = classObj.new TreeNode(15);
        ex73.right.left = classObj.new TreeNode(Integer.MIN_VALUE);
        ex73.right.right = classObj.new TreeNode(20);

        boolean ans = classObj.isValidBST(ex70C);
        System.out.println(ans);
    }

 
//  Definition for a binary tree node.
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
 
}