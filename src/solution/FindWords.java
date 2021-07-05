package solution;

import java.util.Scanner;

/**
* 未解决
 */
public class FindWords {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();//记录录入数据数量
        long[] solutionNum = new long[count];//记录解决方案数量
        int[] data = new int[26];//记录每个数据的详情
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 26; j++) {
                data[j] = scanner.nextInt();
            }
            solutionNum[i] = calculateSolutionNum(data);
        }
        scanner.close();
        for (Long num:solutionNum) {
            System.out.println(num);
        }
    }

    public static Long calculateSolutionNum(int[] data){
        int[][] usableValues = new int[26][20];
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j <= data[i]; j++) {
                if (j*(i+1) <= 50){
                    usableValues[i][j-1] = j*(i+1);
                }else {
                    break;
                }
            }
        }
        for (int i = 0; i < usableValues.length; i++) {
            for (int j = 0; j < usableValues[i].length; j++) {
                System.out.printf("%2d ",usableValues[i][j]);
            }
            System.out.println();
        }
        return 0l;
    }

}
