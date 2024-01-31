package cn.ocsio.leetcode.greedy.c01;

import java.util.Arrays;

// https://leetcode.cn/problems/assign-cookies/
public class E0455_findContentChildren {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        E0455_findContentChildren e = new E0455_findContentChildren();
        int ans = e.findContentChildren(g, s);
        System.out.println(ans);
    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        /*
            大饼干优先满足胃口大的孩子
         */
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                ans++;
                j--;
            }
            i--;
        }
        return ans;
    }
}
