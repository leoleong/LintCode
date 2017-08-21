package com.leo.lintcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/18
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TwoSumWithSortedArray {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int temp = nums[low] + nums[high];
            if (temp < target) {
                low++;
            } else if (temp > target) {
                high--;
            } else {
                break;
            }
        }

        if (low == high) {
            low = high = -1;
        }

        return new int[]{low + 1, high + 1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        int[] results = twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }
}
