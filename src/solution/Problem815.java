package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// TODO 待解决
public class Problem815 {
    public static void main(String args[]){
        int[][] routes = new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}};
        int source = 4,target = 19;
        System.out.println(numBusesToDestination(routes,source,target));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        int num = 0;
        List<List<Integer>> list = new LinkedList<>();
        if (source == target){
            return num;
        }
        for (int i = 0; i < routes.length; i++){
            List integers = Arrays.asList(routes[i]);
            list.add(integers);
        }
        return num;
    }
}
