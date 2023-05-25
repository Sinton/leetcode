package com.github.sinton.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yan
 */
public class SolutionTest {
    Solution0500 solution0500 = new Solution0500();
    Solution1000 solution1000 = new Solution1000();
    Solution1500 solution1500 = new Solution1500();
    Solution2000 solution2000 = new Solution2000();
    Solution2500 solution2500 = new Solution2500();
    Solution3000 solution3000 = new Solution3000();

    /**
     * 1. Two Sum
     * 两数之和
     */
    @Test
    public void twoSum() {
        int[][][] testCase = {
            {
                {2, 7, 11, 15},
                {9}
            },
            {
                {3, 2, 4},
                {6}
            },
            {
                {3, 3},
                {6}
            },
            {
                {0, 4, 3, 0},
                {0}
            },
            {
                {-3, 4, 3, 90},
                {0}
            },
            {
                {-1, -2, -3, -4, -5},
                {-8}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution0500.twoSum(caseItem[0], caseItem[1][0])));
        }
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     * 无重复字符的最长子串
     */
    @Test
    public void lengthOfLongestSubstring() {
        String[] testCase = {
            "aaabcddd",
            "dvdf",
            "aab",
            "abcabcbb",
            "bbbbb",
            "pwwkew"
        };
        for (String caseItem : testCase) {
            System.out.println(solution0500.lengthOfLongestSubstring(caseItem));
        }
    }

    /**
     * 9. Palindrome Number
     * 回文数
     */
    @Test
    public void isPalindrome() {
        int[] testCase = {3223, 2233, 121, -121, 10, -10};
        for (int caseItem : testCase) {
            System.out.println(solution0500.isPalindrome(caseItem));
        }
    }

    /**
     * 20. Valid Parentheses
     * 有效的括号
     */
    @Test
    public void isValid() {
        String[] testCase = {
            "({[)",
            "()",
            "()[]{}",
            "(]"
        };
        for (String caseItem : testCase) {
            System.out.println(solution0500.isValid(caseItem));
        }
    }

    /**
     * 21. Merge Two Sorted Lists
     * 合并两个有序链表
     */
    @Test
    public void mergeTwoLists() {
        int[][][] testCase = {
            {
                {-9, 3},
                {5, 7}
            },
            {
                {1, 2, 4},
                {1, 3, 4}
            },
            {
                {},
                {}
            },
            {
                {},
                {0}
            }
        };
        for (int[][] caseItem : testCase) {
            ListNode left = Helper.buildListNode(caseItem[0]);
            ListNode right = Helper.buildListNode(caseItem[1]);
            Helper.listNodeFormatOutput(solution0500.mergeTwoLists(left, right));
        }
    }

