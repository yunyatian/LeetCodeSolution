package solution;

import java.util.Arrays;
// TODO 未解决，思路都没有
/**
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。4 是数组中最高频元素，频数是 3 。
 * */
public class Problem1838 {
    public static void main(String[] args) {
        int[] nums = new int[]{9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};
        int k = 7925;
        System.out.println(maxFrequency(nums,k));
    }

    /**
     * 解题思路：将传入的数组进行排序，从最后一位进行遍历，将最后一位设置为可通过修改得到的最大高频元素，对其前面的数进行修改，
     *         当可修改的数值不够时，通过change += count * (nums[nums.length-record] - nums[nums.length-record-1]);
     *         修正可修改值。通过record来获取当前最大高频元素偏移位置。当前最大频数为nums.length-record
     * */
    public static int maxFrequency(int[] nums, int k) {
        int same = 1;//记录最大频数
        int record = 1;//已经记录的次数
        int change = k;//可修改值
        int count = 1;//记录当前最大频数
        //数组排序
        Arrays.sort(nums);
        //如果数组长度为1，直接返回1
        if (nums.length == 1){
            return same;
        }
        for (int i = nums.length-2; i >= 0; i--){
            //修改可改变值
            change = change - (nums[nums.length-record] - nums[i]);
            //如果可改变值大于0，说明可继续改变，且当前改变成立，故当前最大频数+1
            if (change > 0){
                count++;
            }else if (change == 0){//如果可改变值为0，说明当前最大高频元素不支持后续元素向其靠齐，需要对这次更改进行总结
                //为之后的修改刷新可改变值
                change += count * (nums[nums.length-record] - nums[nums.length-record-1]);
                //可改变值为0.说明此次添加成立，需要+1
                count++;
                record++;
                if (same < count){
                    same = count;
                }
                //下一次更改会更改最大高频元素，所以相当于当前最大高频元素被删除，故频数-1
                count--;
                continue;
            }else {//如果可改变值小于0，说明此次更改不成立，count不予以添加
                //为之后的修改刷新可改变值
                change += count * (nums[nums.length-record] - nums[nums.length-record-1]);
                if (same < count){
                    same = count;
                }
                record++;
                continue;
            }
//            for (int j = 1; change >= 0 && i-j >= 0; j++) {
//                change = change - (nums[i] - nums[i-j]);
//                count++;
//                if (change < 0){
//                    count--;
//                }
//            }
            if (same < count){
                same = count;
            }
        }
        return same;
    }
}
