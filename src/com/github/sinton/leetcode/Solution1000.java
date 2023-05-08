package com.github.sinton.leetcode;

import java.util.*;

/**
 * @author Yan
 */
public class Solution1000 {
    /**
     * 507. Perfect Number
     * 完美数
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return sum == num && num != 1;
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
     * 598. Range Addition II
     * 范围求和 II
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        int count = m * n;
        int widthMin = Integer.MAX_VALUE;
        int heightMin = Integer.MAX_VALUE;
        for (int[] op : ops) {
            widthMin = Math.min(widthMin, op[0]);
            heightMin = Math.min(heightMin, op[1]);
        }
        if (widthMin != Integer.MAX_VALUE && heightMin != Integer.MAX_VALUE) {
            return widthMin * heightMin;
        } else {
            return count;
        }
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
     * TODO
     * 704. Binary Search
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // TODO
        int start = 0;
        int end   = nums.length;
        int mid;
        while (start < end) {
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
     * 709. To Lower Case
     * 转换成小写字母
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                result.append((char) (str.charAt(i) + 32));
            }
            else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
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
     * 728. Self Dividing Numbers
     * 自除数
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean isDividing = true;
            for (int j = 0, len = (int) Math.log10(i); j <= len; j++) {
                int curr = i / (int) Math.pow(10, len - j) % 10;
                if (curr == 0 || i % curr != 0) {
                    isDividing = false;
                    break;
                }
            }
            if (isDividing) {
                result.add(i);
            }
        }
        return result;
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
     * TODO
     * 766. Toeplitz Matrix
     * 托普利茨矩阵
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean isToeplize = false;
        for (int i = 0; i < matrix[0].length; i++) {

        }
        return false;
    }

    /**
     * 771. Jewels and Stones
     * 宝石与石头
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.toCharArray().length; i++) {
            for (int j = 0; j < S.toCharArray().length; j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 790. Domino and Tromino Tiling
     * 多米诺和托米诺平铺
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
     * 804. Unique Morse Code Words
     * 唯一摩尔斯密码词
     * @param words
     * @return
     */
    private int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };
        ArrayList<String> morseWords = new ArrayList<>();
        for (String word : words) {
            StringBuilder item = new StringBuilder();
            for (int j = 0, wordLength = word.length(); j < wordLength; j++) {
                item.append(morseCode[word.charAt(j) - 97]);
            }
            if (!morseWords.contains(item.toString())) {
                morseWords.add(item.toString());
            }
        }
        return morseWords.size();
    }

    /**
     * 806. Number of Lines To Write String
     * 写字符串需要的行数
     * @param widths
     * @param S
     * @return
     */
    public int[] numberOfLines(int[] widths, String S) {
        int width = 0;
        int line = 1;
        for (char letter : S.toCharArray()) {
            if (width + widths[letter - 'a'] > 100) {
                line += 1;
                width = widths[letter - 'a'];
            } else {
                width += widths[letter - 'a'];
            }
        }
        return new int[]{line, width};
    }

    /**
     * TODO
     * 811. Subdomain Visit Count
     * 子域名访问计数
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        for (String cpdomain : cpdomains) {
            System.out.println(cpdomain);

        }
        return null;
    }

    /**
     * TODO
     * 821. Shortest Distance to a Character
     * 字符的最短距离
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            result[i] = S.charAt(i) - C;
        }
        return result;
    }

    /**
     * 832. Flipping an Image
     * 翻转图像
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] item : A) {
            for (int i = 0; i < item.length / 2; i++) {
                item[i] ^= item[item.length - 1 - i];
                item[item.length - 1 - i] ^= item[i];
                item[i] ^= item[item.length - 1 - i];
            }
            for (int i = 0; i < item.length; i++) {
                item[i] = item[i] ^ 1;
            }
        }
        return A;
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
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '#') {
                if (left.length() > 0) {
                    left.deleteCharAt(left.length() - 1);
                }
            } else {
                left.append(s.charAt(i));
            }
        }
        for (int i = 0, len = t.length(); i < len; i++) {
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
     * 852. Peak Index in a Mountain Array
     * 山脉数组的峰顶索引
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * 867. Transpose Matrix
     * 转置矩阵
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    /**
     * 872. Leaf-Similar Trees
     * 叶子相似的树
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> srcLeafValues = getTreeNodeLeafValues(root1);
        List<Integer> desLeafValues = getTreeNodeLeafValues(root2);
        return Arrays.toString(srcLeafValues.toArray()).equals(Arrays.toString(desLeafValues.toArray()));
    }

    /**
     * 872. Leaf-Similar Trees
     * 叶子相似的树
     * @param root
     * @return
     */
    public List<Integer> getTreeNodeLeafValues(TreeNode root) {
        List<Integer> leaf = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.left == null && curr.right == null) {
                leaf.add(curr.val);
            } else {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            }
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
     * 905. Sort Array By Parity
     * 按奇偶排序数组
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int  index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[index++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                result[index++] = A[i];
            }
        }
        return result;
    }

    /**
     * TODO
     * 908. Smallest Range I
     * 最小差值 I
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeI(int[] A, int K) {
        return 0;
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
     * 验证外星语词典
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
     * 961. N-Repeated Element in Size 2N Array
     * 在长度 2N 的数组中找出重复 N 次的元素
     * @param nums
     * @return
     */
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        int[] counter = new int[10000 + 1];
        for (int num : nums) {
            counter[num]++;
            if (counter[num] >= Math.sqrt(n)) {
                return num;
            }
        }
        return 0;
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
