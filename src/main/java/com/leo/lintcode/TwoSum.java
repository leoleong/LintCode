package com.leo.lintcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/18
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TwoSum {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int[] results = twoSumUsingSpace(numbers, target);

        return results;
    }

    private static int[] twoSumUsingSpace(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (map.containsKey(temp)) {
                int idx = map.get(temp);
                return new int[]{i + 1, idx + 1};
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] twoSumUsingTime(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                if (a + b == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] results = twoSum(numbers, target);
        System.out.println(Arrays.toString(results));
    }
}
