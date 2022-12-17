package Array;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        printArray(nums);

        System.out.println("\n[Solution 1] Pivot index: " + solution1(nums));
    }

    public static void printArray(int[] array) {
        for(int i : array)
            System.out.print(" " + i);
    }

    public static int solution1(int[] nums) {
        int pivot = nums.length / 2; // midpoint of array

        while(pivot > 0) {
            int leftSum = 0; int rightSum = 0; // current left and right sums
            int leftPointer, rightPointer;

            for(leftPointer = 0; leftPointer < pivot; leftPointer++) {
                leftSum += nums[leftPointer]; // accumulate to left sum
            }

            for(rightPointer = nums.length - 1; rightPointer > pivot; rightPointer--)
                rightSum += nums[rightPointer]; // accumulate to right sum

            if(leftSum == rightSum) break; // if sums are equal, break out of loop and return pivot

            pivot--;
        }

        if(pivot == 0) {
            int leftSum = 0;  // reset left sum
            int rightSum = 0; // reset right sum

            // find total right sum only. if pivot is first element, then there are no elements to the left (i.e., left sum will be zero)
            for(int rightPointer = nums.length - 1; rightPointer > pivot; rightPointer--)
                rightSum += nums[rightPointer];

            if(leftSum == rightSum)
                return 0; // if both sums are equal (0 = 0), then return 0 to indicate the pivot index is nums[0]
            else
                return -1; // else, if they are still not equal, then we have checked all leftmost indexes and no pivot was found (-1)
        }
        return pivot;
    }
}