package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 计算一个整数数组 a 的最长递增子序列长度的方法描述如下：
 *
 * @author : ZhouBin
 */
@Slf4j
public class Test0011 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 7, 1, 7};
        int[] brr = new int[arr.length];
        int j, len;
        brr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            for (j = 0, len = 0; j < i; j++) {
                if (arr[j] <= arr[i] && len < brr[j]){
                    len = brr[j];
                }

            }
            brr[i]=len+1;
        }
        log.info("测试时:{}",JSONObject.toJSONString(brr));
        // 输出结果：  [1,2,3,3,4,5,6,2,7]
        System.out.println(JSONObject.toJSONString(brr));
    }
}
