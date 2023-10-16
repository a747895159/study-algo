package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 快速排序
 * @author : ZhouBin
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 1, 5, 7, 0, 3, 5, 6, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSONObject.toJSONString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right, pivot = arr[i];

        while (i < j) {
            // 从右开始找比基准值小的元素
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // 将该元素放在最左侧
            arr[i] = arr[j];
            // 从左开始找比基准值大的元素
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;

        System.out.println();
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

}
