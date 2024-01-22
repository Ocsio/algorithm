package cn.ocsio.leetcode.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E0239_maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        E0239_maxSlidingWindow e = new E0239_maxSlidingWindow();
        int k = 3;
        int[] ans = e.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        // 单调递增队列
        ArrayDeque<Integer> maxQ = new ArrayDeque<>();
        int winL = 0;
        for (int winR = 0; winR < nums.length; winR++) {
            /*
                只有比队尾元素小的元素才可以进队列，否则需要先将比当前元素小的元素出队，再将当前元素入队
                这样保证了：队列中的元素都是比当前入队元素大的元素，且从队尾到队头是单调递增的
             */
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[winR]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(nums[winR]);
            if (winR >= k - 1) {
                ans.add(maxQ.peekFirst());
                if (!maxQ.isEmpty() && maxQ.peekFirst() == nums[winL]) {
                    maxQ.pollFirst();
                }
                winL++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
