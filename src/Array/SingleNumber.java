package Array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        printArray(nums);

        //System.out.println("\n[Solution 1] Single number: " + solution1(nums));
        System.out.println("\n[Solution 2] Single number: " + solution2(nums));

    }

    public static void printArray(int[] array) {
        for(int i : array)
            System.out.print(" " + i);
    }

    public static int solution1(int[] nums) {
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static int solution2(int[] nums) {
        Arrays.sort(nums); // sort array: 1 1 2 2 4

        for(int i = 0; i < nums.length - 1; i += 2) { // increment i by 2 to compare next pair
            if(nums[i] != nums[i+1]) // if current number does not equal neighbor
                return nums[i]; // return current number (i.e., it is unique)
        }

        return nums[nums.length-1]; // largest num is most unique
    }

}
