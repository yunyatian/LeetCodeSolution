package solution;

import java.util.Arrays;
import java.util.List;

public class Offer15 {
    public static void main(String args[]){
        int x = 00000000000000000000000000001011;
        System.out.println(hammingWeight(x));
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
