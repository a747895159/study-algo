package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * @author : ZhouBin
 */
public class DGTest006 {

    private static boolean[] used;
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        used = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            System.out.println("false");
        }
        canPartition(nums, sum / 2, 0);
        System.out.println(JSONObject.toJSONString(result));
    }

    /**
     * 回溯法
     */
    public static void canPartition(int[] nums, int target, int current) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && current + nums[i] <= target) {
                used[i] = true;
                current += nums[i];
                path.add(nums[i]);
                canPartition(nums, target, current);
                current -= nums[i];
                path.remove(path.size() - 1);
            }

        }

    }

    /**
     * 动态规划解法(二维数组)
     */
    public static void canPartition2(int[] nums, int target) {
        //dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数每个数只能用一次，使得这些数的和恰好等于 j。
        int[][] dp = new int[nums.length][target + 1];
        for (int j = nums[0]; j < target; j++) {
            dp[0][j] = nums[0];
        }
        // 二维数组方式，先判断物品 在判断背包
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
    }

    /**
     * 动态规划解法(一维数组)
     */
    public static void canPartition3(int[] nums, int target) {
        //dp[i]目标和为i时,当前数据的最大值
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            //剪枝一下，每一次完成内层的for-loop，立即检查是否dp[target] == target，
            if (dp[target] == target) {
                break;
            }
        }
    }

}
