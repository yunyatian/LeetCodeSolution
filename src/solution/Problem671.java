package solution;

import java.util.*;

public class Problem671 {
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
        TreeNode lTree3 = new TreeNode(5);
        TreeNode rTree3 = new TreeNode(7);
        TreeNode rTree2 = new TreeNode(5,lTree3,rTree3);
        TreeNode lTree2 = new TreeNode(2);
        TreeNode root = new TreeNode(2,lTree2,rTree2);
        System.out.println(findSecondMinimumValue(root));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        int result = Traverse(root,min);
        return result;
    }

    /**
     * 解题思路：当前节点一旦和根节点的值一致，就去他的左右节点继续寻找，直到出现不一样的值为止，将该值返回
     *         如果返回的值不是最初定义的值，那么就取其中最小的那个值
     * */
    public static int Traverse(TreeNode node,int min){
        int answer = -1;
        if (node != null && node.val == min){
            int lAnswer = Traverse(node.left,min);
            int rAnswer = Traverse(node.right,min);
            if (lAnswer != -1 && rAnswer != -1){
                answer = lAnswer < rAnswer ? lAnswer:rAnswer;
            }else if (lAnswer != -1){
                answer = lAnswer;
            }else if (rAnswer != -1) {
                answer = rAnswer;
            }
        }else if (node != null){
            answer = node.val;
        }
        return answer;
    }

// TODO 以下方法虽然可以通过测试，但时间复杂度和空间复杂度都过大，望改进

//    public static int findSecondMinimumValue(TreeNode root) {
//        Set<Integer> set = new HashSet<>();
//        CompleteMessage(set,root);
//        set.remove(root.val);
//        if (set.isEmpty()){
//            return -1;
//        }else {
//            return set.stream().min(Comparator.comparingInt(Integer::intValue)).get();
//        }
//    }
//
//    public static void CompleteMessage(Set<Integer> set,TreeNode node){
//        if (node != null){
//            set.add(node.val);
//            CompleteMessage(set,node.left);
//            CompleteMessage(set, node.right);
//        }
//    }
}
