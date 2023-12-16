package com.example.search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch implements Search{

    private int resultIndex = -1;

    void quickSort(ArrayList<Integer> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    void quickSort(ArrayList<Integer> list, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(list, left, right);
            quickSort(list, left, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, right);
        }
    }

    int partition(ArrayList<Integer> list, int left, int right) {
        int pivotValue = list.get(right);
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i) <= pivotValue) {
                Collections.swap(list, i, partitionIndex);
                partitionIndex++;
            }
        }

        Collections.swap(list, partitionIndex, right);
        return partitionIndex;
    }

    @Override
    public void search(ArrayList<Integer> array, int target) {
        quickSort(array, 0, array.size() - 1);
        print(array);
        int left = 0;
        int right = array.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array.get(middle) == target) {
                resultIndex = middle;
                return;
            }
            if (array.get(middle) < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        resultIndex = -1;
    }

    public CharSequence getResult() {
        if (resultIndex != -1) {
            return "Using Binary Search: Found at position " + resultIndex;
        } else {
            return "404 Not Found";
        }
    }

    @Override
    public void print(ArrayList<Integer> array) {
        for (Integer item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
