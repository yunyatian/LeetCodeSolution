package solution;

import java.util.*;
import java.util.stream.Collectors;

// TODO 时间复杂度过高
public class Offer38 {
    public static void main(String args[]){
        String string = "abc";
        String[] strings = permutation(string);
        int x = 0;
        System.out.print("[");
        for (int i = 0; i < strings.length; i++) {
            x++;
            if ( x != strings.length){
                System.out.print("\""+strings[i]+"\",");
            }else{
                System.out.print("\""+strings[i]+"\"");
            }
        }
        System.out.println("]");
    }

    /***
     * 现阶段仅仅解决不包含重复字母情况下的构造
     */
//    public static String[] permutation(String s) {
//        char[] chars = s.toCharArray();
//        String[] strings ;
//        HashSet<String> stringSet = new HashSet<>();
//        for (int i = 0; i < chars.length; i++) {
//            stringSet.add(String.valueOf(chars[i]));
//            for (int j = 0; j < chars.length; j++) {
//                HashSet<String> replaceSet = (HashSet<String>) stringSet.clone();
//                if (j == i){
//                    continue;
//                }
//                for (String string : replaceSet) {
//                    if (!string.contains(String.valueOf(chars[j]))) {
//                        stringSet.add(string + chars[j]);
//                        stringSet.add(chars[j] + string);
//                    }
//                }
//            }
//        }
//        List<String> list = stringSet.stream().filter(string -> string.length() == s.length()).collect(Collectors.toList());
//        strings = list.toArray(new String[0]) ;
//        return strings;
//    }
    /**
     * 尚未完全通过测试，因为三for循环和clone的操作会大大影响时间复杂度，所以时间复杂度上存在问题，导致测试类并未完全通过，所以方法仍旧存疑
     * 解法思路：map键值对存储信息，key存储使用字母的排序顺序，value存储该顺序排序得到的值，最后在这个map里面找字符串长度等于输入字符串长
     *         度的字符串，并用set存储，可以去除重复的字符串。
     * */
    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        String[] strings ;
        int len = chars.length;
        LinkedHashMap<String,String> stringListMap = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            stringListMap.put(""+i,""+chars[i]);
            for (int j = 0; j < len; j++) {
                LinkedHashMap<String,String> replace = (LinkedHashMap<String, String>) stringListMap.clone();
                for (String str: replace.keySet()) {
                    //如果当前的键中不包含该下标，则将map中所有键添加此下标，所有值添加该下标的值
                    if (!str.contains(""+j)){
                        stringListMap.put(str + j,stringListMap.get(str) + chars[j]);
                        stringListMap.put(j + str,chars[j] + stringListMap.get(str));
                    }
                }
            }
        }
        Set<String> stringSet = stringListMap.values().stream().filter(string -> string.length() == s.length()).collect(Collectors.toSet());
        strings = stringSet.toArray(new String[0]);
        return strings;
    }
}
