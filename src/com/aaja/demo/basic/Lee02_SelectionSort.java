package com.aaja.demo.basic;

/**
 * <p>Title: Lee02_SelectionSort</p>
 * <p>Description: 选择排序</p>
 *
 * @author aaja
 * @date 2020/7/22 21:00
 */
public class Lee02_SelectionSort {
    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
