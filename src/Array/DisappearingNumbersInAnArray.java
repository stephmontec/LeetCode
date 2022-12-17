package Array;

import java.util.ArrayList;
import java.util.List;

public class DisappearingNumbersInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1}; // missing 5 and 6

        printArray(nums);

        System.out.println("\n[Solution 1] List of missing number(s): " + solution1(nums));
    }

    public static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(" " + i);
        }
    }

    public static List<Integer> solution1(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // subtract one to apply 0-based array indexing

            if(nums[index] > 0)
                nums[index] = -nums[index]; // marking the elements that are present with a negative sign
        }

        // after iterating through entire array and marking, find remaining positive numbers
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) // if number is positive
                result.add(i + 1); // revert to [1,n] by adding 1 to the index
        }
        return result;
    }
}
