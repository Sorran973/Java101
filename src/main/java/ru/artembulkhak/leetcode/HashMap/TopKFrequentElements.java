package ru.artembulkhak.leetcode.HashMap;
import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */

public class TopKFrequentElements {

    public int[] topKFrequentPriorityQueue(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i: nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        priorityQueue.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    public int[] topKFrequentHashMapComparator(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

//      Faster approach:
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

//      Slower approach:
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public int[] topKFrequentBucketSort(int[] nums, int k) {
        int[] result = new int[k];
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i: nums){
            map.put(i,map.getOrDefault(i,0) + 1);
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
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentBucketSort(new int[]{3,0,1,0}, 1)));
    }
}
