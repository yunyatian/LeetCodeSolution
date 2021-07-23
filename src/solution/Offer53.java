package solution;

import java.util.Arrays;

public class Offer53 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5,7,7,8,8,10};
        System.out.println(search(numbers,8));
    }
/**
 *
 * */
    public static int search(int[] nums, int target) {
        int x = 0;
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (nums[i] == target){
                x++;
            }
        }
        return x;
    }

}
