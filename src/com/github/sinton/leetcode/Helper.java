package com.github.sinton.leetcode;

import java.util.*;

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
     * 前序BFS构建树节点
     *
     * @param testCase
     * @return
     */
    public static TreeNode buildTreeNode(Integer[] testCase) {
        int index = 0;
        int len = testCase.length;
        if (0 == len) {
            return null;
        }
        TreeNode rootTreeNode = new TreeNode(testCase[index]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootTreeNode);
        while(index < len) {
            TreeNode currTreeNode = queue.poll();
            if (currTreeNode == null) {
                continue;
            }
            index++;
            if (index < len) {
                TreeNode left = testCase[index] == null ? null : new TreeNode(testCase[index]);
                queue.add(left);
                currTreeNode.left = left;
            }
            index++;
            if (index < len) {
                TreeNode right = testCase[index] == null ? null : new TreeNode(testCase[index]);
                queue.add(right);
                currTreeNode.right = right;
            }
        }
        return rootTreeNode;
    }

    /**
     * 多维数组转列表集合
     *
     * @param caseItem
     * @return
     */
    public static List<List<Integer>> convertList(int[][] caseItem) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < caseItem.length; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < caseItem[i].length; j++) {
                item.add(caseItem[i][j]);
            }
            result.add(item);
        }
        return result;
    }
}
