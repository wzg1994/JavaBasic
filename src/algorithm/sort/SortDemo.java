package algorithm.sort;

import java.util.Arrays;

/**
 * @author wangzhiguo
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 4, 3, 6, 6, 7};

        int[] ints = MergeSort(arr);

        System.out.println(Arrays.toString(ints));
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



    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    /**
     *   使用二分查找实现平方根函数，要求精确到小数点后6位 ==
     */
    public float sqrt_search(float n){
        float mid = 0.0f;
        if(n < -1e-6){
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }else if(Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6){
            return mid;
        }else{
            // 逐次逼近，默认平方根的不会超过n的一半
            float high = n / 2.0f;
            float low = 0.0f;
            while(Math.abs(high - low) > 1e-6){
                // 首先找到中间值
                mid = low + (high - low) / 2;
                float tmp = mid * mid;
                // 比较并更新 high和low
                if((tmp - n) > 1e-6){
                    high = mid;
                }else if((tmp -n) < -1e-6){
                    low = mid;
                }else{
                    return mid;
                }
            }
        }
        return mid;
    }

}
