package Array;

import java.util.HashSet;
import java.util.Random;

public class MissingNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = {0,1};

        printArray(nums);
        //System.out.println("\n[Solution 1 - Bit Manipulation] Missing number: " + solution1(nums));
        System.out.println("\n[Solution 2 - Sum formula] Missing number: " + solution2(nums));
        //System.out.println("\n[Solution 3 - Hashing] Missing number: " + solution3(nums));

    }

    public static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(" " + i);
        }
    }

    /*
        XOR Table
        ---------
        0 ^ 0 = 0
        0 ^ 1 = 1
        1 ^ 0 = 1
        1 ^ 1 = 0

        A ^ A = 0

        INDEX:  0  1  2  3  4
        VALUE: {0, 2, 5, 4, 1}

        missing = 5 ^ (0^0) ^ (1^2) ^ (2^5) ^ (3^4) ^ (4^1)
                = (0^0) ^ (1^1) ^ (2^2) ^ (3) ^ (4^4) ^ (5^5)
                = 0 ^ 0 ^ 0 ^ 3 ^ 0 ^ 0
                = 3
     */
    public static int solution1(int[] nums) {
        int result = nums.length;

        for(int i = 0; i < nums.length; i++) {
            result ^= (i ^ nums[i]);
        }

        return result;
    }

    public static int solution2(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        int n = nums.length + 1;
        int sumFormula = (n/2) * (n-1);

        return sumFormula - sum;
    }

    public static int solution3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
