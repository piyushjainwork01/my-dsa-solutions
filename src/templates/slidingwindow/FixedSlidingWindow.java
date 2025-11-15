package templates.slidingwindow;

/**
 * SLIDING WINDOW - FIXED SIZE PATTERN
 * 
 * Use Case: Window size is known/fixed (k elements)
 * Questions: Maximum Sum Subarray of Size K, Maximum Average Subarray,
 *            Fixed size problems
 * 
 * Key Points:
 * - Window size = k (constant)
 * - Calculate first window
 * - Slide: add right, remove left
 * - Update result at each step
 * 
 * Time: O(n), Space: O(1)
 */
public class FixedSlidingWindow {
    
    /**
     * Template: Maximum sum of k consecutive elements
     */
    public int maxSumFixedWindow(int[] arr, int k) {
        if (arr.length < k) return -1;
        
        // Calculate first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        
        // Slide window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];        // Add new element (right)
            windowSum -= arr[i - k];    // Remove old element (left)
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Example: Maximum Average Subarray (LeetCode 643)
     */
    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        
        int maxSum = windowSum;
        
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return (double) maxSum / k;
    }
    
    /**
     * Pattern Variation: Fixed window with condition check
     * Example: Check if any k-length subarray has sum >= target
     */
    public boolean hasSubarrayWithSum(int[] arr, int k, int target) {
        int windowSum = 0;
        
        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        if (windowSum >= target) return true;
        
        // Slide and check
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            if (windowSum >= target) return true;
        }
        
        return false;
    }
}
