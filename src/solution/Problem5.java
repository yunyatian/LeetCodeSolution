package solution;
/**
 * 最长回文字段
 * */
public class Problem5 {
    public static void main(String args[]){
        //测试用例：abcb,abbabba,babad,b,cbbd,ccd,adam
        //测试时长测试用例：ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
        String string = "abbabba";
        System.out.println(longestPalindrome(string));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String string = String.valueOf(chars[0]);
        String string1,string2;
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length-1; j-i >= 1 ; j--) {
                //此时保证起始位置不变，终点位置向后退，不断迭代从而找到当前情况下的最长回文字段，通过循环实现终点位置向后退
                string1 = Match(i,j,chars,s.substring(i,j+1));
                //只要string1能够得出结果，就说明此时的结果就是当前情况下的最长回文字符串，则停止此次循环
                if (string1.length() > 0) {
                    //如果此时得出的字符串比原先的要长，则将这个字符串赋值给定义的最后结果string
                    if (string1.length() > string.length()) {
                        string = string1;
                    }
                    break;
                }
            }
            //此时保证结束位置不变，开始位置不断向前进，不断迭代从而获得当前情况下的最长回文字段，通过循环实现起始位置向前进
            string2 = Match(i, chars.length-1, chars,s.substring(i, chars.length));
            //只要string2能得出结果，就说明此时就是最长的回文字段，结束循环
            if (string2.length() > 0) {
                if (string2.length() > string.length()) {
                    string = string2;
                }
                break;
            }
        }

        return string;
    }

    public static String Match(int i,int j,char[] chars,String string){
        String s = "";
        //如果传输进来的字符串是奇数的，则只要开始位置和结束位置前后差距为2，且起始和结束位置的值是一样的，则返回传输进来的字符串
        //如果传输进来的字符串是偶数的，则需要开始位置和结束位置前后差距为1，且起始和结束位置的值是一样的，则返回传输进来的字符串
        //如果传输进来的字符串开始和结束位置的值一样，开始和结束位置不一致，且不满足前两个的所有前置条件，，则将开始位置向前进1，结束位置向后减1，再重新调用该方法
        if (j-i <= 2 && chars[i] == chars[j] && string.length()%2 == 1){
            return string;
        }else if(j-i == 1 && chars[i] == chars[j]){
            return string;
        }else if (chars[i] == chars[j] && i!=j){
            s = Match(i+1,j-1,chars,string);
        }
        return s;
    }

}
