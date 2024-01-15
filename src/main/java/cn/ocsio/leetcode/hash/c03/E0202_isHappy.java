package cn.ocsio.leetcode.hash.c03;

// https://leetcode.cn/problems/happy-number/
public class E0202_isHappy {
    public static void main(String[] args) {
        int n = 19;
        E0202_isHappy e = new E0202_isHappy();
        boolean ans = e.isHappy(n);
        System.out.println(ans);
        System.out.println(e.calc(16));
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = calc(slow);
            fast = calc(fast);
            fast = calc(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public int calc(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        return ans;
    }
}
