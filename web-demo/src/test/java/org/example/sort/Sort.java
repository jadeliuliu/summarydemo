package org.example.sort;

/**
 * @author: liuxuan
 * @date: 2023-01-07 11:36
 **/
public interface Sort {
    SortType getSortType();
    int[] sorting(int[] sourceArray);
}
