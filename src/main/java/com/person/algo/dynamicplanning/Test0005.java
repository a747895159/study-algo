package com.person.algo.dynamicplanning;

/**
 * @author : ZhouBin
 * @date : 2022/8/25
 */
public class Test0005 {
    public static void main(String[] args) {
        int[] num = {2, 4, 1, 5, 7, 9, 2, 5, 3, 4};
        int[] result = new int[num.length];
        result[0] = num[0];
        result[1] = Math.max(num[0], num[1]);

        for (int i = 2; i < num.length; i++) {

            result[i]= Math.max(result[i-1], num[i]+result[i-2]);
        }
        System.out.println(result[result.length-1]);
    }
}
