package solution;

import java.util.Arrays;

/**
 * 判断left到right之间的数是否都被nums内的元素覆盖
 * */
public class Problem1893 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{23,43},{12,17},{14,35},{13,20},{16,24},{6,18},{6,49},{6,29},{37,42},{22,42},{15,25},{3,20},{12,21},{21,38},{16,20},{7,22},{35,40},{38,39},{6,16},{2,15},{16,26},{5,18},{5,36},{5,47},{2,41},{1,19},{23,49},{31,32},{7,10},{33,50},{5,21},{33,43},{12,12},{10,50},{10,21},{7,20},{33,46},{19,39},{9,14},{10,35},{3,47}};
        int left = 21;
        int right = 50;
        System.out.println(isCovered(nums,left,right));
    }
/**
 * 解题思路：将left，right看做成一个[left，right]的区间，通过不断检索ranges来缩小[left，right]的范围
 * left,right,ranges[i][0],ranges[i][1]有以下六种位置关系：
 * ①(left)<(right)<[i][0]<[i][1]:此情况ranges并没有覆盖任何值，故[left，right]区域不变
 * ②[i][0]<[i][1]<(left)<(right)：此情况ranges并没有覆盖任何值，故[left，right]区域不变
 * ③[i][0]<(left)<(right)<[i][1]:此情况ranges覆盖[left,right]区域内的所有值，返回true
 * ④(left)<[i][0]<(right)<[i][1]:此情况ranges将[left,right]中的[[i][0],right]覆盖，那么接下来要判断的就是[left,[i][0]-1]
 * ⑤[i][0]<(left)<[i][1]<(right):此情况ranges将[left,right]中的[left,[i][i]]覆盖，那么接下来要判断的就是[[i][1]+1,right]
 * ⑥(left)<[i][0]<[i][1]<(right):此情况ranges将[left,right]中的[[i][0],[i][1]]覆盖，那么还剩下[left,[i][0]-1]和[[i][1]+1，right]
 * */
    public static boolean isCovered(int[][] ranges, int left, int right) {
        boolean result = false;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] <= left && ranges[i][1] >= right){
                result = true;
                break;
            }else if (ranges[i][0] > left && ranges[i][1] < right){
                boolean result1 = isCovered(ranges,left,ranges[i][0]-1);
                boolean result2 = isCovered(ranges,ranges[i][1]+1,right);
                result = result1 && result2;
                break;
            }else if (ranges[i][0] >= left && ranges[i][1] >= right && ranges[i][0] <= right){
                right = ranges[i][0]-1;
            }else if (ranges[i][0] <= left && ranges[i][1] >= left && ranges[i][1] <= right ){
                left = ranges[i][1]+1;
            }
        }
        return result;
    }
}
