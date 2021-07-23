package solution;

import java.util.Arrays;

public class Problem1877 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,2,4,6};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        int x = 0 ;
        int[] sum = new int[nums.length/2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length/2; i++) {
            if (nums[i]+nums[nums.length-i-1] > x){
                x = nums[i]+nums[nums.length-i-1];
            }
//            sum[i] = nums[i]+nums[nums.length-i-1];
        }
//        Arrays.stream(sum).max().getAsInt()
        return x;
    }
}
