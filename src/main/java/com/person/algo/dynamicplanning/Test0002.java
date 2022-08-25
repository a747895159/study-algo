package com.person.algo.dynamicplanning;

import com.alibaba.fastjson.JSONObject;

/**
 * @Desc:
 *      求相隔数据和最大值：有数据 {5,7,3,1,4,2} 需要间隔式的取出几个数使数之和最大，求出最大值。
 * @Author: ZhouBin
 * @Date: 2022/1/24
 */
public class Test0002 {

    public static void main(String[] args) {
        int[] data=new int[]{5,7,3,1,4,2,6,12};
        System.out.println(re_OPT(data,5));
        System.out.println(dp_OPT(data,5));
    }

    /**
     * 动态规划：递归式计算出最优解
     * @param data 需要求解的数据
     * @param i 在第i个数据前进行最优解计算
     * @return 返回最优解
     */
    public static int re_OPT(int[] data, int i){
        if (i==0){//i==0时，第一个数据本身就是最优解。递归终止条件
            return data[0];
        }else if (i==1){//i==1是，前两个数中的最大值就是最优解。递归终止条件
            return Math.max(data[0],data[1]);
        }else {
            int A= re_OPT(data,i-2)+data[i];//A方案：选当前数据
            int B= re_OPT(data,i-1);//B方案：不选当前数据
            return Math.max(A,B);//在AB方案中，返回最大值作为最优解
        }
    }

    /**
     * 动态规划：非递归计算出最优解
     * @param data 需要求解的数据
     * @param i 在第i个数据前进行最优解计算
     * @return 返回最优解
     */
    public static int dp_OPT(int[] data, int i){
        //
        int[] opt=new int[data.length];
        int A;
        int B;
        opt[0]=data[0];
        opt[1]=Math.max(data[0],data[1]);
        for (int j=2;j<data.length;j++){
            A=opt[j-2]+data[j];//A方案：选当前数据
            B=opt[j-1];//B方案：不选当前数据
            opt[j]=Math.max(A,B);
        }
        System.out.println(JSONObject.toJSONString(opt));
        return opt[i];
    }



}
