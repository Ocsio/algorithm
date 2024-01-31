package cn.ocsio.leetcode.greedy.c06;

// https://leetcode.cn/problems/gas-station/
public class E0134_canCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        E0134_canCompleteCircuit e = new E0134_canCompleteCircuit();
        int ans = e.canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        // 无论如何不能跑完一圈
        if (total < 0) {
            return -1;
        }
        return start;
    }
}
