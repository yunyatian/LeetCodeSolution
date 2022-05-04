package solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
// TODO 时间和空间复杂度相当的大，应该想办法减少
public class Problem1005 {
    public static void main(String args[]){
        int nums[] = new int[]{-4,-2,-3};
        System.out.println(largestSumAfterKNegations(nums,4));

    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0,localmMin = 0;
        int result[] = Arrays.stream(nums).filter(x -> x <= 0).toArray();
        long count = Arrays.stream(nums).filter(x -> x > 0).count();
        if (count > 0 ){
            localmMin = Arrays.stream(nums).filter(x -> x > 0).min().getAsInt();
        }
        Arrays.sort(result);//默认从小到大排序
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                sum += nums[i];
            }
        }
        for (int i = 0; i < k && i < result.length ; i++) {
                sum -= result[i];
        }
        if (k > result.length){
            double pow = Math.pow(-1, k - result.length);
            if (pow == -1) {
                if ((result.length > 0 && localmMin > -result[result.length - 1]) || localmMin == 0) {
                    sum += result[result.length - 1] * 2;
                } else {
                    sum -= localmMin * 2;
                }
            }
        }else {
            for (int i = k; i < result.length; i++) {
                sum += result[i];
            }
        }
        return sum;
    }
}
