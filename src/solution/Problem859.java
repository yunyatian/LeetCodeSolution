package solution;

import java.util.ArrayList;
import java.util.List;

/**
* 需要考虑如果两个不同位置字母相同，如“aa”就是可以交换两个字母，仍旧相同
 */
public class Problem859 {
    public static void main(String args[]){
        String s = "abca";
        String goal = "acba";
        System.out.println(buddyStrings(s,goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] goals = goal.toCharArray();
        int[] nums = new int[chars.length];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != goals[i]){
                nums[count] = i;
                count++;
            }
        }
        if (count != 2){
            List<Character> characters = new ArrayList<>();
            boolean judge = false;
            for (int i = 0; i < chars.length; i++) {
                if (!characters.contains(chars[i])){
                    characters.add(chars[i]);
                }else {
                    judge = true;
                }
            }
            if (count == 0 && judge){
                return true;
            }else {
                return false;
            }
        }else{
            if (chars[nums[0]] != goals[nums[1]] || chars[nums[1]] != goals[nums[0]]){
                return false;
            }else {
                return true;
            }
        }
    }
}
