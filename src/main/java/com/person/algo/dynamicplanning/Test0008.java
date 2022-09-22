package com.person.algo.dynamicplanning;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * <p>
 * 输入：m = 2, n = 3  输出：3
 * 解释： 从左上角开始，总共有 3 条路径可以到达右下角。
 * 向右 -> 向右 -> 向下
 * 向右 -> 向下 -> 向右
 * 向下 -> 向右 -> 向右
 *
 * 输入：m = 7, n = 3  输出：28
 *
 * @author : ZhouBin
 * @date : 2022/9/19
 */
public class Test0008 {

    public static void main(String[] args) {


        System.out.println(calc(7, 3));
    }

    private static int calc(int m, int n) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            temp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            temp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[m - 1][n - 1];
    }
}
