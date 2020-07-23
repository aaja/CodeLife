package com.aaja.demo.basic;

import java.util.Arrays;

/**
 * <p>Title: Lee05_MergeSort</p>
 * <p>Description: 归并排序</p>
 *  ①基本思想：
 *      归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常
 *      典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将
 *      两个有序表合并成一个有序表，称为2-路归并。
 * ②算法描述：
 *      把长度为n的输入序列分成两个长度为n/2的子序列；
 *      对这两个子序列分别采用归并排序；
 *      将两个排序好的子序列合并成一个最终的排序序列。
 * @author aaja
 * @date 2020/7/22 21:04
 */
public class Lee05_MergeSort {

    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
}
