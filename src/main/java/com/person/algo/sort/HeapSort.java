package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 堆排序
 *
 * 堆排序是一种常用的排序算法。用顺序存储结构存储堆中元素。非递减堆排序的步骤是：
 * （1）将含 n 个元素的待排序数列构造成一个初始大顶堆，存储在数组 R（R[1]，R[2]，...，
 * R[n]）中。此时堆的规模为 n，堆顶元素 R[1]就是序列中最大的元素，R[n]是堆中最后一个
 * 元素。
 * （2）将堆顶元素和堆中最后一个元素交换，最后一个元素脱离堆结构，堆的规模减 1，
 * 将堆中剩余的元素调整成大顶堆;
 * （3）重复步骤（2），直到只剩下最后一个元素在堆结构中，此时数组 R 是一个非递减
 * 的数据序列。
 * <p>
 * n：待排序的数组长度
 * R[]：待排序数组，n 个数放在 R[1]，R[2]，...，R[n]中
 *
 * @author : ZhouBin
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {-1,7, 10, 13, 15, 4, 20, 19, 8};

        heapSort(arr, 8);
        System.out.println(JSONObject.toJSONString(arr));

    }


    /**
     * 调正堆
     * R：待排序数组；
     * V：结点编号, 以 v 为根的二叉树, R[v] ≥ R[2v], R[v] ≥ R[2v + 1],
     * 且其左子树和右子树都是大顶堆；
     * n：堆结构的规模，即堆中的元素数
     */
    private static void heapify(int[] arr, int v, int n) {
        int i, j;
        i = v;
        j = 2 * i;
        // arr[0] 存放的是临时变量作用
        arr[0] = arr[i];
        while (j <= n) {
            if (j < n && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[0] < arr[j]) {
                arr[i] = arr[j];
                i = j;
                j = 2 * i;
            } else {
                j = n + 1;
            }
        }
        arr[i] = arr[0];
    }

    /**
     * 堆排序
     *
     * @param arr 为待排序数组
     * @param n   数组大小
     */
    private static void heapSort(int[] arr, int n) {

        int i;
        //构建初始的大顶堆
        for (i = n / 2; i >= 1; i--) {
            heapify(arr, i, n);
            System.out.println(JSONObject.toJSONString(arr));
        }
        //大顶堆排序
        for (i = n; i > 1; i--) {
            // arr[0] 存放的是临时变量作用
            arr[0] = arr[i];
            arr[i] = arr[1];
            arr[1] = arr[0];
            heapify(arr, 1, i - 1);
        }

    }

}
