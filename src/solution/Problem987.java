package solution;

import sun.reflect.generics.tree.Tree;

import java.util.List;

// TODO
public class Problem987 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode lNode21 = new TreeNode(4);
        TreeNode lNode22 = new TreeNode(5);
        TreeNode rNode21 = new TreeNode(6);
        TreeNode rNode22 = new TreeNode(7);
        TreeNode lNode11 = new TreeNode(2,lNode21,rNode21);
        TreeNode rNode11 =new TreeNode(3,lNode22,rNode22);
        TreeNode root = new TreeNode(1,lNode11,rNode11);
        verticalTraversal(root);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        return null;
    }
}
