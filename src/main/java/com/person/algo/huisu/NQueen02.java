package com.person.algo.huisu;

/**
 * N皇后
 * N*N棋盘,放入N个皇后,任意两个都不能处于同一行、同一列、同一条斜线上
 * 非递归解法
 *
 * @author : ZhouBin
 */
public class NQueen02 {

    static int N = 4;
    static int[] q = new int[N + 1];
    static int answer = 0;


    public static void main(String[] args) {

        queen();
    }


    /**
     * 检查放入的皇后是否合法
     */
    private static boolean check(int j) {
        for (int i = 1; i < j; i++) {
            if (q[i] == q[j] || Math.abs(i - j) == Math.abs(q[i] - q[j])) {
                return false;
            }
        }
        return true;
    }

    private static void queen() {
        // 初始化棋盘
        for (int i = 1; i <= N; i++) {
            q[i] = 0;
        }
        // 表示摆放第 j 个皇后
        int j = 1;
        // 防止回溯时溢出
        while (j >= 1) {
            // 让该皇后按列摆放
            q[j] = q[j] + 1;

            // 判断皇后位置是否合法且不越界
            while (q[j] <= N && !check(j)) {
                // 不合法就往下一个位置摆放
                q[j] = q[j] + 1;
            }
            if (q[j] <= N) {
                // 第j个找到合法位置
                if (j == N) {
                    // 找到一组解
                    answer++;
                    System.out.print("方案" + answer + ": ");
                    for (int i = 1; i < q.length; i++) {
                        System.out.print(q[i] + " ");
                    }
                    System.out.println();
                } else {
                    // 继续摆放
                    j = j + 1;
                }
            } else {
                // 还原第j个皇后的位置
                q[j] = 0;
                // 第j个找不到合法位置,回溯到上一个皇后的位置
                j = j - 1;
            }
        }
    }
}
