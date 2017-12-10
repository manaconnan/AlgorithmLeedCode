package leedCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem350 {
    public static void main(String[] args) {
        Problem350 p = new Problem350();
        int [] nums1={1,2,2,4};
        int [] nums2={2,2};
        int[] ints = p.intersect(nums1, nums2);
        for(int i = 0 ; i<ints.length;i++){
            System.out.println(ints[i]);
        }

    }
    
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> resList = new ArrayList<>();
        Map<Integer,Integer> temMap = new HashMap<>();
        
        for(int i = 0 ; i<nums1.length;i++){
            int tem=0;
            if(temMap.get(nums1[i])!=null&&temMap.get(nums1[i])>=0){
                tem=temMap.get(nums1[i]);
                tem++;
                temMap.put(nums1[i],tem);
            }else{
                temMap.put(nums1[i],1);
            }
        }
        for(int i = 0 ;i<nums2.length;i++){
            int tem = 0;
            if(temMap.get(nums2[i])!=null&&temMap.get(nums2[i])>0){
                resList.add(nums2[i]);
                tem = temMap.get(nums2[i]);
                tem--;
                temMap.put(nums2[i],tem);
            }
        }
        int[] res = new int[resList.size()];
        int k=0;
        for(Integer m: resList){
            res[k++]=m;
        }
        return res;
    }
}
