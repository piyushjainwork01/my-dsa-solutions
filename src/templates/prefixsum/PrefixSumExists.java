package templates.prefixsum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * PREFIX SUM + HASHMAP - EXISTS PATTERN
 * 
 * Use Case: Check if subarray exists with given property
 * Questions: Continuous Subarray Sum
 * 
 * Key Points:
 * - Store presence of prefix sums (Set or Map)
 * - Base case: seen.add(0) or map.put(0, -1)
 * - Return true when condition met
 * - May need index for constraints (use Map)
 */
public class PrefixSumExists {
    
    /**
     * Template: Check if subarray with sum equal to target exists
     * Time: O(n), Space: O(n)
     */
    public boolean existsSubarray(int[] nums, int target) {
        int prefixSum = 0;
        
        // Store prefix sums we've seen
        Set<Integer> seen = new HashSet<>();
        seen.add(0);  // Base case
        
        for (int num : nums) {
            prefixSum += num;
            
            // Check if (prefixSum - target) exists
            if (seen.contains(prefixSum - target)) {
                return true;
            }
            
            seen.add(prefixSum);
        }
        
        return false;
    }
    
    /**
     * Example: Continuous Subarray Sum (LeetCode 523)
     * Check if subarray (size >= 2) exists with sum divisible by k
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;
        
        // Store (remainder -> index)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);  // Base case
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            
            // Get remainder when divided by k
            int remainder = prefixSum % k;
            
            if (map.containsKey(remainder)) {
                // Check if length >= 2
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Store first occurrence
                map.put(remainder, i);
            }
        }
        
        return false;
    }
}
