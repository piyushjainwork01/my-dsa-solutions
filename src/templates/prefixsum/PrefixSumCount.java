package templates.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * PREFIX SUM + HASHMAP - COUNT PATTERN
 * 
 * Use Case: Count number of subarrays with given property
 * Questions: Subarray Sum Equals K, Binary Subarrays With Sum, 
 *            Subarrays Divisible by K
 * 
 * Key Points:
 * - Store FREQUENCY of prefix sums
 * - Base case: map.put(0, 1)
 * - ALWAYS update frequency
 * - Return total count
 */
public class PrefixSumCount {
    
    /**
     * Template: Count subarrays with sum equal to target
     * Time: O(n), Space: O(n)
     */
    public int countSubarrays(int[] nums, int target) {
        int prefixSum = 0;
        int count = 0;
        
        // Store (prefixSum -> frequency)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Base case: sum 0 has frequency 1
        
        for (int num : nums) {
            prefixSum += num;
            
            // If (prefixSum - target) exists, add its frequency to count
            if (map.containsKey(prefixSum - target)) {
                count += map.get(prefixSum - target);
            }
            
            // Update frequency (ALWAYS)
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
    
    /**
     * Example: Subarray Sum Equals K (LeetCode 560)
     */
    public int subarraySum(int[] nums, int k) {
        return countSubarrays(nums, k);
    }
}
