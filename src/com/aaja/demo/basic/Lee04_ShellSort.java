package com.aaja.demo.basic;

/**
 * <p>Title: Lee04_ShellSort</p>
 * <p>Description: 希尔排序</p>
 *
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
