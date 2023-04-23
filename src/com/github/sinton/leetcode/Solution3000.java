package com.github.sinton.leetcode;

/**
 * @author Yan
 */
public class Solution3000 {
    /**
     * 2520. Count the Digits That Divide a Number
     * 统计能整除数字的位数
     * @param num
     * @return
     */
    public int countDigits(int num) {
        int count = 0;
        int digit = num;
        while (digit > 0) {
            if (num % (digit % 10) == 0) {
                count++;
            }
            digit /= 10;
        }
        return count;
    }

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

    /**
     * 2651. Calculate Delayed Arrival Time
     * 计算列车到站时间
     * @param arrivalTime
     * @param delayedTime
     * @return
     */
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    /**
     * 2652. Sum Multiples
     * 倍数求和
     * @param n
     * @return
     */
    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
