package com.github.sinton.leetcode.util;

import com.github.sinton.leetcode.inner.*;

import java.util.*;

/**
 * @author Yan
 */
public class Helper {
    /**
     * 链表格式输出
     *
     * @param head
     */
    public static void outputListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(",");
            }
            head = head.next;
        }
        System.out.println();
    }

    /**
     * BFS方式用数组格式输出
     *
     * @param root
     */
    public static List<Integer> outputTreeNode(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> currLevelNodes = new LinkedList<>();
        currLevelNodes.offer(root);
        int height = calTreeHeight(root);
        while (height > 0) {
            Queue<TreeNode> nextLevelNodes = new LinkedList<>();
            while (!currLevelNodes.isEmpty()) {
                TreeNode currNode = currLevelNodes.poll();
                if (currNode == null) {
                    answer.add(null);
                } else {
                    answer.add(currNode.val);
                    nextLevelNodes.offer(currNode.left);
                    nextLevelNodes.offer(currNode.right);
                }
            }
            currLevelNodes.addAll(nextLevelNodes);
            height--;
        }
        return answer;
    }

    public static ListNode buildListNodeWithTestCase() {
        return buildListNodeWithTestCase(-1, -1);
    }

    public static ListNode buildListNodeWithTestCase(int range, int length) {
        return buildListNodeWithTestCase(range, length, length <= 0);
    }

    public static ListNode buildListNodeWithTestCase(int range, int length, boolean randomLength) {
        return buildListNodeWithTestCase(range, range <= 0, length, randomLength);
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
    public static ListNode buildListNodeWithTestCase(int range, boolean randomRange, int length, boolean randomLength) {
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
        TreeNode root = new TreeNode(testCase[index]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(index < len) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                continue;
            }
            index++;
            if (index < len) {
                TreeNode left = testCase[index] == null ? null : new TreeNode(testCase[index]);
                queue.offer(left);
                curr.left = left;
            }
            index++;
            if (index < len) {
                TreeNode right = testCase[index] == null ? null : new TreeNode(testCase[index]);
                queue.offer(right);
                curr.right = right;
            }
        }
        return root;
    }

    /**
     * BFS构建多叉树节点
     *
     * @param testCase
     * @return
     */
    public static Node buildNode(Integer[] testCase) {
        int index = 0;
        int len = testCase.length;
        if (0 == len) {
            return null;
        }
        Node root = new Node(testCase[index++]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (index < len) {
            Node curr = queue.poll();
            if (testCase[index++] == null) {
                List<Node> children = new ArrayList<>();
                while (index < len && testCase[index] != null) {
                    Node childrenNode = new Node(testCase[index]);
                    queue.offer(childrenNode);
                    children.add(childrenNode);
                    curr.children = children;
                    index++;
                }
            }
        }
        return root;
    }

    /**
     * 多维数组转列表集合
     *
     * @param caseItem
     * @return
     */
    public static <T> List<List<T>> buildNestedList(T[][] caseItem) {
        List<List<T>> result = new ArrayList<>();
        for (T[] item : caseItem) {
            result.add(new ArrayList<>(Arrays.asList(item)));
        }
        return result;
    }

    /**
     * 计算树高
     *
     * @param root
     * @return
     * @param <T>
     */
    public static <T> int calTreeHeight(T root) {
        if (root instanceof TreeNode) {
            return calTreeNodeHeight((TreeNode) root);
        }
        if (root instanceof Node) {
            return calNodeHeight((Node) root);
        }
        return 0;
    }

    /**
     * 计算TreeNode类型树高
     *
     * @param root
     * @return
     */
    private static int calTreeNodeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> currLevelNodes = new LinkedList<>();
        currLevelNodes.offer(root);
        while (!currLevelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            while (!currLevelNodes.isEmpty()) {
                TreeNode curr = currLevelNodes.poll();
                if (curr != null) {
                    nextLevelNodes.add(curr.left);
                    nextLevelNodes.add(curr.right);
                }
            }
            if (nextLevelNodes.stream().anyMatch(Objects::nonNull)) {
                currLevelNodes.addAll(nextLevelNodes);
            }
            height++;
        }
        return height;
    }

    /**
     * 计算多叉树Node类型树高
     *
     * @param root
     * @return
     */
    private static int calNodeHeight(Node root) {
        return 0;
    }
}
