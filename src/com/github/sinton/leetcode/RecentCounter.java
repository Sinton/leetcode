package com.github.sinton.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls
 * 最近的请求次数
 */
public class RecentCounter {
    Queue<Integer> record;

    public RecentCounter() {
        record = new LinkedList<>();
    }

    public int ping(int t) {
        record.add(t);
        while (!(t - 3000 <= record.peek() && record.peek() <= t)) {
            record.poll();
        }
        return record.size();
    }
}
