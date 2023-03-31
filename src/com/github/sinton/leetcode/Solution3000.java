package com.github.sinton.leetcode;

/**
 * @author Yan
 */
public class Solution3000 {
    /**
     * 2574. Left and Right Sum Differences
     * 左右元素和的差值
     */
    public int[] leftRigthDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = 0;
        for(int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(left - right);
            left += nums[i];
            right -= (i + 1) < nums.length ? nums[i + 1] : 0;
        }
        return answer;
    }
}
