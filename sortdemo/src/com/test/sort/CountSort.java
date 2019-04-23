package com.test.sort;

/**
 * 计数排序
 * 非比较排序、对数据范围有要求
 * 应用场景：量大但是范围小
 * O（n+k）、O（n+k）、O（n+k）、O（n+k）稳定
 */
public class CountSort {

    public static void main(String[] args) {
        //小范围特殊数组，0~9
        int[] arr = {2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};
        int[] result = sort1(arr);
        SortUtil.print(result);
    }

    /**
     * 升级版计数排序
     * 缺点：对数据源有要求，出现的数字范围不是很大
     * @param arr
     * @return
     */
    public static int[] sort1(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        //累加数组
        for(int i=1;i<count.length;i++){
            count[i] = count[i] + count[i-1];
        }

        //倒叙遍历arr数组，将每一个值对应累加数组放置元素
        for (int i=arr.length-1;i>=0;i--){
            result[--count[arr[i]]] = arr[i];
        }

        return result;
    }

    /**
     * 简易版计数排序
     * 缺点：不稳定、数值不从0开始，只取固定范围值,导致无用排序太多
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];

        for (int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        //将计数数组中数据循环放入结果数组
        for(int i=0,j=0;i<count.length;i++){
            while(count[i]-->0) result[j++] = i;
        }

        return result;
    }
}
