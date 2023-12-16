package com.example.search;

import java.util.ArrayList;

public class LinearSearch implements Search{

    private int resultIndex = -1;

    @Override
    public void search(ArrayList<Integer> array, int target) {
        print(array);
        for (int index = 0; index < array.size(); index++) {
            if (array.get(index) == target) {
                print(array);
                resultIndex = index;
                return;
            }
        }
        resultIndex = -1;
    }

    public CharSequence getResult() {
        if (resultIndex != -1) {
            return "Using Linear Search: Found at position " + resultIndex;
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
