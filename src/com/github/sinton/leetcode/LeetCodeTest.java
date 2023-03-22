package com.github.sinton.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Yan
 */
public class LeetCodeTest {
    Solution1000 solution1000 = new Solution1000();
    Solution2000 solution2000 = new Solution2000();

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

    @Test
    public void rob() {
        int[][] testCase = {
            {1},
            {2, 1, 1, 2},
            {1, 2, 3, 1},
            {2, 7, 9, 3, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.rob(caseItem));
        }
    }

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

    @Test
    public void evalRPN() {
        String[][] testCase = {
            {"18"},
            {"2", "1", "+", "3", "*"},
            {"4", "13", "5", "/", "+"},
            {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.evalRPN(caseItem));
        }
    }

    @Test
    public void findTheDifference() {
        String[][] testCase = {
            {"abcd", "abcde"},
            {"", "y"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.findTheDifference(caseItem[0], caseItem[1]));
        }
    }

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
            System.out.println(solution2000.checkStraightLine(caseItem));
        }
    }

    @Test
    public void moveZeroes() {
        int[][] testCase = {
            {2, 1},
            {0, 1, 0, 3, 12},
            {0}
        };
        for (int[] caseItem : testCase) {
            solution1000.moveZeroes(caseItem);
            System.out.println(Arrays.toString(caseItem));
        }
    }

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

    @Test
    public void search() {
        int[][][] testCase = {
//            {
//                {2, 5},
//                {2}
//            },
//            {
//                {5},
//                {5}
//            },
//            {
//                {-1, 0, 3, 5, 9, 12},
//                {9}
//            },
//            {
//                {-1, 0, 3, 5, 9, 12},
//                {2}
//            },
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

    @Test
    public void solutionClimbStairs() {
        int[] testCase = {2, 3, 45};
        for (int caseItem : testCase) {
            System.out.println(solution1000.climbStairs(caseItem));
        }
    }

    @Test
    public void solutionFindKthLargest() {
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
            System.out.println(solution1000.findKthLargest(caseItem[0], caseItem[1][0]));
        }
    }

    @Test
    public void solutionLengthOfLongestSubstring() {
        String[] testCase = {
            "aaabcddd",
            "dvdf",
            "aab",
            "abcabcbb",
            "bbbbb",
            "pwwkew"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1000.lengthOfLongestSubstring(caseItem));
        }
    }

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
            int[][] result = solution1000.merge(caseItem);
            for(int[] item : result) {
                System.out.print(Arrays.toString(item));
            }
            System.out.println();
        }
    }

    @Test
    public void generate() {
        int[] testCase = {5, 1};
        for (int caseItem : testCase) {
            System.out.println(solution1000.generate(caseItem).toString());
        }
    }

    public void solutionNearestValidPoint() {
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

    @Test
    public void solutionMatrixReshape() {
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

    @Test
    public void solutionGetDecimalValue() {
        int[][] testCase = {
            {1, 0, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.getDecimalValue(Helper.buildListNode(caseItem)));
        }
    }

    @Test
    public void solutionMergeNodes() {
        int[][] testCase = {
            {0, 3, 1, 0, 4, 5, 2, 0},
            {0, 1, 0, 3, 0, 2, 2, 0}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution2000.mergeNodes(head));
        }
    }

    @Test
    public void solutionLongestPalindrome() {
        String[] testCase = {
            "abccccdd",
            "a",
            "bb",
            "tattarrattat",
        };
        for (String caseItem : testCase) {
            System.out.println(solution1000.longestPalindrome(caseItem));
        }
    }

    @Test
    public void solutionDiagonalSum() {
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

    @Test
    public void solutionSumOddLengthSubarrays() {
        int[][] testCase = {
            {1, 4, 2, 5, 3},
            {1, 2},
            {10, 11, 12}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.sumOddLengthSubarrays(caseItem));
        }
    }

    @Test
    public void isValid() {
        String[] testCase = {
            "({[)",
            "()",
            "()[]{}",
            "(]"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1000.isValid(caseItem));
        }
    }

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
            Helper.listNodeFormatOutput(solution1000.removeElements(Helper.buildListNode(caseItem[0]), caseItem[1][0]));
        }
    }

    @Test
    public void deleteDuplicates() {
        int[][] testCase = {
            {},
            {0, 0, 0, 0, 0},
            {-1, 0, 0, 0, 0, 3, 3},
            {1, 1, 2},
            {1, 1, 2, 3, 3}
        };
        for (int[] caseItem : testCase) {
            Helper.listNodeFormatOutput(solution1000.deleteDuplicates(Helper.buildListNode(caseItem)));
        }
    }

    @Test
    public void maxDepth() {
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
            System.out.println(solution1000.maxDepth(root4));
        }
    }

    @Test
    public void canConstruct() {
        String[][] testCase = {
            {"a", "b"},
            {"aa", "ab"},
            {"aa", "aab"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.canConstruct(caseItem[0], caseItem[1]));
        }
    }

    @Test
    public void isAnagram() {
        String[][] testCase = {
            {"dgqztusjuu", "dqugjzutsu"},
            {"anagram", "nagaram"},
            {"rat", "car"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.isAnagram(caseItem[0], caseItem[1]));
        }
    }

    @Test
    public void firstUniqChar() {
        String[] testCase = {
            "leetcode",
            "loveleetcode",
            "aabb"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1000.firstUniqChar(caseItem));
        }
    }

    @Test
    public void maxProduct() {
        Integer[][] testCase = {
//            {1, 2, 3, 4, 5, 6},
            {1, null, 2, 3, 4, null, null, 5, 6}
        };
        for (Integer[] caseItem : testCase) {
            System.out.println(solution2000.maxProduct(Helper.buildTreeNode(caseItem, 0)));
        }
    }

    @Test
    public void solutionRangeSumBST() {
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
            System.out.println(solution1000.rangeSumBST(Helper.buildTreeNode(caseItem[0], 0), caseItem[1][0], caseItem[2][0]));;
        }
    }

    @Test
    public void solutionMergeTwoLists() {
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
            Helper.listNodeFormatOutput(solution1000.mergeTwoLists(left, right));
        }
    }

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
            System.out.println(solution1000.divide(caseItem[0], caseItem[1]));
        }
    }

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

    public void reverseList() {
        int[][] testCase = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution1000.reverseList(head));
        }
    }

    @Test
    public void solutionMiddleNode() {
        int[][] testCase = {
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6}
        };
        for (int[] caseItem : testCase) {
            ListNode head = Helper.buildListNode(caseItem);
            Helper.listNodeFormatOutput(solution1000.middleNode(head));
        }
    }

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
            System.out.println(Arrays.toString(solution1000.intersect(caseItem[0], caseItem[1])));
        }
    }

    @Test
    public void solutionMaxProfit() {
        int[][] testCase = {
            {7, 1, 5, 3, 6, 4},
            {7, 6, 4, 3, 1},
            {1, 2},
            {9, 4, 6, 11, 19, 47, 53, 79, 103, 137, 139, 149, 163, 167, 179, 223, 263, 269, 283, 293}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.maxProfit(caseItem));
        }
    }

    @Test
    public void isStrictlyPalindromic() {
        int[] testCase = {9, 4, 6, 11, 19, 47, 53, 79, 103, 137, 139, 149, 163, 167, 179, 223, 263, 269, 283, 293};
        for (int caseItem : testCase) {
            System.out.println(solution2000.isStrictlyPalindromic(caseItem));
        }
    }

    @Test
    public void solutionIsPalindrome() {
        int[] testCase = {3223, 2233, 121, -121, 10, -10};
        for (int caseItem : testCase) {
            System.out.println(solution1000.isPalindrome(caseItem));
        }
    }

    @Test
    public void solutionTwoSum() {
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
            System.out.println(Arrays.toString(solution1000.twoSum(caseItem[0], caseItem[1][0])));
        }
    }

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

    @Test
    public void convertTemperature() {
        double[] testCase = {36.50, 122.11};
        for (double caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.convertTemperature(caseItem)));
        }
    }

    @Test
    public void defangIPaddr() {
        String[] testCase = {"1.1.1.1", "255.100.50.0"};
        for (String caseItem : testCase) {
            System.out.println(solution2000.defangIPaddr(caseItem));
        }
    }

    @Test
    public void solutionMerge88() {
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
            solution1000.merge(caseItem[0], caseItem[1][0], caseItem[2], caseItem[3][0]);
            System.out.println(Arrays.toString(caseItem[0]));
        }
    }

    @Test
    public void solutionIsIsomorphic() {
        String[][] testCase = {
            {"egg", "add"},
            {"foo", "bar"},
            {"paper", "title"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.isIsomorphic(caseItem[0], caseItem[1]));
        }
    }

    @Test
    public void runningSum() {
        int[][] testCase = {
            {1, 2, 3, 4},
            {1, 1, 1, 1, 1},
            {3, 1, 2, 10, 1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.runningSum(caseItem)));
        }
    }
    @Test
    public void finalValueAfterOperations() {
        String[][] testCase = {
            {"--X", "X++", "X++"},
            {"++X", "++X", "X++"},
            {"X++", "++X", "--X", "X--"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.finalValueAfterOperations(caseItem));
        }
    }
    @Test
    public void shuffle() {
        int[][] testCase = {
            {2, 5, 1, 3, 4, 7},
            {1, 2, 3, 4, 4, 3, 2, 1},
            {1, 1, 2, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.shuffle(caseItem, caseItem.length / 2)));
        }
    }

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

    @Test
    public void solutionIsSubsequence() {
        String[][] testCase = {
            {"abc", "ahbgdc"},
            {"axc", "ahbgdc"},
            {"ahbgdc", "ahbgdc"},
            {"bb", "ahbgdc"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.isSubsequence(caseItem[0], caseItem[1]));
        }
    }

    @Test
    public void mostWordsFound() {
        String[][] testCase = {
            {"alice and bob love leetcode", "i think so too", "this is great thanks very much"},
            {"please wait", "continue to fight", "continue to win"},
            {"helloworld"},
            {"v"}
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution2000.mostWordsFound(caseItem));
        }
    }

    @Test
    public void solutionPivotIndex() {
        int[][] testCase = {
            {1, 7, 3, 6, 5, 6},
            {1, 2, 3},
            {2, 1, -1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.pivotIndex(caseItem));
        }
    }

    @Test
    public void solutionLargestPerimeter() {
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

    @Test
    public void solutionContainsDuplicate() {
        int[][] testCase = {
            {1, 2, 3, 1},
            {1, 2, 3, 4},
            {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.containsDuplicate(caseItem));
        }
    }

    @Test
    public void average() {
        int[][] testCase = {
            {4000, 3000, 1000, 2000},
            {1000, 2000, 3000},
            {6000, 5000, 4000, 3000, 2000, 1000},
            {8000, 9000, 2000, 3000, 6000, 1000}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.average(caseItem));
        }
    }

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

    @Test
    public void solutionMaxSubArray() {
        int[][] testCase = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {5, 4, -1, 7, 8},
            {1},
            {-1, -2, -3 , -4},
            {8, -2, -4, -1, -8, 3, 8, 8, 3, 4, 2, -9, -1, -3, -6, 8, -3, 9},
            {-64, 78, 56, 10, -8, 26, -18, 47, -31, 75, 89, 13, 48, -19, -69, 36, -39, 55, -5, -4, -15, -37, -27, -8, -5, 35, -51, 83, 21, -47, 46, 33, -91, -21, -57, 0, 81, 1, -75, -50, -23, -86, 39, -98, -29, 69, 38, 32, 24, -90, -95, 86, -27, -23, -22, 44, -88, 3, 27, 9, 55, -50, -80, 40, 5, -61, -82, -14, 40, -58, 35, 93, -68, -26, 94, 3, -79, 9, -88, 21, 19, -84, 7, 91, -8, 84, 12, -19, -13, -83, 66, -80, -34, 62, 59, 48, -98, 53, -66, 18, 94, 46, 11, -73, 96, -18, 6, -83, 91, 17, 38, 10, 9, -78, -22, 77, 83, 89, -42, -30, -94, -98, -34, -51, 63, -97, 96, 64, 55, -93, -41, 27, 52, 69, 53, 26, -71, -64, 42, -80, 52, -43, 6, -62, -21, 83, -85, -38, 49, -50, 8, 55, -72, 74, 80, 90, 53, 53, 32, -15, 36, 90, -88, -34, 37, 41, 91, 65, 76, 33, 61, 5, 90, -33, 42, -54, -73, 34, -16, 75, 83, 91, 7, -89, 42, -36, 77, -5, -83, 9, 80, 53, -23, 68, -81, 90, 10, -90, 55, -14, 19, -7, 91, -14, 59, 33, 31, 62, -33, -85, 37, -73, 83, -78, -86, 25, -15, 91, 97, 2, -23, 54, -68, 53, 22, -73, 43, -68, -87, -25, 18, 31, 67, -14, 94, 3, -81, 25, -35, -37, 17, 79, -34, -23, -99, -43, -98, -38, -52, 75, 63, 1, 29, 71, -68, -71, 74, 51, -40, 86, -73, 54, -5, 70, -60, -11, -49, -64, 90, -8, -25, -16, -52, 40, 60, -75, 96, 39, -13, -79, 14, -73, 22, -79, 75, 30, -51, 49, -19, -15, 36, -16, -60, -69, -68, -21, -4, -18, -9, -14, 50, 65, 70, 75, -17, 30, 99, -44, -31, -14, -46, 60, -10, 52, 80, -35, -18, -94, -86, 62, -10, 49, -53, 6, 56, -45, 62, -48, 36, -47, 15, -37, -81, -15, -62, -22, 91, -85, 33, -62, -23, 86, 97, 66, 15, 54, -69, 96, 36, -55, 36, -97, 70, 82, 9, 4, -63, -29, 32, 49, 23, -53, 88, 18, 8, -96, 72, -23, -82, 6, 14, -6, -31, -12, -39, 61, -58, -32, 57, 77, 12, -7, 56, -40, -48, -35, 40, -35, 12, -28, 90, -87, -4, 79, 30, 80, 82, -20, -43, 76, 62, 70, -30, -92, -42, 7, 68, -24, 75, 26, -70, -36, 95, 86, 0, -52, -49, -60, 12, 63, -11, -20, 75, 84, -41, -18, 41, -82, 61, 98, 70, 0, 45, -83, 8, -96, 24, -24, -44, -24, -98, -14, 39, 97, -51, -60, -78, -24, -44, 10, -84, 44, 89, 67, 5, -75, -73, -53, -81, 64, -55, 88, -35, 89, -94, 72, 69, 29, -52, -97, 81, -73, -35, 20, -99, 13, 36, 98, 65, 69, 8, 81, 13, -25, 25, 95, -1, 51, -58, -5, 16, -37, -17, 57, -71, -35, 29, 75, 70, 53, 77, 51, 79, -58, -51, 56, 31, 84, 54, -27, 30, -37, -46, -56, 14, 56, -84, 89, 7, -43, -16, 99, 19, 67, 56, 24, -68, -38, -1, -97, -84, -24, 53, 71, -6, -98, 28, -98, 63, -18, -25, -7, 21, 5, 13, -88, -39, 28, -98, 68, 61, -15, 44, -43, -71, 1, 81, -39, 62, -20, -60, 54, 33, 69, 26, -96, 48, -69, -94, 11, -11, -20, 80, 87, 61, -29, 98, -77, 75, 99, 67, 37, -38, 11, 93, -10, 88, 51, 27, 28, -68, 66, -41, 41, 36, 84, 44, -16, 91, 49, 71, -19, -94, 28, -32, 44, 75, -57, 66, 51, -80, 10, -35, -19, 97, -65, 70, 63, 86, -2, -9, 94, -59, 26, 35, 76, 11, -21, -63, -21, -94, 84, 59, 87, 13, -96, 31, -35, -53, -26, -84, -34, 60, -20, 23, 58, 15, -7, 21, -22, 67, 88, -28, -91, 14, -93, 61, -98, -38, 75, -19, -56, 59, -83, -91, -51, -79, 16, 14, -56, 90, 6, -14, 27, 63, -91, -15, -22, -22, 82, 32, -54, 47, -96, -69, -61, 86, 91, -60, -75, 43, -3, -31, 3, -9, -23, 28, 11, 69, -81, 31, 59, 25, -83, -36, -12, -75, 48, 42, -21, 8, -26, 24, -68, -23, 31, -30, -60, 0, -13, -36, -57, 60, 32, 22, -49, 85, -49, 38, 55, -54, -31, -9, 70, -38, 54, -65, -37, -20, 76, 42, 64, -73, -57, 95, -20, 74, -57, 19, -49, 29, 83, -7, -11, -8, -84, 40, -45, -57, -45, 86, -12, 24, -46, -64, 62, -91, -30, -74, -35, -76, 44, -94, -73, 86, 77, 7, 37, -80, -74, 87, 48, 85, -19, -85, -45, -27, 31, 9, -8, 85, -28, 79, -14, 25, 91, -51, 10, -61, -49, 74, -38, 94, 56, -12, 57, 34, 71, -5, 53, 74, -18, -21, 59, 39, -30, 90, -88, -99, -24, 3, 62, 47, -40, -51, -27, -49, -26, 82, -11, 1, 34, 27, -5, -10, 92, -48, -99, 63, 23, 31, 14, -94, -90, -49, 44, -44, -59, 33, -44, 17, -64, -82, -36, -28, -57, 13, 0, -7, -4, 88, 70, -93, -7, -35, -4, -15, -6, -26, -75, 93, -95, 39, 98, 90, 66, 20, -54, -93, -47, -22, 0, -35, -28, 41, 14, -8, -46, -86, 84, 26, -98, 55, 32, -29, 96, -94, 32, -33, -21, 57, -39, -17, -27, -64, -50, -61, 55, -28, -78, 84, 49, 22, -73, -79, -37, 40, 12, -7, 53, -26, -80, 31, -94, 51, -97, -98, 56, 34, -54, -88, -32, -17, -29, 17, 18, 20, 32, -49, 91, 54, -65, 40, -47, -39, 38, -8, -99, -73, 84, 30, 0, -96, -38, 5, 32, -36, -16, -35, 74, 29, -23, -80, -88, 47, 36, 29, -32, -54, 79, -64, 76, 91, 53, -71, -71, -9, -3, -93, 17, -19, 36, 94, -38, 97, -1, 70, -62, 82, -65, -87, 11, 11, -68, -1, -41, 44, -71, 3, 89}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution1000.maxSubArray(caseItem));
        }
    }

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
            System.out.println(Arrays.toString(solution1000.nextGreaterElement(caseItem[0], caseItem[1])));
        }
    }

    @Test
    public void minimumSum() {
        int[] testCase = {
            4009,
            2932
        };
        for (int caseItem : testCase) {
            System.out.println(solution2000.minimumSum(caseItem));
        }
    }

    @Test
    public void getHint() {
        String[][] testCase = {
            {"11", "10"},
            {"1807", "7810"},
            {"1123", "0111"},
        };
        for (String[] caseItem : testCase) {
            System.out.println(solution1000.getHint(caseItem[0], caseItem[1]));
        }
    }

    @Test
    public void numTilings() {
        int[] testCase = {1, 2, 3, 4, 5, 7, 9, 30};
        for (int caseItem : testCase) {
            System.out.println(solution1000.numTilings(caseItem));
        }
    }

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
            System.out.println(Arrays.toString(solution2000.sortByBits(caseItem)));
        }
    }

    @Test
    public void lastStoneWeight() {
        int[][] testCase = {
            {2, 2},
            {2, 7, 4, 1, 8, 1},
            {2, 9, 3, 2}
        };
        for (int[] caseItem : testCase) {
            System.out.println(solution2000.lastStoneWeight(caseItem));
        }
    }

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

    @Test
    public void freqAlphabets() {
        String[] testCase = {
            "1",
            "#",
            "10#11#12",
            "1326#"
        };
        for (String caseItem : testCase) {
            System.out.println(solution2000.freqAlphabets(caseItem));
        }
    }

    @Test
    public void decodeString() {
        String[] testCase = {
            "100[leetcode]",
            "3[a]2[bc]",
            "3[a2[c]]",
            "2[abc]3[cd]ef"
        };
        for (String caseItem : testCase) {
            System.out.println(solution1000.decodeString(caseItem));
        }
    }

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

    @Test
    public void leftRigthDifference() {
        int[][] testCase = {
            {10,4,8,3},
            {1}
        };
        for (int[] caseItem : testCase) {
            System.out.println(Arrays.toString(solution2000.leftRigthDifference(caseItem)));
        }
    }

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
            System.out.println(solution1000.kidsWithCandies(caseItem[0], caseItem[1][0]));
        }
    }

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
            System.out.println(solution1000.searchMatrix(caseItem[0], caseItem[1][0][0]));
        }
    }

    @Test
    public void preorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution1000.preorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution1000.preorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution1000.preorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution1000.preorderTraversal(root2));

        System.out.println(solution1000.preorderTraversal(null));
        System.out.println(solution1000.preorderTraversal(new TreeNode(1)));
    }

    @Test
    public void inorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution1000.inorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution1000.inorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution1000.inorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution1000.inorderTraversal(root2));

        System.out.println(solution1000.inorderTraversal(null));
        System.out.println(solution1000.inorderTraversal(new TreeNode(1)));
    }

    @Test
    public void postorderTraversal() {
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(3);
        System.out.println(solution1000.postorderTraversal(root3));

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(solution1000.postorderTraversal(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution1000.postorderTraversal(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        System.out.println(solution1000.postorderTraversal(root2));

        System.out.println(solution1000.postorderTraversal(null));
        System.out.println(solution1000.postorderTraversal(new TreeNode(1)));
    }

    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(solution1000.isValidBST(root));

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(solution1000.isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        System.out.println(solution1000.isValidBST(root2));

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(4);
        root3.left.left = new TreeNode(11);
        root3.left.left.left = new TreeNode(7);
        root3.left.left.right = new TreeNode(2);
        root3.right = new TreeNode(8);
        root3.right.left = new TreeNode(13);
        root3.right.right = new TreeNode(4);
        root3.right.right.right = new TreeNode(1);
        System.out.println(solution1000.isValidBST(root3));
    }

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
        System.out.println(solution1000.hasPathSum(root, 22));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(solution1000.hasPathSum(root1, 5));

        System.out.println(solution1000.hasPathSum(null, 0));
    }

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
        System.out.println(solution1000.sumOfLeftLeaves(root1));
        System.out.println(solution1000.sumOfLeftLeaves(new TreeNode(1)));
    }

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
        TreeNode answer = solution1000.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println(answer);
    }

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

    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = solution1000.invertTree(root);
        System.out.println(root);
    }

    @Test
    public void designParkingSystem() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

    @Test
    public void myQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

    @Test
    public void NumArray() {
        NumArray numArray = new NumArray(new int[] {});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}
