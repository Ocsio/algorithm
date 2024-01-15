package cn.ocsio.leetcode.hash.c01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/group-anagrams/
public class E0049_groupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        E0049_groupAnagrams e = new E0049_groupAnagrams();
        List<List<String>> ans = e.groupAnagrams(strs);
        System.out.println("ans = " + ans);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        System.out.println("map = " + map);
        return new ArrayList<>(map.values());
    }
}
