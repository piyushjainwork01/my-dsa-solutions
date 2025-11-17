package templates.twopointers;

/**
 * TWO POINTERS PATTERN (SAME DIRECTION)
 *
 * Use Case: Process array/list with two pointers moving in same direction
 * Questions: Remove duplicates, Remove element, Move zeros, Partition array
 *
 * Key Points:
 * - Both pointers start at beginning (usually index 0)
 * - Fast pointer explores/reads elements
 * - Slow pointer writes/places valid elements
 * - Fast pointer always >= slow pointer
 *
 * Time: O(n), Space: O(1) - in-place modification
 */
public class TwoPointerSameDirection {

    /**
     * Template 1: Remove Element Pattern
     * USE: When you need to remove certain elements in-place
     * PATTERN: Skip unwanted, keep wanted
     */
    public int removeElement(int[] nums, int val) {
        int slow = 0;  // Position to write next valid element

        for (int fast = 0; fast < nums.length; fast++) {
            // If current element is valid (not the one to remove)
            if (nums[fast] != val) {
                nums[slow] = nums[fast];  // Write it
                slow++;  // Move write position
            }
            // If invalid, fast pointer just skips it
        }

        return slow;  // New length (slow is now the count of valid elements)
    }

    /**
     * Template 2: Remove Duplicates from Sorted Array
     * USE: Keep only unique elements in sorted array
     * PATTERN: Compare with previous, only write if different
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 1;  // Start at 1, first element always stays

        for (int fast = 1; fast < nums.length; fast++) {
            // Only write if different from previous unique element
            if (nums[fast] != nums[slow - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        return slow;
    }

    /**
     * Template 3: Move Zeros
     * USE: Move all zeros to end while maintaining order of non-zeros
     * PATTERN: Collect non-zeros first, fill rest with zeros
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;  // Position for next non-zero

        // Phase 1: Collect all non-zeros
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // Phase 2: Fill remaining with zeros
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    /**
     * Template 3 (Optimized): Move Zeros with Swap
     * USE: Same as above but more elegant
     * PATTERN: Swap non-zero with slow position
     */
    public void moveZeroesSwap(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // Swap only if they're different positions
                if (slow != fast) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
    }

    /**
     * Template 4: Partition Array (Dutch National Flag - simplified)
     * USE: Partition array based on condition (e.g., even before odd)
     * PATTERN: Slow marks boundary, fast explores
     */
    public void sortArrayByParity(int[] nums) {
        int slow = 0;  // Boundary: everything before slow is even

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 0) {  // If even
                // Swap to put even number in "even section"
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }

    /**
     * Template 5: Squares of Sorted Array (works with negatives)
     * USE: Square sorted array (with negatives), result should be sorted
     * PATTERN: Compare from both ends, largest absolute values are at ends
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1;  // Fill result from right to left (largest first)

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[pos] = leftSquare;
                left++;
            } else {
                result[pos] = rightSquare;
                right--;
            }
            pos--;
        }

        return result;
    }

    /**
     * MENTAL MODEL - Same Direction:
     *
     * [X X X X X X X X X]
     *  ↑       ↑
     *  slow    fast
     *
     * - slow: "write here next" or "valid section ends here"
     * - fast: "currently reading/exploring"
     * - fast finds valid elements, slow places them
     *
     * DECISION TREE:
     * 1. Is nums[fast] valid/wanted?
     *    YES → Write to slow, increment slow
     *    NO  → Skip, only increment fast
     *
     * 2. Loop continues until fast reaches end
     * 3. Return slow (often the new length)
     */
}