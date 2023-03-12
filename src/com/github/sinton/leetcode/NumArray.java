package com.github.sinton.leetcode;

/**
 * 303. Range Sum Query - Immutable
 * 区域和检索 - 数组不可变
 */
public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
