package com.person.algo.dynamicplanning;

/**
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * @author : ZhouBin
 */
public class DGTest007 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int n = canPartition(nums, target);
        System.out.println(n);
    }


    /**
     * 假设加法的总和为x，那么减法对应的总和就是sum - x。
     * 所以我们要求的是 x - (sum - x) = target
     * x = (target + sum) / 2
     */
    public static int canPartition(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        // 填满j（包括j）这么大容积的包，有dp[j]种方法
        int[] dp = new int[bagSize + 1];
        //如果数组[0] ，target = 0，那么 bagSize = (target + sum) / 2 = 0。 dp[0]也应该是1， 也就是说给数组里的元素 0 前面无论放加法还是减法，都是 1 种方法。
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            // 倒序可以避免重复计算，避免重复使用。 如果重复使用，使用正序 for (int j = nums[i]; j <= bagSize; j++){
            for (int j = bagSize; j >= nums[i]; j--) {
                // 在求装满背包有几种方法的情况下，递推公式一般为 dp[j] = dp[j] + dp[j - nums[i]]
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[bagSize];

    }
}
