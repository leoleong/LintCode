package com.leo.lintcode;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/9
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UglyNumber {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public static boolean isUgly(int num) {
        if (num <= 0 ) {
            return false;
        }

        return isUglyNumber(num);
    }

    private static boolean isUglyNumber(int num) {
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            boolean ret = isUgly(num);
            System.out.println(ret);
        }
    }
}
