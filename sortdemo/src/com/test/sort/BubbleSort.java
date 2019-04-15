package com.test.sort;

/**
 * 冒泡排序，练手Demo
 * 简易版/优化版冒泡排序
 * O（n2）、O（n2）、O（n）、O（1）稳定
 */
public class BubbleSort {

    public static void main(String[] args) {
        //初始数组
        int arr[] = {9,3,1,4,6,8,7,5,2};
        bubbleSort2(arr);

    }

    //优化第二版冒泡排序
    public static void bubbleSort2(int arr[]){
        boolean flag = true;
        int lastIndex = arr.length;
        for (int i=1;i<arr.length;i++){
            int j;
            for (j=0;j<lastIndex-1;j++){
                if(arr[j]>arr[j+1]){
                    SortUtil.sort(arr,j,j+1);
                    flag = false;
                }
            }
            lastIndex = j;
            if(flag){
                break;
            }
        }
        SortUtil.print(arr);
    }

    //优化第一版冒泡排序
    public static void bubbleSort1(int arr[]){
        boolean flag = true;
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    SortUtil.sort(arr,j,j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        SortUtil.print(arr);
    }

    //简易版冒泡排序
    public static void bubbleSort(int arr[]){
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    SortUtil.sort(arr,j,j+1);
                }
            }
        }
        SortUtil.print(arr);
    }

}
