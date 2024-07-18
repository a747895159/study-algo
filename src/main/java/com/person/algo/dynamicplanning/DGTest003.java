package com.person.algo.dynamicplanning;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @author : ZhouBin
 */
public class DGTest003 {

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                //j * (i - j) 是单纯的把整数拆分为两个数相乘
                //j * dp[i - j]是拆分成两个以及两个以上的个数相乘
                max = Math.max(max, Math.max(dp[i - j] * j, (i - j) * j));
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);

    }

}
