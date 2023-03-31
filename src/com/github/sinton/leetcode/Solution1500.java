package com.github.sinton.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Yan
 */
public class Solution1500 {
    /**
     * 1046. Last Stone Weight
     * 最后一块石头的重量
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int y = stones[len - 1];
        int x = stones[len - 2];
        int[] subStones = new int[0];
        if (x == y) {
            subStones = new int[len - 2];
            if (subStones.length > 0) {
                System.arraycopy(stones, 0, subStones, 0, len - 2);
            }
        }
        if (x < y) {
            subStones = new int[len - 1];
            stones[len - 2] = y - x;
            System.arraycopy(stones, 0, subStones, 0, len - 1);
        }
        return lastStoneWeight(subStones);
    }

    /**
     * 1108. Defanging an IP Address
     * IP 地址无效化
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        // return address.replace(".", "[.]");
        String interval = "[.]";
        StringBuilder result = new StringBuilder();
        for (int i = 0, len = address.length(); i < len; i++) {
            if (address.charAt(i) == '.') {
                result.append(interval);
            } else {
                result.append(address.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * 1232. Check If It Is a Straight Line
     * 缀点成线
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        boolean offset = true;
        int xCount = 0;
        int yCount = 0;
        for (int[] coordinate : coordinates) {
            if (coordinate[0] == 0 && coordinate[1] == 0) {
                offset = false;
                xCount++;
                yCount++;
            } else {
                if (coordinate[0] == 0) {
                    xCount++;
                }
                if (coordinate[1] == 0) {
                    yCount++;
                }
            }
        }
        if (!offset && xCount > 0) {
            return xCount == coordinates.length;
        }
        if (!offset && yCount > 0) {
            return yCount == coordinates.length;
        }
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        int xn;
        int yn;
        for(int i = 2, pair = coordinates.length; i < pair; i++) {
            xn = coordinates[i][0];
            yn = coordinates[i][1];
            if (offset) {
                if (1.0 * (y2 - y1) / (x2 - x1) != 1.0 * (yn - y1) / (xn - x1)) {
                    return false;
                }
            } else {
                if (1.0 * y2 / x2 != 1.0 * yn/ xn) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 1281. Subtract the Product and Sum of Digits of an Integer
     * 整数的各位积和之差
     * @param n
     * @return
     */
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int multiply = 1;
        while (n > 0) {
            sum = sum + n % 10;
            multiply = multiply * (n % 10);
            n /= 10;
        }
        return multiply - sum;
    }

    /**
     * 1290. Convert Binary Number in a Linked List to Integer
     * 二进制链表转整数
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

    /**
     * 1309. Decrypt String from Alphabet to Integer Mapping
     * 解码字母到整数映射
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
        if ("#".equals(s)) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '#') {
                char transChar = (char) ((stack.pop() - '0' + 10 * (stack.pop() - '0'))  - 1 + 'a');
                stack.push(transChar);
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()) {
            if ('1' <= stack.peek() && stack.peek() <= '9') {
                answer.insert(0, (char)(stack.pop() - '1' + 'a'));
            } else {
                answer.insert(0, stack.pop());
            }
        }
        return answer.toString();
    }

    /**
     * 1339. Maximum Product of Splitted Binary Tree
     * 分裂二叉树的最大乘积
     * @param root
     * @return
     */
    public int maxProduct(TreeNode root) {
        int result = Integer.MIN_VALUE;
        int sum = getTreeNodeSum(root);
        int leftSum;
        int rightSum;
        int multiply;
        if (root.left != null) {
            leftSum = getTreeNodeSum(root.left);
            multiply = (int) (((leftSum % (Math.pow(10, 9) + 7)) *
                    (sum - leftSum) % (Math.pow(10, 9) + 7)) %
                    (Math.pow(10, 9) + 7));
            result = Math.max(result, multiply);
        }
        if (root.right != null) {
            rightSum = getTreeNodeSum(root.right);
            multiply = (int) (((rightSum % (Math.pow(10, 9) + 7)) *
                    (sum - rightSum) % (Math.pow(10, 9) + 7)) %
                    (Math.pow(10, 9) + 7));
            result = Math.max(result, multiply);
        }
        return result;
    }

    /**
     * 1339. Maximum Product of Splitted Binary Tree
     * 分裂二叉树的最大乘积
     * @param root
     * @return
     */
    public int getTreeNodeSum(TreeNode root) {
        int sum = root.val;
        if (root.left != null) {
            sum += getTreeNodeSum(root.left);
        }
        if (root.right != null) {
            sum += getTreeNodeSum(root.right);
        }
        return sum;
    }

    /**
     * 1356. Sort Integers by The Number of 1 Bits
     * 根据数字二进制下 1 的数目排序
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        int[] bits = new int[len];
        for(int i = 0; i < len; i++) {
            bits[i] = bitCount(arr[i]);
        }
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if (bits[i] > bits[j]) {
                    bits[i] ^= bits[j];
                    bits[j] ^= bits[i];
                    bits[i] ^= bits[j];
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                } else if (bits[i] == bits[j] && arr[i] > arr[j]) {
                    bits[i] ^= bits[j];
                    bits[j] ^= bits[i];
                    bits[i] ^= bits[j];
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                }
            }
        }
        return arr;
    }

    /**
     * 1356. Sort Integers by The Number of 1 Bits
     * 计算二进制1个个数
     * @param num
     * @return
     */
    public int bitCount(int num) {
        int count = 0;
        while(num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    /**
     * 1365. How Many Numbers Are Smaller Than the Current Number
     * 有多少小于当前数字的数字
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[100];
        int[] answer = new int[nums.length];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                answer[i] += bucket[j];
            }
        }
        return answer;
    }

    /**
     * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
     * 找出克隆二叉树中的相同节点
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned.val == target.val) {
            return cloned;
        }
        // TODO
        if (cloned.left != null) {
        }
        if (cloned.right != null) {

        }
        return null;
    }

    /**
     * 1389. Create Target Array in the Given Order
     * 按既定顺序创建目标数组
     * @param nums
     * @param index
     * @return
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        // 数组位移操作
        int[] answer = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            for (int j = nums.length - 1; j >= index[i]; j--) {
                if (j + 1 < nums.length) {
                    answer[j + 1] = answer[j];
                }
            }
            answer[index[i]] = nums[i];
        }
        return answer;
    }

    /**
     * 1431. Kids With the Greatest Number of Candies
     * 有最多糖果的孩子
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> answer = new ArrayList<>();
        int max = candies[0];
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        for (int candy : candies) {
            answer.add(candy + extraCandies >= max);
        }
        return answer;
    }

    /**
     * 1470. Shuffle the Array
     * 重新排列数组
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }

    /**
     * 1480. Running Sum of 1d Array
     * 一维数组的动态和
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    /**
     * 1491. Average Salary Excluding the Minimum and Maximum Salary
     * 去掉最低工资和最高工资后的工资平均值
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        int sum = 0;
        Arrays.sort(salary);
        for (int i = 1, len = salary.length; i < len - 1; i++) {
            sum += salary[i];
        }
        return 1.0 * sum / (salary.length - 2);
    }
}