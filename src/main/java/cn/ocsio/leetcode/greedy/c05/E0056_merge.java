package cn.ocsio.leetcode.greedy.c05;

import cn.ocsio.utils.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/
public class E0056_merge {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        E0056_merge e = new E0056_merge();
        int[][] ans = e.merge(intervals);
        Print.print(ans);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                ans.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][]);
    }
}
