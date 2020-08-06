package algorithm.sort;

import java.util.Arrays;

/**
 * @author wangzhiguo
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 4, 3, 6, 6, 7};

        int[] ints = insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     *
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    /**
     * 选择排序
     *
     * 选择排序(Selection-sort) 是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            int minIndex = j;
            for (; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     *
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            for (; j >= 1; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 希尔排序
     *
     *
     */
    public static int[] ShellSort(int[] array) {

        return array;
    }

}
