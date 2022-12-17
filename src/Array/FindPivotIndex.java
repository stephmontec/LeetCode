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
        int pivot = -1; // default pivot
        int leftSum = 0; // current left sum
        int rightSum = 0; // current right sum

        for (int num : nums) rightSum += num; // right sum will temporarily be the total sum of all elements

        for(int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i]; // decreasing right sum

            if(leftSum == rightSum) return i; // if equal sums, return current i

            leftSum = leftSum + nums[i]; // increasing left sum
        }
        return pivot;
    }
}