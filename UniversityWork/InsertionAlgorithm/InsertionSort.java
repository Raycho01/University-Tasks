package InsertionAlgorithm;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            int current = array[i];
            int j = i - 1;
            while (array[j] > current && j >= 0) {          // 1 3 4 7 8 9 2 6
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        int[] array = new int[]{1, 7, 3, 4, 2, 5};

        insertionSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
