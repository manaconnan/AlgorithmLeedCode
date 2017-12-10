package leedCode;

public class binarySearch2LeedCode {

    public static void main(String[] args) {
        binarySearch2LeedCode b = new binarySearch2LeedCode();
        int[] n = {0,0,1,3};
        int[] ints = b.twoSum(n, 0);
        System.out.println(ints[0]);
        System.out.println(ints[1]);


    }
    
    public int[] twoSum(int[] numbers, int target) {
        String s ="";
        int[] res = new int[2];
        for(int i = 0 ;i<numbers.length;i++){
            int j = binarySearch(numbers,i+1,numbers.length,target-numbers[i]);
            if(j!=-1){
                res[0]=i+1;
                res[1]=j+1;
                break;
            }
        }
        return res;
    }
    private int binarySearch(int[] numbers,int left,int right,int tempTarget){
        int mid;
        while(left<right){
            mid = left+(right-left)/2;
            if(numbers[mid]==tempTarget){
                return mid;
            }
            if(tempTarget<numbers[mid]){
                right = mid; // 注意边界， 左闭右开
            }
            if(tempTarget>numbers[mid]){
                left = mid+1;
            }
        }
        return -1;
    }
    
    
}