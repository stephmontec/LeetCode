package Array;

import java.util.HashSet;
import java.util.Random;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(10 - 1) + 1]; // random array length from size 1 to 10

        for(int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10 - -10) + -10; // random integer from -10 to 10
        }

        printArray(nums);
        System.out.println("\n[Solution 1 - Hashing] Duplicate found: " + solution1(nums));
    }

    public static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(" " + i);
        }
    }

    public static boolean solution1(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // use hash set since it does not allow duplicates

        for(int num : nums) {
            if(set.contains(num))
                return true; // if the set already contains num, then return true

            set.add(num); // else, add num to the set
        }
        return false; // no duplicates found; all added elements are unique
    }
}
