package solution;

import java.util.Arrays;

public class Problems1823 {
    public static void main(String args[]){
        int n = 6;
        int k = 5;
        System.out.println(findTheWinner(n,k));
    }
    public static int findTheWinner(int n, int k) {
        LNode begin = new LNode(1);
        LNode pre = begin;
        int val = 2;
        int num = 0;
        while (pre.value != n){
            LNode node = new LNode(val);
            pre.right = node;
            pre = node;
            val++;
        }
        if (pre.value == n){
            pre.right = begin;
        }
        while (pre.right != pre){
            LNode node = pre.right;
            num++;
            if (num%k == 0){
                pre.right = node.right;
                node.right = null;
            }else {
                pre = node;
            }
        }
        return pre.value;
    }

    public static class  LNode{
        private int value;
        private LNode right;

        public LNode(int value) {
            this.value = value;
        }

        public LNode(int value, LNode right) {
            this.value = value;
            this.right = right;
        }
    }
}


