package cn.ocsio.leetcode.greedy.c04;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.cn/problems/queue-reconstruction-by-height/
public class E0406_reconstructQueue {
    public static void main(String[] args) {
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        E0406_reconstructQueue e = new E0406_reconstructQueue();
        int[][] ans = e.reconstructQueue(people);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] reconstructQueue(int[][] people) {
        // 优先按照 h 降序，若身高一致则按照 k 升序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][]);
    }
}
