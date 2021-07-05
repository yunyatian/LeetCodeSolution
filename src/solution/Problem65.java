package solution;

public class Problem65 {
    public static void main(String args[]){
        String string = "e";
        System.out.println(isNumber(string));
    }
    public static boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int count = 0;//记录小数点出现次数
        int tag = 0;//记录e和E出现次数
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] < '0' || chars[i] > '9') && (chars[i] != '-' && chars[i] != '+' && chars[i] !='e' && chars[i] != 'E' && chars[i] != '.')){
                //如果字符串内出现非规定字符，则为false
                return false;
            }else if(chars[i] == '-' || chars[i] == '+'){
                if (i != 0 && chars[i-1] != 'e' && chars[i-1] != 'E') {
                    //如果+和-出现的位置不是首位，且他的前一位不是e或者E，则为false
                    return false;
                }else if (i+1 == chars.length){
                    //如果+或-出现在字符串末尾，则为false
                    return false;
                }
            }else if (chars[i] =='e' || chars[i] == 'E'){
                tag++;
                if (tag > 1){//如果e和E出现超过一次，则为false
                    return false;
                }else if (i-1 < 0){//如果e或者E出现在字符串首位为false
                    return false;
                }else if(i+1 == chars.length){//如果e或者E出现在字符串末位为false
                    return false;
                }else if ((chars[i+1] < '0' || chars[i+1] > '9') && chars[i+1] != '+' && chars[i+1] != '-' ) {
                    //如果e或E的下一个字符是除+和-之外的非数字字符，则为false
                    return false;
                }else if (chars[i-1] < '0' || chars[i-1] > '9'){
                    if ((chars[i-1] == '.' || chars[i-1] == '+' || chars[i-1] == '-') && i-1 == 0){
                        //如果e或E的前一个位置非数字，且是.或+或-中的一个，并且位于字符串首位，则为false
                        return false;
                    }else{
                        continue;
                    }
                }
            }else if (chars[i] == '.'){
                count++;
                if (tag > 0){//如果已经出现了e或E，则为false
                    return false;
                }else if (count > 1){//如果小数点出现不止一次，则为false
                    return false;
                }else if (chars.length == 1) {//如果字符串仅有一个小数点为false
                    return false;
                }else if (i+1 != chars.length && (chars[i+1] < '0' || chars[i+1] > '9') && chars[i+1] != 'e' && chars[i+1] != 'E'){
                    //如果小数点后非数字字符不是e或E，则为false
                    return false;
                }else if (i+1 == chars.length && (chars[i-1] < '0' || chars[i-1] > '9')){
                    //如果小数点是最后一位，但前一位不是数字，则为false
                    return false;
                }
            }
        }
        return true;
    }
}
