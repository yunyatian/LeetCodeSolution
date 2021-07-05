package solution;

import java.util.Arrays;
import java.util.List;
// TODO 未解决，本身解题思维逻辑就存在问题
public class Problem752 {
    public static void main(String args[]){
        String[] strings = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(strings,target));
    }

    /***
     * 没有考虑到可以通过变动其他值去跳过死锁，而是一味的觉得前面的值走最少的步数，就可以得到最少步数，殊不知后面为了避免锁会走更多的步数
     * 当死锁盘中出现0100，而我们的目标盘是0101时，可以两步解开锁盘，但因为我写的逻辑是从头到尾的查找，故在查找到0100时会导致结果展示为死锁，错误
     * 下方解法逻辑存在重大错误。
     */
//    public static int openLock(String[] deadends, String target) {
//        List<String> deadendList = Arrays.asList(deadends);
//        if (deadendList.contains("0000")){
//            return -1;
//        }
//        int count = 0,change ,record;
//        char[] chars = "0000".toCharArray();
//        char[] targetChars = target.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int difference = chars[i] - targetChars[i];
//            if (Math.abs(difference) <= 5){
//                change = Math.abs(difference);
//                // TODO 执行加操作
//                record = increase(change,chars,deadendList,i);
//                if (record == -1){
//                    record = reduce(10-change,chars,deadendList,i);
//                }
//
//            }else {
//                change = (10 - Math.abs(difference));
//                // TODO 执行减操作
//                record= reduce(change,chars,deadendList,i);
//                if (record == -1){
//                    record = increase(10-change,chars,deadendList,i);
//                }
//            }
//            if (record == -1){
//                return -1;
//            }else {
//                count += record;
//            }
//        }
//        return count;
//    }
//
//    public static int increase(int change,char[] chars,List<String> deadends,int index){
//        String judge = "";
//        for (int i = 0; i < chars.length; i++) {
//            judge += chars[i];
//        }
//        StringBuilder stringBuilder = new StringBuilder(judge);
//        for (int i = 0; i < change; i++) {
//            if (chars[index] == '9') {
//                String x = String.valueOf((chars[index]) % 57);
//                chars[index] =  x.toCharArray()[0];
//            }else {
//                chars[index]++;
//            }
//            stringBuilder.replace(index,index+1,""+chars[index]);
//            if (deadends.contains(stringBuilder.toString())){
//                chars[index] = '0';
//                return -1;
//            }
//        }
//        return change;
//    }
//
//    public static int reduce(int change,char[] chars,List<String> deadends,int index){
//        String judge = "";
//        for (int i = 0; i < chars.length; i++) {
//            judge += chars[i];
//        }
//        StringBuilder stringBuilder = new StringBuilder(judge);
//        for (int i = 0; i < change; i++) {
//            if (chars[index] == '0') {
//                String x = String.valueOf((chars[index] + 9) % 48);
//                chars[index] =  x.toCharArray()[0];
//            }else {
//                chars[index]--;
//            }
//            stringBuilder.replace(index,index+1,""+chars[index]);
//            if (deadends.contains(stringBuilder.toString())){
//                chars[index] = '0';
//                return -1;
//            }
//        }
//        return change;
//    }

    public static int openLock(String[] deadends, String target) {

        return 0;
    }

}
