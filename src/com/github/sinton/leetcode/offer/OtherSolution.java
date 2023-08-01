package com.github.sinton.leetcode.offer;

/**
 * @author Yan
 */
public class OtherSolution {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
