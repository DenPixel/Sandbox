package com.alevel.nix.java.hometask.lesson10;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length+nums2.length];

        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

        Arrays.parallelSort(nums);

        if (nums.length%2 != 0){
            return nums[(nums.length-1)/2];
        }else{
            return (double) (nums[nums.length/2] + nums[nums.length/2-1])/2;
        }
    }

}
