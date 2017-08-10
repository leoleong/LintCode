package com.leo.lintcode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/9
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UglyNumberII {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public static int nthUglyNumber(int n) {
       if (n <= 0) {
           return -1;
       }

       int cnt = 0;
       int num = 0;
       while (cnt < n) {
           num++;
           if (isUgly(num)) {
               cnt++;
           }
       }

       return num;
    }

    private static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }

        boolean hasValidFactor = true;
        while (hasValidFactor) {
            hasValidFactor = false;
            if (n % 2 == 0) {
                n = n / 2;
                hasValidFactor = true;
            }
            if (n % 3 == 0) {
                n = n / 3;
                hasValidFactor = true;
            }
            if (n % 5 == 0) {
                n = n / 5;
                hasValidFactor = true;
            }
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            int ret = nthUglyNumber(num);
            System.out.println(ret);
        }
    }
}
