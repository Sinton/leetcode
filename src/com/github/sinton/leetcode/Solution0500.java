package com.github.sinton.leetcode;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Yan
 */
public class Solution0500 {
    /**
     * 1. Two Sum
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = j;
                    result[1] = i;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 2. Add Two Numbers
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = new ListNode(0);
        ListNode current = sum;
        while (l1 != null || l2 != null) {
            int result = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = result / 10;
            current.next = new ListNode(result % 10);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return sum.next;
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> record = new HashMap<>(16);
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(tmp.indexOf(String.valueOf(s.charAt(i))) >= 0) {
                tmp = new StringBuilder();
                i = record.get(s.charAt(i)) + 1;
                record.clear();
            }
            tmp.append(s.charAt(i));
            record.put(s.charAt(i), i);
            max = Math.max(tmp.length(), max);
        }
        return max;
    }

    /**
     * 9. Palindrome Number
     * 回文数
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            char[] nums = String.valueOf(x).toCharArray();
            for (int i = 0, length = nums.length; i < length / 2; i++) {
                if (nums[i] != nums[length - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 20. Valid Parentheses
     * 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0, len = s.length(); i < len; i++) {
            if (!stack.isEmpty() && stack.peek() == '(') {
                if (s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (!stack.isEmpty() && stack.peek() == '[') {
                if (s.charAt(i) == ']') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (!stack.isEmpty() && stack.peek() == '{') {
                if (s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    /**
     * 21. Merge Two Sorted Lists
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode();
        ListNode head = curr;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            curr = curr.next;
        }
        while (list1 != null) {
            curr.next = new ListNode(list1.val);
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = new ListNode(list2.val);
            list2 = list2.next;
            curr = curr.next;
        }
        return head.next;
    }

    /**
     * 29. Divide Two Integers
     * 两数相除
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean unsigned = (dividend ^ divisor) >= 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int quotient = 0;
        for (int i = 31; i >= 0; i--) {
            if (a >> i >= b) {
                quotient += 1 << i;
                a -= b << i;
            }
        }
        return unsigned ? quotient : -quotient;
    }

    /**
     * 36. Valid Sudoku
     * 有效的数独
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // TODO
        boolean isSudoku = true;
        int len = board.length;
        for (int i = 0; i < len; i++) {
        }
        return isSudoku;
    }

    /**
     * 53. Maximum Subarray
     * 最大子数组和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 56. Merge Intervals
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] interval : intervals) {
            min = Math.min(interval[0], min);
            max = Math.max(interval[1], max);
        }
        int[] counting = new int[max - min + 1];
        for(int[] interval : intervals) {
            for(int i = interval[0]; i <= interval[1]; i++) {
                counting[i - min]++;
            }
        }
        boolean isBegin = false;
        List<int[]> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0, len = counting.length; i < len; i++) {
            if (counting[i] > 0) {
                if (isBegin) {
                    end = min + i + 1;
                } else {
                    start = min + i;
                    isBegin = true;
                }
                if (i + 1 == len) {
                    isBegin = false;
                }
            } else {
                if (isBegin) {
                    int[] a = new int[]{start, end};
                    result.add(a);
                }
                isBegin = false;
            }
        }
        return result.toArray((new int[result.size()][2]));
    }

    /**
     * 70. Climbing Stairs
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            int[] step = new int[n];
            step[0] = 1;
            step[1] = 2;
            for(int i = 2; i < n; i++) {
                step[i] = step[i - 1] + step[i -  2];
            }
            return step[n - 1];
        }
    }

    /**
     * TODO
     * 71. Simplify Path
     * 简化路径
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String answer = "/";
        Stack<String> stack = new Stack<>();
        stack.push("/");
        for (int i = 0, len = path.length(); i < len; i++) {
            if (path.charAt(i) == '/' && stack.peek() == "/") {
                stack.pop();
                stack.push("/");
            }
        }
        return answer;
    }

    /**
     * 74. Search a 2D Matrix
     * 搜索二维矩阵
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isExist = false;
        boolean isSort = matrix[0].length == 1;
        boolean isDesc = matrix.length == 1;
        for(int i = 0, matrixHeight = matrix.length; i < matrixHeight; i++) {
            for(int j = 0, matrixWidth = matrix[i].length; j < matrixWidth; j++) {
                if (matrix[i][j] == target) {
                    isExist = true;
                }
                if (j > 0) {
                    if (matrix[i][j] >= matrix[i][j - 1]) {
                        isSort = true;
                    } else {
                        return false;
                    }
                }
                if (i > 0 && j == 0) {
                    if (matrix[i][j] > matrix[i - 1][matrixWidth - 1]) {
                        isDesc = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return isExist && isSort && isDesc;
    }

    /**
     * TODO
     * <p>
     * 只能AC链表第一个元素和其后继元素不相同的情况
     * 对与表头以及其后继元素相同的情况伪造一个表头值
     * 但是如果测试用例中表头值刚好与伪造的相同时则会WA
     * </p>
     */
    public ListNode deleteDuplicates82(ListNode head) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode curr = newHead;
        ListNode prev = curr;
        ListNode next = curr.next;
        ListNode tmp = curr;
        while (next != null) {
            while (tmp.val == next.val) {
                next = next.next;
                curr = prev;
                if (next == null) {
                    break;
                }
            }
            tmp = next;
            curr.next = tmp;
            prev = curr;
            curr = curr.next;
            if (next != null) {
                next = next.next;
            }
        }
        return newHead.next;
    }

    /**
     * 83. Remove Duplicates from Sorted List
     * 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates83(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode answer = new ListNode(head.val);
        ListNode currPointer = answer;
        int currValue = head.val;
        while(head != null) {
            if(head.val != currValue) {
                currPointer.next = new ListNode(head.val);
                currPointer = currPointer.next;
                currValue = head.val;
            }
            head = head.next;
        }
        return answer;
    }

    /**
     * 88. Merge Sorted Array
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 94. Binary Tree Inorder Traversal
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if (root != null) {
            if (root.left != null) {
                answer.addAll(inorderTraversal(root.left));
            }
            answer.add(root.val);
            if (root.right != null) {
                answer.addAll(inorderTraversal(root.right));
            }
        }
        return answer;
    }

    /**
     * 98. Validate Binary Search Tree
     * 验证二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (root.left.val < root.val) {
                    if (!isValidBST(root.left)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (root.right != null) {
                if (root.val < root.right.val) {
                    if (!isValidBST(root.right)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * TODO
     * 101. Symmetric Tree
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr;
        queue.offer(root);
        while(!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.left != null) {

            }
        }
        return false;
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currLevel = new LinkedList<>();
        TreeNode currTreeNode;
        if (root != null) {
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                currTreeNode = queue.poll();
                currLevel.add(currTreeNode.val);
                if (currTreeNode.left != null) {
                    tmpQueue.add(currTreeNode.left);
                }
                if (currTreeNode.right != null) {
                    tmpQueue.add(currTreeNode.right);
                }
                if (queue.isEmpty()) {
                    result.add(currLevel);
                    currLevel = new LinkedList<>();
                    queue.addAll(tmpQueue);
                    tmpQueue.clear();
                }
            }
        }
        return result;
    }

    /**
     * 104. Maximum Depth of Binary Tree
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            TreeNode curr;
            Queue<TreeNode> currLevelQueue = new LinkedList<>();
            Queue<TreeNode> nextLevelQueue = new LinkedList<>();
            currLevelQueue.offer(root);
            depth++;
            while (!currLevelQueue.isEmpty()) {
                curr = currLevelQueue.poll();
                if (curr.left != null) {
                    nextLevelQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    nextLevelQueue.offer(curr.right);
                }
                if (currLevelQueue.isEmpty()) {
                    if (!nextLevelQueue.isEmpty()) {
                        currLevelQueue.addAll(nextLevelQueue);
                        nextLevelQueue.clear();
                        depth++;
                    }
                }
            }
        }
        return depth;
    }

    /**
     * 112. Path Sum
     * 路径总和
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            if (root.left == null && root.right == null && root.val - targetSum == 0) {
                return true;
            } else {
                boolean exist;
                if (root.left != null) {
                    exist = hasPathSum(root.left, targetSum - root.val);
                    if (exist) {
                        return true;
                    }
                }
                if (root.right != null) {
                    exist = hasPathSum(root.right, targetSum - root.val);
                    if (exist) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 118. Pascal's Triangle
     * 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new LinkedList<>();
        List<Integer> curr = Arrays.asList(1);
        List<Integer> prev;
        pascalTriangle.add(curr);
        for (int i = 2; i <= numRows; i++) {
            prev = pascalTriangle.get(pascalTriangle.size() - 1);
            curr = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    curr.add(1);
                } else if (j == i - 1) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }
            pascalTriangle.add(curr);
        }
        return pascalTriangle;
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     * 买卖股票的最佳时机
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int preMin = Integer.MAX_VALUE;
        for (int price : prices) {
            max = Math.max(max, price - preMin);
            preMin = Math.min(preMin, price);
        }
        return max;
    }

    /**
     * 136. Single Number
     * 只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    /**
     * 141. Linked List Cycle
     * 环形链表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        Set<String> record = new HashSet<>(16);
        while (curr != null) {
            if (record.contains(Integer.toHexString(curr.hashCode()))) {
                return true;
            } else {
                record.add(Integer.toHexString(curr.hashCode()));
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * 142. Linked List Cycle II
     * 环形链表 II
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        Set<String> record = new HashSet<>(16);
        while (curr != null) {
            if (record.contains(Integer.toHexString(curr.hashCode()))) {
                break;
            } else {
                record.add(Integer.toHexString(curr.hashCode()));
            }
            curr = curr.next;
        }
        return curr;
    }

    /**
     * TODO
     * 143. Reorder List
     * 重排链表
     */
    public void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode curr = head;
            ListNode second = head.next;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            ListNode last = curr;
            curr = curr.next;
            head.next = curr;
            curr.next = second;
            last.next = null;
        }
    }

    /**
     * 144. Binary Tree Preorder Traversal
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // DFS
        List<Integer> answer = new LinkedList<>();
        if (root != null) {
            answer.add(root.val);
            if (root.left != null) {
                answer.addAll(preorderTraversal(root.left));
            }
            if (root.right != null) {
                answer.addAll(preorderTraversal(root.right));
            }
        }
        return answer;
        /*
        // 栈的实现方式
        List<Integer> answer = new LinkedList<>();
        if (root == null) {
            return answer;
        } else {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr;
            stack.push(root);
            while(!stack.isEmpty()) {
                curr = stack.pop();
                answer.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return answer;
        */
    }

    /**
     * 145. Binary Tree Postorder Traversal
     * 二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        if (root != null) {
            if (root.left != null) {
                answer.addAll(postorderTraversal(root.left));
            }
            if (root.right != null) {
                answer.addAll(postorderTraversal(root.right));
            }
            answer.add(root.val);
        }
        return answer;
    }

    /**
     * 150. Evaluate Reverse Polish Notation
     * 逆波兰表达式求值
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        int answer = Integer.valueOf(tokens[0]);
        if (tokens.length == 1) {
            return answer;
        }
        int a;
        int b;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch(token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    answer = b + a;
                    stack.push(answer);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    answer = b - a;
                    stack.push(answer);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    answer = b * a;
                    stack.push(answer);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    answer = b / a;
                    stack.push(answer);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        return answer;
    }

    /**
     * 191. Number of 1 Bits
     * 位1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        String bin = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) - '0' == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * 198. House Robber
     * 打家劫舍
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        int sum = Math.max(dp[0][0], dp[1][0]);
        for(int i = 1; i < len; i++) {
            dp[0][i] += Math.max(dp[0][i -1], dp[1][i - 1]);
            dp[1][i] += dp[0][i - 1] + nums[i];
            sum = Math.max(dp[0][i], dp[1][i]);
        }
        return sum;
    }

    /**
     * 202. Happy Number
     * 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (int) Math.pow(n % 10, 2);
            n /= 10;
        }
        if (sum > 9) {
            return isHappy(sum);
        } else {
            return sum == 1 || sum == 7;
        }
    }

    /**
     * 203. Remove Linked List Elements
     * 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode answer = new ListNode();
        ListNode currPointer = answer;
        while(head != null) {
            if(head.val != val) {
                currPointer.next = new ListNode(head.val);
                currPointer = currPointer.next;
            }
            head = head.next;
        }
        return answer.next;
    }

    /**
     * 205. Isomorphic Strings
     * 构字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == t.length()) {
            int[] left = new int[s.length()];
            int[] right = new int[t.length()];
            for (int i = 0, len = s.length(); i < len; i++) {
                left[i] = s.indexOf(s.charAt(i));
                right[i] = t.indexOf(t.charAt(i));
                if (left[i] != right[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 206. Reverse Linked List
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 215. Kth Largest Element in an Array
     * 数组中的第K个最大元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        countingSort(nums);
        return nums[nums.length - k];
    }

    /**
     * 计数排序 O(n)
     * @param nums
     */
    public void countingSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] counting = new int[max - min + 1];
        for (int num : nums) {
            counting[num - min]++;
        }
        int index = 0;
        int position = 0;
        while(position < counting.length) {
            if (counting[position] != 0) {
                nums[index] = min + position;
                counting[position]--;
                index++;
            } else {
                position++;
            }
        }
    }

    /**
     * 217. Contains Duplicate
     * 存在重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>(8);
        for (int num : nums) {
            if (record.containsKey(num)) {
                return true;
            } else {
                record.put(num, num);
            }
        }
        return false;
    }

    /**
     * 226. Invert Binary Tree
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode curr;
        curr = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(curr);
        return root;
    }

    /**
     * 231. Power of Two
     * 2 的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        char[] binary = Integer.toBinaryString(n).toCharArray();
        System.out.println(binary);
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') {
                count++;
            }
        }
        return count == 1 && n > 0;
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * 二叉搜索树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 242. Valid Anagram
     * 有效的字母异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            int[] letter = new int[26];
            for(int i = 0, len = s.length(); i < len; i++) {
                letter[s.charAt(i) - 'a']++;
            }
            for(int i = 0, len = t.length(); i < len; i++) {
                letter[t.charAt(i) - 'a']--;
            }
            for(int i = 0, len = letter.length; i < len; i++) {
                if (letter[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 278. First Bad Version
     * 第一个错误的版本
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int end = n;
        while(end == 0) {
            if(isBadVersion(end / 2)) {
                return end / 2;
            } else {
                end = end / 2;
            }
        }
        return 0;
    }

    /**
     * 278. First Bad Version
     * 第一个错误的版本
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return false;
    }

    /**
     * 283. Move Zeroes
     * 移动零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    /**
     * 299. Bulls and Cows
     * 猜数字游戏
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int bullsCount = 0;
        char[] counter = secret.toCharArray();
        for(int i = 0, len = secret.length(); i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullsCount++;
            }
        }
        int count = 0;
        for(int i = 0, len = guess.length(); i < len; i++) {
            for(int j = 0, counterLen = counter.length; j < counterLen; j++) {
                if (counter[j] == guess.charAt(i)) {
                    counter[j] = ' ';
                    count++;
                    break;
                }
            }
        }
        return new StringBuilder().append(bullsCount).append("A").append(count - bullsCount).append("A").toString();
    }

    /**
     * 349. Intersection of Two Arrays
     * 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> union = new LinkedList<>();
        Map<Integer, Boolean> map = new HashMap<>(16);
        for (int num : nums1) {
            map.put(num, true);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num)) {
                union.add(num);
                map.put(num, false);
            }
        }
        int[] result = new int[union.size()];
        for (int i = 0; i < union.size(); i++) {
            result[i] = union.get(i);
        }
        return result;
    }

    /**
     * 350. Intersection of Two Arrays II
     * 两个数组的交集 II
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> union = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) >= 0) {
                    union.add(num);
                }
            }
        }
        int[] result = new int[union.size()];
        for (int i = 0; i < union.size(); i++) {
            result[i] = union.get(i);
        }
        return result;
    }

    /**
     * TODO
     * <p>用大数数据结构模拟，虽然AC但不是本意解法</p>
     * 371. Sum of Two Integers
     * 两整数之和
     */
    public int getSum(int a, int b) {
        BigInteger numberA = BigInteger.valueOf(Long.parseLong(String.valueOf(a)));
        BigInteger numberB = BigInteger.valueOf(Long.parseLong(String.valueOf(b)));
        return Integer.parseInt(numberA.add(numberB).toString());
    }

    /**
     * 383. Ransom Note
     * 赎金信
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] letter = new int[26];
        for(int i = 0, len = magazine.length(); i < len; i++) {
            letter[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0, len = ransomNote.length(); i < len; i++) {
            letter[ransomNote.charAt(i) - 'a'] -= 1;
            if (letter[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 387. First Unique Character in a String
     * 字符串中的第一个唯一字符
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] letter = new int[26];
        for(int i = 0, len = s.length(); i < len; i++) {
            letter[s.charAt(i) - 'a']++;
        }
        for(int i = 0, len = s.length(); i < len; i++) {
            if (letter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 389. Find the Difference
     * 找不同
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int index;
        StringBuilder tmp = new StringBuilder(t);
        for(int i = 0, len = s.length(); i < len; i++) {
            index = tmp.indexOf(String.valueOf(s.charAt(i)));
            if (index >= 0) {
                tmp.deleteCharAt(index);
            }
        }
        return tmp.toString().charAt(0);
    }

    /**
     * 392. Is Subsequence
     * 判断子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() <= t.length()) {
            if (s.length() == 0) {
                return true;
            }
            int subEndIndex = s.length();
            for (int i = t.length() - 1; i >= 0; i--) {
                if (s.charAt(subEndIndex - 1) == t.charAt(i)) {
                    subEndIndex--;
                    if (subEndIndex == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 394. Decode String
     * 字符串解码
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder fragment;
        StringBuilder answer;
        StringBuilder numberRepeat;
        for(int i = 0, len = s.length(); i < len; i++) {
            if(s.charAt(i) == ']') {
                fragment = new StringBuilder();
                while(!"[".equals(stack.peek())) {
                    fragment.insert(0, stack.pop());
                }
                stack.pop();
                numberRepeat = new StringBuilder();
                while(!stack.isEmpty() && '0' <= stack.peek().charAt(0) && stack.peek().charAt(0) <= '9') {
                    numberRepeat.insert(0, stack.pop());
                }
                int count = Integer.parseInt(numberRepeat.toString());
                while(count > 0) {
                    stack.push(fragment.toString());
                    count--;
                }
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        answer = new StringBuilder();
        while(!stack.isEmpty()) {
            answer.insert(0, stack.pop());
        }
        return answer.toString();
    }

    /**
     * 404. Sum of Left Leaves
     * 左叶子之和
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root != null) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                } else {
                    sum += sumOfLeftLeaves(root.left);
                }
            }
            if (root.right != null) {
                sum += sumOfLeftLeaves(root.right);
            }
        } else {
            return sum;
        }
        return sum;
    }

    /**
     * 409. Longest Palindrome
     * 最长回文串
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0, len = s.length(); i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (map.size() == 1 && map.containsKey(s.charAt(0))) {
            return map.get(s.charAt(0));
        }
        int oddCount = 0;
        int longest  = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() + 2) % 2 == 1) {
                if (oddCount > 0) {
                    longest += entry.getValue() - 1;
                } else {
                    longest += entry.getValue();
                }
                oddCount++;
            } else {
                longest += entry.getValue();
            }
        }
        return longest;
    }

    /**
     * 412. Fizz Buzz
     * Fizz Buzz
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> fizzbuzzList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzzList.add("FizzBuzz");
            } else if (i % 5 == 0) {
                fizzbuzzList.add("Buzz");
            } else if (i % 3 == 0) {
                fizzbuzzList.add("Fizz");
            } else {
                fizzbuzzList.add(String.valueOf(i));
            }
        }
        return fizzbuzzList;
    }

    /**
     * 442. Find All Duplicates in an Array
     * 数组中重复的数据
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] flag = new int[nums.length + 1];
        for (int num : nums) {
            flag[num] += 1;
        }
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] > 1) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 448. Find All Numbers Disappeared in an Array
     * 找到所有数组中消失的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] flag = new int[nums.length + 1];
        for (int num : nums) {
            flag[num] += 1;
        }
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 461. Hamming Distance
     * 汉明距离
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        char[] result = Integer.toBinaryString(x ^ y).toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 476. Number Complement
     * 数字的补数
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int bit = (int)(Math.log((double) num) / Math.log((double) 2)) + 1;
        StringBuilder agent = new StringBuilder("0");
        for (int i = 0; i < bit; i++) {
            agent.append(1);
        }
        return Integer.parseInt(agent.toString(), 2) ^ num;
    }

    /**
     * 485. Max Consecutive Ones
     * 最大连续 1 的个数
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        return max > count ? max : count;
    }

    /**
     * 496. Next Greater Element I
     * 下一个更大元素 I
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for(int i = 0, len1 = nums1.length; i < len1; i++) {
            int find = -1;
            int index = nums2.length - 1;
            for(int j = 0, len2 = nums2.length; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }
            for(int j = index + 1, len2 = nums2.length; j < len2; j++) {
                if (nums2[j] > nums1[i]) {
                    find = nums2[j];
                    break;
                }
            }
            answer[i] = find;

        }
        return answer;
    }
}