    /**
     * 29. Divide Two Integers
     * 两数相除
     */
    @Test
    public void divide() {
        int[][] testCase = {
            {10, 3},
            {100, 3},
            {1, 2},
            {-1, 1},
            {1, -1},
            {7, -3},
            {2147483647, 1},
            {2147483647, 2},
            {-2147483648, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution0500.divide(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 53. Maximum Subarray
     * 最大子数组和
     */
    @Test
    public void maxSubArray() {
        int[][] testCase = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {5, 4, -1, 7, 8},
            {1},
            {-1, -2, -3 , -4},
            {8, -2, -4, -1, -8, 3, 8, 8, 3, 4, 2, -9, -1, -3, -6, 8, -3, 9},
            {-64, 78, 56, 10, -8, 26, -18, 47, -31, 75, 89, 13, 48, -19, -69, 36, -39, 55, -5, -4, -15, -37, -27, -8, -5, 35, -51, 83, 21, -47, 46, 33, -91, -21, -57, 0, 81, 1, -75, -50, -23, -86, 39, -98, -29, 69, 38, 32, 24, -90, -95, 86, -27, -23, -22, 44, -88, 3, 27, 9, 55, -50, -80, 40, 5, -61, -82, -14, 40, -58, 35, 93, -68, -26, 94, 3, -79, 9, -88, 21, 19, -84, 7, 91, -8, 84, 12, -19, -13, -83, 66, -80, -34, 62, 59, 48, -98, 53, -66, 18, 94, 46, 11, -73, 96, -18, 6, -83, 91, 17, 38, 10, 9, -78, -22, 77, 83, 89, -42, -30, -94, -98, -34, -51, 63, -97, 96, 64, 55, -93, -41, 27, 52, 69, 53, 26, -71, -64, 42, -80, 52, -43, 6, -62, -21, 83, -85, -38, 49, -50, 8, 55, -72, 74, 80, 90, 53, 53, 32, -15, 36, 90, -88, -34, 37, 41, 91, 65, 76, 33, 61, 5, 90, -33, 42, -54, -73, 34, -16, 75, 83, 91, 7, -89, 42, -36, 77, -5, -83, 9, 80, 53, -23, 68, -81, 90, 10, -90, 55, -14, 19, -7, 91, -14, 59, 33, 31, 62, -33, -85, 37, -73, 83, -78, -86, 25, -15, 91, 97, 2, -23, 54, -68, 53, 22, -73, 43, -68, -87, -25, 18, 31, 67, -14, 94, 3, -81, 25, -35, -37, 17, 79, -34, -23, -99, -43, -98, -38, -52, 75, 63, 1, 29, 71, -68, -71, 74, 51, -40, 86, -73, 54, -5, 70, -60, -11, -49, -64, 90, -8, -25, -16, -52, 40, 60, -75, 96, 39, -13, -79, 14, -73, 22, -79, 75, 30, -51, 49, -19, -15, 36, -16, -60, -69, -68, -21, -4, -18, -9, -14, 50, 65, 70, 75, -17, 30, 99, -44, -31, -14, -46, 60, -10, 52, 80, -35, -18, -94, -86, 62, -10, 49, -53, 6, 56, -45, 62, -48, 36, -47, 15, -37, -81, -15, -62, -22, 91, -85, 33, -62, -23, 86, 97, 66, 15, 54, -69, 96, 36, -55, 36, -97, 70, 82, 9, 4, -63, -29, 32, 49, 23, -53, 88, 18, 8, -96, 72, -23, -82, 6, 14, -6, -31, -12, -39, 61, -58, -32, 57, 77, 12, -7, 56, -40, -48, -35, 40, -35, 12, -28, 90, -87, -4, 79, 30, 80, 82, -20, -43, 76, 62, 70, -30, -92, -42, 7, 68, -24, 75, 26, -70, -36, 95, 86, 0, -52, -49, -60, 12, 63, -11, -20, 75, 84, -41, -18, 41, -82, 61, 98, 70, 0, 45, -83, 8, -96, 24, -24, -44, -24, -98, -14, 39, 97, -51, -60, -78, -24, -44, 10, -84, 44, 89, 67, 5, -75, -73, -53, -81, 64, -55, 88, -35, 89, -94, 72, 69, 29, -52, -97, 81, -73, -35, 20, -99, 13, 36, 98, 65, 69, 8, 81, 13, -25, 25, 95, -1, 51, -58, -5, 16, -37, -17, 57, -71, -35, 29, 75, 70, 53, 77, 51, 79, -58, -51, 56, 31, 84, 54, -27, 30, -37, -46, -56, 14, 56, -84, 89, 7, -43, -16, 99, 19, 67, 56, 24, -68, -38, -1, -97, -84, -24, 53, 71, -6, -98, 28, -98, 63, -18, -25, -7, 21, 5, 13, -88, -39, 28, -98, 68, 61, -15, 44, -43, -71, 1, 81, -39, 62, -20, -60, 54, 33, 69, 26, -96, 48, -69, -94, 11, -11, -20, 80, 87, 61, -29, 98, -77, 75, 99, 67, 37, -38, 11, 93, -10, 88, 51, 27, 28, -68, 66, -41, 41, 36, 84, 44, -16, 91, 49, 71, -19, -94, 28, -32, 44, 75, -57, 66, 51, -80, 10, -35, -19, 97, -65, 70, 63, 86, -2, -9, 94, -59, 26, 35, 76, 11, -21, -63, -21, -94, 84, 59, 87, 13, -96, 31, -35, -53, -26, -84, -34, 60, -20, 23, 58, 15, -7, 21, -22, 67, 88, -28, -91, 14, -93, 61, -98, -38, 75, -19, -56, 59, -83, -91, -51, -79, 16, 14, -56, 90, 6, -14, 27, 63, -91, -15, -22, -22, 82, 32, -54, 47, -96, -69, -61, 86, 91, -60, -75, 43, -3, -31, 3, -9, -23, 28, 11, 69, -81, 31, 59, 25, -83, -36, -12, -75, 48, 42, -21, 8, -26, 24, -68, -23, 31, -30, -60, 0, -13, -36, -57, 60, 32, 22, -49, 85, -49, 38, 55, -54, -31, -9, 70, -38, 54, -65, -37, -20, 76, 42, 64, -73, -57, 95, -20, 74, -57, 19, -49, 29, 83, -7, -11, -8, -84, 40, -45, -57, -45, 86, -12, 24, -46, -64, 62, -91, -30, -74, -35, -76, 44, -94, -73, 86, 77, 7, 37, -80, -74, 87, 48, 85, -19, -85, -45, -27, 31, 9, -8, 85, -28, 79, -14, 25, 91, -51, 10, -61, -49, 74, -38, 94, 56, -12, 57, 34, 71, -5, 53, 74, -18, -21, 59, 39, -30, 90, -88, -99, -24, 3, 62, 47, -40, -51, -27, -49, -26, 82, -11, 1, 34, 27, -5, -10, 92, -48, -99, 63, 23, 31, 14, -94, -90, -49, 44, -44, -59, 33, -44, 17, -64, -82, -36, -28, -57, 13, 0, -7, -4, 88, 70, -93, -7, -35, -4, -15, -6, -26, -75, 93, -95, 39, 98, 90, 66, 20, -54, -93, -47, -22, 0, -35, -28, 41, 14, -8, -46, -86, 84, 26, -98, 55, 32, -29, 96, -94, 32, -33, -21, 57, -39, -17, -27, -64, -50, -61, 55, -28, -78, 84, 49, 22, -73, -79, -37, 40, 12, -7, 53, -26, -80, 31, -94, 51, -97, -98, 56, 34, -54, -88, -32, -17, -29, 17, 18, 20, 32, -49, 91, 54, -65, 40, -47, -39, 38, -8, -99, -73, 84, 30, 0, -96, -38, 5, 32, -36, -16, -35, 74, 29, -23, -80, -88, 47, 36, 29, -32, -54, 79, -64, 76, 91, 53, -71, -71, -9, -3, -93, 17, -19, 36, 94, -38, 97, -1, 70, -62, 82, -65, -87, 11, 11, -68, -1, -41, 44, -71, 3, 89}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution0500.maxSubArray(caseItem));
        }
    }

    /**
     * 56. Merge Intervals
     * 合并区间
     */
    @Test
    public void merge56() {
        int[][][] testCase = {
            {
                {1, 4},
                {5, 6}
            },
//            {
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18}
//            },
//            {
//                {1, 4},
//                {4, 5}
//            }
        };
        for (int[][] caseItem : testCase) {
            int[][] result = solution0500.merge(caseItem);
            for(int[] item : result) {
                System.out.print(Arrays.toString(item));
            }
            System.out.println();
        }
    }

    /**
     * 70. Climbing Stairs
     * 爬楼梯
     */
    @Test
    public void climbStairs() {
        int[] testCase = {2, 3, 45};
        for (int caseItem : testCase) {
            System.out.println(solution0500.climbStairs(caseItem));
        }
    }

    /**
     * 74. Search a 2D Matrix
     * 搜索二维矩阵
     */
    @Test
    public void searchMatrix() {
        int[][][][] testCase = {
            {
                {
                    {1}
                },
                {
                    {1}
                }
            },
            {
                {
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}
                },
                {
                    {3}
                }
            },
            {
                {
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 60}
                },
                {
                    {13}
                }
            },
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(solution0500.searchMatrix(caseItem[0], caseItem[1][0][0]));
        }
    }

    /**
     * 83. Remove Duplicates from Sorted List
     * 删除排序链表中的重复元素
     */
    @Test
    public void deleteDuplicates83() {
        int[][] testCase = {
            {},
            {0, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0, 3, 3},
            {1, 1, 2},
            {1, 1, 2, 3, 3}
        };
        for (int[] caseItem : testCase) {
            Helper.listNodeFormatOutput(solution0500.deleteDuplicates83(Helper.buildListNode(caseItem)));
        }
    }

    /**
     * 88. Merge Sorted Array
     * 合并两个有序数组
     */
    @Test
    public void merge88() {
        int[][][] testCase = {
            {
                {1, 2, 3, 0, 0, 0},
                {3},
                {2, 5, 6},
                {3}
            },
            {
                {1},
                {1},
                {},
                {0}
            },
            {
                {0},
                {0},
                {1},
                {1}
            }
        };
        for (int[][] caseItem : testCase) {
            solution0500.merge(caseItem[0], caseItem[1][0], caseItem[2], caseItem[3][0]);
            System.out.println(Arrays.toString(caseItem[0]));
        }
    }

    /**
     * 94. Binary Tree Inorder Traversal
     * 二叉树的中序遍历
     */
    @Test
    public void inorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution0500.inorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution0500.inorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution0500.inorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution0500.inorderTraversal(root2));

        System.out.println(solution0500.inorderTraversal(null));
        System.out.println(solution0500.inorderTraversal(new TreeNode(1)));
    }

    /**
     * 98. Validate Binary Search Tree
     * 验证二叉搜索树
     */
    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution0500.isValidBST(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution0500.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        System.out.println(solution0500.isValidBST(root2));

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(4);
        root3.left.left = new TreeNode(11);
        root3.left.left.left = new TreeNode(7);
        root3.left.left.right = new TreeNode(2);
        root3.right = new TreeNode(8);
        root3.right.left = new TreeNode(13);
        root3.right.right = new TreeNode(4);
        root3.right.right.right = new TreeNode(1);
        System.out.println(solution0500.isValidBST(root3));
    }

    /**
     * 104. Maximum Depth of Binary Tree
     * 二叉树的最大深度
     */
    @Test
    public void maxDepth104() {
        Integer[][] testCase = {
//            {1, 2, 3, 4, 5, 6},
            {1, null, 2, 3, 4, null, null, 5, 6}
        };
        for (Integer[] caseItem : testCase) {
            TreeNode root = new TreeNode(15);
            TreeNode root1 = new TreeNode(7);
            TreeNode root2 = new TreeNode(20);
            root2.left = root;
            root2.right = root1;
            TreeNode root3 = new TreeNode(9);
            TreeNode root4 = new TreeNode(3);
            root4.left = root3;
            root4.right = root2;
            System.out.println(solution0500.maxDepth(root4));
        }
    }

    /**
     * 112. Path Sum
     * 路径总和
     */
    @Test
    public void hasPathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(solution0500.hasPathSum(root, 22));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(solution0500.hasPathSum(root1, 5));

        System.out.println(solution0500.hasPathSum(null, 0));
    }

    /**
     * 118. Pascal's Triangle
     * 杨辉三角
     */
    @Test
    public void generate() {
        int[] testCase = {5, 1};
        for (int caseItem : testCase) {
            System.out.println(solution0500.generate(caseItem).toString());
        }
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     * 买卖股票的最佳时机
     */
    @Test
    public void maxProfit() {
        int[][] testCase = {
            {7, 1, 5, 3, 6, 4},
            {7, 6, 4, 3, 1},
            {1, 2},
            {9, 4, 6, 11, 19, 47, 53, 79, 103, 137, 139, 149, 163, 167, 179, 223, 263, 269, 283, 293}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution0500.maxProfit(caseItem));
        }
    }

    /**
     * 142. Linked List Cycle II
     * 环形链表 II
     */
    @Test
    public void detectCycle() {
        int[][][] testCase = {
            {
                {-1, -7, 7, -4, 19, 6, -9, -5, -2, -5},
                {6}
            },
            {
                {3, 2, 0, -4},
                {1}
            },
            {
                {1, 2},
                {0}
            },
            {
                {1},
                {-1}
            }
        };
        for (int[][] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem[0]);
            ListNode curr = head;
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            for (int i = caseItem[1][0]; i > 0; i--) {
                curr = curr.next;
            }
            last.next = curr;
        }
    }

    /**
     * 144. Binary Tree Preorder Traversal
     * 二叉树的前序遍历
     */
    @Test
    public void preorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution0500.preorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution0500.preorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution0500.preorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution0500.preorderTraversal(root2));

        System.out.println(solution0500.preorderTraversal(null));
        System.out.println(solution0500.preorderTraversal(new TreeNode(1)));
    }

    /**
     * 145. Binary Tree Postorder Traversal
     * 二叉树的后序遍历
     */
    @Test
    public void postorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution0500.postorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution0500.postorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution0500.postorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution0500.postorderTraversal(root2));

        System.out.println(solution0500.postorderTraversal(null));
        System.out.println(solution0500.postorderTraversal(new TreeNode(1)));
    }

    /**
     * 150. Evaluate Reverse Polish Notation
     * 逆波兰表达式求值
     */
    @Test
    public void evalRPN() {
        String[][] testCase = {
            {"18"},
            {"2", "1", "+", "3", "*"},
            {"4", "13", "5", "/", "+"},
            {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.evalRPN(caseItem));
        }
    }

    /**
     * 198. House Robber
     * 打家劫舍
     */
    @Test
    public void rob() {
        int[][] testCase = {
            {1},
            {2, 1, 1, 2},
            {1, 2, 3, 1},
            {2, 7, 9, 3, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution0500.rob(caseItem));
        }
    }

    /**
     * 203. Remove Linked List Elements
     * 移除链表元素
     */
    @Test
    public void removeElements() {
        int[][][] testCase = {
            {
                {1, 2, 6, 3, 4, 5, 6}, {6}
            },
            {
                {}, {1}
            },
            {
                {7, 7, 7, 7}, {7}
            }
        };
        for (int[][] caseItem : testCase) {
            Helper.listNodeFormatOutput(solution0500.removeElements(Helper.buildListNode(caseItem[0]), caseItem[1][0]));
        }
    }

    /**
     * 205. Isomorphic Strings
     * 构字符串
     */
    @Test
    public void isIsomorphic() {
        String[][] testCase = {
            {"egg", "add"},
            {"foo", "bar"},
            {"paper", "title"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.isIsomorphic(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 206. Reverse Linked List
     * 反转链表
     */
    public void reverseList() {
        int[][] testCase = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution0500.reverseList(head));
        }
    }

    /**
     * 215. Kth Largest Element in an Array
     * 数组中的第K个最大元素
     */
    @Test
    public void findKthLargest() {
        int[][][] testCase = {
            {
                {3, 2, 1, 5, 6, 4},
                {2}
            },
            {
                {3, 2, 3, 1, 2, 4, 5, 5, 6},
                {4}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution0500.findKthLargest(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 217. Contains Duplicate
     * 存在重复元素
     */
    @Test
    public void containsDuplicate() {
        int[][] testCase = {
            {1, 2, 3, 1},
            {1, 2, 3, 4},
            {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution0500.containsDuplicate(caseItem));
        }
    }

    /**
     * 226. Invert Binary Tree
     * 翻转二叉树
     */
    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = solution0500.invertTree(root);
        System.out.println(root);
    }

    /**
     * 232. Implement Queue using Stacks
     * 用栈实现队列
     */
    @Test
    public void myQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    /**
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * 二叉搜索树的最近公共祖先
     */
    @Test
    public void lowestCommonAncestor() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode answer = solution0500.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(answer);
    }

    /**
     * 242. Valid Anagram
     * 有效的字母异位词
     */
    @Test
    public void isAnagram() {
        String[][] testCase = {
            {"dgqztusjuu", "dqugjzutsu"},
            {"anagram", "nagaram"},
            {"rat", "car"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.isAnagram(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 283. Move Zeroes
     * 移动零
     */
    @Test
    public void moveZeroes() {
        int[][] testCase = {
            {2, 1},
            {0, 1, 0, 3, 12},
            {0}
        };
        for (int[] caseItem : testCase) {
            solution0500.moveZeroes(caseItem);
            System.out.println(Arrays.toString(caseItem));
        }
    }

    /**
     * 299. Bulls and Cows
     * 猜数字游戏
     */
    @Test
    public void getHint() {
        String[][] testCase = {
            {"11", "10"},
            {"1807", "7810"},
            {"1123", "0111"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.getHint(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 303. Range Sum Query - Immutable
     * 区域和检索 - 数组不可变
     */
    @Test
    public void NumArray() {
        NumArray numArray = new NumArray(new int[] {});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }

    /**
     * 338. Counting Bits
     * 比特位计数
     */
    @Test
    public void countBits() {
        int[] testCase = {2, 5};
        for (int caseItem : testCase) {
            System.out.println(Arrays.toString(solution0500.countBits(caseItem)));
        }
    }

    /**
     * 350. Intersection of Two Arrays II
     * 两个数组的交集 II
     */
    @Test
    public void intersection() {
        int[][][] testCase = {
            {
                {1, 2, 2, 1},
                {2, 2}
            },
            {
                {4, 9, 5},
                {9, 4, 9, 8,}
            },
            {
                {4, 7, 9, 7, 6, 7},
                {5, 0, 0, 6, 1, 6, 2, 2, 4}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution0500.intersect(caseItem[0], caseItem[1])));
        }
    }

    /**
     * 383. Ransom Note
     * 赎金信
     */
    @Test
    public void canConstruct() {
        String[][] testCase = {
            {"a", "b"},
            {"aa", "ab"},
            {"aa", "aab"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.canConstruct(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 387. First Unique Character in a String
     * 字符串中的第一个唯一字符
     */
    @Test
    public void firstUniqChar() {
        String[] testCase = {
            "leetcode",
            "loveleetcode",
            "aabb"
        };
        for (String caseItem : testCase) {
            System.out.println(solution0500.firstUniqChar(caseItem));
        }
    }

    /**
     * 389. Find the Difference
     * 找不同
     */
    @Test
    public void findTheDifference() {
        String[][] testCase = {
            {"abcd", "abcde"},
            {"", "y"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.findTheDifference(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 392. Is Subsequence
     * 判断子序列
     */
    @Test
    public void isSubsequence() {
        String[][] testCase = {
            {"abc", "ahbgdc"},
            {"axc", "ahbgdc"},
            {"ahbgdc", "ahbgdc"},
            {"bb", "ahbgdc"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution0500.isSubsequence(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 394. Decode String
     * 字符串解码
     */
    @Test
    public void decodeString() {
        String[] testCase = {
            "100[leetcode]",
            "3[a]2[bc]",
            "3[a2[c]]",
            "2[abc]3[cd]ef"
        };
        for (String caseItem : testCase) {
            System.out.println(solution0500.decodeString(caseItem));
        }
    }

    /**
     * 404. Sum of Left Leaves
     * 左叶子之和
     */
    @Test
    public void sumOfLeftLeaves() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(solution0500.sumOfLeftLeaves(root1));
        System.out.println(solution0500.sumOfLeftLeaves(new TreeNode(1)));
    }

    /**
     * 409. Longest Palindrome
     * 最长回文串
     */
    @Test
    public void longestPalindrome() {
        String[] testCase = {
            "abccccdd",
            "a",
            "bb",
            "tattarrattat",
        };
        for (String caseItem : testCase) {
            System.out.println(solution0500.longestPalindrome(caseItem));
        }
    }

    /**
     * 496. Next Greater Element I
     * 下一个更大元素 I
     */
    @Test
    public void nextGreaterElement() {
        int[][][] testCase = {
            {
                {4, 1, 2},
                {1, 3, 4, 2}
            },
            {
                {2, 4},
                {1, 2, 3, 4}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution0500.nextGreaterElement(caseItem[0], caseItem[1])));
        }
    }

    /**
     * 566. Reshape the Matrix
     * 重塑矩阵
     */
    @Test
    public void matrixReshape() {
        int[][][][] testCase = {
            {
                {{1}, {2}, {3}, {4}},
                {{2, 2}}
            },
            {
                {{1, 2}, {3, 4}},
                {{1, 4}}
            },
            {
                {{1, 2}, {3, 4}},
                {{2, 4}}
            }
        };
        for (int[][][] caseItem : testCase) {
            int[][] result = solution1000.matrixReshape(caseItem[0], caseItem[1][0][0], caseItem[1][0][1]);
            for (int[] item : result) {
                System.out.println(Arrays.toString(item));
            }
            System.out.println();
        }
    }

    /**
     * 598. Range Addition II
     * 范围求和 II
     */
    @Test
    public void maxCount() {
        int[][][][] testCase = {
            {
                {{3}, {3}},
                {{2, 2}, {3, 3}}
            },
            {
                {{3}, {3}},
                {{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}
            },
            {
                {{3}, {3}},
                {}
            }
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(solution1000.maxCount(caseItem[0][0][0], caseItem[0][1][0], caseItem[1]));
        }
    }

    /**
     * 653. Two Sum IV - Input is a BST
     * 两数之和 IV - 输入二叉搜索树
     */
    @Test
    public void findTarget() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(solution1000.findTarget(root, 28));
    }

    /**
     * 682. Baseball Game
     * 棒球比赛
     */
    @Test
    public void calPoints() {
        String[][] testCase = {
            {"1", "C", "-62", "-45", "-68"},
            {"5", "2", "C", "D", "+"},
            {"5", "-2", "4", "C", "D", "9", "+", "+"},
            {"1"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.calPoints(caseItem));
        }
    }

    /**
     * 692. Top K Frequent Words
     * 前K个高频单词
     */
    @Test
    public void topKFrequent() {
        String[][][] testCase = {
            {
                {"a", "aa", "aaa"},
                {"1"}
            },
            {
                {"i", "love", "leetcode", "i", "love", "coding"},
                {"2"}
            },
            {
                {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                {"4"}
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution1000.topKFrequent(caseItem[0], Integer.parseInt(caseItem[1][0])));
        }
    }

    /**
     * 700. Search in a Binary Search Tree
     * 二叉搜索树中的搜索
     */
    @Test
    public void searchBST() {
        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(2);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(63);
        root.right.right.right = new TreeNode(84);
        root = solution1000.searchBST(root, 63);
        System.out.println(root);
    }

    /**
     * 701. Insert into a Binary Search Tree
     * 二叉搜索树中的插入操作
     */
    @Test
    public void insertIntoBST() {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(7);
//        root = solution1000.insertIntoBST(root, 5);
//        System.out.println(root);
        TreeNode root1 = new TreeNode(40);
        root1.left = new TreeNode(20);
        root1.left.left = new TreeNode(10);
        root1.left.right = new TreeNode(30);
        root1.right = new TreeNode(60);
        root1.right.left = new TreeNode(50);
        root1.right.right = new TreeNode(70);
        root1 = solution1000.insertIntoBST(root1, 25);
        System.out.println(root1);
    }

    /**
     * 703. Kth Largest Element in a Stream
     * 数据流中的第 K 大元素
     */
    @Test
    public void KthLargest() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    /**
     * 704. Binary Search
     * 二分查找
     */
    @Test
    public void search() {
        int[][][] testCase = {
            {
                {2, 5},
                {2}
            },
            {
                {5},
                {5}
            },
            {
                {-1, 0, 3, 5, 9, 12},
                {9}
            },
            {
                {-1, 0, 3, 5, 9, 12},
                {2}
            },
            {
                {5, 1},
                {1}
            },
            {
                {5, 1},
                {2}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1000.search(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 724. Find Pivot Index
     * 寻找数组的中心下标
     */
    @Test
    public void pivotIndex() {
        int[][] testCase = {
            {1, 7, 3, 6, 5, 6},
            {1, 2, 3},
            {2, 1, -1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.pivotIndex(caseItem));
        }
    }

    /**
     * 746. Min Cost Climbing Stairs
     * 使用最小花费爬楼梯
     */
    @Test
    public void minCostClimbingStairs() {
        int[][] testCase = {
            {10, 15, 20},
            {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.minCostClimbingStairs(caseItem));
        }
    }

    /**
     * 844. Backspace String Compare
     * 比较含退格的字符串
     */
    @Test
    public void backspaceCompare() {
        String[][] testCase = {
            {"a##c", "#a#c"},
            {"ab#c", "ad#c"},
            {"ab##", "c#d#"},
            {"a#c", "b"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.backspaceCompare(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 876. Middle of the Linked List
     * 链表的中间结点
     */
    @Test
    public void middleNode() {
        int[][] testCase = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution1000.middleNode(head));
        }
    }

    /**
     * 872. Leaf-Similar Trees
     * 叶子相似的树
     */
    @Test
    public void leafSimilar() {
        Integer[][][] testCase = {
            {
                {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4},
                {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}
            },
            {
                {1,2,3},
                {1,3,2}
            },
        };
        for (Integer[][] caseItem : testCase) {
            TreeNode root1 = Helper.buildTreeNode(caseItem[0]);
            TreeNode root2 = Helper.buildTreeNode(caseItem[1]);
            System.out.println(solution1000.leafSimilar(root1, root2));
        }
    }

    /**
     * 931. Minimum Falling Path Sum
     * 下降路径最小和
     */
    @Test
    public void minFallingPathSum() {
        int[][][] testCase = {
            {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
            },
            {
                {-19, 57},
                {-40, -5}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1000.minFallingPathSum(caseItem));
        }
    }

    /**
     * 938. Range Sum of BST
     * 二叉搜索树的范围和
     */
    @Test
    public void rangeSumBST() {
        Integer[][][] testCase = {
            {
                {10, 5, 15, 3, 7, null, 18},
                {7},
                {15}
            },
            {
                {10, 5, 15, 3, 7, 13, 18, 1, null, 6},
                {6},
                {10}
            }
        };
        for (Integer[][] caseItem : testCase) {
            System.out.println(solution1000.rangeSumBST(Helper.buildTreeNode(caseItem[0]), caseItem[1][0], caseItem[2][0]));;
        }
    }

    /**
     * 944. Delete Columns to Make Sorted
     * 删列造序
     */
    @Test
    public void minDeletionSize() {
        String[][] testCase = {
            {"rrjk", "furt", "guzm"},
            {"cba", "daf", "ghi"},
            {"a", "b"},
            {"zyx", "wvu", "tsr"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.minDeletionSize(caseItem));
        }
    }

    /**
     * 953. Verifying an Alien Dictionary
     * 验证外星语词典
     */
    @Test
    public void isAlienSorted() {
        String[][][] testCase = {
            {
                {"apple", "apple", "app"},
                {"abcdefghijklmnopqrstuvwxyz"}
            },
            {
                {"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"},
                {"zkgwaverfimqxbnctdplsjyohu"}
            },
            {
                {"hello", "leetcode"},
                {"hlabcdefgijkmnopqrstuvwxyz"}
            },
            {
                {"word", "world", "row"},
                {"worldabcefghijkmnpqstuvxyz"}
            },
            {
                {"apple","app"},
                {"abcdefghijklmnopqrstuvwxyz"}
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution1000.isAlienSorted(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 790. Domino and Tromino Tiling
     * 多米诺和托米诺平铺
     */
    @Test
    public void numTilings() {
        int[] testCase = {1, 2, 3, 4, 5, 7, 9, 30};
        for (int caseItem : testCase) {
            System.out.println(solution1000.numTilings(caseItem));
        }
    }

    /**
     * 933. Number of Recent Calls
     * 最近的请求次数
     */
    @Test
    public void testRecentCounter() {
        int[] testCase = {1, 100, 3001, 3002};
        RecentCounter recentCounter = new RecentCounter();
        for (int caseItem : testCase) {
            System.out.println(recentCounter.ping(caseItem));
        }
    }

    /**
     * 961. N-Repeated Element in Size 2N Array
     * 在长度 2N 的数组中找出重复 N 次的元素
     */
    @Test
    public void repeatedNTimes() {
        int[][] testCase = {
            {1, 2, 3, 3},
            {2, 1, 2, 5, 3, 2},
            {5, 1, 5, 2, 5, 3, 5, 4},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.repeatedNTimes(caseItem));
        }
    }

    /**
     * 976. Largest Perimeter Triangle
     * 三角形的最大周长
     */
    @Test
    public void largestPerimeter() {
        int[][] testCase = {
            {1, 2, 1},
            {1, 2, 1, 10},
            {2, 2, 1},
            {1, 2, 3, 4},
            {3, 2, 3, 4},
            {3, 4, 15, 2, 9, 4}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.largestPerimeter(caseItem));
        }
    }

    /**
     * 1021. Remove Outermost Parentheses
     * 删除最外层的括号
     */
    @Test
    public void removeOuterParentheses() {
        String[] testCase = {
            "(()())(())",
            "(()())(())(()(()))",
            "()()"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1500.removeOuterParentheses(caseItem));
        }
    }

    /**
     * 1046. Last Stone Weight
     * 最后一块石头的重量
     */
    @Test
    public void lastStoneWeight() {
        int[][] testCase = {
            {2, 2},
            {2, 7, 4, 1, 8, 1},
            {2, 9, 3, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.lastStoneWeight(caseItem));
        }
    }

    /**
     * 1051. Height Checker
     * 高度检查器
     */
    @Test
    public void heightChecker() {
        int[][] testCase = {
            {1, 1, 4, 2, 1, 3},
            {5, 1, 2, 3, 4},
            {1, 2, 3, 4, 5}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.heightChecker(caseItem));
        }
    }

    /**
     * 1108. Defanging an IP Address
     * IP 地址无效化
     */
    @Test
    public void defangIPaddr() {
        String[] testCase = {"1.1.1.1", "255.100.50.0"};
        for (String caseItem : testCase) {
            System.out.println(solution1500.defangIPaddr(caseItem));
        }
    }

    /**
     * 1207. Unique Number of Occurrences
     * 独一无二的出现次数
     */
    @Test
    public void uniqueOccurrences() {
        int[][] testCase = {
            {1, 2, 2, 1, 1, 3},
            {1, 2},
            {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.uniqueOccurrences(caseItem));
        }
    }

    /**
     * 1217. Minimum Cost to Move Chips to The Same Position
     * 玩筹码
     */
    @Test
    public void minCostToMoveChips() {
        int[][] testCase = {
            {1, 2, 3},
            {2, 2, 2, 3, 3},
            {1, 1000000000}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.minCostToMoveChips(caseItem));
        }
    }

    /**
     * 1221. Split a String in Balanced Strings
     * 分割平衡字符串
     */
    @Test
    public void balancedStringSplit() {
        String[] testCase = {
            "RLRRLLRLRL",
            "RLRRRLLRLL",
            "LLLLRRRR"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1500.balancedStringSplit(caseItem));
        }
    }

    /**
     * 1232. Check If It Is a Straight Line
     * 缀点成线
     */
    @Test
    public void checkStraightLine() {
        int[][][] testCase = {
            {
                {1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}
            },
            {
                {0, 0}, {0, 1}, {0, -1}
            },
            {
                {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}
            },
            {
                {1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1500.checkStraightLine(caseItem));
        }
    }

    /**
     * 1252. Cells with Odd Values in a Matrix
     * 奇数值单元格的数目
     */
    @Test
    public void oddCells() {
        int[][][][] testCase = {
            {
                {{2, 3}},
                {{0, 1}, {1, 1}}
            },
            {
                {{2, 2}},
                {{1, 1}, {0, 0}}
            },
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(solution1500.oddCells(caseItem[0][0][0], caseItem[0][0][1], caseItem[1]));
        }
    }

    /**
     * 1290. Convert Binary Number in a Linked List to Integer
     * 二进制链表转整数
     */
    @Test
    public void getDecimalValue() {
        int[][] testCase = {
            {1, 0, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.getDecimalValue(Helper.buildListNode(caseItem)));
        }
    }

    /**
     * 1295. Find Numbers with Even Number of Digits
     * 统计位数为偶数的数字
     */
    @Test
    public void findNumbers() {
        int[][] testCase = {
            {12, 345, 2, 6, 7896},
            {555, 901, 482, 1771}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.findNumbers(caseItem));
        }
    }

    /**
     * 1299. Replace Elements with Greatest Element on Right Side
     * 将每个元素替换为右侧最大元素
     */
    @Test
    public void replaceElements() {
        int[][] testCase = {
            {17, 18, 5, 4, 6, 1},
            {400},
            {555, 901, 482, 1771}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.replaceElements(caseItem)));
        }
    }

    /**
     * 1304. Find N Unique Integers Sum up to Zero
     * 和为零的 N 个不同整数
     */
    @Test
    public void sumZero() {
        int[] testCase = {5, 4, 3, 2, 1};
        for (int caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.sumZero(caseItem)));
        }
    }

    /**
     * 1309. Decrypt String from Alphabet to Integer Mapping
     * 解码字母到整数映射
     */
    @Test
    public void freqAlphabets() {
        String[] testCase = {
            "1",
            "#",
            "10#11#12",
            "1326#"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1500.freqAlphabets(caseItem));
        }
    }

    /**
     * 1313. Decompress Run-Length Encoded List
     * 解压缩编码列表
     */
    @Test
    public void decompressRLElist() {
        int[][] testCase = {
            {1, 2, 3, 4},
            {1, 1, 2, 3},
            {55, 11, 70, 26, 62, 64},
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.decompressRLElist(caseItem)));
        }
    }

    /**
     * 1323. Maximum 69 Number
     * 6 和 9 组成的最大数字
     */
    @Test
    public void maximum69Number() {
        int[] testCase = {
            6,
            9,
            66,
            69,
            96,
            99,
            666,
            996,
            999,
            9669,
            9996,
            9999
        };
        for (int caseItem : testCase) {
            System.out.println(solution1500.maximum69Number(caseItem));
        }
    }

    /**
     * 1332. Remove Palindromic Subsequences
     * 删除回文子序列
     */
    @Test
    public void removePalindromeSub() {
        String[] testCase = {"ababa", "abb", "baabb"};
        for (String caseItem : testCase) {
            System.out.println(solution1500.removePalindromeSub(caseItem));
        }
    }

    /**
     * 1337. The K Weakest Rows in a Matrix
     * 矩阵中战斗力最弱的 K 行
     */
    @Test
    public void kWeakestRows() {
        int[][][][] testCase = {
            {
                {
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0},
                    {1, 0, 0, 0, 0},
                    {1, 1, 0, 0, 0},
                    {1, 1, 1, 1, 1}
                },
                {{3}}
            },
            {
                {
                    {1, 0, 0, 0},
                    {1, 1, 1, 1},
                    {1, 0, 0, 0},
                    {1, 0, 0, 0}
                },
                {{2}}
            }
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.kWeakestRows(caseItem[0], caseItem[1][0][0])));
        }
    }

    /**
     * TODO
     * 1339. Maximum Product of Splitted Binary Tree
     * 分裂二叉树的最大乘积
     */
    @Test
    public void maxProduct() {
        Integer[][] testCase = {
            {1, 2, 3, 4, 5, 6},
            {1, null, 2, 3, 4, null, null, 5, 6}
        };
        for (Integer[] caseItem : testCase) {
            System.out.println(solution1500.maxProduct(Helper.buildTreeNode(caseItem)));
        }
    }

    /**
     * 1342. Number of Steps to Reduce a Number to Zero
     * 将数字变成 0 的操作次数
     */
    @Test
    public void numberOfSteps() {
        int[] testCase = {14, 8, 123};
        for (int caseItem : testCase) {
            System.out.println(solution1500.numberOfSteps(caseItem));
        }
    }

    /**
     * 1351. Count Negative Numbers in a Sorted Matrix
     * 统计有序矩阵中的负数
     */
    @Test
    public void countNegatives() {
        int[][][] testCase = {
            {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}},
            {{3, 2}, {1, 0}},
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1500.countNegatives(caseItem));
        }
    }

    /**
     * 1356. Sort Integers by The Number of 1 Bits
     * 根据数字二进制下 1 的数目排序
     */
    @Test
    public void sortByBits() {
        int[][] testCase = {
            {0},
            {1, 0},
            {0, 1, 2, 3, 4, 5, 6, 7, 8},
            {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1},
            {2, 9, 3, 2},
            {2, 9, 3, 3, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.sortByBits(caseItem)));
        }
    }

    /**
     * 1365. How Many Numbers Are Smaller Than the Current Number
     * 有多少小于当前数字的数字
     */
    @Test
    public void smallerNumbersThanCurrent() {
        int[][] testCase = {
            {8, 1, 2, 2, 3},
            {6, 5, 4, 8},
            {7, 7, 7, 7}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.smallerNumbersThanCurrent(caseItem)));
        }
    }

    /**
     * 1370. Increasing Decreasing String
     * 上升下降字符串
     */
    @Test
    public void sortString() {
        String[] testCase = {
            "aaaabbbbcccc",
            "rat",
            "leetcode",
            "ggggggg",
            "spo"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1500.sortString(caseItem));
        }
    }

    /**
     * 1374. Generate a String With Characters That Have Odd Counts
     * 生成每种字符都是奇数个的字符串
     */
    @Test
    public void generateTheString() {
        int[] testCase = {4, 2, 7};
        for (int caseItem : testCase) {
            System.out.println(solution1500.generateTheString(caseItem));
        }
    }

    /**
     * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
     * 找出克隆二叉树中的相同节点
     */
    @Test
    public void getTargetCopy() {
        Integer[][][] testCase = {
            {
                {7, 4, 3, null, null, 6, 19}, {3}
            },
            {
                {7}, {7}
            },
            {
                {8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1}, {4}
            }
        };
        for (Integer[][] caseItem : testCase) {
            TreeNode root = Helper.buildTreeNode(caseItem[0]);
            TreeNode clone = Helper.buildTreeNode(caseItem[0]);
            TreeNode target = Helper.buildTreeNode(caseItem[1]);
            System.out.println(solution1500.getTargetCopy(root, clone, target).val);
        }
    }

    /**
     * 1389. Create Target Array in the Given Order
     * 按既定顺序创建目标数组
     */
    @Test
    public void createTargetArray() {
        int[][][] testCase = {
            {
                {0, 1, 2, 3, 4}, {0, 1, 2, 2, 1}
            },
            {
                {1, 2, 3, 4, 0}, {0, 1, 2, 3, 0}
            },
            {
                {1}, {0}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.createTargetArray(caseItem[0], caseItem[1])));
        }
    }

    /**
     * 1431. Kids With the Greatest Number of Candies
     * 有最多糖果的孩子
     */
    @Test
    public void kidsWithCandies() {
        int[][][] testCase = {
            {
                {2,3,5,1,3}, {3}
            },
            {
                {4,2,1,1,2}, {1}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1500.kidsWithCandies(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 1450. Number of Students Doing Homework at a Given Time
     * 在既定时间做作业的学生人数
     */
    @Test
    public void busyStudent() {
        int[][][] testCase = {
            {
                {1, 2, 3}, {3, 2, 7}, {4}
            },
            {
                {4}, {4}, {4}
            },
            {
                {4}, {4}, {5}
            },
            {
                {1, 1, 1, 1}, {1, 3, 2, 4}, {7}
            },
            {
                {9, 8, 7, 6, 5, 4, 3, 2, 1}, {10, 10, 10, 10, 10, 10, 10, 10, 10}, {5}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1500.busyStudent(caseItem[0], caseItem[1], caseItem[2][0]));
        }
    }

    /**
     * 1460. Make Two Arrays Equal by Reversing Subarrays
     * 通过翻转子数组使两个数组相等
     */
    @Test
    public void canBeEqual() {
        int[][][] testCase = {
            {
                {1, 2, 3, 4}, {2, 4, 1, 3}
            },
            {
                {7}, {7}
            },
            {
                {3, 7, 9}, {3, 7, 11}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution1500.canBeEqual(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1464. Maximum Product of Two Elements in an Array
     * 数组中两元素的最大乘积
     */
    @Test
    public void maxProduct1464() {
        int[][] testCase = {
            {3, 4, 5, 2},
            {1, 5, 4, 5},
            {3, 7},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.maxProduct(caseItem));
        }
    }

    /**
     * 1470. Shuffle the Array
     * 重新排列数组
     */
    @Test
    public void shuffle() {
        int[][] testCase = {
            {2, 5, 1, 3, 4, 7},
            {1, 2, 3, 4, 4, 3, 2, 1},
            {1, 1, 2, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.shuffle(caseItem, caseItem.length / 2)));
        }
    }

    /**
     * 1475. Final Prices With a Special Discount in a Shop
     * 商品折扣后的最终价格
     */
    @Test
    public void finalPrices() {
        int[][] testCase = {
            {8, 4, 6, 2, 3},
            {1, 2, 3, 4, 5},
            {10, 1, 1, 6}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.finalPrices(caseItem)));
        }
    }

    /**
     * 1480. Running Sum of 1d Array
     * 一维数组的动态和
     */
    @Test
    public void runningSum() {
        int[][] testCase = {
            {1, 2, 3, 4},
            {1, 1, 1, 1, 1},
            {3, 1, 2, 10, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution1500.runningSum(caseItem)));
        }
    }

    /**
     * 1486. XOR Operation in an Array
     * 数组异或操作
     */
    @Test
    public void xorOperation() {
        int[][] testCase = {
            {5, 0},
            {4, 3},
            {1, 7},
            {10, 5}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.xorOperation(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1491. Average Salary Excluding the Minimum and Maximum Salary
     * 去掉最低工资和最高工资后的工资平均值
     */
    @Test
    public void average() {
        int[][] testCase = {
            {4000, 3000, 1000, 2000},
            {1000, 2000, 3000},
            {6000, 5000, 4000, 3000, 2000, 1000},
            {8000, 9000, 2000, 3000, 6000, 1000}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1500.average(caseItem));
        }
    }

    /**
     * 1502. Can Make Arithmetic Progression From Sequence
     * 判断能否形成等差数列
     */
    @Test
    public void canMakeArithmeticProgression() {
        int[][] testCase = {
            {3, 5, 1},
            {1, 2, 4}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.canMakeArithmeticProgression(caseItem));
        }
    }

    /**
     * 1512. Number of Good Pairs
     * 好数对的数目
     */
    @Test
    public void numIdenticalPairs() {
        int[][] testCase = {
            {1, 2, 3, 1, 1, 3},
            {1, 1, 1, 1},
            {1, 2, 3},
            {1, 2, 3, 4, 4, 3, 2, 1},
            {1, 1, 2, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.numIdenticalPairs(caseItem));
        }
    }

    /**
     * 1523. Count Odd Numbers in an Interval Range
     * 在区间范围内统计奇数数目
     */
    @Test
    public void countOdds() {
        int[][] testCase = {
            {3, 8},
            {3, 7},
            {8, 10},
            {3, 5},
            {4, 9},
            {2, 4},
            {7, 8},
            {3, 5},
            {278382788, 569302584}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.countOdds(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1528. Shuffle String
     * 重新排列字符串
     */
    @Test
    public void restoreString() {
        String[][] testCase = {
            {"codeleet", "4,5,6,7,0,2,1,3"},
            {"abc", "0,1,2"},
        };
        for (String[] caseItem : testCase) {
            String[] result = caseItem[1].split(",");
            int[] indices = new int[result.length];
            for (int i = 0, len = indices.length; i < len; i++) {
                indices[i] = caseItem[1].split(",")[i].charAt(0) - '0';
            }
            System.out.println(solution2000.restoreString(caseItem[0], indices));
        }
    }

    /**
     * 1534. Count Good Triplets
     * 统计好三元组
     */
    @Test
    public void countGoodTriplets() {
        int[][][] testCase = {
            {
                {4, 9, 9, 8, 9, 5, 3, 7},
                {7}, {2}, {3}
            },
            {
                {3, 0, 1, 1, 9, 7},
                {7}, {2}, {3}
            },
            {
                {1, 1, 2, 2, 3},
                {0}, {0}, {1}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2000.countGoodTriplets(caseItem[0], caseItem[1][0], caseItem[2][0], caseItem[3][0]));
        }
    }

    /**
     * 1572. Matrix Diagonal Sum
     * 矩阵对角线元素的和
     */
    @Test
    public void diagonalSum() {
        int[][][] testCase = {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
            },
            {
                {5}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2000.diagonalSum(caseItem));
        }
    }

    /**
     * 1588. Sum of All Odd Length Subarrays
     * 所有奇数长度子数组的和
     */
    @Test
    public void sumOddLengthSubarrays() {
        int[][] testCase = {
            {1, 4, 2, 5, 3},
            {1, 2},
            {10, 11, 12}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.sumOddLengthSubarrays(caseItem));
        }
    }

    /**
     * 1603. Design Parking System
     * 设计停车系统
     */
    @Test
    public void designParkingSystem() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

    /**
     * 1614. Maximum Nesting Depth of the Parentheses
     * 括号的最大嵌套深度
     */
    @Test
    public void maxDepth1614() {
        String[] testCase = {
            "(1+(2*3)+((8)/4))+1",
            "(1)+((2))+(((3)))"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.maxDepth(caseItem));
        }
    }

    /**
     * 1662. Check If Two String Arrays are Equivalent
     * 检查两个字符串数组是否相等
     */
    @Test
    public void arrayStringsAreEqual() {
        String[][][] testCase = {
            {
                {"ab", "c"}, {"a", "bc"},
            },
            {
                {"a", "cb"}, {"ab", "c"},
            },
            {
                {"abc", "d", "defg"}, {"abcddefg"},
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2000.arrayStringsAreEqual(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1656. Design an Ordered Stream
     * 设计有序流
     */
    @Test
    public void designOrderedStream() {
        OrderedStream os= new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }

    /**
     * 1672. Richest Customer Wealth
     * 最富有客户的资产总量
     */
    @Test
    public void maximumWealth() {
        int[][][] testCase = {
            {{1, 2, 3}, {3, 2, 1}},
            {{1, 5}, {7, 3}, {3, 5}},
            {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2000.maximumWealth(caseItem));
        }
    }

    /**
     * 1678. Goal Parser Interpretation
     * 设计 Goal 解析器
     */
    @Test
    public void interpret() {
        String[] testCase = {"G()(al)", "G()()()()(al)", "(al)G(al)()()G"};
        for (String caseItem : testCase) {
            System.out.println(solution2000.interpret(caseItem));
        }
    }

    /**
     * 1684. Count the Number of Consistent Strings
     * 统计一致字符串的数目
     */
    @Test
    public void countConsistentStrings() {
        String[][][] testCase = {
            {
                {"ab"},
                {"ad", "bd", "aaab", "baa", "badab"}
            },
            {
                {"abc"},
                {"a", "b", "c", "ab", "ac", "bc", "abc"}
            },
            {
                {"cad"},
                {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2000.countConsistentStrings(caseItem[0][0], caseItem[1]));
        }
    }

    /**
     * 1688. Count of Matches in Tournament
     * 比赛中的配对次数
     */
    @Test
    public void numberOfMatches() {
        int[] testCase = {2, 7, 14};
        for (int caseItem : testCase) {
            System.out.println(solution2000.numberOfMatches(caseItem));
        }
    }

    /**
     * 1704. Determine if String Halves Are Alike
     * 判断字符串的两半是否相似
     */
    @Test
    public void halvesAreAlike() {
        String[] testCase = {"book", "textbook"};
        for (String caseItem : testCase) {
            System.out.println(solution2000.halvesAreAlike(caseItem));
        }
    }

    /**
     * 1720. Decode XORed Array
     * 解码异或后的数组
     */
    @Test
    public void decode() {
        int[][][] testCase = {
            {
                {1, 2, 3},
                {1}
            },
            {
                {6, 2, 7, 3},
                {4}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.decode(caseItem[0], caseItem[1][0])));
        }
    }

    /**
     * 1725. Number Of Rectangles That Can Form The Largest Square
     * 可以形成最大正方形的矩形数目
     */
    @Test
    public void countGoodRectangles() {
        int[][][] testCase = {
            {{5, 8}, {3, 9}, {5, 12}, {16, 5}},
            {{2, 3}, {3, 7}, {4, 3}, {3, 7}}
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2000.countGoodRectangles(caseItem));
        }
    }

    /**
     * 1732. Find the Highest Altitude
     * 找到最高海拔
     */
    @Test
    public void largestAltitude() {
        int[][] testCase = {
            {-5, 1, 5, 0, -7},
            {-4, -3, -2, -1, 4, 3, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.largestAltitude(caseItem));
        }
    }

    /**
     * 1742. Maximum Number of Balls in a Box
     * 盒子中小球的最大数量
     */
    @Test
    public void countBalls() {
        int[][] testCase = {
            {1, 10},
            {5, 15},
            {19, 28},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.countBalls(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1748. Sum of Unique Elements
     * 唯一元素的和
     */
    @Test
    public void sumOfUnique() {
        int[][] testCase = {
            {1, 2, 3, 2},
            {1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.sumOfUnique(caseItem));
        }
    }

    /**
     * 1768. Merge Strings Alternately
     * 交替合并字符串
     */
    @Test
    public void mergeAlternately() {
        String[][] testCase = {
            {"abc", "pqr"},
            {"ab", "pqrs"},
            {"abcd", "pq"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.mergeAlternately(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1773. Count Items Matching a Rule
     * 统计匹配检索规则的物品数量
     */
    @Test
    public void countMatches() {
        String[][][][] testCase = {
            {
                {
                    {"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}
                },
                {
                    {"color"}, {"silver"}
                }
            },
            {
                {
                    {"phone", "blue", "pixel"}, {"computer", "silver", "phone"}, {"phone", "gold", "iphone"}
                },
                {
                    {"type"}, {"phone"}
                }
            }
        };
        List<List<String>> items;
        for (String[][][] caseItem : testCase) {
            items = new ArrayList<>();
            for (String[] content : caseItem[0]) {
                items.add(Arrays.asList(content));
            }
            System.out.println(solution2000.countMatches(items, caseItem[1][0][0], caseItem[1][1][0]));
        }
    }

    /**
     * 1779. Find Nearest Point That Has the Same X or Y Coordinate
     * 找到最近的有相同 X 或 Y 坐标的点
     */
    @Test
    public void nearestValidPoint() {
        int[][][][] testCase = {
            {
                {{3}},
                {{4}},
                {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}}
            },
            {
                {{3}},
                {{4}},
                {{4, 4}}
            },
            {
                {{3}},
                {{4}},
                {{2, 3}}
            }
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(solution2000.nearestValidPoint(caseItem[0][0][0], caseItem[1][0][0], caseItem[2]));
        }
    }

    /**
     * 1790. Check if One String Swap Can Make Strings Equal
     * 仅执行一次字符串交换能否使两个字符串相等
     */
    @Test
    public void areAlmostEqual() {
        String[][] testCase = {
            {"bank", "kanb"},
            {"attack", "defend"},
            {"kelb", "kelb"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.areAlmostEqual(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1791. Find Center of Star Graph
     * 找出星型图的中心节点
     */
    @Test
    public void findCenter() {
        int[][][] testCase = {
            {{1, 2}, {2, 3}, {4, 2}},
            {{1, 2}, {5, 1}, {1, 3}, {1, 4}}
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2000.findCenter(caseItem));
        }
    }

    /**
     * 1816. Truncate Sentence
     * 截断句子
     */
    @Test
    public void truncateSentence() {
        String[][] testCase = {
            {"Hello how are you Contestant", "4"},
            {"What is the solution to this problem", "4"},
            {"chopper is not a tanuki", "5"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.truncateSentence(caseItem[0], Integer.parseInt(caseItem[1])));
        }
    }

    /**
     * 1812. Determine Color of a Chessboard Square
     * 判断国际象棋棋盘中一个格子的颜色
     */
    @Test
    public void squareIsWhite() {
        String[][] testCase = {
            {"a1"},
            {"h3"},
            {"c7"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.squareIsWhite(caseItem[0]));
        }
    }

    /**
     * 1822. Sign of the Product of an Array
     * 数组元素积的符号
     */
    @Test
    public void arraySign() {
        int[][] testCase = {
            {-1, -2, -3, -4, 3, 2, 1},
            {1, 5, 0, 2, -3},
            {-1, 1, -1, 1, -1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.arraySign(caseItem));
        }
    }

    /**
     * 1827. Minimum Operations to Make the Array Increasing
     * 最少操作使数组递增
     */
    @Test
    public void minOperations() {
        int[][] testCase = {
            {1, 1, 1},
            {1, 5, 2, 4, 1},
            {8}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.minOperations(caseItem));
        }
    }

    /**
     * 1832. Check if the Sentence Is Pangram
     * 判断句子是否为全字母句
     */
    @Test
    public void checkIfPangram() {
        String[] testCase = {
            "thequickbrownfoxjumpsoverthelazydog",
            "leetcode"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.checkIfPangram(caseItem));
        }
    }

    /**
     * 1837. Sum of Digits in Base K
     * K 进制表示下的各位数字总和
     */
    @Test
    public void sumBase() {
        int[][] testCase = {
            {68, 2},
            {34, 6},
            {10, 10}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.sumBase(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 1844. Replace All Digits with Characters
     * 将所有数字用字符替换
     */
    @Test
    public void replaceDigits() {
        String[] testCase = {
            "a1c1e1",
            "a1b2c3d4e"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.replaceDigits(caseItem));
        }
    }

    /**
     * 1859. Sorting the Sentence
     * 将句子排序
     */
    @Test
    public void sortSentence() {
        String[] testCase = {
            "is2 sentence4 This1 a3",
            "Myself2 Me1 I4 and3"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.sortSentence(caseItem));
        }
    }

    /**
     * 1880. Check if Word Equals Summation of Two Words
     * 检查某单词是否等于两单词之和
     */
    @Test
    public void isSumEqual() {
        String[][] testCase = {
            {"acb", "cba", "cdb"},
            {"aaa", "a", "aab"},
            {"aaa", "a", "aaaa"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.isSumEqual(caseItem[0], caseItem[1], caseItem[2]));
        }
    }

    /**
     * 1913. Maximum Product Difference Between Two Pairs
     * 两个数对之间的最大乘积差
     */
    @Test
    public void maxProductDifference() {
        int[][] testCase = {
            {5, 6, 2, 7, 4},
            {4, 2, 5, 9, 7, 4, 8},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.maxProductDifference(caseItem));
        }
    }

    /**
     * 1920. Build Array from Permutation
     * 基于排列构建数组
     */
    @Test
    public void buildArray() {
        int[][] testCase = {
            {0, 2, 1, 5, 3, 4},
            {5, 0, 1, 2, 3, 4},
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.buildArray(caseItem)));
        }
    }

    /**
     * 1941. Check if All Characters Have Equal Number of Occurrences
     * 检查是否所有字符出现次数相同
     */
    @Test
    public void areOccurrencesEqual() {
        String[] testCase = {"abacbc", "aaabb"};
        for (String caseItem : testCase) {
            System.out.println(solution2000.areOccurrencesEqual(caseItem));
        }
    }

    /**
     * 1967. Number of Strings That Appear as Substrings in Word
     * 作为子字符串出现在单词中的字符串数目
     */
    @Test
    public void numOfStrings() {
        String[][][] testCase = {
            {
                {"a", "abc", "bc", "d"},
                {"abc"}
            },
            {
                {"a","b","c"},
                {"aaaaabbbbb"}
            },
            {
                {"a","a","a"},
                {"ab"}
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2000.numOfStrings(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 1974. Minimum Time to Type Word Using Special Typewriter
     * 使用特殊打字机键入单词的最少时间
     */
    @Test
    public void minTimeToType() {
        String[] testCase = {
            "abc",
            "bza",
            "zjpc"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.minTimeToType(caseItem));
        }
    }

    /**
     * 1979. Find Greatest Common Divisor of Array
     * 找出数组的最大公约数
     */
    @Test
    public void findGCD() {
        int[][] testCase = {
            {8, 5, 8, 7, 4},
            {2, 5, 6, 9, 10},
            {7, 5, 6, 8, 3},
            {3, 3},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.findGCD(caseItem));
        }
    }

    /**
     * 2000. Reverse Prefix of Word
     * 反转单词前缀
     */
    @Test
    public void reversePrefix() {
        String[][] testCase = {
            {"abcdefd", "d"},
            {"xyxzxe", "z"},
            {"abcd", "z"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.reversePrefix(caseItem[0], caseItem[1].charAt(0)));
        }
    }

    /**
     * 2006. Count Number of Pairs With Absolute Difference K
     * 差的绝对值为 K 的数对数目
     */
    @Test
    public void countKDifference() {
        int[][][] testCase = {
            {
                {1, 2, 2, 1},
                {1}
            },
            {
                {1, 3},
                {3}
            },
            {
                {3, 2, 1, 5, 4},
                {2}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.countKDifference(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2011. Final Value of Variable After Performing Operations
     * 执行操作后的变量值
     */
    @Test
    public void finalValueAfterOperations() {
        String[][] testCase = {
            {"--X", "X++", "X++"},
            {"++X", "++X", "X++"},
            {"X++", "++X", "--X", "X--"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.finalValueAfterOperations(caseItem));
        }
    }

    /**
     * 2032. Two Out of Three
     * 至少在两个数组中出现的值
     */
    @Test
    public void twoOutOfThree() {
        int[][][] testCase = {
            {
                {1, 1, 3, 2},
                {2, 3},
                {3}
            },
            {
                {3, 1},
                {2, 3},
                {1, 2},
            },
            {
                {1, 2, 2},
                {4, 3, 3},
                {5},
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.twoOutOfThree(caseItem[0], caseItem[1], caseItem[2]));
        }
    }

    /**
     * 2037. Minimum Number of Moves to Seat Everyone
     * 使每位学生都有座位的最少移动次数
     */
    @Test
    public void minMovesToSeat() {
        int[][][] testCase = {
            {
                {3, 1, 5},
                {2, 7, 4}
            },
            {
                {4, 1, 5, 9},
                {1, 3, 2, 6}
            },
            {
                {2, 2, 6, 6},
                {1, 3, 2, 6}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.minMovesToSeat(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2053. Kth Distinct String in an Array
     * 数组中第 K 个独一无二的字符串
     */
    @Test
    public void kthDistinct() {
        String[][][] testCase = {
            {
                {"d", "b", "c", "b", "c", "a"},
                {"2"}
            },
            {
                {"aaa", "aa", "a"},
                {"1"}
            },
            {
                {"a", "b", "a"},
                {"3"}
            },
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2500.kthDistinct(caseItem[0], Integer.parseInt(caseItem[1][0])));
        }
    }

    /**
     * 2089. Find Target Indices After Sorting Array
     * 找出数组排序后的目标下标
     */
    @Test
    public void targetIndices() {
        int[][][] testCase = {
            {
                {1, 2, 5, 2, 3},
                {2}
            },
            {
                {1, 2, 5, 2, 3},
                {3}
            },
            {
                {1, 2, 5, 2, 3},
                {5}
            },
            {
                {1, 2, 5, 2, 3},
                {4}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.targetIndices(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2103. Rings and Rods
     * 环和杆
     */
    @Test
    public void countPoints() {
        String[] testCase = {
            "B0B6G0R6R0R6G9",
            "B0R0G0R9R0B0G0",
            "G4",
        };
        for (String caseItem : testCase) {
            System.out.println(solution2500.countPoints(caseItem));
        }
    }

    /**
     * 2108. Find First Palindromic String in the Array
     * 找出数组中的第一个回文字符串
     */
    @Test
    public void firstPalindrome() {
        String[][] testCase = {
            {"abc", "car", "ada", "racecar", "cool"},
            {"notapalindrome", "racecar"},
            {"def", "ghi"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.firstPalindrome(caseItem));
        }
    }

    /**
     * 2114. Maximum Number of Words Found in Sentences
     * 句子中的最多单词数
     */
    @Test
    public void mostWordsFound() {
        String[][] testCase = {
            {"alice and bob love leetcode", "i think so too", "this is great thanks very much"},
            {"please wait", "continue to fight", "continue to win"},
            {"helloworld"},
            {"v"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.mostWordsFound(caseItem));
        }
    }

    /**
     * 2119. A Number After a Double Reversal
     * 反转两次的数字
     */
    @Test
    public void isSameAfterReversals() {
        int[] testCase = {
            526,
            1800,
            0
        };
        for (int caseItem : testCase) {
            System.out.println(solution2500.isSameAfterReversals(caseItem));
        }
    }

    /**
     * 2154. Keep Multiplying Found Values by Two
     * 将找到的值乘以 2
     */
    @Test
    public void findFinalValue() {
        int[][][] testCase = {
            {{161, 28, 640, 264, 81, 561, 320, 2, 61, 244, 183, 108, 773, 61, 976, 122, 988, 2, 370, 392, 488, 375, 349, 432, 713, 563}, {61}},
            {{5, 3, 6, 1, 12}, {3}},
            {{2, 7, 9}, {4}},
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.findFinalValue(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2160. Minimum Sum of Four Digit Number After Splitting Digits
     * 拆分数位后四位数字的最小和
     */
    @Test
    public void minimumSum() {
        int[] testCase = {
            4009,
            2932
        };
        for (int caseItem : testCase) {
            System.out.println(solution2500.minimumSum(caseItem));
        }
    }

    /**
     * 2169. Count Operations to Obtain Zero
     * 得到 0 的操作数
     */
    @Test
    public void countOperations() {
        int[][] testCase = {
            {2, 3},
            {10, 10}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2500.countOperations(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2176. Count Equal and Divisible Pairs in an Array
     * 统计数组中相等且可以被整除的数对
     */
    @Test
    public void countPairs() {
        int[][][] testCase = {
            {
                {5, 5, 9, 2, 5, 5, 9, 2, 2, 5, 5, 6, 2, 2, 5, 2, 5, 4, 3},
                {7}
            },
            {
                {3, 1, 2, 2, 2, 1, 3},
                {2}
            },
            {
                {1, 2, 3, 4},
                {1}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.countPairs(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2181. Merge Nodes in Between Zeros
     * 合并零之间的节点
     */
    @Test
    public void mergeNodes() {
        int[][] testCase = {
            {0, 3, 1, 0, 4, 5, 2, 0},
            {0, 1, 0, 3, 0, 2, 2, 0}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution2500.mergeNodes(head));
        }
    }

    /**
     * 2185. Counting Words With a Given Prefix
     * 统计包含给定前缀的字符串
     */
    @Test
    public void prefixCount() {
        String[][][] testCase = {
            {
                {"pay", "attention", "practice", "attend"}, {"at"}
            },
            {
                {"leetcode","win","loops","success"}, {"code"}
            }
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2500.prefixCount(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2194. Cells in a Range on an Excel Sheet
     * Excel 表中某个范围内的单元格
     */
    @Test
    public void cellsInRange() {
        String[] testCase = {
            "K1:L2",
            "A1:F1"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2500.cellsInRange(caseItem));
        }
    }

    /**
     * 2206. Divide Array Into Equal Pairs
     * 将数组划分成相等数对
     */
    @Test
    public void divideArray() {
        int[][] testCase = {
            {3, 2, 3, 2, 2, 2},
            {1, 2, 3, 4},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2500.divideArray(caseItem));
        }
    }

    /**
     * 2215. Find the Difference of Two Arrays
     * 找出两数组的不同
     */
    @Test
    public void findDifference() {
        int[][][] testCase = {
            {
                {1, 2, 3},
                {2, 4, 6},
            },
            {
                {1, 2, 3, 3},
                {1, 1, 2, 2},
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.findDifference(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2220. Minimum Bit Flips to Convert Number
     * 转换数字的最少位翻转次数
     */
    @Test
    public void minBitFlips() {
        Integer[][] testCase = {
            {10, 7},
            {3, 4},
        };
        for (Integer[] caseItem : testCase) {
            System.out.println(solution2500.minBitFlips(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2236. Root Equals Sum of Children
     * 判断根结点是否等于子结点之和
     */
    @Test
    public void checkTree() {
        Integer[][] testCase = {
            {10, 4, 6},
            {5, 3, 1}
        };
        for (Integer[] caseItem : testCase) {
            System.out.println(solution2500.checkTree(Helper.buildTreeNode(caseItem)));
        }
    }

    /**
     * 2255. Count Prefixes of a Given String
     * 统计是给定字符串前缀的字符串数目
     */
    @Test
    public void countPrefixes() {
        String[][][] testCase = {
            {
                {"a", "b", "c", "ab", "bc", "abc"}, {"abc"}
            },
            {
                {"a", "a"}, {"aa"}
            },
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution2500.countPrefixes(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2278. Percentage of Letter in String
     * 字母在字符串中的百分比
     */
    @Test
    public void percentageLetter() {
        String[][] testCase = {
            {"foobar", "o"},
            {"jjjj", "k"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.percentageLetter(caseItem[0], caseItem[1].charAt(0)));
        }
    }

    /**
     * 2283. Check if Number Has Equal Digit Count and Digit Value
     * 判断一个数的数字计数是否等于数位的值
     */
    @Test
    public void digitCount() {
        String[] testCase = {"1210", "030"};
        for (String caseItem : testCase) {
            System.out.println(solution2500.digitCount(caseItem));
        }
    }

    /**
     * 2315. Count Asterisks
     * 统计星号
     */
    @Test
    public void countAsterisks() {
        String[] testCase = {
            "yo|uar|e**|b|e***au|tifu|l",
            "l|*e*et|c**o|*de|",
            "iamprogrammer",
        };
        for (String caseItem : testCase) {
            System.out.println(solution2500.countAsterisks(caseItem));
        }
    }

    /**
     * 2325. Decode the Message
     * 密消息
     */
    @Test
    public void decodeMessage() {
        String[][] testCase = {
            {"the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"},
            {"eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.decodeMessage(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2331. Evaluate Boolean Binary Tree
     * 计算布尔二叉树的值
     */
    @Test
    public void evaluateTree() {
        Integer[][] testCase = {
            {2, 1, 3, null, null, 0, 1},
            {0}
        };
        for (Integer[] caseItem : testCase) {
            TreeNode root = Helper.buildTreeNode(caseItem);
            System.out.println(solution2500.evaluateTree(root));
        }
    }

    /**
     * 2341. Maximum Number of Pairs in Array
     * 数组能形成多少数对
     */
    @Test
    public void numberOfPairs() {
        int[][] testCase = {
            {1, 3, 2, 1, 3, 2, 2},
            {1, 1},
            {0},
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2500.numberOfPairs(caseItem)));
        }
    }

    /**
     * 2351. First Letter to Appear Twice
     * 第一个出现两次的字母
     */
    @Test
    public void repeatedCharacter() {
        String[] testCase = {
            "abccbaacz",
            "abcdd",
        };
        for (String caseItem : testCase) {
            System.out.println(solution2500.repeatedCharacter(caseItem));
        }
    }

    /**
     * 2357. Make Array Zero by Subtracting Equal Amounts
     * 使数组中所有元素都等于零
     */
    @Test
    public void minimumOperations() {
        int[][] testCase = {
            {1, 5, 0, 3, 5},
            {0},
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2500.minimumOperations(caseItem));
        }
    }

    /**
     * 2363. Merge Similar Items
     * 合并相似的物品
     */
    @Test
    public void mergeSimilarItems() {
        int[][][][] testCase = {
            {
                {{1, 1}, {4, 5}, {3, 8}},
                {{3, 1}, {1, 5}}
            },
            {
                {{1, 1}, {3, 2}, {2, 3}},
                {{2, 1}, {3, 2}, {1, 3}}
            },
            {
                {{1, 3}, {2, 2}},
                {{7, 1}, {2, 2}, {1, 4}}
            },
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(solution2500.mergeSimilarItems(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2367. Number of Arithmetic Triplets
     * 算术三元组的数目
     */
    @Test
    public void arithmeticTriplets() {
        int[][][] testCase = {
            {
                {0, 1, 4, 6, 7, 10}, {3}
            },
            {
                {4, 5, 6, 7, 8, 9}, {2}
            },
            {
                {4, 5, 6, 7, 8, 9}, {3}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.arithmeticTriplets(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2373. Largest Local Values in a Matrix
     * 矩阵中的局部最大值
     */
    @Test
    public void largestLocal() {
        int[][][] testCase = {
            {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}},
            {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}}
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.deepToString(solution2500.largestLocal(caseItem)));
        }
    }

    /**
     * 2396. Strictly Palindromic Number
     * 严格回文的数字
     */
    @Test
    public void isStrictlyPalindromic() {
        int[] testCase = {9, 4, 6, 11, 19, 47, 53, 79, 103, 137, 139, 149, 163, 167, 179, 223, 263, 269, 283, 293};
        for (int caseItem : testCase) {
            System.out.println(solution2500.isStrictlyPalindromic(caseItem));
        }
    }

    /**
     * 2418. Sort the People
     * 按身高排序
     */
    @Test
    public void sortPeople() {
        String[][][] testCase = {
            {
                {"Mary", "John", "Emma"},
                {"180", "165", "170"}
            },
            {
                {"Alice", "Bob", "Bob"},
                {"155", "185", "150"}
            },
        };
        for (String[][] caseItem : testCase) {
            int[] heights = new int[caseItem[1].length];

            for (int i = 0 , len = heights.length; i< len; i++) {
                heights[i] = Integer.parseInt(caseItem[1][i]);
            }
            System.out.println(Arrays.toString(solution2500.sortPeople(caseItem[0], heights)));
        }
    }

    /**
     * 2427. Number of Common Factors
     * 公因子的数目
     */
    @Test
    public void commonFactors() {
        int[][] testCase = {
            {12, 6},
            {25, 30}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2500.commonFactors(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2469. Convert the Temperature
     * 温度转换
     */
    @Test
    public void convertTemperature() {
        double[] testCase = {36.50, 122.11};
        for (double caseItem : testCase) {
            System.out.println(Arrays.toString(solution2500.convertTemperature(caseItem)));
        }
    }

    /**
     * 2485. Find the Pivot Integer
     * 找出中枢整数
     */
    @Test
    public void pivotInteger() {
        int[] testCase = {8, 1, 4};
        for (int caseItem : testCase) {
            System.out.println(solution2500.pivotInteger(caseItem));
        }
    }

    /**
     * 2496. Maximum Value of a String in an Array
     * 数组中字符串的最大值
     */
    @Test
    public void maximumValue() {
        String[][] testCase = {
            {"alic3", "bob", "3", "4", "00000"},
            {"1", "01", "001", "0001"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2500.maximumValue(caseItem));
        }
    }

    /**
     * 2500. Delete Greatest Value in Each Row
     * 删除每行中的最大值
     */
    @Test
    public void deleteGreatestValue() {
        int[][][] testCase = {
            {
                {1, 2, 4},
                {3, 3, 1}
            },
            {
                {10}
            }
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution2500.deleteGreatestValue(caseItem));
        }
    }

    /**
     * 2520. Count the Digits That Divide a Number
     * 统计能整除数字的位数
     */
    @Test
    public void countDigits() {
        int[] testCase = {1, 2, 3, 7, 121, 1248};
        for (int caseItem : testCase) {
            System.out.println(solution3000.countDigits(caseItem));
        }
    }

    /**
     * 2529. Maximum Count of Positive Integer and Negative Integer
     * 正整数和负整数的最大计数
     */
    @Test
    public void maximumCount() {
        int[][] testCase = {
            {-2, -1, -1, 1, 2, 3},
            {-3, -2, -1, 0, 0, 1, 2},
            {5, 20, 66, 1314}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution3000.maximumCount(caseItem));
        }
    }

    /**
     * 2535. Difference Between Element Sum and Digit Sum of an Array
     * 数组元素和与数字和的绝对差
     */
    @Test
    public void differenceOfSum() {
        int[][] testCase = {
            {2, 7, 16, 19, 12, 2, 15, 1, 8, 6, 20, 1, 12, 3, 1, 17, 11, 17, 3, 3},
            {3, 6, 15, 14, 17, 12, 9, 9, 15, 3, 13, 5, 18, 13, 18, 17, 5, 14, 7, 20},
            {2, 7, 8, 10, 8, 10, 1, 10, 5, 9},
            {1, 15, 6, 3},
            {1, 2, 3, 4}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution3000.differenceOfSum(caseItem));
        }
    }

    /**
     * 2553. Separate the Digits in an Array
     * 分割数组中数字的数位
     */
    @Test
    public void separateDigits() {
        int[][] testCase = {
            {32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99},
            {13, 25, 83, 77},
            {7, 1, 3, 9},
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution3000.separateDigits(caseItem)));
        }
    }

    @Test
    public void mergeArrays() {
        int[][][][] testCase = {
            {
                {{1, 2}, {2, 3}, {4, 5}},
                {{1, 4}, {3, 2}, {4, 1}}
            },
            {
                {{2, 4}, {3, 6}, {5, 5}},
                {{1, 3}, {4, 3}}
            },
        };
        for (int[][][] caseItem : testCase) {
            System.out.println(Arrays.deepToString(solution3000.mergeArrays(caseItem[0], caseItem[1])));
        }
    }

    /**
     * 2574. Left and Right Sum Differences
     * 左右元素和的差值
     */
    @Test
    public void leftRigthDifference() {
        int[][] testCase = {
            {10,4,8,3},
            {1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution3000.leftRigthDifference(caseItem)));
        }
    }

    /**
     * 2586. Count the Number of Vowel Strings in Range
     * 统计范围内的元音字符串数
     */
    @Test
    public void vowelStrings() {
        String[][][] testCase = {
            {
                {"are", "amy", "u"},
                {"0"},
                {"2"},
            },
            {
                {"hey", "aeo", "mu", "ooo", "artro"},
                {"1"},
                {"4"},
            },
        };
        for (String[][] caseItem : testCase) {
            System.out.println(solution3000.vowelStrings(caseItem[0], Integer.parseInt(caseItem[1][0]), Integer.parseInt(caseItem[2][0])));
        }
    }

    /**
     * 2643. Row With Maximum Ones
     * 一最多的行
     */
    @Test
    public void rowAndMaximumOnes() {
        int[][][] testCase = {
            {{0, 1}, {1, 0}},
            {{0, 0, 0}, {0, 1, 1}},
            {{0, 0}, {1, 1}, {0, 0}},
        };
        for (int[][] caseItem : testCase) {
            System.out.println(Arrays.toString(solution3000.rowAndMaximumOnes(caseItem)));
        }
    }

    /**
     * 2652. Sum Multiples
     * 倍数求和
     */
    @Test
    public void sumOfMultiples() {
        int[] testCase = {7, 10, 9};
        for (int caseItem : testCase) {
            System.out.println(solution3000.sumOfMultiples(caseItem));
        }
    }

    /**
     * 2651. Calculate Delayed Arrival Time
     * 计算列车到站时间
     */
    @Test
    public void findDelayedArrivalTime() {
        int[][] testCase = {
            {15, 5},
            {13, 11}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution3000.findDelayedArrivalTime(caseItem[0], caseItem[1]));
        }
    }

    /**
     * 2656. Maximum Sum With Exactly K Elements
     * K 个元素的最大和
     */
    @Test
    public void maximizeSum() {
        int[][][] testCase = {
            {
                {1, 2, 3, 4, 5},
                {3}
            },
            {
                {5, 5, 5},
                {2}
            },
        };
        for (int[][] caseItem : testCase) {
            System.out.println(solution3000.maximizeSum(caseItem[0], caseItem[1][0]));
        }
    }

    /**
     * 2670. Find the Distinct Difference Array
     * 找出不同元素数目差数组
     */
    @Test
    public void distinctDifferenceArray() {
        int[][] testCase = {
            {1, 2, 3, 4, 5},
            {3, 2, 3, 4, 2},
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution3000.distinctDifferenceArray(caseItem)));
        }
    }
}
