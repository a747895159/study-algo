package com.person.algo.dynamicplanning;

/**
 * @Desc: 8个任务分布在0~11的时间段内，每个任务对应的收益不同，（1号任务，收益5），在一个时间段内只能做一件任务。问在8个任务中最优收益为多少？
 * @Author: ZhouBin
 * @Date: 2022/1/24
 */
public class Test0004 {
    static int[][] taskTime = {{0, 0}, {1, 4}, {3, 5}, {0, 6}, {4, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}};//存储任务时长
    static int[] income = {0, 5, 1, 8, 4, 6, 3, 2, 4};//存储任务收益

    public static void main(String[] args) {


        System.out.println(OPT(8));
    }

    /**
     * 动态规划：递归计算出最优解
     *
     * @param i 开始计算的任务序号
     * @return 最优解
     */
    public static int OPT(int i) {
        if (i == 0) {//当i为1时，说明已经完成规划内的任务，停止递归
            return 0;
        }
        int A = income[i] + OPT(prev(i));//方案1：选择当前任务
        int B = OPT(i - 1);//方案2：不选择当前任务
        return Math.max(A, B);//求最优解
    }

    /**
     * 根据任务时长获取当前任务之前的最近可用任务
     *
     * @param i 当前任务
     * @return 最近可用任务
     */
    public static int prev(int i) {
        int value = taskTime[i][0];
        while (true) {
            if (i == 1) {
                return 0;
            }
            if (value >= taskTime[i - 1][1]) {
                return i - 1;
            }
            i--;
        }
    }


}
