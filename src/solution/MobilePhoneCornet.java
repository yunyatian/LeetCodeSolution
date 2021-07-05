package solution;

import java.util.Scanner;

public class MobilePhoneCornet {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.next());
        String[] mobile = new String[count];
        for (int i = 0;i < count;i++){
            //substring(begin,end)凭借字符串，不包括begin，包括end，不以0为起始下标
            mobile[i] = "6"+scanner.next().substring(6,11);
        }
        scanner.close();
        for (String str:mobile) {
            System.out.println(str);
        }
    }
}
