package cn.ocsio.leetcode.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class E0347_topKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4};
        int k = 2;
        E0347_topKFrequent e = new E0347_topKFrequent();
        int[] ans = e.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 记录频次 num => num 出现的次数
        HashMap<Integer, Integer> fre = new HashMap<>();
        for (int num : nums) {
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }
        // 使用小顶堆，要统计 topK，只有将最小的元素弹出，最后小顶堆中的元素才是 topK 的元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(fre::get));
        fre.forEach((key, value) -> {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}
