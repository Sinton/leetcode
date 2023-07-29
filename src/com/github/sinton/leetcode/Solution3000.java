package com.github.sinton.leetcode;

import java.util.*;

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
     * 2529. Maximum Count of Positive Integer and Negative Integer
     * 正整数和负整数的最大计数
     * @param nums
     * @return
     */
    public int maximumCount(int[] nums) {
        int posCount = 0;
        int negCount = 0;
        for (int num : nums) {
            if (num > 0) {
                posCount++;
            }
            if (num < 0) {
                negCount++;
            }
        }
        return Math.max(posCount, negCount);
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
     * 2570. Merge Two 2D Arrays by Summing Values
     * 合并两个二维数组 - 求和法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] counter = new int[1001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] item : nums1) {
            min = Math.min(min, item[0]);
            max = Math.max(max, item[0]);
            counter[item[0]] += item[1];
        }
        for (int[] item : nums2) {
            min = Math.min(min, item[0]);
            max = Math.max(max, item[0]);
            counter[item[0]] += item[1];
        }
        int capacity = 0;
        for (int i = min; i <= max; i++) {
            if (counter[i] != 0) {
                capacity++;
            }
        }
        int[][] answer = new int[capacity][2];
        for (int i = min; i <= max; i++) {
            if (counter[i] != 0) {
                answer[answer.length - capacity][0] = i;
                answer[answer.length - capacity][1] = counter[i];
                capacity--;
            }
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

    /**
     * 2670. Find the Distinct Difference Array
     * 找出不同元素数目差数组
     * @param nums
     * @return
     */
    public int[] distinctDifferenceArray(int[] nums) {
        Set<Integer> leftSet;
        Set<Integer> rightSet;
        int length = nums.length;
        int[] answer = new int[length];
        int index = 0;
        while (index < length) {
            leftSet = new HashSet<>();
            rightSet = new HashSet<>();
            for (int i = 0; i <= index; i++) {
                leftSet.add(nums[i]);
            }
            for (int i = index + 1; i < length; i++) {
                rightSet.add(nums[i]);
            }
            answer[index] = leftSet.size() - rightSet.size();
            index++;
        }
        return answer;
    }

    /**
     * 2710. Remove Trailing Zeros From a String
     * 移除字符串中的尾随零
     * @param num
     * @return
     */
    public String removeTrailingZeros(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') {
                return num.substring(0, i + 1);
            }
        }
        return num;
    }

    /**
     * 2716. Minimize String Length
     * 最小化字符串长度
     * @param s
     * @return
     */
    public int minimizedStringLength(String s) {
        int[] letter = new int[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            letter[s.charAt(i) - 'a']++;
        }
        int answer = 0;
        for (int count : letter) {
            if (count > 0) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 2769. Find the Maximum Achievable Number
     * 找出最大的可达成数字
     * @param num
     * @param t
     * @return
     */
    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }

    /**
     * 2678. Number of Senior Citizens
     * 老人的数目
     * @param details
     * @return
     */
    public int countSeniors(String[] details) {
        int answer = 0;
        int age;
        for (String detail : details) {
            age = Integer.parseInt(String.valueOf(detail.charAt(11)));
            age = age * 10 + Integer.parseInt(String.valueOf(detail.charAt(12)));
            if (age > 60) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 2778. Sum of Squares of Special Elements
     * 特殊元素平方和
     * @param nums
     * @return
     */
    public int sumOfSquares(int[] nums) {
        int answer = 0;
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (i != 0 && n % i == 0) {
                answer += nums[i - 1] * nums[i - 1];
            }
        }
        return answer;
    }

    /**
     * 2798. Number of Employees Who Met the Target
     * 满足目标工作时长的员工数目
     * @param hours
     * @param target
     * @return
     */
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int answer = 0;
        for (int hour : hours) {
            if (hour >= target) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 2810. Faulty Keyboard
     * 故障键盘
     * @param s
     * @return
     */
    public String finalString(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == 'i') {
                answer.reverse();
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     * 2824. Count Pairs Whose Sum is Less than Target
     * 统计和小于目标的下标对数目
     * @param nums
     * @param target
     * @return
     */
    public int countPairs(List<Integer> nums, int target) {
        int answer = 0;
        for (int i = 0, len = nums.size(); i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 2828. Check if a String Is an Acronym of Words
     * 判别首字母缩略词
     * @param words
     * @param s
     * @return
     */
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder answer = new StringBuilder();
        words.forEach(word -> answer.append(word.charAt(0)));
        return answer.toString().equals(s);
    }

    /**
     * 2843. Count Symmetric Integers
     * 统计对称整数的数目
     * @param low
     * @param high
     * @return
     */
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;
        for (int i = low; i <= high; i++) {
            if (i > 10) {
                int len = (int) Math.log10(i) + 1;
                if (len % 2 == 0) {
                    int left = i / (int) Math.pow(10, len / 2.0);
                    int right = i % (int) Math.pow(10, len / 2.0);
                    int leftSum = 0;
                    int rightSum = 0;
                    while (left != 0) {
                        leftSum += left % 10;
                        left /= 10;
                    }
                    while (right != 0) {
                        rightSum += right % 10;
                        right /= 10;
                    }
                    if (leftSum == rightSum) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 2848. Points That Intersect With Cars
     * 与车相交的点
     * @param nums
     * @return
     */
    public int numberOfPoints(List<List<Integer>> nums) {
        int answer = 0;
        int[] parking = new int[101];
        for (List<Integer> park : nums) {
            for (int index = park.get(0); index <= park.get(1); index++) {
                parking[index]++;
            }
        }
        for (int index : parking) {
            if (index > 0) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 2859. Sum of Values at Indices With K Set Bits
     * 计算 K 置位下标对应元素的和
     * @param nums
     * @param k
     * @return
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int answer = 0;
        for (int i = 0, len = nums.size(); i < len; i++) {
            int index = i;
            int count = 0;
            while (index != 0) {
                index = index & (index - 1);
                count++;
            }
            if (count == k) {
                answer += nums.get(i);
            }
        }
        return answer;
    }
}
