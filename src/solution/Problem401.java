package solution;


import java.util.*;

public class Problem401 {
    public static void main(String args[]){
        int x = 3,y = 0,z = 0;
        System.out.print("[");
        for (String str:readBinaryWatch(x)) {
            y++;
            if (y != readBinaryWatch(x).size()) {
                System.out.print("\"" + str + "\",");
            }else{
                System.out.print("\"" + str + "\"");
            }
        }
        System.out.println("]");
        System.out.print("[");
        for (String str:readBinaryWatch1(x)) {
            z++;
            if (z != readBinaryWatch1(x).size()) {
                System.out.print("\"" + str + "\",");
            }else{
                System.out.print("\"" + str + "\"");
            }
        }
        System.out.println("]");

    }



/**
 * 解法一：通过map存储所有可能的时间总和，key存储时间总和，value存储已用键的次数，然后比对时的map和分的map，如果他俩的value相加等于turnedOn，
 *        则将这两的key进行拼接放入链表中。
 * */
    public  static List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new LinkedList<>();
        int[] hour = new int[]{1,2,4,8};
        int[] min = new int[]{1,2,4,8,16,32};
        //在这里必须是LinkedHashMap，否则后面的clone方法无法使用
        LinkedHashMap<String,Integer> hourMessage = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> minMessage = new LinkedHashMap<>();
        hourMessage.put("0",0);
        minMessage.put("00",0);
        for (int i = 0; i < hour.length || i < min.length; i++) {
            for (int j = i; j < hour.length; j++){
                LinkedHashMap<String,Integer> replaceHour = (LinkedHashMap<String, Integer>) hourMessage.clone();
                for (String string: replaceHour.keySet()) {
                    if (Integer.parseInt(string) < hour[i]){
                        int sum = Integer.parseInt(string)+hour[i];
                        if (sum < 12) {
                            hourMessage.put(String.valueOf(sum), hourMessage.get(string) + 1);
                        }else {
                            break;
                        }
                    }
                }
            }
            for (int j = i; j < min.length; j++){
                LinkedHashMap<String,Integer> replaceMin = (LinkedHashMap<String, Integer>) minMessage.clone();
                for (String string : replaceMin.keySet()) {
                    if (Integer.parseInt(string) < min[i]){
                        int sum = Integer.parseInt(string)+min[i];
                        if (sum < 10){
                            minMessage.put("0"+sum,minMessage.get(string)+1);
                        }else if (sum < 60){
                            minMessage.put(String.valueOf(sum),minMessage.get(string)+1);
                        }else {
                            break;
                        }
                    }
                }
            }

        }
        for (String x : hourMessage.keySet()) {
            for (String y : minMessage.keySet()) {
                if (hourMessage.get(x)+minMessage.get(y) == turnedOn){
                    times.add(x+":"+y);
                }
            }
        }
        return times;
    }

    /**
     * 解法二：学会运用Integer.bitCount()方法，这个方法会返回补码中1的个数
     * */
    public  static List<String> readBinaryWatch1(int turnedOn) {
        List<String> times = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){
                    times.add(i+":"+(j < 10 ? "0":"")+j);
                }
            }

        }
        return times;
    }
}
