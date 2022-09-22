package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * 输入：cost = [10, 15, 20] 输出：15 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。  示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 输出：6 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 *
 * @author : ZhouBin
 * @date : 2022/9/19
 */
public class Test0007 {

    public static void main(String[] args) {
        //0->         1  2  3  4  5  6  7  8  9
//        int[] cost = {1, 2, 1, 2, 1, 3, 4, 1, 1};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(calc(cost));
    }

    private static int calc(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] temp = new int[cost.length];
        temp[0] = cost[0];
        temp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            temp[i] = Math.min(temp[i - 1], temp[i - 2]) + cost[i];
        }
        System.out.println(JSONObject.toJSONString(temp));
        return temp[cost.length - 1];
    }
}
