package com.github.sinton.leetcode;

import java.util.*;

/**
 * @author Yan
 */
public class Solution1000 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

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
     * 83. Remove Duplicates from Sorted List
     * 删除排序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
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
     * 101. Symmetric Tree
     * 对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        // TODO
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
     *
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
     *
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

    /**
     * 509. Fibonacci Number
     * 斐波那契数
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
        return fibonacci[n];
    }

    /**
     * 566. Reshape the Matrix
     * 重塑矩阵
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        for (int i = 0, m = mat.length; i < m; i++) {
            for (int j = 0, n = mat[i].length; j < n; j++) {
                if (m * n != r * c) {
                    return mat;
                }
                result[(i * n + j) / c][(i * n + j) % c] = mat[i][j];
            }
        }
        return result;
    }

    /**
     * 589. N-ary Tree Preorder Traversal
     * N 叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            result.add(root.val);
            if (root.children != null && !root.children.isEmpty()) {
                root.children.forEach(subRoot -> {
                    if (subRoot != null) {
                        result.addAll(preorder(subRoot));
                    }
                });
            }
        }
        return result;
    }

    /**
     * 653. Two Sum IV - Input is a BST
     * 两数之和 IV - 输入二叉搜索树
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Map<Integer, Integer> target = new HashMap<>(16);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr;
        queue.offer(root);
        while(!queue.isEmpty()) {
            curr = queue.poll();
            if (target.containsKey(curr.val)) {
                if (target.get(curr.val) == k - curr.val) {
                    return true;
                }
            } else if (target.containsKey(k - curr.val)) {
                if (target.get(k - curr.val) == curr.val) {
                    return true;
                }
            } else {
                target.put(curr.val, k - curr.val);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return false;
    }

    /**
     * 692. Top K Frequent Words
     * 前K个高频单词
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> answer = new LinkedList<>();
        Map<String, Integer> record = new HashMap<>(16);
        for (String word : words) {
            if (record.containsKey(word)) {
                record.put(word, record.get(word) + 1);
            } else {
                record.put(word, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(record.entrySet());
        list.sort((word1, word2) -> {
            int compareResult = word2.getValue().compareTo(word1.getValue());
            if (compareResult == 0) {
                return word1.getKey().compareTo(word2.getKey());
            }
            return compareResult;
        });
        for (Map.Entry<String, Integer> item : list) {
            if (k == 0) {
                break;
            } else {
                answer.add(item.getKey());
                k--;
            }
        }
        return answer;
    }

    /**
     * 700. Search in a Binary Search Tree
     * 二叉搜索树中的搜索
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            TreeNode curr;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                curr = queue.poll();
                if (curr.val == val) {
                    return curr;
                } else {
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * 701. Insert into a Binary Search Tree
     * 二叉搜索树中的插入操作
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else if (root.val < val){
                root.right = insertIntoBST(root.right, val);
            }
        }
        return root;
    }

    /**
     * 704. Binary Search
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // TODO
        int start = 0;
        int end   = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     *
     * @param n
     * @return
     */
    public int numTilings(int n) {
        switch (n) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int[] fx = new int[n + 1];
                fx[0] = 1;
                fx[1] = 1;
                fx[2] = 2;
                for(int i = 3; i <= n; i++) {
                    fx[i] = (2 * fx[i - 1] % (int) (1e9 + 7) + fx[i - 3] % (int) (1e9 + 7)) % (int) (1e9 + 7);
                }
                return fx[n];
        }
    }

    /**
     * 724. Find Pivot Index
     * 寻找数组的中心下标
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int k = i + 1; k < len; k++) {
                rightSum += nums[k];
            }
            if (leftSum == rightSum) {
                return i;
            } else {
                leftSum = 0;
                rightSum = 0;
            }
        }
        return -1;
    }

    /**
     * 746. Min Cost Climbing Stairs
     * 使用最小花费爬楼梯
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len <= 1) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int minSum = 0;
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i < len ? cost[i] : 0);
            minSum = dp[i];
        }
        return minSum;
    }

    /**
     * 844. Backspace String Compare
     * 比较含退格的字符串
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for(int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '#') {
                if (left.length() > 0) {
                    left.deleteCharAt(left.length() - 1);
                }
            } else {
                left.append(s.charAt(i));
            }
        }
        for(int i = 0, len = t.length(); i < len; i++) {
            if (t.charAt(i) == '#') {
                if (right.length() > 0) {
                    right.deleteCharAt(right.length() - 1);
                }
            } else {
                right.append(t.charAt(i));
            }
        }
        return left.toString().equals(right.toString());
    }

    /**
     * 872. Leaf-Similar Trees
     * 叶子相似的树
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // TODO
        List<Integer> srcLeafValues = getTreeNodeLeafValues(root1);
        List<Integer> desLeafValues = getTreeNodeLeafValues(root2);
        for (int i = 0; i < srcLeafValues.size(); i++) {
            if (srcLeafValues.get(i) - desLeafValues.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 872. Leaf-Similar Trees
     * 叶子相似的树
     * @param root
     * @return
     */
    public List<Integer> getTreeNodeLeafValues(TreeNode root) {
        List<Integer> leaf = new LinkedList<>();
        if (root.left != null) {
            leaf.addAll(getTreeNodeLeafValues(root.left));
        }
        if (root.right != null) {
            leaf.addAll(getTreeNodeLeafValues(root.right));
        }
        return leaf;
    }

    /**
     * 876. Middle of the Linked List
     * 链表的中间结点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        int middle = length / 2;
        while (middle > 0) {
            head = head.next;
            middle--;
        }
        return head;
    }

    /**
     * 931. Minimum Falling Path Sum
     * 下降路径最小和
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        if (length == 1) {
            return matrix[0][0];
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j + 1 == length) {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                } else {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
                }
                if (i + 1 == length) {
                    answer = Math.min(answer, matrix[i][j]);
                }
            }
        }
        return answer;
    }

    /**
     * 938. Range Sum of BST
     * 二叉搜索树的范围和
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root != null) {
            if (low <= root.val && root.val <= high) {
                sum += root.val;
            }
            if (root.left != null) {
                sum += rangeSumBST(root.left, low, high);
            }
            if (root.right != null) {
                sum += rangeSumBST(root.right, low, high);
            }
        }
        return sum;
    }

    /**
     * 953. Verifying an Alien Dictionary
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) {
            return true;
        } else {
            int index1;
            int index2;
            boolean skip;
            for(int i = 1; i < words.length; i++) {
                index1 = 0;
                index2 = 0;
                skip = false;
                while (index1 < words[i].length() && index2 < words[i - 1].length()) {
                    if (order.indexOf(words[i - 1].charAt(index1)) < order.indexOf(words[i].charAt(index2))) {
                        skip = true;
                        break;
                    } else if (order.indexOf(words[i - 1].charAt(index1)) == order.indexOf(words[i].charAt(index2))) {
                        index1++;
                        index2++;
                    } else {
                        return false;
                    }
                }
                if (!skip) {
                    if (words[i - 1].length() < words[i].length()) {
                        return true;
                    }
                    if (words[i].length() < words[i - 1].length()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * 976. Largest Perimeter Triangle
     * 三角形的最大周长
     * @param nums
     * @return
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int len = nums.length, i = len - 1; i > 1; i--) {
            if (nums[i] - nums[i - 1] < nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    /**
     * 977. Squares of a Sorted Array
     * 有序数组的平方
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
