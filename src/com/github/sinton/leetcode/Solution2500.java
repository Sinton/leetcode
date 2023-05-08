package com.github.sinton.leetcode;

import java.util.*;

/**
 * @author Yan
 */
public class Solution2500 {
    /**
     * 2006. Count Number of Pairs With Absolute Difference K
     * 差的绝对值为 K 的数对数目
     * @param nums
     * @param k
     * @return
     */
    public int countKDifference(int[] nums, int k) {
        // TODO 可以用哈希表计数方式统计
        int answer = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    answer++;
                }
            }
        }
        return answer;
    }

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
     * 2037. Minimum Number of Moves to Seat Everyone
     * 使每位学生都有座位的最少移动次数
     * @param seats
     * @param students
     * @return
     */
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int answer = 0;
        int seatsIndex = seats.length - 1;
        int studentsIndex = students.length - 1;
        while (seatsIndex >= 0 || studentsIndex >= 0) {
            answer += Math.abs(seats[seatsIndex--] - students[studentsIndex--]);
        }
        return answer;
    }

    /**
     * 2089. Find Target Indices After Sorting Array
     * 找出数组排序后的目标下标
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == target) {
                answer.add(i);
            }
        }
        return answer;
    }

    /**
     * 2103. Rings and Rods
     * 环和杆
     * @param rings
     * @return
     */
    public int countPoints(String rings) {
        int answer = 0;
        Character color;
        StringBuilder[] polesColor = new StringBuilder[10];
        int pole;
        for (int i = 0, len = rings.length(); i < len; i = i + 2) {
            color = rings.charAt(i);
            pole = rings.charAt(i + 1) - '0';
            if (polesColor[pole] == null) {
                polesColor[pole] = new StringBuilder();
            }
            if (polesColor[pole].indexOf("#") < 0) {
                polesColor[pole].append(color);
                if (polesColor[pole].indexOf("R") >= 0 &&
                    polesColor[pole].indexOf("G") >= 0 &&
                    polesColor[pole].indexOf("B") >= 0) {
                    answer++;
                    polesColor[pole].append('#');
                }
            }
        }
        return answer;
    }

    /**
     * 2108. Find First Palindromic String in the Array
     * 找出数组中的第一个回文字符串
     * @param words
     * @return
     */
    public String firstPalindrome(String[] words) {
        StringBuilder palindrome = new StringBuilder();
        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                palindrome.append(word.charAt(i));
            }
            if (word.contentEquals(palindrome)) {
                return word;
            } else {
                palindrome = new StringBuilder();
            }
        }
        return "";
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
     * 2119. A Number After a Double Reversal
     * 反转两次的数字
     * @param num
     * @return
     */
    public boolean isSameAfterReversals(int num) {
        int reversed1 = 0;
        int tmp = num;
        while(tmp > 0) {
            reversed1 = reversed1 * 10 + tmp % 10 ;
            tmp /= 10;
        }
        int reversed2 = 0;
        tmp = reversed1;
        while(tmp > 0) {
            reversed2 = reversed2 * 10 + tmp % 10;
            tmp /= 10;
        }
        return reversed2 == num;
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
     * 2176. Count Equal and Divisible Pairs in an Array
     * 统计数组中相等且可以被整除的数对
     * @param nums
     * @param k
     * @return
     */
    public int countPairs(int[] nums, int k) {
        // 打表剪枝
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int answer = 0;
        int[][] counter = new int[max + 1][nums.length + 1];
        int[] record;
        for (int i = 0, len = nums.length; i < len; i++) {
            record = counter[nums[i]];
            record[++record[0]] = i;
        }
        for (int i = 1, len = counter.length; i <= len - 1; i++) {
            if (counter[i][0] > 1) {
                for (int start = 1; start < counter[i][0]; start++) {
                    for (int end = start + 1; end <= counter[i][0]; end++) {
                        if (counter[i][start] * counter[i][end] % k == 0) {
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
        // 纯冒泡-效率稍差
        /*
        int answer = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    answer++;
                }
            }
        }
        return answer;
        */
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
     * 2185. Counting Words With a Given Prefix
     * 统计包含给定前缀的字符串
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int answer = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                answer++;
            }
        }
        return answer;
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
     * 2215. Find the Difference of Two Arrays
     * 找出两数组的不同
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        for (int num : nums1) {
            leftNums.add(num);
        }
        for (int num : nums2) {
            rightNums.add(num);
        }
        for (int num : nums1) {
            if (!rightNums.contains(num) && !left.contains(num)) {
                left.add(num);
            }
        }
        for (int num : nums2) {
            if (!leftNums.contains(num) && !right.contains(num)) {
                right.add(num);
            }
        }
        answer.add(left);
        answer.add(right);
        return answer;
    }

    /**
     * 2220. Minimum Bit Flips to Convert Number
     * 转换数字的最少位翻转次数
     * @param start
     * @param goal
     * @return
     */
    public int minBitFlips(int start, int goal) {
        // TODO 用异或运算效率更高
        StringBuilder begin = new StringBuilder(Integer.toBinaryString(start));
        StringBuilder end = new StringBuilder(Integer.toBinaryString(goal));
        int maxLength = Math.max(begin.length(), end.length());
        int distance = begin.length() - end.length();
        if (distance > 0) {
            for(int i = 0; i < distance; i++) {
                end.insert(0, "0");
            }
        }
        if (distance < 0) {
            for(int i = 0; i < -distance; i++) {
                begin.insert(0, "0");
            }
        }
        int count = 0;
        while(maxLength > 0) {
            if (begin.charAt(maxLength - 1) != end.charAt(maxLength - 1)) {
                count++;
            }
            maxLength--;
        }
        return count;
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
     * 2315. Count Asterisks
     * 统计星号
     * @param s
     * @return
     */
    public int countAsterisks(String s) {
        String[] words = s.split("\\|");
        int count = 0;
        for (int i = 0, len = words.length; i < len; i = i + 2) {
            for(int j = 0, wordLen = words[i].length(); j < wordLen; j++) {
                if (words[i].charAt(j) == '*') {
                    count++;
                }
            }
        }
        return count;
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
     * 2341. Maximum Number of Pairs in Array
     * 数组能形成多少数对
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] answer = new int[2];
        int[] counter = new int[101];
        for (int num : nums) {
            counter[num]++;
            if (counter[num] >= 2) {
                counter[num] -= 2;
                answer[0]++;
            }
        }
        for (int count : counter) {
            if (count > 0) {
                answer[1]++;
            }
        }
        return answer;
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
     * 2373. Largest Local Values in a Matrix
     * 矩阵中的局部最大值
     * @param grid
     * @return
     */
    public int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length - 2][grid.length - 2];
        int maxValue;
        for (int row = 1, rowLen = grid.length - 1; row < rowLen; row++) {
            for (int col = 1, colLen = grid.length - 1; col < colLen; col++) {
                maxValue = Integer.MIN_VALUE;
                maxValue = Math.max(maxValue, grid[row][col]);
                maxValue = Math.max(maxValue, grid[row - 1][col]);
                maxValue = Math.max(maxValue, grid[row + 1][col]);
                maxValue = Math.max(maxValue, grid[row][col - 1]);
                maxValue = Math.max(maxValue, grid[row][col + 1]);
                maxValue = Math.max(maxValue, grid[row - 1][col - 1]);
                maxValue = Math.max(maxValue, grid[row - 1][col + 1]);
                maxValue = Math.max(maxValue, grid[row + 1][col - 1]);
                maxValue = Math.max(maxValue, grid[row + 1][col + 1]);
                answer[row - 1][col - 1] = maxValue;
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
     * 2418. Sort the People
     * 按身高排序
     * @param names
     * @param heights
     * @return
     */
    public String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0, len = heights.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (heights[i] < heights[j]) {
                    heights[i] ^= heights[j];
                    heights[j] ^= heights[i];
                    heights[i] ^= heights[j];
                    String tmp = names[i];
                    names[i]= names[j];
                    names[j] = tmp;
                }
            }
        }
        return names;
    }

    /**
     * 2427. Number of Common Factors
     * 公因子的数目
     * @param a
     * @param b
     * @return
     */
    public int commonFactors(int a, int b) {
        int answer = 0;
        for (int i = 1, len = Math.min(a, b); i <= len; i++) {
            if (a % i == 0 && b % i == 0) {
                answer++;
            }
        }
        return answer;
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

    /**
     * 2485. Find the Pivot Integer
     * 找出中枢整数
     * @param n
     * @return
     */
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return -1;
        }
        int total = (n + 1) * n / 2;
        for (int i = n; i > 0; i--) {
            if (total == (n + i) * (n - i + 1) / 2) {
                return i;
            }
            total = total - i;
        }
        return -1;
    }

    /**
     * 2500. Delete Greatest Value in Each Row
     * 删除每行中的最大值
     * @param grid
     * @return
     */
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                Arrays.sort(grid[i]);
                max = Math.max(max, grid[i][n - 1]);
                grid[i][n - 1] = 0;
            }
            answer += max;
            max = Integer.MIN_VALUE;
        }
        return answer;
    }
}
