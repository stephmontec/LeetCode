package DynamicProgramming;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("\n[Solution 1 - Dynamic Programming]: " + Arrays.toString(solution1(n)));
    }

    public static int[] solution1(int n) {
        int[] result = new int[n + 1];
        int offset = 1; // most significant bit (1, 2, 4, 8, 16, 32, ...)

        for(int i = 1; i < result.length; i++) {
            if(offset * 2 == i) { // checking if we have reached a new most significant bit
                offset = i; // as the current value we are counting bits for to be our new most significant bit (MSB)
            }
            result[i] = 1 + result[i - offset]; // add new bit PLUS the remaining bits which were already counted previously (use offset to jump to the correct value the bits will be extracted from)
        }
        return result; // return array of bit counts for values 0 to n
    }
}

