package com.aaja.demo.basic;

/**
 * <p>Title: Lee04_ShellSort</p>
 * <p>Description: 希尔排序</p>
 *
 *  ①基本思想：希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，
 *      同时该算法是冲破O(n2）的第一批算法之一。它与插入排序的不同之处在于，它会优先比较距离较远的元素。
 *  ②算法描述：
 *      选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 *      按增量序列个数k，对序列进行k 趟排序；
 *      每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子
 *      为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @author aaja
 * @date 2020/7/22 21:02
 */
public class Lee04_ShellSort {

    public static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
