package solution;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1713 {
    public static void main(String[] args) {
        int[] target = new int[]{6,4,8,1,3,2};
        int[] arr = new int[]{4,7,6,2,3,8,6,1};
        System.out.println(minOperations(target,arr));
    }

    /**
     * 暂定思路：获取最长子序列，问题转变为如何获取最长子序列
     * //TODO 最长子序列思路尚未知
     * */
    public static int minOperations(int[] target, int[] arr) {
        int count = 0;
        ArrayList<Integer> list = (ArrayList<Integer>)Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (!list.contains(target[i])){
                count++;
            }else {

            }
        }


        return count;
    }
}
