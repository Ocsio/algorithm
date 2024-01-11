package cn.ocsio.leetcode.c03;

import java.util.HashMap;

// https://leetcode.cn/problems/fruit-into-baskets/
public class E0904_totalFruit {
    public static void main(String[] args) {
        int[] fruits = {1, 1, 2};
        E0904_totalFruit e = new E0904_totalFruit();
        int ans = e.totalFruit(fruits);
        System.out.println("ans = " + ans);
    }

    public int totalFruit(int[] fruits) {
        int ans = Integer.MIN_VALUE;
        int winL = 0;
        // kind 表示：滑动窗口内的数 => 该数出现的次数
        HashMap<Integer, Integer> kind = new HashMap<>();
        for (int winR = 0; winR < fruits.length; winR++) {
            kind.put(fruits[winR], kind.getOrDefault(fruits[winR], 0) + 1);
            while (kind.size() > 2) {
                kind.put(fruits[winL], kind.get(fruits[winL]) - 1);
                if (kind.get(fruits[winL]) == 0) {
                    kind.remove(fruits[winL]);
                }
                winL++;
            }
            ans = Math.max(ans, winR - winL + 1);
        }
        return ans;
    }
}
