package com.github.sinton.leetcode;

import java.util.*;

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
     * 2194. Cells in a Range on an Excel Sheet
     * Excel 表中某个范围内的单元格
     * @param s
     * @return
     */
    public List<String> cellsInRange(String s) {
        List<String> answer = new ArrayList<>();
        int startCol = s.charAt(0) - 'A';
        int startRow = s.charAt(1) - '0';
        int endCol   = s.charAt(3) - 'A';
        int endRow   = s.charAt(4) - '0';

        for (int colNum = startCol; colNum <= endCol; colNum++) {
            for (int rowNum = startRow; rowNum <= endRow; rowNum++) {
                answer.add(String.format("%c%d", (char)(colNum + 'A'), rowNum));
            }
        }

        return answer;
    }

    /**
     * 2236. Root Equals Sum of Children
     * 判断根结点是否等于子结点之和
     * @param root
     * @return
     */
    public boolean checkTree(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                return (root.val == root.left.val + root.right.val) && checkTree(root.left) && checkTree(root.right);
            } else {
                return root.left == null && root.right == null;
            }
        } else {
            return true;
        }
    }

    /**
     * 2325. Decode the Message
     * 密消息
     * @param key
     * @param message
     * @return
     */
    public String decodeMessage(String key, String message) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Character> dict = new HashMap<>(16);
        int index = 0;
        for (int i = 0, len = key.length(); i < len; i++) {
            if (!dict.containsKey(key.charAt(i)) && key.charAt(i) != ' ') {
                dict.put(key.charAt(i), (char) (index + 'a'));
                index++;
            }
        }
        for (int i = 0, len = message.length(); i < len; i++) {
            if ('a' <= message.charAt(i) && message.charAt(i) <= 'z') {
                answer.append(dict.get(message.charAt(i)));
            } else {
                answer.append(message.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     * 2367. Number of Arithmetic Triplets
     * 算术三元组的数目
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int num : nums) {
            if (list.contains(num + diff) && list.contains(num + diff + diff)) {
                answer++;
            }
        }
        return answer;
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
     * TODO
     * 2439. Minimize Maximum of Array
     * 最小化数组中的最大值
     * @param nums
     * @return.
     */
    public int minimizeArrayValue(int[] nums) {
        int average = 0;
        int maxSum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > nums[i + 1]) {
                average = nums[i];
            } else {
                average = (nums[i] + nums[i + 1]) / 2;
            }
        }
        return average;
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
