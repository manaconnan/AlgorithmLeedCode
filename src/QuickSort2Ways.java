import com.util.ArrayHelper;

public class QuickSort2Ways {
    public static void main(String[] args) {

        int[] array = ArrayHelper.getRandomArray(10,0,1000);
//        for (int i=0;i<array.length;i++){
//            System.out.print(array[i]+"  ");
//        }
        System.out.println();
        long start = System.currentTimeMillis();
        quickSort2Ways(array);
        long end = System.currentTimeMillis();
        System.out.println("====> " + (end-start));
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }

    }

    public static void quickSort2Ways(int[] array){

        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array,int left, int right){
        if(left>=right){
            return;
        }

        int p = partition(array,left,right);
        quickSort(array,left,p);
        quickSort(array,p+1,right);

    }
    private static int partition(int[] array,int left,int right){

        int i , j, k,temp;
        k = array[left];
        i =left;
        j =right;
        while (i<j){

            while (array[j]>=k&&j>i){
                j--;
            }
            while (array[i]<=k&&i<j){
                i++;
            }
        if(i<j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        }
        array[left]=array[i];
        array[i] = k;

        return i;
    }

}
