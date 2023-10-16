package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 插入排序
 * @author : ZhouBin
 */
public class InsertSort {


    public static void main(String[] args) {

        Integer[] arr = {5, 3, 2, 1, 5, 7, 0, 3, 5, 6, 11};
        sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }

    private static void sort(Integer[] arr) {
        /*
         * 稳定,不归位
         * 每次比较i的左侧部分,小的往左移动 :
         * 第一次： 3, 5, 2, 1, 5, 7, 0, 3, 5, 6, 11
         * 第二次： 3, 5, 2, 1, 5, 7, 0, 3, 5, 6, 11
         * 第三次： 2, 3, 5, 1, 5, 7, 0, 3, 5, 6, 11
         */
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (i == 3) {
                return;
            }
        }

    }

}
