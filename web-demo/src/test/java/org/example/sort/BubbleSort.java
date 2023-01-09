package org.example.sort;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BubbleSort implements Sort {
    @Override
    public SortType getSortType() {
        return SortType.BUBBLE;
    }

    @Override
    public int[] sorting(int[] sourceArray) {

        if(sourceArray == null) {
            throw new NullPointerException();
        }
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if(sourceArray.length < 2) {
            return arr;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count ++;
                }
            }
        }
        return arr;
    }
}