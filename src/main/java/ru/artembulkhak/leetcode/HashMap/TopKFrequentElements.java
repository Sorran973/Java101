package ru.artembulkhak.leetcode.HashMap;
import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */

public class TopKFrequentElements {

    public int[] topKFrequentHashMap(int[] nums, int k) {
        int[] result = new int[k];
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        for (int key: map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        int res_index = 0;
        for (int i = nums.length; i > 0; i--) {
            if (buckets[i] != null) {
                for (int j: buckets[i]) {
                    result[res_index] = j;
                    res_index += 1;
                    if (res_index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentHashMap(new int[]{3,0,1,0}, 1)));
    }
}
