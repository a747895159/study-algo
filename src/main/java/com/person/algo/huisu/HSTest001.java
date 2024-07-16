package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 *
 * @author : ZhouBin
 */
public class HSTest001 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {
        result =new ArrayList<>();
        backTrack(1,1,1);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void backTrack(int n, int k, int start){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
        //path长度加上区间 [start, n] 的长度小于 k
        for (int i = start; i <= n-k+path.size()+1; i++){
            path.add(i);
            backTrack(n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}
