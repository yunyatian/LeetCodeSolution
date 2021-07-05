package solution;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {
    public static void main(String args[]){
        int[] num = new int[]{23,2,6,4,7};
        int i = 6;
        boolean judge = checkSubarraySum(num,i);
        System.out.println(judge);

    }
     public static boolean checkSubarraySum(int[] nums, int k) {
         int sum;
         if (nums.length < 2){
             return false;
         }
         for(int i=0;i<nums.length-1;i++){
             if(nums[i]==0 && nums[i+1]==0)
                 return true;
         }
         for (int x = 0; x < nums.length - 1; x++){
             sum = 0;
             sum += nums[x];
             for (int y = x+1; y < nums.length; y++){
                 sum += nums[y];
                 if(sum%k == 0){
                     return true;
                 }else if(y == nums.length - 1 && sum < k){
                     return false;
                 }
             }
         }
         return false;

    }


}

