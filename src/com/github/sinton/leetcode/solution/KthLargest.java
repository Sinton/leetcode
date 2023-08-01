package com.github.sinton.leetcode.solution;

import java.util.Arrays;

/**
 * 703. Kth Largest Element in a Stream
 * 数据流中的第 K 大元素
 */
public class KthLargest {
    private int k;

    private int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = Arrays.copyOf(nums, nums.length);
    }

    public int add(int val) {
        this.nums = Arrays.copyOf(this.nums, this.nums.length + 1);
        this.nums[this.nums.length - 1] = val;
        Arrays.sort(this.nums);
        return this.nums[this.nums.length - this.k];
    }
}
