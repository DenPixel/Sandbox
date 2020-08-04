package com.pixel.sandbox.arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length+nums2.length];
        int length = nums.length;
        int length1 = nums1.length;
        int length2 = nums2.length;

        System.arraycopy(nums1, 0, nums, 0, length1);
        System.arraycopy(nums2, 0, nums, length1, length2);

        Arrays.parallelSort(nums);

        if (length%2 != 0){
            return nums[(length-1)/2];
        }else{
            return (nums[length/2] + nums[length/2-1]) / 2.0;
        }
    }

}
