package com.person.algo.dynamicplanning;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 数据求和匹配：{3,34,4,12,5,2}的数据中，给出一个待匹配的值n，问是否能从数据中任意取出几个数，使得之和等于n ?
 * @Author: ZhouBin
 * @Date: 2022/1/24
 */
public class Test0003 {

    static int[] data = {3, 34, 4, 12, 5, 2};

    public static void main(String[] args) {
        /*System.out.println(re_OPT(data.length - 1, 9));
        System.out.println(re_OPT(data.length - 1, 13));*/


        System.out.println(dp_OPT(data.length - 1, 9));

        System.out.println(dp_OPT2(data.length - 1, 9));
    }

    /**
     * 动态规划：递归求出在一组数据中，是否有相加之和为待匹配数的情况
     *
     * @param i 数组索引
     * @param a 待匹配数
     * @return true or false
     */
    public static boolean re_OPT(int i, int a) {
        if (a == 0) {//终止递归
            return true;
        } else if (i == 0) {//终止递归
            return data[i] == a;
        } else if (data[i] > a) {//剪枝
            return re_OPT(i - 1, a);
        }
        return re_OPT(i - 1, a - data[i]) || re_OPT(i - 1, a);//两种方案，选与不选
    }

    public static boolean dp_OPT2(int i, int a) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int temp = 0;
        for (int datum : data) {
            temp = a - datum;
            if(temp>=0){
                if (map.containsKey(datum)) {
                    System.out.println(datum + "---" + temp);
                    break;
                } else {
                    map.put(temp, datum);
                }
            }
        }
        return false;
    }

    /**
     * 动态规划：非递归出在一组数据中，是否有相加之和为待匹配数的情况
     *
     * @param i 数组索引
     * @param a 待匹配数
     * @return true or false
     */
    public static boolean dp_OPT(int i, int a) {
        boolean[][] res = new boolean[data.length][a + 1];
        boolean A, B;
        for (int x = 0; x < res.length; x++) {
            for (int y = 0; y < a + 1; y++) {
                if (y == 0) {
                    res[x][y] = true;
                }
                if (x == 0 && y == data[0]) {
                    res[x][y] = true;
                }
            }
        }
        for (int x = 1; x < res.length; x++) {
            for (int y = 1; y < a + 1; y++) {
                if (data[x] > y) {
                    res[x][y] = res[x - 1][y];
                } else {
                    A = res[x - 1][y - data[x]];
                    B = res[x - 1][y];
                    res[x][y] = A || B;
                }
            }
        }
        return res[i][a];
    }

}
