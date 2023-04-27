package com.github.sinton.leetcode;

import java.util.*;

/**
 * @author Yan
 */
public class Solution2000 {
    /**
     * 1502. Can Make Arithmetic Progression From Sequence
     * 判断能否形成等差数列
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int a1 = arr[0];
        int d = arr[1] - arr[0];
        for(int i = 1, len = arr.length; i < len; i++) {
            if (arr[i] != a1 + i * d) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1512. Number of Good Pairs
     * 好数对的数目
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 1523. Count Odd Numbers in an Interval Range
     * 在区间范围内统计奇数数目
     * @param low
     * @param high
     * @return
     */
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }
        return (high - low) / 2 + 1;
    }

    /**
     * 1528. Shuffle String
     * 重新排列字符串
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] content = new char[indices.length];
        for (int i = 0, len = indices.length; i < len; i++) {
            content[indices[i]] = s.charAt(i);
        }
        return String.valueOf(content);
    }

    /**
     * 1534. Count Good Triplets
     * 统计好三元组
     * @param arr
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * 1572. Matrix Diagonal Sum
     * 矩阵对角线元素的和
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int index = 0;
        int duplicateValue = 0;
        int len = mat.length;
        for (int[] element : mat) {
            sum += element[index];
            sum += element[len - 1 - index];
            if (len - 1 - index == index) {
                duplicateValue = element[index];
            }
            index++;
        }
        return sum - duplicateValue;
    }

    /**
     * 1588. Sum of All Odd Length Subarrays
     * 所有奇数长度子数组的和
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int len = arr.length;
        int dynamicLen = 1;
        if (len == 0) {
            return sum;
        }
        while (dynamicLen <= len) {
            for (int i = 0; i <= len - dynamicLen; i++) {
                int[] subArr = new int[dynamicLen];
                System.arraycopy(arr, i, subArr, 0, dynamicLen);
                for (int item : subArr) {
                    sum += item;
                }
            }
            dynamicLen += 2;
        }
        return sum;
    }

    /**
     * 1614. Maximum Nesting Depth of the Parentheses
     * 括号的最大嵌套深度
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        int answer = 0;
        int combo = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') {
                combo++;
                answer = Math.max(answer, combo);
            }
            if (s.charAt(i) == ')') {
                combo--;
            }
        }
        return answer;
    }

    /**
     * 1662. Check If Two String Arrays are Equivalent
     * 检查两个字符串数组是否相等
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for (String word : word1) {
            left.append(word);
        }
        for (String word : word2) {
            right.append(word);
        }
        return left.toString().contentEquals(right);
    }

    /**
     * 1672. Richest Customer Wealth
     * 最富有客户的资产总量
     * @param accounts
     * @return
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int proSummary : account) {
                sum += proSummary;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 1678. Goal Parser Interpretation
     * 设计 Goal 解析器
     * @param command
     * @return
     */
    public String interpret(String command) {
        // 字符串替换
        // return command.replace("()", "o").replace("(al)", "al");
        // 栈方式实现
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        StringBuilder tmp;
        for(int i = 0, len = command.length(); i < len; i++) {
            if (command.charAt(i) == ')') {
                tmp = new StringBuilder();
                while(!stack.isEmpty() && !"(".equals(stack.peek())) {
                    tmp.insert(0, stack.pop());
                }
                tmp.insert(0, stack.pop());
                tmp.append(command.charAt(i));
                if ("()".equals(tmp.toString())) {
                    stack.push("o");
                }
                if ("(al)".equals(tmp.toString())) {
                    stack.push("al");
                }
            } else {
                stack.push(String.valueOf(command.charAt(i)));
            }
        }
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    /**
     * 1684. Count the Number of Consistent Strings
     * 统计一致字符串的数目
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for (String word : words) {
            int len = word.length();
            while(len > 0) {
                if (!allowed.contains(String.valueOf(word.charAt(len - 1)))) {
                    break;
                }
                len--;
            }
            if (len == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 1688. Count of Matches in Tournament
     * 比赛中的配对次数
     * @param n
     * @return
     */
    public int numberOfMatches(int n) {
        int sum = 0;
        while (n >= 2) {
            if (n % 2 == 1) {
                n = (n - 1) / 2 + 1;
                sum += n - 1;
            }
            else {
                n = n / 2;
                sum += n;
            }
        }
        return sum;
    }

    /**
     * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
     * 十-二进制数的最少数目
     * @param n
     * @return
     */
    public int minPartitions(String n) {
        int max = n.charAt(0) - '0';
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(n.charAt(i) - '0', max);
        }
        return max;
    }

    /**
     * 1720. Decode XORed Array
     * 解码异或后的数组
     * @param encoded
     * @param first
     * @return
     */
    public int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length + 1];
        answer[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            answer[i + 1] = answer[i] ^ encoded[i];
        }
        return answer;
    }

    /**
     * 1725. Number Of Rectangles That Can Form The Largest Square
     * 可以形成最大正方形的矩形数目
     * @param rectangles
     * @return
     */
    public int countGoodRectangles(int[][] rectangles) {
        int[] edge = new int[rectangles.length];
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 0, len = rectangles.length; i < len; i++) {
            edge[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            if (edge[i] == max) {
                answer++;
            } else if (edge[i] > max) {
                max = edge[i];
                answer = 1;
            }
        }
        return answer;
    }

    /**
     * 1732. Find the Highest Altitude
     * 找到最高海拔
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int[] myGain = new int[gain.length];
        myGain[0] = gain[0];
        int answer = Math.max(0, myGain[0]);
        for (int i = 1, len = gain.length; i < len; i++) {
            myGain[i] = myGain[i - 1] + gain[i];
            answer = Math.max(myGain[i], answer);
        }
        return answer;
    }

    /**
     * 1768. Merge Strings Alternately
     * 交替合并字符串
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        int length = Math.max(word1.length(), word2.length());
        for(int i = 0; i < length; i++) {
            if(i < word1.length()) {
                answer.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                answer.append(word2.charAt(i));
            }
        }
        return answer.toString();
    }

    /**
     * 1773. Count Items Matching a Rule
     * 统计匹配检索规则的物品数量
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (item.get(1).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (item.get(2).equals(ruleValue)) {
                        count++;
                    }
                    break;
                default:
                    break;
            }
        }
        return count;
    }

    /**
     * 1779. Find Nearest Point That Has the Same X or Y Coordinate
     * 找到最近的有相同 X 或 Y 坐标的点
     * @param x
     * @param y
     * @param points
     * @return
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int nearestDistance = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0, len = points.length; i < len; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]) < nearestDistance) {
                    nearestDistance = Math.min(nearestDistance, Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]));
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * 1790. Check if One String Swap Can Make Strings Equal
     * 仅执行一次字符串交换能否使两个字符串相等
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        } else {
            if (s1.length() == s2.length()) {
                Character s1Left  = null;
                Character s1Right = null;
                Character s2Left  = null;
                Character s2Right = null;
                for(int i = 0, len = s1.length(); i < len; i++) {
                    if(s1.charAt(i) != s2.charAt(i)) {
                        if (s1Left == null && s2Left == null) {
                            s1Left = s1.charAt(i);
                            s2Left = s2.charAt(i);
                        } else {
                            if (s1Right == null && s2Right == null) {
                                s1Right = s1.charAt(i);
                                s2Right = s2.charAt(i);
                            } else {
                                return false;
                            }
                        }
                    }
                }
                if (s1Left.equals(s2Right) && s2Left.equals(s1Right)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 1791. Find Center of Star Graph
     * 找出星型图的中心节点
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];
        int answer = u;
        for (int[] edge : edges) {
            if (edge[0] == u || edge[1] == u) {
                answer =  u;
            } else if (edge[0] == v || edge[1] == v) {
                answer = v;
            }
        }
        return answer;
    }

    /**
     * 1812. Determine Color of a Chessboard Square
     * 判断国际象棋棋盘中一个格子的颜色
     * @param coordinates
     * @return
     */
    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0) - 'a';
        int row = coordinates.charAt(1) - '0';
        if (col % 2 == 1) {
            return row % 2 == 1;
        } else {
            return row % 2 == 0;
        }
    }

    /**
     * 1816. Truncate Sentence
     * 截断句子
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        StringBuilder answer = new StringBuilder();
        int count = 1;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (count++ == k) {
                    break;
                }
            }
            answer.append(s.charAt(i));
        }
        return answer.toString();
    }

    /**
     * 1822. Sign of the Product of an Array
     * 数组元素积的符号
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                negativeCount++;
            }
        }
        if (negativeCount == 0) {
            return 1;
        } else {
            return (negativeCount + 2) % 2 == 0 ? 1 : -1;
        }
    }

    /**
     * 1827. Minimum Operations to Make the Array Increasing
     * 最少操作使数组递增
     * @param nums
     * @return
     */
    public int minOperations(int[] nums) {
        int answer = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] <= nums[i - 1] + 1) {
                answer += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return answer;
    }

    /**
     * 1832. Check if the Sentence Is Pangram
     * 判断句子是否为全字母句
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (sentence.contains(String.valueOf((char)('a' + i)))) {
                count++;
            }
        }
        return count == 26;
    }

    /**
     * 1844. Replace All Digits with Characters
     * 将所有数字用字符替换
     * @param s
     * @return
     */
    public String replaceDigits(String s) {
        StringBuilder answer = new StringBuilder();
        int offset;
        for (int i = 0, len = s.length(); i < len; i = i + 2) {
            answer.append(s.charAt(i));
            if (i + 1 < len) {
                offset = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                answer.append((char) (s.charAt(i) + offset));
            }
        }
        return answer.toString();
    }

    /**
     * 1859. Sorting the Sentence
     * 将句子排序
     * @param s
     * @return
     */
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] answerWords = new String[words.length];
        int index;
        for (String word : words) {
            index = word.charAt(word.length() - 1) - '0';
            answerWords[index - 1] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", answerWords);
    }

    /**
     * 1913. Maximum Product Difference Between Two Pairs
     * 两个数对之间的最大乘积差
     * @param nums
     * @return
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    /**
     * 1920. Build Array from Permutation
     * 基于排列构建数组
     * @param nums
     * @return
     */
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    /**
     * 1929. Concatenation of Array
     * 数组串联
     * @param nums
     * @return
     */
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length * 2];
        for(int i = 0, length = nums.length; i < length; i++) {
            result[i] = nums[i];
            result[i + length] = nums[i];
        }
        return result;
    }

    /**
     * 2000. Reverse Prefix of Word
     * 反转单词前缀
     * @param word
     * @param ch
     * @return
     */
    public String reversePrefix(String word, char ch) {
        StringBuilder answer = new StringBuilder();
        int index = word.indexOf(ch);
        if (index <= 0) {
            return word;
        } else {
            for (int i = index; i >= 0; i--) {
                answer.append(word.charAt(i));
            }
            for (int i = index + 1, len = word.length(); i < len; i++) {
                answer.append(word.charAt(i));
            }
            return answer.toString();
        }
    }
}
