package solution;

public class Problem852 {
    public static void main(String args[]){
        int[] num = new int[]{2,3,4,3};
        int x = peakIndexInMountainArray(num);
        System.out.println(x);
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        for (int x = 0;x < arr.length; x++){
            if(arr[i] <= arr[x]){
                i = x;
            }else{
                break;
            }
        }
        return i;
    }
}
