package com.company;

import java.util.Scanner;

public class Main {

    static int[] temp;
    static int[] array;
    private static Scanner inScan = new Scanner(System.in);

    public static int mergeSort(int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {

            mid = (right + left) / 2;

            inv_count = mergeSort(left, mid);
            inv_count += mergeSort(mid + 1, right);

            inv_count += merge(left, mid + 1, right);
        }
        return inv_count;
    }

    public static int merge(int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;

        i = left;

        j = mid;

        k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];

                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }

        return inv_count;
    }

    public static void main(String[] args) {
        int numofreps = inScan.nextInt();

        for (int i = 0; i < numofreps; i++) {

            int size = inScan.nextInt();
            array = new int[size];
            temp = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = inScan.nextInt();
            }
            System.out.println(mergeSort(0, size - 1));


        }
    }

}
