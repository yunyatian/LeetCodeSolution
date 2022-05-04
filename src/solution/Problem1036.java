package solution;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1036 {
    public static void main(String[] args) {
        int[][] block = new int[][]{};
        int[] source = new int[]{0,0};
        int[] target = new int[]{0,2};
        System.out.println(isEscapePossible(block,source,target));
    }

    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        boolean flag = false;
        Map<Integer,Integer> blockMap = new LinkedHashMap<>();
        if (blocked.length == 0){
            return true;
        }
        if (source[0] == target[0] && source[1] == target[1]){
            return true;
        }
        return flag;
    }


}
