package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

/**
 * 完全背包
 * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 * <p>
 * 对于纯完全背包问题，其for循环的先后循环是可以颠倒的！
 */
public class DGTest005 {

    private static int[] value = {15, 20, 30};
    private static int[] weight = {1, 3, 4};

    public static void main(String[] args) {

        System.out.println(dp_OPT(4));

        System.out.println(dp_OPT2(4));
    }


    //先遍历物品，再遍历背包
    private static int dp_OPT(int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            //完全背包，物品可以重复，必须使用正序
            for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println("---------" + JSONObject.toJSONString(dp));
        return dp[bagWeight];
    }

    //先遍历背包，再遍历物品
    private static int dp_OPT2(int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        //完全背包，物品可以重复，必须使用正序
        for (int i = 1; i <= bagWeight; i++) { // 遍历背包容量
            for (int j = 0; j < weight.length; j++) { // 遍历物品
                if (i - weight[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        System.out.println("---------" + JSONObject.toJSONString(dp));
        return dp[bagWeight];
    }
}
