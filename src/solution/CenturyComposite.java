package solution;

public class CenturyComposite {
    public static void main(String[] args) {
        int century = 2;
        int nums = 1;
        for (int i = 101; nums != 100; i+=2) {
            int mid = 0;
            if (i % 2 == 0) {
                i++;
                nums++;
            }else {
                for (int j = 2; j < i/2; j++) {
                    if (i%j == 0){
                        mid++;
                        break;
                    }
                }
            }
            if (mid > 0){
                nums+=2;
            }else{
                i = century*100-1;
                century++;
                nums = 0 ;
            }
        }
        System.out.println(century);
    }
}
