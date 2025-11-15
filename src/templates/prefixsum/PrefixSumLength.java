package templates.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * PREFIX SUM + HASHMAP - LENGTH PATTERN
 * 
 * Use Case: Find maximum/minimum length of subarray with given property
 * Questions: Contiguous Array, Maximum Size Subarray Sum Equals K
 * 
 * Key Points:
 * - Store FIRST INDEX where prefix sum appears
 * - Base case: map.put(0, -1)
 * - Update ONLY on first occurrence
 * - Calculate length: currentIndex - previousIndex
 * - Track maxLength
 */
public class PrefixSumLength {
    
    /**
     * Template: Find maximum length subarray with sum equal to target
     * Time: O(n), Space: O(n)
     */
    public int maxLengthSubarray(int[] nums, int target) {
        int prefixSum = 0;
        int maxLength = 0;
        
        // Store (prefixSum -> first index where it appeared)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Base case: sum 0 at index -1
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            // Calculate length if target sum found
            if (map.containsKey(prefixSum - target)) {
                int length = i - map.get(prefixSum - target);
                maxLength = Math.max(maxLength, length);
            }
            
            // Store index ONLY on first occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
    
    /**
     * Example: Contiguous Array (LeetCode 525)
     * Find max length subarray with equal 0s and 1s
     */
    public int findMaxLength(int[] nums) {
        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1
            prefixSum += (nums[i] == 0) ? -1 : 1;
            
            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                maxLength = Math.max(maxLength, length);
            } else {
                map.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}
