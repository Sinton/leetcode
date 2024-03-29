package com.github.sinton.leetcode.solution;

import com.github.sinton.leetcode.inner.*;

import java.util.*;

/**
 * @author Yan
 */
public class Solution1500 {
    /**
     * 1021. Remove Outermost Parentheses
     * 删除最外层的括号
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder answer = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            builder.append(s.charAt(i));
            if (s.charAt(i) == '(') {
                level++;
            }
            if (s.charAt(i) == ')') {
                level--;
                if (level == 0) {
                    answer.append(builder.substring(1, builder.length() - 1));
                    builder = new StringBuilder();
                }
            }
        }
        return answer.toString();
    }

    /**
     * 1022. Sum of Root To Leaf Binary Numbers
     * 从根到叶的二进制数之和
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        int answer = 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left != null) {
            root.left.val += root.val << 1;
            answer += sumRootToLeaf(root.left);
        }
        if (root.right != null) {
            root.right.val += root.val << 1;
            answer += sumRootToLeaf(root.right);
        }
        return answer;
    }

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
     * 1051. Height Checker
     * 高度检查器
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int answer = 0;
        int[] result = heights.clone();
        Arrays.sort(result);
        for (int i = 0, len = heights.length; i < len; i++) {
            if (heights[i] != result[i]) {
                answer++;
            }
        }
        return answer;
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
     * 1207. Unique Number of Occurrences
     * 独一无二的出现次数
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        int[] record = new int[2002];
        for (int num : arr) {
            record[1000 + num]++;
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0, len = record.length; i < len; i++) {
            if (record[i] != 0) {
                if (map.containsKey(record[i])) {
                    return false;
                } else {
                    map.put(record[i], i);
                }
            }
        }
        return true;
    }

    /**
     * 1217. Minimum Cost to Move Chips to The Same Position
     * 玩筹码
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int index : position) {
            if ((index + 1) % 2 == 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }

    /**
     * 1221. Split a String in Balanced Strings
     * 分割平衡字符串
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!stack.empty() && stack.peek() == 'R' && s.charAt(i) == 'L') {
                stack.pop();
                if (stack.empty()) {
                    answer++;
                }
            }
            else if (!stack.empty() && stack.peek() == 'L' && s.charAt(i) == 'R') {
                stack.pop();
                if (stack.empty()) {
                    answer++;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return answer;
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
     * 1252. Cells with Odd Values in a Matrix
     * 奇数值单元格的数目
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] index : indices) {
            for (int i = 0; i < n; i++) {
                matrix[index[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][index[1]]++;
            }
        }
        int answer = 0;
        for (int[] row : matrix) {
            for (int rowCol : row) {
                if (rowCol % 2 == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 1266. Minimum Time Visiting All Points
     * 访问所有点的最小时间
     * @param points
     * @return
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        // TODO
        return 0;
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
     * 1295. Find Numbers with Even Number of Digits
     * 统计位数为偶数的数字
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int answer = 0;
        int len;
        for (int num : nums) {
            if (num >= 10) {
                len = (int) (Math.log10(num) + 1);
                if (len % 2 == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    /**
     * 1299. Replace Elements with Greatest Element on Right Side
     * 将每个元素替换为右侧最大元素
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        int max;
        for (int i = 0, len = arr.length; i < len; i++) {
            max = Integer.MIN_VALUE;
            if (i == len - 1) {
                max = -1;
            }
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            answer[i] = max;
        }
        return answer;
    }

    /**
     * 1302. Deepest Leaves Sum
     * 层数最深叶子节点的和
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            TreeNode currNode;
            for (int i = 0, length = queue.size(); i < length; i++) {
                currNode = queue.poll();
                if (currNode != null) {
                    sum += currNode.val;
                    if (currNode.left != null) {
                        queue.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        queue.add(currNode.right);
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 1304. Find N Unique Integers Sum up to Zero
     * 和为零的 N 个不同整数
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        int[] answer = new int[n];
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                answer[i] = -1 * (n - 1) / 2  + i;
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                answer[i] = -1 * n / 2  + i;
                answer[n - i - 1] = n / 2  - i;
            }
        }
        return answer;
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
     * 1313. Decompress Run-Length Encoded List
     * 解压缩编码列表
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                result.add(nums[i + 1]);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0, len = result.size(); i < len; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    /**
     * 1323. Maximum 69 Number
     * 6 和 9 组成的最大数字
     * @param num
     * @return
     */
    public int maximum69Number (int num) {
        int max = num;
        int base = 1;
        int prev = 0;
        int modDigit;
        for (int i = 0, len = (int) Math.round(Math.log10(num)); i < len; i++) {
            modDigit = num % (base * 10);
            if ((modDigit - prev) / base == 6) {
                max = Math.max(max, num - modDigit + 9 * base + prev);
            }
            prev = modDigit;
            base *= 10;
        }
        return max;
    }

