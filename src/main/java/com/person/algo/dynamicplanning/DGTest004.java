package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;


/**
 * 01 背包
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class DGTest004 {

    private static int[] value = {0, 15, 20, 30};
    private static int[] weight = {0, 1, 3, 4};

    public static void main(String[] args) {

        System.out.println(dp_OPT(3, 4));

        System.out.println(re_OPT(3, 4));
    }


    /**
     * 动态规划：非递归求最优解
     *
     * @param n   第n个物品
     * @param bag 背包容量
     * @return 最优解
     */
    public static int dp_OPT(int n, int bag) {
        //表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[weight.length][bag + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //此种场景 放不下 当前物品 i
                if (j < weight[i]) {
                    dp[i][i] = dp[i - 1][j];
                } else {
                    //当前背包的容量可以放下物品i,比较 放物品i 与 不放物品i 这两种情况下，哪种背包中物品的最大价值最大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(JSONObject.toJSONString(dp));

        return dp[n][bag];
    }

    /**
     * 动态规划：递归来求最优解
     *
     * @param n   第n个物品
     * @param bag 背包容量
     * @return 最优解
     */
    public static int re_OPT(int n, int bag) {
        if (n == 0) {
            return 0;
        }
        if (bag >= weight[n]) {
            return Math.max(value[n] + re_OPT(n - 1, bag - weight[n]), re_OPT(n - 1, bag));
        } else {
            return re_OPT(n - 1, bag);
        }
    }

}