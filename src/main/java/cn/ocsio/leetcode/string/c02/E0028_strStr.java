package cn.ocsio.leetcode.string.c02;

public class E0028_strStr {
    public static void main(String[] args) {
        E0028_strStr e = new E0028_strStr();
        String haystack = "mississippi";
        String needle = "issip";
        int ans = e.strStr(haystack, needle);
        System.out.println(ans); // 0
    }

    public int strStr(String haystack, String needle) {
        int[] next = next(needle.toCharArray());
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 若模式串前缀匹配不成功，则将模式串进行回退
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            // 当前模式串匹配成功，则 j++ 继续匹配
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            // 当前模式串完全匹配成功，返回匹配开始的位置
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[] next(char[] p) {
        int[] next = new int[p.length];
        // 前缀串开始所在的下标位置
        int left = 0;
        // 后缀串开始所在的下标位置
        for (int right = 1; right < p.length; right++) {
            // 匹配失败，left 回退，left 为 0 或者匹配成功时停止
            while (left > 0 && p[left] != p[right]) {
                left = next[left - 1];
            }
            // 匹配成功，找到相同的前后缀，先让 left++
            if (p[left] == p[right]) {
                left++;
            }
            // 记录前缀长度，更新 next[right]
            next[right] = left;
        }
        return next;
    }
}
