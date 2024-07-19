package com.person.algo.dynamicplanning;

/**
 * 377. 组合总和III   参考HSTest003 递归方式求解
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * 所有可能的组合为： (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2, 2) (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 *
 * @author : ZhouBin
 */
public class DGTest009 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int n = canPartition(nums, target);
        System.out.println(n);
    }


    public static int canPartition(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        /*
         * 如果求 **组合** 数就是外层for循环遍历物品，内层for遍历背包。
         *
         * 如果求 **排列** 数就是外层for遍历背包，内层for循环遍历物品。
         */
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
