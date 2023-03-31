package com.github.sinton.leetcode;

import java.util.Arrays;

/**
 * @author Yan
 */
public class Solution2500 {

    /**
     * 2011. Final Value of Variable After Performing Operations
     * 执行操作后的变量值
     * @param operations
     * @return
     */
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for (String operation : operations) {
            switch (operation) {
                case "++X":
                case "X++":
                    result = result + 1;
                    break;
                case "--X":
                case "X--":
                    result = result - 1;
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    /**
     * 2114. Maximum Number of Words Found in Sentences
     * 句子中的最多单词数
     * @param sentences
     * @return
     */
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String sentence : sentences) {
            /*
            解法一
            int count = sentence.split(" ").length;
            if (count> max) {
                max = count;
            }
            */
            int count = 0;
            for (char word : sentence.toCharArray()) {
                if (word == ' ') {
                    count++;
                }
            }
            if (count + 1 > max) {
                max = count + 1;
            }
        }
        return max;
    }

    /**
     * 2160. Minimum Sum of Four Digit Number After Splitting Digits
     * 拆分数位后四位数字的最小和
     * @param num
     * @return
     */
    public int minimumSum(int num) {
        int sum = 0;
        int numLength = (int) Math.floor(Math.log10(num) + 1);
        int[] nums = new int[numLength];
        while (numLength > 0) {
            nums[numLength - 1] = num % 10;
            num /= 10;
            numLength--;
        }
        Arrays.sort(nums);
        sum = sum + nums[0] * 10 + nums[2];
        sum = sum + nums[1] * 10 + nums[3];
        return sum;
    }

    /**
     * 2181. Merge Nodes in Between Zeros
     * 合并零之间的节点
     * @param head
     * @return
     */
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = null;
        ListNode result = null;
        int sum = 0;
        while (head != null) {
            if (head.val == 0) {
                if (sum > 0) {
                    if (result != null) {
                        curr.next = new ListNode(sum);
                        curr = curr.next;
                    } else {
                        result =  new ListNode(sum);
                        curr = result;
                    }
                }
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return result;
    }

    /**
     * 2396. Strictly Palindromic Number
     * 严格回文的数字
     * @param n
     * @return
     */
    public boolean isStrictlyPalindromic(int n) {
        StringBuilder result = new StringBuilder();
        int current;
        for (int i = 2; i <= n - 2; i++) {
            current = n;
            while (current != 0) {
                result.append(current % i);
                current = current / i;
            }
            if (!result.toString().equals(result.reverse().toString())) {
                return false;
            } else {
                System.out.println(result);
                result = new StringBuilder();
            }
        }
        return true;
    }

    /**
     * 2413. Smallest Even Multiple
     * 最小偶倍数
     * @param n
     * @return
     */
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }

    /**
     * 2469. Convert the Temperature
     * 温度转换
     * @param celsius
     * @return
     */
    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = celsius * 1.80 + 32.00;
        return result;
    }
}
