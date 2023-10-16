package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 简单选择排序
 * @author : ZhouBin
 */
public class SelectSort {

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 2, 1, 5, 7, 0, 3, 5, 6, 11};
        // 不稳定,归位
        sort(arr);
        System.out.println(JSONObject.toJSONString(arr));
    }

    private static void sort(Integer[] arr) {
        /*
         * 不稳定,归位
         * 每次循环往右找到最小,和当前i替换
         * 第一次 ：0,3,2,1,5,7,5,3,5,6,11
         * 第二次 ：0,1,2,3,5,7,5,3,5,6,11
         * 第三次 ：0,1,2,3,5,7,5,3,5,6,11
         * 第四次 ：0,1,2,3,5,7,5,3,5,6,11
         * 第五次 ：0,1,2,3,3,7,5,5,5,6,11
         */
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

    }
}
