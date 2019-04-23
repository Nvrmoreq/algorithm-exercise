package com.test.sort;

/**
 * 选择排序
 * 算法：数组开始值为最小值坐标，将数组第二个数开始依次和首位比较，确定最小值，将最小值和开始值交换，重复此操作
 * 简易版/优化版选择排序
 * O（n2）、O（n2）、O（n2）、O（1）不稳定
 * 算法不稳定：在一个待排序的序列中，存在两个相等的数，在排序后这两个数的相对位置保持不变，那么该算法为稳定的
 */
public class SelectSort {

    public static void main(String[] args) {

        int arr[] = {9,3,1,4,6,8,7,5,2};
        sort(arr);
    }

    //简易版选择排序
    public static void sort(int arr[]){
        for (int i=0;i<arr.length-1;i++){
            int minPos = i;
            int j;
            for (j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minPos]){
                    minPos = j;
                }
            }
            SortUtil.sort(arr,i,minPos);
        }
        SortUtil.print(arr);
    }
}
