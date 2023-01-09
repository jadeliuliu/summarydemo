package org.example.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author: liuxuan
 * @date: 2023-01-07 13:00
 **/
public class SortTest {
    @Test
    public void test1() {
        int[] arr = new int[]{2,1,3,5,4};
//        bubbleSortOpt(arr);
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSortOpt(int[] arr) {
        if(arr == null) {
            throw new NullPointerException();
        }
        if(arr.length < 2) {
            return;
        }
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort(int[] arr, int start, int end) {

        if(start < end) {
            // 把数组中的首位数字作为基准数
            int pivot = arr[start];
            // 记录需要排序的下标
            int low = start;
            int high = end;
            // 循环找到比基准数大的数和比基准数小的数
            while(low < high) {
                // 右边的数字比基准数大
                while(low < high && arr[high] >= pivot) {
                    high--;
                }
                // 使用右边的数替换左边的数
                arr[low] = arr[high];
                // 左边的数字比基准数小
                while(low < high && arr[low] <= pivot) {
                    low++;
                }
                // 使用左边的数替换右边的数
                arr[high] = arr[low];
            }
            // 把标准值赋给下标重合的位置
            arr[low] = pivot;
            // 处理所有小的数字
            quickSort(arr, start, low);
            // 处理所有大的数字
            quickSort(arr, low + 1, end);
        }
    }



}
