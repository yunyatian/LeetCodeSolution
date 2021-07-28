package solution;

public class Problem1945 {
    public static void main(String[] args) {
        String s = "dbvmfhnttvr";
        int k = 5;
        System.out.println(getLucky(s,k));
    }

    public static int getLucky(String s, int k) {
        int result = 0;
        char[] chars = s.toCharArray();
        int[] nums = new int[chars.length*2];
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            int num = (int)chars[i] - 96;
            if (num >= 10){
                nums[j] = num/10;
                nums[j+1] = num%10;
                j = j+2;
            }else {
                nums[j] = num;
                j++;
            }
        }
        for (int i = 0; i < k; i++) {
            result = 0;
            for (int l = 0; l < nums.length; l++) {
                result += nums[l];
                nums[l] = 0;
            }
            char[] mid = String.valueOf(result).toCharArray();
            for (int l = 0; l < mid.length; l++) {
                nums[l] = (int)mid[l] - 48;
            }
        }
        return result;
    }
}
