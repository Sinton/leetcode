package com.github.sinton.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 * 设计有序流
 */
public class OrderedStream {
    String[] stream;
    int ptr = 1;

    public OrderedStream(int n) {
        stream = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey] = value;
        if (idKey == ptr) {
            while (ptr < stream.length && stream[ptr] != null) {
                result.add(stream[ptr]);
                ptr++;
            }
        }
        return result;
    }
}
