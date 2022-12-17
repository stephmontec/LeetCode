package Array;

import java.util.Arrays;

public class Convert1DArrayTo2DArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

        printArray(nums);

        System.out.println("\n[Solution 1] - Reformatted array: " + Arrays.deepToString(solution1(nums, 2, 3)));
    }

    public static void printArray(int[] array) {
        for(int i : array)
            System.out.println(" " + i);
    }

    public static int[][] solution1(int[] nums, int rows, int cols) {
        int[][] result = new int[rows][cols];
        int k = 0; // original array iterator

        for(int i = 0; i < rows; i++) { // row iterator
            for(int j = 0; j < cols; j++) { // column iterator
                result[i][j] = nums[k++];
            }
        }
        return result;
    }
}
