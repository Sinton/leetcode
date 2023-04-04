package com.github.sinton.leetcode;

/**
 * @author Yan
 */
public class Solution3000 {
    /**
     * 2535. Difference Between Element Sum and Digit Sum of an Array
     * 数组元素和与数字和的绝对差
     * @param nums
     * @return
     */
    public int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int numSum = 0;
        for (int num : nums) {
            elementSum += num;
            while(num >= 10) {
                numSum += num % 10;
                num /= 10;
            }
            numSum += num % 10;
        }
        return Math.abs(elementSum - numSum);
    }

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
