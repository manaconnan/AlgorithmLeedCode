public class BinarySearch<T extends Comparable<? super T>> {

    /**
     * 二分查找
     * @param arr 传入的数组必须为有序数组
     * @return
     */
    public int binarySearch(T[] arr, T target){
        int l = 0;
        int r = arr.length-1;
        
        while (l<=r){
            
            int mid = l+(r-l)/2; //避免使用l+r 导致int溢出
            if (target.compareTo(arr[mid]) ==0){
                return  mid;
            }
            if(target.compareTo(arr[mid])>0){
                l = mid+1;
            }
            if(target.compareTo(arr[mid])<0){
                r= mid-1;
            }
        }
        return -1;
        
    }

    /**
     *   Binary search with recursion
     * @param arr must be sorted array
     * @param target the target to search
     * @return
     */

    public int binarySearchRecursion(T[] arr, T target){

        int l = 0;
        int r = arr.length;


        return handlerSearch(arr,l,r,target);

    }

    private int handlerSearch(T[] arr,int left,int right,T target){

        int mid=(left+right)/2;

        if(arr[mid].compareTo(target)==0){
            return mid;
        }else if(arr[mid].compareTo(target)>0){
           return handlerSearch(arr,left,mid,target);
        }else if (arr[mid].compareTo(target)<0){
           return handlerSearch(arr,mid+1,right,target);
        }else {
            return -1;
        }

    }


    public static void main(String[] args) {
        Integer[] a = {1,2,4,5,8,10,14};
        BinarySearch<Integer> b= new BinarySearch<>();

        int i = b.binarySearch(a, 10);
        System.out.println("====> " + i);

        int i2 = b.binarySearchRecursion(a, 10);
        System.out.println(i2);

        String[] s = {"123","abc","df","马"};
        
        BinarySearch<String> stringBinarySearch = new BinarySearch<>();

        int i1 = stringBinarySearch.binarySearch(s, "df");
        System.out.println("====> " + i1);


    }

}
