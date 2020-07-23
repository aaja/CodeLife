package com.aaja.demo.basic;

/**
 * <p>Title: Lee03_InsertionSort</p>
 * <p>Description: 插入排序</p>
 *
 * ①基本思想：在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，
 *           使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * ②算法描述：
 *      从第一个元素开始，该元素可以认为已经被排序；
 *      取出下一个元素，在已经排序的元素序列中从后向前扫描；
 *      如果该元素（已排序）大于新元素，将该元素移到下一位置；
 *      重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 *      将新元素插入到该位置后；
 *      重复步骤2~5。
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
