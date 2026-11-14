package com.example.comment.util;

import java.util.Arrays;

public class Hello {
    public static void main(String[] args) {
        int[] numbers = {7, 2, 9, 1, 5, 3, 8, 4, 6};
        quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void quickSort(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return;
        }
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] numbers, int left, int right) {
        int i = left;
        int j = right;
        int pivot = numbers[left + (right - left) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(numbers, left, j);
        }
        if (i < right) {
            quickSort(numbers, i, right);
        }
    }
}
