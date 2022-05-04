package solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem506 {
    public static void main(String args[]){
        int score[] = new int[]{1,10,2,4,5};
        String order[] = findRelativeRanks(score);
        for (int i = 0; order[i] != null; i++) {
            System.out.println(order[i]+",");
        }
    }

    public static  String[] findRelativeRanks(int[] score) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        String order[] = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            map.put(score[i],i);
        }
        List<Integer> key= map.keySet().stream().sorted(Comparator.comparingInt(Integer::intValue)).collect(Collectors.toList());
        int count = 1;
        for (int x: key) {
            if (count == score.length){
                order[map.get(x)] = "Gold Medal ";
            }else if(count == score.length-1){
                order[map.get(x)] = "Silver Medal";
            }else if (count == score.length -2){
                order[map.get(x)] = "Bronze Medal";
            }else{
                order[map.get(x)] = String.valueOf(score.length-count+1);
            }
            count++;
        }
        return order;
    }
}
