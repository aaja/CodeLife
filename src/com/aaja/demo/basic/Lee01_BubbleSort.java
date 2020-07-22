package com.aaja.demo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: Lee01_BubbleSort</p>
 * <p>Description: 冒泡排序</p>
 * 冒泡排序算法的原理：
 *      1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *      2、对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 *      3、针对所有的元素重复以上的步骤，除了最后一个。
 *      4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 算法分析：
 *      时间复杂度：
 *          若文件的初始状态是正序的，一趟扫描即可完成排序。所需的关键字比较次数 和记录移动次数 均达到最小值
 *          所以，冒泡排序最好的时间复杂度为O(n)。
 *          若初始文件是反序的，需要进行 趟排序。每趟排序要进行 次关键字的比较(1≤i≤n-1)，且每次比较都必须移
 *          动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值
 *          冒泡排序的最坏时间复杂度为O(n²)。
 *          综上，因此冒泡排序总的平均时间复杂度为O(n²)。
 *      空间复杂度：O(1)
 *      稳定性：稳定
 * @author aaja
 * @date 2020/7/22 13:58
 */
public class Lee01_BubbleSort {

    public static int[] bubbleSort(int arr[]) {
        boolean flag;
        for(int i =0 ; i<arr.length-1 ; i++) {
            flag = false;
            for(int j=0 ; j<arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]) {
                    flag = true;
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j]^arr[j+1];
                    arr[j+1] = arr[j]^arr[j+1];
                }
            }
            if(!flag) break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 34, 6, -3, 9, 13};
        List<Integer> resList = Arrays.stream(bubbleSort(arr))
                                      .boxed()
                                      .collect(Collectors.toList());
        System.out.println(resList);
    }
}
