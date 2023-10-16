package com.person.algo.sort;

/**
 * 归并排序
 *
 * @author : ZhouBin
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {6,3,2,4,5,7,9,8,1};
        mergeSort(arr);

    }

    // 分+合 默认值
    private static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    // 分+合
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 向左分解
            mergeSort(arr, left, mid, temp);
            // 向右分解
            mergeSort(arr, mid + 1, right, temp);

            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    // 治
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边序列初始索引
        int i = left;
        // 右边序列初始索引
        int j = mid + 1;
        // temp数组的当前索引
        int t = 0;
        //  12349 / 5678
        // 1）先把左右序列按顺序填充到temp数组，直到左右序列有一方处理完毕
        while (i <= mid && j <= right) {
            // 如果左序列的值小于右序列则进行存放并将左序列指针右移
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else { // 如果右序列的值小于等于左序列则进行存放并将右序列指针右移
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 2）把有剩余数据的一边序列全部填充到temp
        // 如果左边还有剩余
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        // 如果右边还有剩余
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 3）将temp数组的元素拷贝回arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
