package solution;

public class Problem483 {
    public static void main(String args[]){
        String string = "4681";
        System.out.println(smallestGoodBase(string));

    }

    public static String smallestGoodBase(String n) {
//        String s = "";
        Long base = Long.parseLong(n);
        Long i = 2L;
        //暴力破解，时间复杂度过高
        for (; i < base; i++) {
//            s = "";
            while (base%i == 1){
//                s += "1";
                base = base/i;
                if (base == 1){
//                    s += "1";
//                    return String.format("%s的%d进制是%s。",n,i,s);
                    return String.valueOf(i);
                }
            }
            base = Long.parseLong(n);
        }
//        return String.format("%s的%d进制是%s。",n,base-1,"11");
        return String.valueOf(base-1);
    }
}
