import com.util.ArrayHelper;

public class QuickSort {


    public static void main(String[] args) {


        int[] array = ArrayHelper.getRandomArray(4,0,10);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();

        quickSortOneWay(array);
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }

    }

    public static void quickSortOneWay(int[] arr){

        quickSort(arr,0,arr.length);


    }

    private static void quickSort(int[] arr, int left,int right){
        if(left>=right){
            return;
        }
        int p = partition(arr,left,right);
        quickSort(arr,left,p);
        quickSort(arr,p+1,right);

    }

    private static int partition(int[] arr, int left, int right) {

        int k = arr[left];
        int j=left;
        int temp;

        for(int i = left+1;i<right;i++){   //[left~j]<k     [j+1,right]>k
            if(arr[i]<k){
                temp = arr[j+1];
                arr[j+1]=arr[i];
                arr[i]=temp;
                j++;
            }

        }
        arr[left] = arr[j];
        arr[j] = k;

        return j;
    }



}
