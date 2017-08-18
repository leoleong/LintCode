package com.leo.lintcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/17
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SortColorsII {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public static void sortColors2(int[] colors, int k) {
        if (k <= 1 || colors == null || colors.length == 0) {
            return;
        }

//        countSort(colors, k);
        twoPointerSort(colors, k);
    }

    /**
     * time: O(n), space: O(k)
     * @param colors
     * @param k
     */
    private static void countSort(int[] colors, int k) {
        int[] counters = new int[k + 1];
        for (int color : colors) {
            counters[color]++;
        }

        int j = 0;
        for (int i = 1; i <= k; i++) {
            int counter = counters[i];
            for (int l = 0; l < counter; l++) {
                colors[j++] = i;
            }
        }
    }

    /**
     * time: k*O(n), space: O(1)
     * @param colors
     * @param k
     */
    private static void twoPointerSort(int[] colors, int k) {
        int min = 1, max = k;
        int i = 0, left = 0, right = colors.length - 1;

        while (min < max) {
            while (i <= right) {
                if (colors[i] == min) {
                    swap(colors, i++, left++);
                } else if (colors[i] == max) {
                    swap(colors, i, right--);
                } else {
                    i++;
                }
            }
            min++;
            max--;
            i = left;
        }
    }

    private static void swap(int[] arr, int src, int dst) {
        int temp = arr[src];
        arr[src] = arr[dst];
        arr[dst] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 1, 3, 3, 2, 2, 1, 4};
        sortColors2(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}
