package com.krishnamurti.tipsandtricks.bitmanipulation;

public class BitManipulationTricks {
    // 1. Isolate Rightmost Set Bit: x & -x
    // - Returns a number with only the rightmost 1 bit set (all others 0)
    // - Use: Split numbers in Single Number III, check power of 2
    // - How: Two's complement (-x = ~x + 1) keeps rightmost 1, AND keeps only that bit
    // - Example: x = 6 (0110), -x = -6 (1010), x & -x = 0010 (2)
    static int getRightmostSetBit(int x) {
        return x & -x;
    }
    // LC Problems: Single Number III (#260), Power of Two (#231)

    // 2. Clear Rightmost Set Bit: x & (x - 1)
    // - Turns the rightmost 1 bit to 0, keeps others unchanged
    // - Use: Count set bits, iterate over 1 bits
    // - How: x - 1 flips rightmost 1 to 0 and trailing 0s to 1s, AND clears the 1
    // - Example: x = 6 (0110), x - 1 = 5 (0101), x & (x - 1) = 0100 (4)
    static int clearRightmostSetBit(int x) {
        return x & (x - 1);
    }
    // LC Problems: Number of 1 Bits (#191), Counting Bits (#338)

    // 3. Check if Power of 2: (x & (x - 1)) == 0
    // - Checks if x has exactly one 1 bit (e.g., 1, 2, 4, 8)
    // - Use: Validate power of 2, optimize math operations
    // - How: Powers of 2 have one 1 (e.g., 4 = 0100), x & (x - 1) clears it to 0
    // - Example: x = 4 (0100), x - 1 = 3 (0011), 0100 & 0011 = 0
    static boolean isPowerOfTwo(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }
    // LC Problems: Power of Two (#231), Count Bits (#338)

    // 4. Toggle a Bit: x ^ (1 << k)
    // - Flips the k-th bit (0 to 1, or 1 to 0)
    // - Use: Modify specific bits, solve bit-flipping problems
    // - How: 1 << k creates mask with 1 at k, XOR toggles that bit
    // - Example: x = 6 (0110), k = 1, 1 << 1 = 0010, 0110 ^ 0010 = 0100 (4)
    static int toggleBit(int x, int k) {
        return x ^ (1 << k);
    }
    // LC Problems: Single Number (#136), Reverse Bits (#190)

    // 5. Check if k-th Bit is Set: (x & (1 << k)) != 0
    // - Tests if the k-th bit is 1
    // - Use: Inspect bits, solve bit-based conditions
    // - How: 1 << k masks the k-th bit, AND checks if it’s 1
    // - Example: x = 6 (0110), k = 2, 1 << 2 = 0100, 0110 & 0100 = 0100 (non-zero)
    static boolean isKthBitSet(int x, int k) {
        return (x & (1 << k)) != 0;
    }
    // LC Problems: Number of 1 Bits (#191), Single Number II (#137)

    // 6. Set k-th Bit: x | (1 << k)
    // - Sets the k-th bit to 1 (leaves others unchanged)
    // - Use: Build numbers, modify bit patterns
    // - How: 1 << k creates mask, OR sets the bit to 1
    // - Example: x = 6 (0110), k = 0, 1 << 0 = 0001, 0110 | 0001 = 0111 (7)
    static int setKthBit(int x, int k) {
        return x | (1 << k);
    }
    // LC Problems: Reverse Bits (#190), Single Number II (#137)

    // 7. Clear k-th Bit: x & ~(1 << k)
    // - Sets the k-th bit to 0 (leaves others unchanged)
    // - Use: Reset specific bits, solve bit-clearing problems
    // - How: ~(1 << k) creates mask with 0 at k, AND clears that bit
    // - Example: x = 6 (0110), k = 1, 1 << 1 = 0010, ~(0010) = 1101, 0110 & 1101 = 0100 (4)
    static int clearKthBit(int x, int k) {
        return x & ~(1 << k);
    }
    // LC Problems: Reverse Bits (#190), Number of 1 Bits (#191)

    // 8. Count Set Bits (Hamming Weight): Loop with x & (x - 1)
    // - Counts number of 1 bits in x
    // - Use: Compute bit differences, solve counting problems
    // - How: Repeatedly clear rightmost 1 until x = 0, count iterations
    // - Example: x = 6 (0110), 0110 & 0101 = 0100, 0100 & 0011 = 0000, count = 2
    static int countSetBits(int x) {
        int count = 0;
        while (x != 0) {
            x &= (x - 1); // Clear rightmost 1
            count++;
        }
        return count;
    }
    // LC Problems: Number of 1 Bits (#191), Hamming Distance (#461)

    // 9. Get Lowest Set Bit Index: Integer.numberOfTrailingZeros(x)
    // - Returns the index of the rightmost 1 bit (or 32 if x = 0)
    // - Use: Find bit positions, optimize bit-based loops
    // - How: Uses hardware instruction or x & -x, counts trailing zeros
    // - Example: x = 6 (0110), rightmost 1 at bit 1, returns 1
    static int lowestSetBitIndex(int x) {
        return Integer.numberOfTrailingZeros(x);
    }
    // LC Problems: Single Number III (#260), Power of Two (#231)

    // 10. Swap Bits: x ^ y, then update
    // - Swaps values of two integers without a temporary variable
    // - Use: Optimize space, solve bit-based swapping
    // - How: XOR stores differences, repeated XORs swap values
    // - Example: x = 6 (0110), y = 3 (0011), x ^= y (0101), y ^= x (0011), x ^= y (0110)
    static int[] swapBits(int x, int y) {
        x ^= y;
        y ^= x;
        x ^= y;
        return new int[] {x, y};
    }
    // LC Problems: Not directly used, but handy in bit-heavy problems like Reverse Bits (#190)

    // Time Complexity for all tricks: O(1) per operation
    // - Most operations (AND, XOR, OR, NOT, shifts) are single CPU instructions
    // - Exception: countSetBits is O(k) where k is number of 1 bits (max 32 for int)
    // Space Complexity: O(1)
    // - Only use a few variables, no extra data structures
}
