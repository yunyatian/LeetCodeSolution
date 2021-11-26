package solution;

public class Problem700 {

    static  class TreeNode {
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

    public static void main(String args[]){
        TreeNode T3 = new TreeNode(1);
        TreeNode T4 = new TreeNode(3);
        TreeNode T1 = new TreeNode(2,T3,T4);
        TreeNode T2 = new TreeNode(7);
        TreeNode root = new TreeNode(4,T1,T2);
        TreeNode result = searchBST(root,2);
        if (result != null) {
            OutBST(result);
        }else{
            System.out.println("NUll");
        }

    }

    public static  TreeNode searchBST(TreeNode root, int val) {
        if (root != null && root.val != val){
            TreeNode result1 = searchBST(root.left,val);
            if (result1 != null){
                return result1;
            }
            TreeNode result2 = searchBST(root.right,val);
            if (result2 != null){
                return result2;
            }
            return null;
        }else{
            return root;
        }
    }

    public static void OutBST(TreeNode root){
        if (root != null){
            System.out.println(root.val);
            OutBST(root.left);
            OutBST(root.right);
        }

    }
}
