package solution;

public class Problem1946 {
    public static void main(String[] args) {
        String num = "334111";
        int[] change = new int[]{0,9,2,3,3,2,5,5,5,5};
        System.out.println(maximumNumber(num,change));
    }

    public static String maximumNumber(String num, int[] change) {
        boolean revise = false;
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int x = Character.getNumericValue(chars[i]);
            if (change[x] > x){
                chars[i] = (char) (change[x]+48);
                revise = true;
            } else if(change[x] == x){
                continue;
            }else if (revise){
                break;
            }
        }
        return String.valueOf(chars);
    }
}
