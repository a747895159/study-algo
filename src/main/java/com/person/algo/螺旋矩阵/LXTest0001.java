package com.person.algo.螺旋矩阵;

import com.alibaba.fastjson.JSONObject;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 输入: 4 输出: [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
 *
 * @author : ZhouBin
 */
public class LXTest0001 {

    public static void main(String[] args) {
        int n = 1;
        int[][] arr = exec(n);

        exec2(arr);
    }

    public static int[][] exec(int n) {
        int[][] arr = new int[n][n];
        int sx = 0;
        int sy = 0;
        int offset = 1;
        int num = 1;
        int loop = n / 2;
        while (loop > 0) {
            for (sy = offset - 1; sy < n - offset; sy++) {
                arr[sx][sy] = num++;
            }
            for (sx = offset - 1; sx < n - offset; sx++) {
                arr[sx][sy] = num++;
            }
            for (; sy > offset - 1; sy--) {
                arr[sx][sy] = num++;
            }
            for (; sx > offset - 1; sx--) {
                arr[sx][sy] = num++;
            }
            offset++;
            loop--;
            sx++;
            sy++;
        }
        if (n % 2 != 0) {
            arr[sx][sy] = num;
        }
        System.out.println(JSONObject.toJSON(arr));

        return arr;
    }

    public static int[] exec2(int[][] nums) {
        if (nums == null || nums.length == 0 || nums[0].length == 0 || nums.length!=nums[0].length) {
            return new int[0];
        }
        int n = nums.length;
        //遍历二维数组将[[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]] 输出 [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
        int[] arr = new int[n * n];
        int sx = 0;
        int sy = 0;
        int loop = n / 2;
        int index = 0;
        int offset = 1;
        while (loop > 0) {
            for (; sy < n - offset; sy++) {
                arr[index++] = nums[sx][sy];
            }
            for (; sx < n - offset; sx++) {
                arr[index++] = nums[sx][sy];
            }
            for (; sy > offset - 1; sy--) {
                arr[index++] = nums[sx][sy];
            }
            for (; sx > offset - 1; sx--) {
                arr[index++] = nums[sx][sy];
            }
            offset++;
            loop--;
            sx++;
            sy++;
        }

        if (n % 2 != 0) {
            arr[index] = nums[sx][sy];
        }
        System.out.println(JSONObject.toJSON(arr));

        return arr;
    }
}
