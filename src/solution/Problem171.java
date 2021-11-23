package solution;

public class Problem171 {
    public static void main(String[] args) {
        String string = "FXSHRXW";
        System.out.println(titleToNumber(string));

    }

    public static int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int sum = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            sum += Math.pow(26, chars.length-1-i)*((int)chars[i]-'A'+1);
        }
        return sum;
    }
}
