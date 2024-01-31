package cn.ocsio.leetcode.greedy.c04;

import java.util.Arrays;

// https://leetcode.cn/problems/candy/
public class E0135_candy {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 2, 5, 4, 3, 2};
        E0135_candy e = new E0135_candy();
        int ans = e.candy(ratings);
        System.out.println(ans);
    }

    public int candy(int[] ratings) {
        int[] temp = new int[ratings.length];
        Arrays.fill(temp, 1);
        for (int i = 1; i < ratings.length; i++) {
            // 从左向右遍历
            if (ratings[i] > ratings[i - 1]) {
                temp[i] = temp[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            // 从右往左遍历
            if (ratings[i + 1] < ratings[i]) {
                temp[i] = Math.max(temp[i], temp[i + 1] + 1);
            }
        }
        return Arrays.stream(temp).sum();
    }
}
