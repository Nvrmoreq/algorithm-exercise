package com.test.sort;

/**
 * 归并排序
 * 算法：取一个相同大小的新数组，将老数组分为两个序列，左右比较，小的存到新数组，直到比较完成，判断左右数组那个数组剩下了值直接将剩下的值赋到新数组，将新数组复制回老数组
 * 两边已知有序版、升级版（截取一段排序）、 递归调用版
 * O（nlog2n）、O（nlog2n）、O（nlog2n）、O（n） 稳定
 * java对象排序要求稳定，内嵌排序使用归并排序，jdk1.8后使用TimSort
 * TimSort是归并排序的优化版，可以认为是多路归并，直接分块两两归并，其中既用到了二分插入也用到了归并排序(当数组比分区小时使用二分插入排序)
 * BinarySort二分插入排序，优化的插入排序，效率更高
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {1,2,6,7,3,4,5};

        //merge(arr,1,3,5);
        sort(arr, 0, arr.length-1);
        SortUtil.print(arr);
    }

    /**
     * 递归调用，归并排序
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     */
    static void sort(int[] arr, int left, int right){
       //边界判断
        if(left == right) return;
        //小细节，直接right+left可能会int越界
        int mid = left + (right - left)/2;
        //分两边，左边递归调用sort排序
        sort(arr, left, mid);
        //右边递归调用sort排序
        sort(arr,mid+1, right);

        merge(arr, left, mid+1, right);
    }


    /**
     * 截取数组中的一段数列进行归并排序
     * @param arr 数组
     * @param leftPtr 左指针
     * @param leftPtr 右指针
     * @param leftPtr 右边界
     */
    public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound){
        int mid = rightPtr-1;
        int[] temp = new int[rightBound-leftPtr+1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;

        while(i <= mid && j <= rightBound){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= rightBound) temp[k++] = arr[j++];

       for(int m = 0; m < rightBound-leftPtr+1; m++){
            arr[m+leftPtr] = temp[m];
        }
    }


    /**
     * 两边已知有序，基数数组
     */
    public static void merge(int[] arr){
        int mid = arr.length/2;
        int[] temp = new int[arr.length];

        int i = 0;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j < arr.length){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while(i<=mid) temp[k++] = arr[i++];
        while(j<arr.length) temp[k++] = arr[j++];

        for(int m=0;m<arr.length;m++){
            arr[m] = temp[m];
        }
        SortUtil.print(arr);
    }

}