    /**
     * 1332. Remove Palindromic Subsequences
     * 删除回文子序列
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {
        boolean isPalindrome = true;
        for (int i = 0, len = s.length(); i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome ? 1 : 2;
    }

    /**
     * 1337. The K Weakest Rows in a Matrix
     * 矩阵中战斗力最弱的 K 行
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] battleValues = new int[mat.length];
        int sum;
        for (int i = 0, len = mat.length; i < len; i++) {
            sum = 0;
            for (int value : mat[i]) {
                sum += value;
            }
            battleValues[i] = sum;
        }
        int[] answer = new int[k];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0, len = battleValues.length; j < len; j++) {
                if (battleValues[j] < min) {
                    minIndex = j;
                    min = battleValues[j];
                }
            }
            answer[i] = minIndex;
            battleValues[minIndex] = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
        }
        return answer;
    }

    /**
     * TODO
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
     * 1342. Number of Steps to Reduce a Number to Zero
     * 将数字变成 0 的操作次数
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        if (num == 0) {
            return num;
        }
        if (num == 1) {
            return num;
        }
        int step = 0;
        if (num % 2 == 0) {
            step++;
            return step + numberOfSteps(num / 2);
        }
        if (num % 2 == 1) {
            step++;
            return step + numberOfSteps(num - 1);
        }
        return num;
    }

    /**
     * 1351. Count Negative Numbers in a Sorted Matrix
     * 统计有序矩阵中的负数
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int[] gridItem : grid) {
            if (gridItem[0] < 0) {
                answer += gridItem.length;
            } else {
                for (int item : gridItem) {
                    if (item < 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
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
     * 1370. Increasing Decreasing String
     * 上升下降字符串
     * @param s
     * @return
     */
    public String sortString(String s) {
        StringBuilder answer = new StringBuilder();
        int[] records = new int[26];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0, len = s.length(); i < len; i++) {
            records[s.charAt(i) - 'a']++;
            min = Math.min(min, s.charAt(i) - 'a');
            max = Math.max(max, s.charAt(i) - 'a');
        }
        if (min == max) {
            return s;
        }

        while (answer.length() < s.length()) {
            for (int i = min; i <= max; i++) {
                if (records[i] > 0) {
                    answer.append((char) (i + 'a'));
                    records[i]--;
                }
            }
            for (int i = max; i >= min; i--) {
                if (records[i] > 0) {
                    answer.append((char) (i + 'a'));
                    records[i]--;
                }
            }
        }
        return answer.toString();
    }

    /**
     * 1374. Generate a String With Characters That Have Odd Counts
     * 生成每种字符都是奇数个的字符串
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < (n % 2 == 1 ? n : n - 1); i++) {
            answer.append("a");
        }
        if (n % 2 == 0) {
            answer.append("b");
        }
        return answer.toString();
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
        // 如果要求节点值相同的情况下，找节点所在位置也相同则是另外一个解法
        Stack<TreeNode> stack = new Stack<>();
        stack.push(cloned);
        TreeNode curr = cloned;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.val == target.val) {
                return curr;
            } else {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
        }
        return curr;
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
     * 1436. Destination City
     * 旅行终点站
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> pathMapping = new HashMap<>(paths.size());
        for (List<String> path : paths) {
            pathMapping.put(path.get(0), path.get(1));
        }
        String end = paths.get(0).get(1);
        while (pathMapping.containsKey(end)) {
            end = pathMapping.get(end);
        }
        return end;
    }

    /**
     * 1437. Check If All 1's Are at Least Length K Places Away
     * 是否所有 1 都至少相隔 k 个元素
     * @param nums
     * @param k
     * @return
     */
    public boolean kLengthApart(int[] nums, int k) {
        int start = 0,
            end,
            distance,
            count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count == 1) {
                    start = i;
                } else {
                    end = i;
                    distance = end - start - 1;
                    start = end;
                    count = 1;
                    if (distance < k) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 1450. Number of Students Doing Homework at a Given Time
     * 在既定时间做作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int answer = 0;
        for (int i = 0, len = startTime.length; i < len; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                answer++;
            }
        }
        return answer;
    }

    /**
     * 1460. Make Two Arrays Equal by Reversing Subarrays
     * 通过翻转子数组使两个数组相等
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] records = new int[1001];
        for (int item : target) {
            records[item]++;
        }
        for (int item : arr) {
            if (records[item] > 0) {
                records[item]--;
            }
        }
        int sum = 0;
        for (int record : records) {
            sum += record;
        }
        return sum == 0;
    }

    /**
     * 1464. Maximum Product of Two Elements in an Array
     * 数组中两元素的最大乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            }
            else if (num > secondMax) {
                secondMax = num;
            }
        }
        return (firstMax - 1) * (secondMax - 1);
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
     * 1475. Final Prices With a Special Discount in a Shop
     * 商品折扣后的最终价格
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0, len = prices.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    answer[i] = prices[i] - prices[j];
                    break;
                }
                if (j == len - 1) {
                    answer[i] = prices[i];
                }
            }
            if (i == len - 1) {
                answer[i] = prices[i];
            }
        }
        return answer;
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
     * 1486. XOR Operation in an Array
     * 数组异或操作
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
        int answer = -1;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
            if (answer == -1) {
                answer = start;
            } else {
                answer = answer ^ nums[i];
            }
        }
        return answer;
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
