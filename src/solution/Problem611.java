package solution;

import java.util.Arrays;

public class Problem611 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,8,45,1,7,9,6,5};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length-3; i++) {
            for (int j = i+1; j <= nums.length-2; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j] > nums[k]){
                        count++;
                    }else{
                        break;
                    }
                }

            }

        }
        return count;
    }
}
