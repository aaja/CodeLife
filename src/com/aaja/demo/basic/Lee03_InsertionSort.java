package com.aaja.demo.basic;

/**
 * <p>Title: Lee03_InsertionSort</p>
 * <p>Description: 插入排序</p>
 *
 * @author aaja
 * @date 2020/7/22 21:01
 */
public class Lee03_InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
