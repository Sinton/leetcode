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
     * 2553. Separate the Digits in an Array
     * 分割数组中数字的数位
     * @param nums
     * @return
     */
    public int[] separateDigits(int[] nums) {
        int[] numLen = new int[nums.length];
        int totalLen = 0;
        for (int i = 0, len = nums.length; i< len; i++) {
            numLen[i] = (int) (Math.log10(nums[i]) + 1);
            totalLen += numLen[i];
        }
        int[] answer = new int[totalLen];
        int index = 0;
        int currLen;
        for (int i = 0, len = nums.length; i< len; i++) {
            currLen = numLen[i];
            while (currLen > 0) {
                answer[index + currLen - 1] = nums[i] % 10;
                nums[i] /= 10;
                currLen--;
            }
            index += numLen[i];
        }
        return answer;
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
     * 2586. Count the Number of Vowel Strings in Range
     * 统计范围内的元音字符串数
     * @param words
     * @param left
     * @param right
     * @return
     */
    public int vowelStrings(String[] words, int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (words[i].charAt(0) == 'a' ||
                words[i].charAt(0) == 'e' ||
                words[i].charAt(0) == 'i' ||
                words[i].charAt(0) == 'o' ||
                words[i].charAt(0) == 'u') {
                if (words[i].charAt(words[i].length() - 1) == 'a' ||
                    words[i].charAt(words[i].length() - 1) == 'e' ||
                    words[i].charAt(words[i].length() - 1) == 'i' ||
                    words[i].charAt(words[i].length() - 1) == 'o' ||
                    words[i].charAt(words[i].length() - 1) == 'u') {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 2643. Row With Maximum Ones
     * 一最多的行
     * @param mat
     * @return
     */
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] answer = new int[2];
        for (int i = 0, rowLen = mat.length; i < rowLen; i++) {
            int count = 0;
            for (int j = 0, colLen = mat[i].length; j < colLen; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > answer[1]) {
                answer[0] = i;
                answer[1] = count;
            }
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

    /**
     * 2656. Maximum Sum With Exactly K Elements
     * K 个元素的最大和
     * @param nums
     * @param k
     * @return
     */
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max * k + (k - 1) * k / 2;
    }
}
