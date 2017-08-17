package com.leo.lintcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/17
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        twoPointerSort(nums);
    }

    private static void countSort(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;

        for (int num: nums) {
            if (num == 0) {
                cnt0++;
            } else if (num == 1) {
                cnt1++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < cnt0) {
                nums[i] = 0;
            } else if (i < cnt0 + cnt1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    private static void twoPointerSort(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i++, j++);
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k--);
            }
        }
    }

    private static void swap(int[] nums, int src, int dst) {
        int temp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0, 0, 1, 2, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
