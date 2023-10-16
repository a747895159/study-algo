package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 冒泡排序
 *
 * @author : ZhouBin
 */
public class BubbleSort {

    public static void main(String[] args) {

        Integer[] arr = {5, 3, 2, 1, 5, 7, 0, 3, 5, 6, 11};
        sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }

    private static void sort(Integer[] arr) {
        /*
         * 稳定,归位
         * 每次比较相邻两位,大的往右移动 :
         * 第一次： 3,2,1,5,5,0,3,5,6,7,11
         * 第二次： 2,1,3,5,0,3,5,5,6,7,11
         * 第三次： 1,2,3,0,3,5,5,5,6,7,11
         * 第四次： 1,2,0,3,3,5,5,5,6,7,11
         */
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (i < 4) {
                System.out.println(JSONObject.toJSONString(arr));
            }
        }

    }
}
