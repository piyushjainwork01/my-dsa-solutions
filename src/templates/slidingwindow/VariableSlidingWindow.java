package templates.slidingwindow;

/**
 * SLIDING WINDOW - VARIABLE SIZE PATTERN
 * 
 * Use Case: Window size changes based on condition
 * Questions: Longest/Shortest substring with condition,
 *            Minimum size subarray sum
 * 
 * Key Points:
 * - Two pointers: left and right
 * - Expand right (add elements)
 * - Shrink left (when condition violated)
 * - Track max/min length
 * 
 * Time: O(n), Space: O(1)
 */
public class VariableSlidingWindow {
    
    /**
     * Template: Longest subarray with sum <= target
     * Pattern: MAXIMUM length, so expand and shrink
     */
    public int longestSubarrayWithSum(int[] arr, int target) {
        int left = 0;
        int windowSum = 0;
        int maxLength = 0;
        
        for (int right = 0; right < arr.length; right++) {
            // Expand window: add right element
            windowSum += arr[right];
            
            // Shrink window: while condition violated
            while (windowSum > target && left <= right) {
                windowSum -= arr[left];
                left++;
            }
            
            // Update result: window is valid now
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Template: Minimum length subarray with sum >= target
     * Pattern: MINIMUM length, so shrink when valid
     */
    public int minSubarrayLen(int target, int[] nums) {
        int left = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            // Expand: add right
            windowSum += nums[right];
            
            // Shrink: while condition SATISFIED (we want minimum)
            while (windowSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= nums[left];
                left++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    /**
     * Example: Longest Subarray with Sum At Most K (variation)
     */
    public int longestSubarrayAtMostK(int[] arr, int k) {
        int left = 0, sum = 0, maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > k) {
                sum -= arr[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    
    /**
     * Pattern Recognition Guide:
     * 
     * MAXIMUM length problems:
     *   - Expand right always
     *   - Shrink left when INVALID
     *   - Update result after shrinking (valid state)
     * 
     * MINIMUM length problems:
     *   - Expand right always
     *   - Shrink left when VALID (to find minimum)
     *   - Update result while shrinking
     */
}
