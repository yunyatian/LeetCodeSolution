package solution;

import java.util.*;

public class Problem3 extends ArrayList {

    public static void main(String args[]){
        String s = "quwukc";
//        int count = 0;
//        char[] chars = s.toCharArray();
//        LinkedList<Character> characters = new LinkedList<>();
//        for (int m = 0; m < chars.length; m++) {
//            if(!characters.contains(chars[m])){
//                characters.add(chars[m]);
//            }else{
//                //修改了list链表后，当即继续进行for循环，存在错误,必须将characters进行复制，但复制会带来巨大内存消耗
//                while(characters.getFirst() != chars[m]){
//                    characters.remove();
//                }
//                characters.remove();
//                characters.add(chars[m]);
//            }
//            if (count < characters.size()){
//                count = characters.size();
//            }
//        }
//        System.out.println(count);
        int count = 0;
        Problem3 characters = new Problem3();
        for (int i = 0;i < s.length();i++){
            if(characters.contains(s.charAt(i))){
                //removeRange是protect方法，必须是子类，同包，或当前类才可以使用，所以需要继承ArrayList
                characters.removeRange(0,characters.indexOf(s.charAt(i))+1);
            }
            characters.add(s.charAt(i));
            count = Math.max(count,characters.size());
        }
        System.out.println(count);
    }
}
