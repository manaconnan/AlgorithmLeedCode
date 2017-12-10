import com.util.ArrayHelper;

public class Sort {


    public static void main(String[] args) throws Exception {


        Sort sort = new Sort();
        int[] array = ArrayHelper.getRandomArray(30, 0, 100);

        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();

        sort.insertSortNew(array,0,30);

        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"  ");
        }

//        System.out.println("====> " );
//        MergeSort.sort(array);
//        for (int i=0;i<array.length;i++){
//            System.out.print(array[i]+"  ");
//        }


//        System.out.println( );
//        System.out.println("=======select========"  );
//        int[] ints = sort.sort01(array);
//        for (int i =0;i<ints.length;i++){
//          System.out.print(ints[i]+"  ");
//        }
//
//        System.out.println( );
//        System.out.println("=======insert========"  );
//        int[] insertSort = sort.insertSortNew(array);
//        for (int i = 0 ; i<insertSort.length;i++){
//          //  System.out.print(" " + insertSort[i]);
//        }
//        System.out.println( );
//        System.out.println("=======Quick========"  );

//
        System.out.println( );
        long start = System.currentTimeMillis();
        sort.quickSort(array, 0, 29);

        for (int i = 0 ; i<array.length;i++){
            System.out.print(array[i]+"  " );
        }
        long end =System.currentTimeMillis();
        System.out.println( );
        System.out.println("时间"+(end-start));




    }
//    选择排序算法O(n^2)

    public  int[] sort01(int[] ints){
        long start = System.currentTimeMillis();

        for (int i = 0;i<ints.length;i++){

            int minIndex = i ;
            for(int j =i;j<ints.length;j++){
                if(ints[minIndex]>ints[j]){
                    int temp =ints[minIndex];
                    ints[minIndex]=ints[j];
                    ints[j]=temp;
                }
                ints[i]=ints[minIndex];
            }


        }
        long end = System.currentTimeMillis();
        System.out.println("====> time " +(end-start) );
        return ints;
    }



    //    插入排序法O(n^2) 但是比选择排序要快


    public  int[] insertSort(int[] ar){


        long start = System.currentTimeMillis();
        for(int i = 0; i<ar.length;i++){
            for(int j = i;j>0;j--){
                if(ar[j]<ar[j-1]){

                    int temp = ar[j-1];
                    ar[j-1] =ar[j];
                    ar[j] = temp;
                }
                else
                    break;

            }
        }

        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("====> time" + time);
        return ar;
    }

//     插入算法优化   最差的时间复杂读也是 O(n^2) 但是对于近乎有序的数组， 此方法更优


    public  int[] insertSortNew(int[] ar){


        long start = System.currentTimeMillis();
        for(int i = 0; i<ar.length;i++){

            int tem = ar[i];
            int j ;
            for(j = i;j>0&&ar[j-1]>tem;j--){
                ar[j] = ar[j-1];
            }
            ar[j] = tem;
        }

        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("====> time " + time);
        return ar;
    }

    public int[] insertSortNew(int[] ar,int left,int right){

        for(int i = left;i<right;i++){
            int tem = ar[i];
            int j;
            for(j = i;j>left&&ar[j-1]>tem;j--){
                ar[j]=ar[j-1];
            }
            ar[j] = tem;


        }
        return ar;
    }

//    shell排序。。。不会写

    public int[] shellSoort(int[] a){

        while (true){
            int b = a.length/2;
            for (int i = 0 ; i<b ;i++){


            }

        }
    }

//    快速排序法 详见： http://developer.51cto.com/art/201403/430986.htm
    public int[] quickSort(int[] array,int left, int right) throws Exception{
        if(left>right){
            return array;
        }
        int i,j,t,temp;
        i=left;
        j=right;
        temp = array[left];
        while (i!=j){
            while (array[j]>=temp&&j>i){
                j--;
            }
            while (array[i]<=temp&&i<j){
                i++;
            }
            if (i<j){
                t=array[i];
                array[i]=array[j];
                array[j]=t;
            }
        }
        array[left] = array[i];
        array[i]=temp;
        quickSort(array,left,i-1);
        quickSort(array,i+1,right);
        return  array;
    }






}
