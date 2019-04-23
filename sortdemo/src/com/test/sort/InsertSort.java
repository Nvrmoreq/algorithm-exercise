package com.test.sort;

/**
 * 插入排序
 * 算法：将待插入数字与有序数列依次比较，比较后插入到对应位置，重复操作
 * 简易版/优化版插入排序
 * O（n2）、O（n2）、O（n）、O（1）稳定
 */
public class InsertSort {
    public static void main(String[] args) {
        //初始数组
        int arr[] = {9,3,1,4,6,8,7,5,2};
        sort2(arr);

    }

    //优化版，使用temp存储
    public static void sort2(int arr[]){
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j;
            for(j=i;j>0;j--){
                if(temp<arr[j-1]){
                    arr[j] = arr[j-1];
                }else{
                    break;
                }
            }
            arr[j] = temp;
        }
        SortUtil.print(arr);
    }

    //简易版插入排序
    public static void sort(int arr[]){
        for (int i=1;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    SortUtil.sort(arr,j,j-1);
                }
            }
        }
        SortUtil.print(arr);
    }


}
