package leedCode;

import com.util.ArrayHelper;

/**
 * 利用快速排序的思路找到数组中第n大的数，时间复杂度O(n)
 */
public class FindRangN {
    private static int count=0;

    public static void main(String[] args) {
        int[] array = {-1,2,0,5,1};
        int n = findN(array, 1);
        System.out.println(n);
    }
    
    public static int findN(int[] array,int theN){
       
         find(array,0,array.length-1,theN);
        
        return array[array.length-theN];
        
    }
    private static void find(int[] array, int left, int right,int theN ){
        count++;
        int n = partition(array,left,right);
        if((array.length-theN)==n){
            return;
        }
        if(array.length-theN<n){
            find(array,left,n-1,theN);
        }
        if (array.length-theN>n){
            find(array,n+1,right,theN);
        }
        
    }
    private static int partition(int[] array,int left, int right){
        
        
        int k = array[left];
        int i = left ;
        int j = right;
        int temp;
        while (i<j){
            while (array[j]>=k&&j>i){
                j--;
            }
            while (array[i]<=k&&i<j){
                i++;
            }
            if(i<j){
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = k;
        return i;
    }
    
}
