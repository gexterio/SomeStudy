package com.gh.gexterio;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = arrayGenerator(1000000);
        int[] sortedArr = sort(arr);

        String bruteResult = bruteForceSearch(arr, 100);
        System.out.println(bruteResult);
        System.out.println("-----------------");
        String binaryResult = binarySearch(sortedArr, 100);
        System.out.println(binaryResult);

    }

    private static String binarySearch(int[] arr, int item) {
        long a = System.currentTimeMillis();
        int low = 0;
        int high = (arr.length) - 1;
        int count = 0;
        while (low<=high) {
            int mid = (low + high) / 2;
            int midVal = arr[mid];

            if (midVal < item) {
                low = mid + 1;
            } else if (midVal > item) {
                high = mid - 1;
            } else {
                long b = System.currentTimeMillis();
                System.out.println("Число найдено!\n" + "Затрачено на бинарный поиск: " + (b - a) + " миллисекунд");
                return "Искомое число: " + midVal + " найдено за " + count + " итераций.";
            }
            count++;
        }
        long b = System.currentTimeMillis();
        System.out.println("Число не найдено!\n" + "Затрачено на бинарный поиск: " + (b - a) + " миллисекунд");
            return "Искомое число не найдено!";
    }


    private static String bruteForceSearch(int[] arr, int item) {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                long b = System.currentTimeMillis();
                System.out.println("Число  найдено!\n" + "Времени затрчено на поиск перебором: " + (b - a) + " миллисекунд");
                return "Число: " + item + " найдено в массиве под индексом: " + i;
            }
        }
        long b = System.currentTimeMillis();
        System.out.println("Число не найдено!\n" + "Времени затрчено на поиск перебором: " + (b - a) + " миллисекунд");
        return "Число " + item + " НЕ найдено в массиве";
    }


    private static int[] sort(int[] arr) {
        long a = System.currentTimeMillis();
        int count = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                int temp = arr[i];
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            count++;
        }
        long b = System.currentTimeMillis();
        System.out.println("Сортировка выполнена за " + count + " итераций.\n Затрачено " + (b - a) + " миллисекунд");
        System.out.println("--------------------------------");
        return arr;
    }

    private static int[] arrayGenerator(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 1000);
        }
        return array;
    }
}
