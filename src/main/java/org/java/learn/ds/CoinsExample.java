package org.java.learn.ds;

import java.util.*;

/**
 * @author duqi
 * @createTime 2018-12-22 09:22
 **/
public class CoinsExample {

    public static void main(String[] args) {
//        int[] coins = {3};
//        int amount = 2;

        int[] coins = {1, 2, 5};
        int amount = 5;
        doCompute(coins, amount);
    }

    public static void doCompute(int[] coins, int amount) {
        if (amount < 0 || amount > 5000) {
            throw new IllegalArgumentException("0<= 金额amount <= 5000");
        }
        if (coins.length > 500) {
            throw new IllegalArgumentException("面值总类大于500");
        }
        if (coins.length <= 0) {
            System.out.println(0);
        }
        if (amount == 0) {
            System.out.println(1);
        }

        //step1 从小到大排序
        Arrays.sort(coins);

        //step2 递归计算，并输出结果
        System.out.println(computation(coins, amount, coins.length - 1, new Integer[amount + 1][coins.length]));
    }

    /**
     * 时间复杂度和空间复杂度都是O(m * n)
     *
     * @param coins    面值的数组
     * @param amount   当前的面值
     * @param position coins数组中的位置
     * @param res      用于记录各个面值的可能的结果
     * @return
     */
    public static int computation(int[] coins, int amount, int position, Integer[][] res) {
        //递归终止条件
        if (amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }

        if (res[amount][position] == null) {
            //该面值是否需要递归
            int temp = 0;
            for (int i = position; i >= 0; i--) {
                temp += computation(coins, amount - coins[i], i, res);
            }
            res[amount][position] = temp;
        }
        return res[amount][position];
    }
}
