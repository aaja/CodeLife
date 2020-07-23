package com.aaja.demo.basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Title: Lee09_BucketSort</p>
 * <p>Description: 桶排序</p>
 *
 * ①基本思想：
 *      桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 *      桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每
 *      个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
 * ②算法描述：
 *      设置一个定量的数组当作空桶；
 *      遍历输入数据，并且把数据一个一个放到对应的桶里去；
 *      对每个不是空的桶进行排序；
 *      从不是空的桶里把排好序的数据拼接起来。
 * @author aaja
 * @date 2020/7/22 21:13
 */
public class Lee09_BucketSort {

    public static void bucketSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }
}
