package cn.ocsio.leetcode.greedy.c01;

// https://leetcode.cn/problems/lemonade-change/
public class E0860_lemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        E0860_lemonadeChange e = new E0860_lemonadeChange();
        boolean ans = e.lemonadeChange(bills);
        System.out.println(ans);
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                if (five < 0) {
                    return false;
                }
                five--;
                ten++;
            }
            if (bill == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
