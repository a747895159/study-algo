package com.person.algo.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * @author : ZhouBin
 */
public class ZQTest0005 {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3};
        int[] arr = {1, 2};
        int[] maxWindowArr = topFreTreeMap(arr, 2);

        System.out.println(JSONObject.toJSONString(maxWindowArr));

    }

    private static int[] topFreTreeMap(int[] nums, int k) {
        //统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] rtn = new int[k];
        //倒序的map,(o1, o2) -> A<B 返回-1，A>B 返回1，A=B 返回0 此种是正序。  倒序就反过来

        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> map.get(o1) < map.get(o2) ? 1 : -1);
        treeMap.putAll(map);
        int i = 0;
        for (int key : treeMap.keySet()) {
            if (i == k) {
                break;
            }
            rtn[i++] = key;
        }
        return rtn;
    }


    private static int[] topFreQueue(int[] nums, int k) {
        //统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] rtn = new int[k];
        //优先队列存放的元素是数组，数组的第一个元素是元素，第二个元素是元素出现的次数，采用的是大顶堆
        //出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆) (o1, o2) -> o1[1] - o2[1],
        //反之大顶堆 (o1, o2) -> o2[1] - o1[1]
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(map::get)));

        for (Integer num : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            }
            if (map.get(num) > map.get(priorityQueue.peek())) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            rtn[i] = priorityQueue.poll();
            i++;
        }
        return rtn;
    }

}
