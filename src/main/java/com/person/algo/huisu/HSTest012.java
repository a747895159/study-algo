package com.person.algo.huisu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 * N*N棋盘,放入N个皇后,任意两个都不能处于同一行、同一列、同一条斜线上
 * 输入：n = 4 输出示例：[2、4、1、3]、[3、1、4、2]
 *
 * @author : ZhouBin
 */
public class HSTest012 {

    private static List<List<String>> result = new ArrayList<>();
    private static List<List<Integer>> resultInt = new ArrayList<>();

    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        back(4);
        System.out.println(JSONObject.toJSONString(result));
        System.out.println(JSONObject.toJSONString(resultInt));
    }

    private static void back(int n) {
        if (path.size() == n) {
            List<String> list = new ArrayList<>();
            for (Integer i : path) {
                char[] rows = new char[n];
                Arrays.fill(rows, '.');
                rows[i - 1] = 'Q';
                list.add(new String(rows));
            }
            resultInt.add(new ArrayList<>(path));
            result.add(list);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                path.add(i);
                back(n);
                path.remove(path.size() - 1);
            }
        }

    }

    private static boolean check(int num) {
        //2、4、1、3
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == num) {
                return false;
            }
            //同一条斜线上
            if (path.size() - i == Math.abs(num - path.get(i))) {
                return false;
            }
        }

        return true;
    }
}
