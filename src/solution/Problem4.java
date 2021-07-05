package solution;

public class Problem4 {
    public static void main(String args[]){
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+ nums2.length];
        int i = 0,j = 0,index;
        for (index = 0; i < nums1.length && j < nums2.length; index++) {
            if (nums1[i] <= nums2[j]){
                nums[index] = nums1[i];
                i++;
            }else {
                nums[index] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length){
            nums[index] = nums1[i];
            index++;
            i++;
        }
        while (j < nums2.length){
            nums[index] = nums2[j];
            index++;
            j++;
        }

        int mid = nums.length/2;
        if (nums.length%2 == 0){
            return (double) (nums[mid]+nums[mid-1])/2;
        }else {
            return nums[mid];
        }
    }
}
