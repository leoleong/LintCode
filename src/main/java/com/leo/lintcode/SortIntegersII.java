package com.leo.lintcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2017/8/16
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SortIntegersII {
    /**
     * @param A an integer array
     * @return void
     */
    public static void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        quickSort(A, 0, A.length - 1);
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(A, start, end);
        quickSort(A, start, pivot - 1);
        quickSort(A, pivot + 1, end);
    }

    private static int partition(int[] A, int start, int end) {
        int i = start - 1;
        int j = start;
        while (j < end) {
            if (A[j] < A[end]) {
                swap(A, ++i, j);
            }
            j++;
        }
        swap(A, ++i, end);

        return i;
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void main(String[] args) {
        int[] A = {-1, 5, 0, 3, 8};
        sortIntegers2(A);
        System.out.print(Arrays.toString(A));
    }
}
