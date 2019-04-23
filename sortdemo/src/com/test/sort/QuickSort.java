package com.test.sort;

/**
 * 快速排序
 * 算法：单轴快速排序，首先找到最后位做轴,判断轴后分两个区，一个小于一个大于，然后左右区分别递归排序，从左到右找到第一个比轴大的和从右到左找到第一个比轴小的数作交换
 * O（nlog2n）、O（n2）、O（nlog2n）、O（n） 不稳定
 * java基本类型排序使用快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {7, 3, 2, 10, 8, 1, 9, 5, 4, 6, 6};
        //partition(arr, 0, arr.length-1);
        sort(arr, 0, arr.length-1);
        SortUtil.print(arr);
    }

    /**
     * 递归排序
     * @param arr
     * @param left
     * @param right
     */
    public static void sort(int[] arr, int left, int right){
        if(left >= right) return;//边界判断，当数组只有一个值时直接返回
        //获取轴的值
        int mid = getPivot(arr, left, right);
        //边界判断，当数组已经有序则直接返回
        //if(mid+1 == right-1) return ;
        sort(arr, left, mid-1);
        sort(arr, mid+1, right);
        //partition(arr, left, right);
    }


    /**
     * 获取分区排序后的轴
     * @param arr
     * @param leftBound
     * @param rightBound
     */
    public static int getPivot(int[] arr, int leftBound, int rightBound){
        //末位为轴
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound-1;

        while(left < right){
            //left<=right为了防止当left==right的情况下left少加一次
            while(left <= right && arr[left] <= pivot) left++;
            while(left < right && arr[right] > pivot) right--;
            //找到左边第一个比轴大的值右边第一个比轴小的值作交换
            if (left < right) SortUtil.sort(arr, left, right);
        }

        if(pivot < arr[left]) {
            //交换左边界与轴的值，分区排序结束
            SortUtil.sort(arr, left, rightBound);
        }
        return left;
    }


    /**
     * 分区排序(代码有bug)
     * 从左到右找到第一个比轴大的和从右到左找到第一个比轴小的数作交换
     * @param arr
     * @param leftBound
     * @param rightBound
     */
    public static void partition(int[] arr, int leftBound, int rightBound){
        //末位为轴
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound-1;

        while(left < right){

            while(left <= right && arr[left] <= pivot) left++;
            while(left <= right && arr[right] > pivot) right--;

            if (left < right) SortUtil.sort(arr, left, right);

        }
        //交换左边界与轴的值，分区排序结束
        SortUtil.sort(arr, left, rightBound);
    }
}
