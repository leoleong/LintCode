package com.leo.lintcode;

import java.util.Scanner;

/**
 * Created by leo on 2017/8/11.
 */
public class Fibonacci {
    /*
     * @param : an integer
     * @return: an ineger f(n)
     */
    public static int fibonacci(int n) {
        if (n <= 0) {
            return -1;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i <= 1) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n -1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            int ret = fibonacci(num);
            System.out.println(ret);
        }
    }
}
