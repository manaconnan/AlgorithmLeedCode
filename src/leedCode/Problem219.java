package leedCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 * @Author mazexiang
 * @CreateDate 2017/12/3
 * @Version 1.0
 */
public class Problem219 {


    // 使用滑动窗口的思路解决问题 , 只要在所给定的滑动窗口中出现了两个相同的数字，那么就满足条件

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l =0; // 滑动窗口的左边界
        int r = l+k; // 滑动窗口的右边界
        int maxLen = nums.length-1;
        Set<Integer> set = new HashSet<>();
        for(int i = l;i<=((r<=maxLen)?r:maxLen);i++){ // 考虑一开始窗口就越界的情况
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }

        while (r<nums.length-1){
            // 先将初始的滑动窗口中最左侧的数字删除，指针右移一位
            set.remove(nums[l++]);
            r++;
            if (set.contains(nums[r])){
                return true;
            }else {
                // 滑动窗口的右侧右移， 整个滑动窗口向右侧移动一位 ，将数字放到set集合中
                set.add(nums[r]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem219 p  = new Problem219();
        int[] nums = {0};
        int k = 4;

        boolean b = p.containsNearbyDuplicate(nums, k);
        System.out.println(b);
    }

}
