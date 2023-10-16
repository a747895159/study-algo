package com.person.algo.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * 希尔排序（直接插入排序的改进版）
 * <p>
 * 希尔排序算法又称最小增量排序算法，其基本思想是：
 * 步骤 1：构造一个步长序列 delta1, delta2, ...., deltak, 其中 delta1 = n / 2，后面的每个 delta 是前一个的 1 / 2，deltak = 1；
 * 步骤 2：根据步长序列进行 k 趟排序；
 * 步骤 3：对第 i 趟排序，根据对应的步长 delta，将等步长位置元素分，对同一组内元素在原位置上进行直接插入排序。
 *
 * @author : ZhouBin
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr={4,5,1,2,6,9,3};
        shellSort(arr,arr.length);

        System.out.println(JSONObject.toJSONString(arr));

    }

    private static void shellSort(int[] data, int n) {
        int k, i, t, dk, j;
        //步长数组，很长的,
        int[] delta = new int[n / 2];
        k = n;
        i = 0;
        do {
            k = k / 2;
            delta[i++] = k;
        } while (k > 1);

        i = 0;
        //此处dk代表步长
        while ((dk = delta[i]) > 0) {
            for (k = delta[i]; k < n; ++k) {
                //对每个步长下的数组 进行移位替换
                if (data[k] < data[k - dk]) {
                    t = data[k];
                    for (j = k - dk; j >= 0 && t < data[j]; j -= dk) {
                        data[j + dk] = data[j];
                    }
                    // 此处 j在上面循环多减dk,不满足上面for循环
                    data[j + dk] = t;
                }
            }
            ++i;
        }
    }

}
