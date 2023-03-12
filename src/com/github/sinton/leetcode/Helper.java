package com.github.sinton.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Yan
 */
public class Helper {
    /**
     * 链表格式输出
     * @param head
     */
    public static void listNodeFormatOutput(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode buildRandomListNode() {
        return buildRandomListNode(-1, -1);
    }

    public static ListNode buildRandomListNode(int range, int length) {
        return buildRandomListNode(range, length, length <= 0);
    }

    public static ListNode buildRandomListNode(int range, int length, boolean randomLength) {
        return buildRandomListNode(range, range <= 0, length, randomLength);
    }

    /**
     * 构建指定范围内的随机长度链表
     *
     * @param range
     * @param randomRange
     * @param length
     * @param randomLength
     * @return
     */
    public static ListNode buildRandomListNode(int range, boolean randomRange, int length, boolean randomLength) {
        int len = randomLength ? new Random().nextInt() : length;
        int[] testCase = new int[len];
        for (int i = 0; i < len; i++) {
            testCase[i] = randomRange ? new Random().nextInt(range) : new Random().nextInt();
        }
        return buildListNode(testCase);
    }

    /**
     * 构建链表节点
     *
     * @param testCase
     * @return
     */
    public static ListNode buildListNode(int[] testCase) {
        ListNode head = null;
        ListNode curr = null;
        for (int caseItem : testCase) {
            if (head != null) {
                curr.next = new ListNode(caseItem);
                curr = curr.next;
            } else {
                head = new ListNode(caseItem);
                curr = head;
            }
        }
        return head;
    }

    /**
     * 前序递归构建树节点
     *
     * @param testCase
     * @return
     */
    public static TreeNode buildTreeNode(Integer[] testCase, int index) {
        TreeNode rootTreeNode = null;
        TreeNode currTreeNode = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0, len = testCase.length; i < len; i++) {
            if (rootTreeNode == null) {
                rootTreeNode = new TreeNode(testCase[i]);
                currTreeNode = rootTreeNode;
            }
            if (i + 1 < len) {
                currTreeNode.left = testCase[i + 1] == null ? null : new TreeNode(testCase[i + 1]);
            }
            if (i + 2 < len) {
                currTreeNode.right = testCase[i + 2] == null ? null : new TreeNode(testCase[i + 2]);
            }
            if (testCase[i] != null) {
                queue.add(currTreeNode);
                if (i + 1 < len && testCase[i + 1] != null) {
                    TreeNode left = new TreeNode(testCase[i + 1]);
                    queue.add(left);
                    currTreeNode.left = left;
                }
                if (i + 2 < len && testCase[i + 2] != null) {
                    TreeNode right = new TreeNode(testCase[i + 2]);
                    queue.add(right);
                    currTreeNode.right = right;
                }
            }
        }
        rootTreeNode.left = buildTreeNode(testCase, 2 * index + 1);
        rootTreeNode.right = buildTreeNode(testCase, 2 * index + 2);
        return rootTreeNode;
    }
}
