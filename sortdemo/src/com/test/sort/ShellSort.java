package com.test.sort;

/**
 * 希尔排序，练手Demo
 * 算法：分间隔，将每一组间隔用插入排序排好顺序，直到间隔为1
 * 简易版/优化版希尔排序
 * O（n1.3）、O（n2）、O（n）、O（1）不稳定
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};

        shellSort1(arr);
    }

    //升级版希尔排序（Knuth间隔h=1  h=3*h+1）
    public static void shellSort2(int arr[]){
        int h = 1;
        while(h<=arr.length/3) {
            h = 3 * h + 1;
        }
        for(int gap=h;gap>0;gap=(gap-1)/3){
            for (int i=gap;i<arr.length;i++){
                for (int j=i;j>gap-1;j-=gap){
                    if(arr[j]<arr[j-1]){
                        SortUtil.sort(arr,j,j-1);
                    }
                }
            }
        }

        SortUtil.print(arr);
    }

    //升级版希尔排序（gap间隔二分）
    public static void shellSort1(int arr[]){

        for(int gap=arr.length>>2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                for (int j=i;j>gap-1;j-=gap){
                    if(arr[j]<arr[j-1]){
                        SortUtil.sort(arr,j,j-1);
                    }
                }
            }
        }

        SortUtil.print(arr);
    }

    //简易版希尔排序
    public static void shellSort(int arr[]){
        int gap = 4;
        for(gap=4;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                for (int j=i;j>gap-1;j-=gap){
                    if(arr[j]<arr[j-1]){
                        SortUtil.sort(arr,j,j-1);
                    }
                }
            }
        }

        SortUtil.print(arr);
    }
}
