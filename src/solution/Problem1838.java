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
        int[] nums = new int[]{1,2,4};
        int k = 5;
        System.out.println(maxFrequency(nums,k));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] DiffArray = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++){
            DiffArray[i] = nums[i+1] - nums[i];
        }
        return 0;
    }
}
