package solution;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description:
 * 给你一个整数数组 nums 和一个整数 target 。 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 *
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Problem494 {
    public static void main(String args[]){
        int[] nums = new int[]{1,0};
        int target = 1;
        System.out.println(findTargetSumWays(nums,target));


    }

    public static int findTargetSumWays(int[] nums, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list1;
        int count = 0;
        list.add(nums[0]);
        if (nums.length == 1 ){
            if (nums[0] == target || nums[0] == -target) {
                return 1;
            }else{
                return 0;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            list1 = (LinkedList<Integer>) list.clone();
            int y = nums[i];
            if (i == nums.length-1){
                //两个流操作增加大量时间复杂度，争取将两个流合并为一个，list内数据有26万多，减少一次流时间复杂度大幅下降
                for (int x:list) {
                    if (x+y == target || x+y == -target){
                        count++;
                    }
                    if (x-y ==target || x-y == -target){
                        count++;
                    }
                }
//                count = (int)list.stream().filter(x -> x+y == target || x+y == -target).count();
//                count += list.stream().filter(x -> x-y ==target || x-y == -target).count();
                if (target != 0) {
                    return count;
                }else{
                    return count*2;
                }
            }
//            list1.stream().forEach(x -> {
//                list.add(x+y);
//                list.add(x-y);
//                list.removeFirstOccurrence(x);
//            });
            for (int x: list1) {
                list.add(x+y);
                list.add(x-y);
                list.removeFirstOccurrence(x);
            }
            //会将我需要的值也删除
//            list.removeAll(list1);
//            list1.stream().map(x -> list.removeFirstOccurrence(x));

        }
//        count = (int) list.stream().filter(x -> x == target || x == -target).count();
        return -1;

    }
}
