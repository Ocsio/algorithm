package cn.ocsio.leetcode.greedy.c05;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/partition-labels/
public class E0763_partitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        E0763_partitionLabels e = new E0763_partitionLabels();
        List<Integer> ans = e.partitionLabels(s);
        System.out.println(ans);
    }

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
