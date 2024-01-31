package cn.ocsio.leetcode.greedy.c05;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.cn/problems/non-overlapping-intervals/
public class E0435_eraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 100},
                {11, 22},
                {1, 11},
                {2, 12}
        };
        E0435_eraseOverlapIntervals e = new E0435_eraseOverlapIntervals();
        int ans = e.eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        int ans = 1;
        // 根据右端点升序
        Arrays.sort(intervals, Comparator.comparing(o -> o[1]));
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right <= intervals[i][0]) {
                ans++;
                right = intervals[i][1];
            }
        }
        return intervals.length - ans;
    }
}
