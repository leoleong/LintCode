package com.leo.lintcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6};
        int[] B = {2,3,4,5};
        double ret = findMedianSortedArrays(A, B);
        System.out.println(ret);
    }

    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];

        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }
        while (j < B.length) {
            C[k++] = B[j++];
        }

        int length = C.length;
        double ret;
        if (length % 2 == 0) {
            ret = ((double) C[length / 2] + (double) C[length / 2 - 1]) / 2;
        } else {
            ret = C[(length - 1) / 2];
        }

        return ret;
    }
}
