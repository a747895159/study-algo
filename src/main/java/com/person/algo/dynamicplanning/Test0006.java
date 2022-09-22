package com.person.algo.dynamicplanning;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author : ZhouBin
 * @date : 2022/9/19
 */
public class Test0006 {

    public static void main(String[] args) {
        System.out.println(calc(5));

    }

    /**
     * 分析如下： N(i)= N(i-2)+ N(i-1); 第i层,由i-2层+跨两步 与 由i-1层+跨一步
     * n1 = 1;
     * n2 = 2;
     * n3 = 3;
     * n4 = 5;
     *
     */
    private static int calc(int n){
        int n1 = 1;
        int n2 = 2;
        if(n==1){
            return n1;
        }
        if(n==2){
            return n2;
        }
        int sum =0;
        for(int i=2;i<n;i++){
            sum =n1+n2;
            n1=n2;
            n2=sum;
        }
        return n2;
    }
}
