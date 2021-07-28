package solution;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem863 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
// TODO 思路有bug，需要改进
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        TreeNode lNode11 = new TreeNode(5);
        TreeNode rNode11 = new TreeNode(1);
        TreeNode lNode21 = new TreeNode(2);
        TreeNode rNode21 = new TreeNode(5);
//        TreeNode lNode22 = new TreeNode(0);
        TreeNode rNode22 = new TreeNode(3);
//        TreeNode lNode32 = new TreeNode(7);
        TreeNode rNode32 = new TreeNode(4);
//        root.left = lNode11;
        root.right = rNode11;
        rNode11.left = lNode21;
        rNode11.right = rNode21;
//        rNode11.left = lNode22;
        lNode21.right = rNode22;
//        rNode21.left = lNode32;
        rNode22.right = rNode32;
        List<Integer> list = distanceK(root,lNode21,3);
        for (Integer x:list) {
            System.out.print(x+"    ");
        }
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Integer val = target.val;
        final List<Integer> list = new LinkedList<>();
        TraverseDown(target,0,k,list,val);
        ReviseTarget(root,target,root,k,list,val);
        list.remove(val);
        return list;
    }

    public static boolean TraverseDown(TreeNode node,int count,int k,List<Integer> list,int val){
        if (count == k && !list.contains(node.val)){
            list.add(node.val);
            return true;
        }
        if (node.left != null && node.left.val != val){
            TraverseDown(node.left,count+1,k,list,val);
        }
        if (node.right != null && node.right.val != val){
            TraverseDown(node.right,count+1,k,list,val);
        }
        return false;
    }
    public static void ReviseTarget(TreeNode root, TreeNode target,TreeNode currentNode, int k,List<Integer> list,int val){
        if (k <= 0 ){
            return;
        }
        if (currentNode.left != null && currentNode.left.val != target.val){
            ReviseTarget(root,target,currentNode.left,k,list,val);
        }else if (currentNode.left != null && currentNode.left.val == target.val ){
            k--;
            boolean judge = TraverseDown(currentNode,0,k,list,val);
            if (!judge){
                k++;
            }
            ReviseTarget(root,currentNode,root,k,list,val);
        }
        if (currentNode.right != null && currentNode.right.val != target.val){
            ReviseTarget(root,target,currentNode.right,k,list,val);
        }else if (currentNode.right != null && currentNode.right.val == target.val){
            k--;
            boolean judge = TraverseDown(currentNode,0,k,list,val);
            if (!judge){
                k++;
            }
            ReviseTarget(root,currentNode,root,k,list,val);
        }
    }

    /**
     * 先只考虑向下距离，不考虑向上距离
     * // TODO 向上距离还需要考量一下
     * 综合考量失败
     * */
//    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        Map<Integer, Map<String,Integer>> nodeMap = new HashMap<>();
//        List<Integer> list = new LinkedList<>();
//        Traverse(root, nodeMap, 0, "left",true,target);
////        Traverse(root,target,k,count,list);
//        int index = nodeMap.keySet().stream().filter(key -> key == target.val).findFirst().get();
//        Map<String,Integer> resultMap = nodeMap.get(index);
//        if (resultMap.keySet().contains("left")){
//            List<Integer> Result = nodeMap.keySet().stream().filter(val -> {
//                if (nodeMap.get(val).get("left") != null) {
//                    return Math.abs(nodeMap.get(val).get("left") - resultMap.get("left")) == k;
//                }else{
//                    return nodeMap.get(val).get("right") + resultMap.get("left") == k;
//                }
//            }).collect(Collectors.toList());
//            list.addAll(Result);
//        }else {
//            List<Integer> Result = nodeMap.keySet().stream().filter(val -> {
//                if (nodeMap.get(val).get("right") != null) {
//                    return Math.abs(nodeMap.get(val).get("right") - resultMap.get("right")) == k;
//                }else{
//                    return nodeMap.get(val).get("left") + resultMap.get("right") == k;
//                }
//            }).collect(Collectors.toList());
//            list.addAll(Result);
//        }
//        return list;
//    }
//
//    public static void Traverse(TreeNode node,Map<Integer, Map<String,Integer>> nodeMap,int high,String str,boolean judge,TreeNode target){
//        if (node.val == target.val){
//            judge = false;
//        }
//        Map<String,Integer> nodes = new HashMap<>();
//        nodes.put(str,high);
//        nodeMap.put(node.val, nodes);
//        if (node.left != null && judge){
//            Traverse(node.left,nodeMap,high+1,"left",judge,target);
//        }
//        if (node.right != null && judge){
//            Traverse(node.right,nodeMap,high+1,"right",judge,target);
//        }
//        if (!judge){
//            if (node.left != null){
//                Traverse(node.left,nodeMap,high+1,str,judge,target);
//            }
//            if (node.right != null){
//                Traverse(node.right,nodeMap,high+1,str,judge,target);
//            }
//        }
//    }

//    public static List<Integer> Traverse(TreeNode root, TreeNode target, int k,int count,List<Integer> list){
//        if (count == k){
//            list.add(root.val);
//        }else if (root.val == target.val){
//            Traverse(root.left,target,k,count+1,list);
//            Traverse(root.right,target,k,count+1,list);
//        }else if (count != 0){
//            if (root.left != null) {
//                Traverse(root.left, target, k, count + 1, list);
//            }
//            if (root.right != null) {
//                Traverse(root.right, target, k, count + 1, list);
//            }
//        }else{
//            if (root.left != null) {
//                Traverse(root.left, target, k, count, list);
//            }
//            if (root.right != null) {
//                Traverse(root.right, target, k, count, list);
//            }
//        }
//        return list;
//    }
}
