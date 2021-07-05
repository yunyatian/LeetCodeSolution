package solution;
/**
 * 未自行解决
 * */
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class Problem877 {
    public static void main(String args[]){
        int[] num = new int[]{3,2,10,4};
        System.out.println(stoneGame(num));
    }
    // 一味选取大值并不能得出最佳结果,一味选取最大值会导致[3，2，10，4]数组判断失误
    // 考虑每次选取后始终和下一人的所有可能选取值保持最大差距，会导致第一人在非必要情况下解开对于最大值的封锁，从而使得判断失误，例如：[6,9,4,3,9,8]
    // 考虑每次取和后和下一人取值之后的和相减，如果有非正数，则取其中最大值，全为正值，也只取最大值，尚未实践就被推翻，反例：[2,1,1,1]
    public static int stoneGame(int[] piles) {
        int len = piles.length;
        int[][] memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            // 由于是相对分数，有可能是在负值里面选较大者，因此初始化的时候不能为 0
            // 为memo二维数组填充数值，memo[i][i]填充piles[i]，其余填充Integer.MIN_VALUE
            Arrays.fill(memo[i], Integer.MIN_VALUE);
            memo[i][i] = piles[i];
        }
        return stoneGame(piles, 0, len - 1, memo);
    }


    /**
     * 计算子区间 [left, right] 里先手能够得到的分数
     *
     * @param piles
     * @param left
     * @param right
     * @return
     */
    private static int stoneGame(int[] piles, int left, int right, int[][] memo) {
        if (left == right) {
            return piles[left];
        }

        if (memo[left][right] != Integer.MIN_VALUE) {
            return memo[left][right];
        }

        int chooseLeft = piles[left] - stoneGame(piles, left + 1, right, memo);
        int chooseRight = piles[right] - stoneGame(piles, left, right - 1, memo);
        int res = Math.max(chooseLeft, chooseRight);
        memo[left][right] = res;
        System.out.println("==============================================================");
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.printf("%15d",memo[i][j]);
            }
            System.out.println();
        }
        return res;
    }


}
