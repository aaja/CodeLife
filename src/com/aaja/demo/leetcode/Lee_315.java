package com.aaja.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @title 		计算右侧小于当前元素的个数
 * @description 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 				数组 counts 有该性质： counts[i] 的值是  nums[i] 右
 * 				侧小于 nums[i] 的元素的数量。
 *
 * @example 	输入：[5,2,6,1]
 *				输出：[2,1,1,0]
 * @Explanation	5 的右侧有 2 个更小的元素 (2 和 1)
 *				2 的右侧仅有 1 个更小的元素 (1)
 *				6 的右侧有 1 个更小的元素 (1)
 *				1 的右侧有 0 个更小的元素
 *
 * @LeetCode	315
 * @author aaja
 * @date 2020/7/22 13:59
 */
public class Lee_315 {

    /**
     * v1.0
     * 看到题目第一眼想到的，然后提交不通过
     */
    public static List<Integer> countSmaller1(int[] nums) {
        List<Integer> couns = new ArrayList<Integer>();
        for(int i= 0; i < nums.length; i++) {
            int j= 0;
            for(int k= i+1; k < nums.length; k++) {
                if(nums[k] < nums[i]) {
                    j++;
                }
            }
            couns.add(j);
        }
        return couns;
    }

    /**
     * 大佬解法
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return result;

        int[] temp = new int[len];
        int[] res = new int[len];
        int[] indexes = new int[len]; // 索引数组，作用：归并回去的时候，方便知道是哪个下标的元素

        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);

        for (int i = 0; i < len; i++) { // 把 int[] 转换成为 List<Integer>，没有业务逻辑
            result.add(res[i]);
        }
        return result;
    }

    /**
     * 针对数组 nums 指定的区间 [left, right] 进行归并排序，在排序的过程中完成统计任务
     *
     * @param nums
     * @param left
     * @param right
     */
    private void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);
    }

    /**
     * [left, mid] 是排好序的，[mid + 1, right] 是排好序的
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param indexes
     * @param temp
     * @param res
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                indexes[k] = temp[j];
                j++;
            } else if (j > right) {
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 注意：这里是 <= ，保证稳定性
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += (j - mid - 1);
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }

    public static void handle() {
        int[] nums = new int[] {5, 2, 6, 1};
        System.out.println(countSmaller1(nums));
    }

    /**
     * 单个Java方法不能超过65535字节
     * 单个Java文件常量个数上限是65536
     */
    public static void handleResult() {
        int[] numx = new int[] {5183,2271,3067,539,8939,2999,9264,737,3974,5846,-210,9278,5800,
                2675,6608,1133,-1,6018,9672,5179,9842,7424,-209,2988,2757,5984,1107,2644,-499,
                7234,7539,6525,347,5718,-742,1797,5292,976,8752,8297,1312,3385,5924,2882,6091,
                -282,2595,96,1906,8014,7667,5895,7283,7974,-167,7068,3946,6223,189,1589,2058,9277,
                -302,8157,8256,5261,8067,1071,9470,2682,8197,5632,753,3179,8187,9042,8167,4657,7080,
                7801,5627,7917,8085,928,-892,-427,3685,4676,2431,8064,8537,343,505,4352,2108,4399,66,
                2086,1922,9126,9460,393,443,5689,7595,850,8493,2866,732,3738,7933,3666,2370,5804,4045,
                7903,8009,5387,5542,7593,6862,1547,6934,-160,9693,4560,7429,9989,7232,-594,587,6476,9277,
                4471,5979,6268,2419,6706,-727,1927,7361,9684,5519,2703,1723,5181,3545,4290,9421,4288,1656,
                1541,9632,1448,-490,4747,5416,4139,-845,3834,3349,8594,7882,2279,7777,9369,9917,8167,6799};
        System.out.println(countSmaller1(numx));
    }

    public static void main(String[] args) {
        handle();
//		handleResult();
    }
}
