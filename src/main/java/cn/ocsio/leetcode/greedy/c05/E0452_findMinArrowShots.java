package cn.ocsio.leetcode.greedy.c05;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
public class E0452_findMinArrowShots {
    public static void main(String[] args) {
        int[][] points = {
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        E0452_findMinArrowShots e = new E0452_findMinArrowShots();
        int ans = e.findMinArrowShots(points);
        System.out.println(ans);
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return 0;
        }
        int ans = 1;
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (right < points[i][0]) {
                ans++;
                right = points[i][1];
            }
        }
        return ans;
    }
}
