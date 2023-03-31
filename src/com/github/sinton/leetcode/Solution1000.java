package com.github.sinton.leetcode;

import java.util.*;

/**
 * @author Yan
 */
public class Solution1000 {
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
