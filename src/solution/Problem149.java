package solution;

import java.util.*;
import java.util.stream.Collectors;

public class Problem149 {
    public static void main(String args[]){
        int[][] points ={{2,3},{3,3},{-5,3}};
        System.out.println(maxPoints(points));
    }
/**
 * 解题思路：构造一个Map<Integer,Map<Double,Integer>>集合，其中Map的键存储着起点的下标值，值中的Map键存储着该起点到其他各个点的斜率，
 *         值存储着该起点到其他点相同斜率的值。最后遍历这个Map找寻其中相同斜率值最大的值返回。
 * */
    public static int maxPoints(int[][] points) {
        if (points.length < 3){
            return points.length;
        }
        Map<Integer,Map<Double,Integer>> message = new LinkedHashMap<>();
        double slope;
        for (int i = 0; i < points.length; i++) {
            //用于存储当前起点到其他各点的斜率
            Map<Double,Integer> slopeMap = new LinkedHashMap<>();
            for (int j = i+1; j < points.length; j++) {
                double x = points[j][0] - points[i][0];
                double y = points[j][1] - points[i][1];
                if (x == 0){
                    //当斜率为无穷大，将斜率定义为Double的最大值
                    slope = Double.MAX_EXPONENT;
                }else {
                    slope = y / x;
                    //考虑斜率0有正负性，将所有斜率为-0调整为0
                    if (slope == -0){
                        slope = 0;
                    }
                }
                //如果斜率不存在，则添加斜率的键为1
                slopeMap.putIfAbsent(slope,1);
                //添加斜率，并使该斜率的键加1
                slopeMap.put(slope,slopeMap.get(slope)+1);
                //将起点小标和斜率信息map放入Map中
                message.put(i,slopeMap);
            }
        }
        //注意：stream里面的max操作获得是Option<Integer>类，所以需要get()操作将Option<Integer>类转换为Integer类
        int  max = message.values().stream().map(map -> map.values().stream()//将message的value转成流，获得所有的Stream<Map<Double,Integer>>
                .max(Comparator.comparing(Integer::byteValue)).get()).collect(Collectors.toList())//将每个Map里的最大值构造成一个list
                .stream().max(Comparator.comparing(Integer::byteValue)).get();//对所有的list进行max操作获得最大值
        return max;
    }
}
