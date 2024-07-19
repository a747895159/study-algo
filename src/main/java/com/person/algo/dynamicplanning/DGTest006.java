package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 最后一块石头的重量II
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 *
 * @author : ZhouBin
 */
public class DGTest006 {

    /**
     * 本题是求最小重量，假设将石头分成2堆，每堆重量是总重量一半。
     * 定义 dp[j] 表示J重量时，当前堆石头可组成的总重量；
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 8, 1};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum / 2;
        //表示J重量时，当前堆石头可组成的总重量；
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        //本题是求最小重量，拿 总量 - 2倍的平均重量时所放的实际重量
        System.out.println(sum - 2 * dp[target]);

        backTrack(dp[target], nums);
    }

    /**
     * 回溯法
     */
    public static void backTrack(int agvWeight, int[] nums) {
        System.out.println("相对平均重量" + agvWeight);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length && agvWeight >= 0; i++) {
            if (nums[i] <= agvWeight) {
                list.add(nums[i]);
                agvWeight -= nums[i];
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }


}
