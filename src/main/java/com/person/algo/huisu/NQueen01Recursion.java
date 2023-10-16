package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

/**
 * N皇后递归
 * N*N棋盘,放入N个皇后,任意两个都不能处于同一行、同一列、同一条斜线上
 * 递归解法
 * @author : ZhouBin
 */
public class NQueen01Recursion {

    static int N = 4;
    static int[] q = new int[N + 1];
    static int answer = 0;


    public static void main(String[] args) {
        queen(1);
    }

    private static void queen(int j) {
        for (int i = 1; i <= N; i++) {
            // 每行都循环按列摆放
            q[j] = i;
            System.out.println("j:" + j + ",i:" + i + "  " + JSONObject.toJSONString(q));
            // 不冲突则检查是否摆放完成，否则摆放下一个
            if (check(j)) {
                // 摆放完成
                if (j == N) {
                    answer();
                } else {
                    // 摆放下一个
                    queen(j + 1);
                }
            }
        }
    }

    /**
     * 检查放入的皇后是否合法 (true 合法 | false 不合法)
     */
    public static boolean check(int j) {
        for (int i = 0; i < j; i++) {
            if (q[i] == q[j] || Math.abs(i - j) == Math.abs(q[i] - q[j])) {
                return false;
            }
        }
        return true;
    }

    private static void answer() {
        answer++;
        System.out.print("方案" + answer + ": ");
        for (int k = 0; k < q.length; k++) {
            System.out.print(q[k] + " ");
        }
        System.out.println();
    }


}
