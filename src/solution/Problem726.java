package solution;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
/**
 * 括号后跟数字的情况尚未解决，可以考虑重新架构map为Map<Integer,Map<String,Integer>>第一个Integer用来记忆括号层级，
 * 从而实现记忆功能，可以使得取出去的数可以重新赋值，但这种方法将带来极大的时间复杂度，需慎重考虑
 * 以上方法无法实现，括号层级会无法作为唯一键，会有重复元素导致不必要的重新赋值导致赋值错误。
 * 新思路：将经历过括号的变更的元素重新入栈，最后一次全部出栈
 * */
public class Problem726 {
    public static void main(String args[]){
        String string = "(NB3)33";
        //测试用例："K4(MgN(SO3)2)2(H2O)2H","(H200)Mg2OH","Be32","(NB3)33"
        System.out.println(countOfAtoms(string));
    }

//    public static String countOfAtoms(String formula) {
//        String string = "";
////        int left_count = 0,right_count = 0;
//        char[] chars = formula.toCharArray();
//        //TreeMap会根据首字母大小自动进行排序
//        Map<String,Integer> sortMap = new TreeMap<>();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ')'){
//                while (stack.peek() != '(') {
//                    if (stack.peek() < '0' || stack.peek() >= '9') {
//                        Key_value_information(sortMap, stack, 1);
//                    } else {
//                        String s = "";
//                        while(stack.peek() >= '0' && stack.peek() <= '9'){
//                            s = stack.pop()+s;
//                        }
//                        Key_value_information(sortMap, stack, Integer.parseInt(s));
//                    }
//                }
//                stack.pop();
//                continue;
//            }
//            stack.push(chars[i]);
//        }
//        Collective_withdrawal(sortMap,stack);
//        for (String key:sortMap.keySet()) {
//            string += key;
//            if (sortMap.get(key) > 1){
//                string += sortMap.get(key);
//            }
////            System.out.println(key+"："+sortMap.get(key));
//        }
//        return string;
//    }
//
//    public static void Collective_withdrawal(Map<String, Integer> sortMap, Stack<Character> stack) {
//        while (!stack.isEmpty()){
//            if (stack.peek() <= '0' || stack.peek() >= '9'){
//                Key_value_information(sortMap,stack,1);
//            }else {
//                Integer numValue = Character.getNumericValue(stack.pop());
//                Key_value_information(sortMap,stack,numValue);
//            }
//        }
//    }
//
//    public static void Key_value_information(Map<String,Integer> sortMap,Stack<Character> stack,int num){
//        char value = stack.pop();
//        if (value >= 'A' && value <= 'Z'){
//            sortMap.putIfAbsent(""+value,0);
//            sortMap.put(""+value, sortMap.get(""+value)+num);
//        }else if (value >= 'a' && value <= 'z'){
//            String key = ""+value;
//            while (stack.peek() >= 'a' && stack.peek() <= 'z'){
//                key = stack.pop()+key;
//            }
//            key = stack.pop()+key;
//            sortMap.putIfAbsent(key,0);
//            sortMap.put(key, sortMap.get(key)+num);
//        }
//    }
    public static String countOfAtoms(String formula) {
        String string = "";
        char[] chars = formula.toCharArray();
        Stack<String> stack = new Stack<>();
        Map<String,Integer> sortMap = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                stack.push(stack.pop()+chars[i]);
                continue;
            }else if (chars[i] >= '0' && chars[i] <= '9'){
                String num = "";
                do {
                    num += chars[i];
                    i++;
                }while(i < chars.length && chars[i] >= '0' && chars[i] <= '9');
                stack.push(num);
                i--;
                continue;
            }else if (chars[i] == ')' && i < chars.length-1 && chars[i+1] >= '0' && chars[i+1] <= '9'){
                i++;
                String num = "";
                do {
                    num += chars[i];
                    i++;
                }while(i < chars.length && chars[i] >= '0' && chars[i] <= '9');
                i--;
                Stack<String> transitStack = new Stack<>();
                while (!stack.peek().equals("(")) {
                    if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(stack.peek().charAt(0) + "")
                            && (transitStack.isEmpty()
                            || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(transitStack.peek().charAt(0) + ""))) {
                        transitStack.push(Integer.parseInt(num)+"");
                    } else if ("0123456789".contains(stack.peek().charAt(0) + "")) {
                        int numbers = Integer.parseInt(stack.pop());
                        numbers = numbers * Integer.parseInt(num);
                        transitStack.push(numbers + "");
                    }
                    transitStack.push(stack.pop());
                }
                stack.pop();
                while (!transitStack.isEmpty()){
                    stack.push(transitStack.pop());
                }
                continue;
            }
            if (chars[i] != ')') {
                stack.push(chars[i] + "");
            }
        }
        while(!stack.isEmpty()){
            String value = stack.pop();
            if ("0123456789".contains(value.charAt(0) + "")){
                String key = stack.pop();
                sortMap.putIfAbsent(key,0);
                sortMap.put(key, sortMap.get(key)+Integer.parseInt(value));
            }else if (value.equals("(")){
                continue;
            }else {
                sortMap.putIfAbsent(value,0);
                sortMap.put(value, sortMap.get(value)+1);
            }
        }
        for (String key: sortMap.keySet()) {
            string += key;
            if (sortMap.get(key) != 1){
                string += sortMap.get(key);
            }
        }
        return string;
    }

}
