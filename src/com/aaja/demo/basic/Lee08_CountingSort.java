package com.aaja.demo.basic;

import java.util.Arrays;

/**
 * <p>Title: Lee08_CountingSort</p>
 * <p>Description: 计数排序</p>
 *
 * ①基本思想：计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 *      作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * ②算法描述：
 *      找出待排序的数组中最大和最小的元素；
 *      统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 *      对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 *      反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * @author aaja
 * @date 2020/7/22 21:11
 */
public class Lee08_CountingSort {

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] CountingSort(int[] array) {
        if (array.length == 0) return array;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return array;
    }
}
