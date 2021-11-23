package solution;

/**
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 *
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 *
 * */
public class Problem650 {
    public static void main(String args[]){
        int n = 101;
        System.out.println(minSteps(n));
    }
    /**
     * 解题思路：找到当前值可被整除的最小值，操作数加上这个最小值，将当前值更换成当前值除以最小值的商。重复上述过程。
     * 这相当于找到每次需要copy的值得次数以及每次需要copy值的数目。当当前值为素数时，则将所需操作数加上该素数。
     * */
    public static int minSteps(int n) {
        int count = 0;
        for (int i = 2; i < n/2; i++) {
            if (n%i == 0){
                count += i ;
                n = n/i;
                i = 1;
            }
        }
        if (n > 1 ){
            count += n;
        }
        return count;
    }

}
