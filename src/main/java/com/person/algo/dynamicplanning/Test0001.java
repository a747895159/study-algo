package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

public class Test0001 {
    private static int[] value = {0, 1500, 3000, 2000};
    private static int[] weight = {0, 1, 4, 3};
    private static int bag = 4;

    public static void main(String[] args) {
        System.out.println(dp_OPT(3, 4));
    }


    /**
     * 动态规划：非递归求最优解
     *
     * @param n   第n个物品
     * @param bag 背包容量
     * @return 最优解
     */
    public static int dp_OPT(int n, int bag) {
        int[][] result = new int[weight.length][bag + 1];
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = 0;
        }
        for (int j = 0; j < result.length; j++) {
            result[j][0] = 0;
        }
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = j >= weight[i] ? Math.max(value[i] + result[i - 1][j - weight[i]], result[i - 1][j]) : result[i - 1][j];
            }
        }
        System.out.println(JSONObject.toJSONString(result));

        return result[n][bag];
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