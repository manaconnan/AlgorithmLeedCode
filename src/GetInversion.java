import com.util.ArrayHelper;

import java.util.Arrays;

public class GetInversion {


    public static void main(String[] args) {
        int[] arr = ArrayHelper.getRandomArray(100,0,100);

        System.out.println("====> " + Arrays.toString(arr));
        
        int n =getInversionCount(arr);
        System.out.println("====> " + n);
        
    }
    
    public static int getInversionCount(int[] array){
        int num=0;
        for(int i = 0 ; i<array.length;i++){
            for (int j = i+1 ; j<array.length;j++){
                if (array[i]>array[j]){
                    ++num;
                }
            }
        }
        return num;
    }
}
