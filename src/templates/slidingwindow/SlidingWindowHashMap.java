package templates.slidingwindow;

import java.util.*;

/**
 * SLIDING WINDOW + HASHMAP PATTERN
 * 
 * Use Case: Track frequency/count of elements in window
 * Questions: Longest substring with K distinct, Minimum window substring,
 *            Anagrams, Permutations
 * 
 * Key Points:
 * - HashMap tracks element frequency in window
 * - Add to map when expanding (right++)
 * - Remove from map when shrinking (left++)
 * - Check map.size() or specific conditions
 * 
 * Time: O(n), Space: O(k) where k = distinct elements
 */
public class SlidingWindowHashMap {
    
    /**
     * Template: Longest substring with at most K distinct characters
     * Pattern: MAXIMUM length with HashMap
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Expand: add right character
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            // Shrink: while too many distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);  // Important: remove when count = 0
                }
                left++;
            }
            
            // Update result
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Example: Longest Substring Without Repeating Characters (LeetCode 3)
     * Pattern: At most 1 occurrence of each character (no duplicates)
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            
            // Shrink: while any character appears more than once
            while (map.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Template: Minimum window substring (contains all characters)
     * Pattern: MINIMUM length with HashMap (advanced)
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        // What we need
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        // What we have in current window
        Map<Character, Integer> window = new HashMap<>();
        
        int left = 0;
        int matched = 0;  // How many characters are fully matched
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Expand: add right character
            char rightChar = s.charAt(right);
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                // If this character's requirement is fully met
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    matched++;
                }
            }
            
            // Shrink: while all characters matched (valid window)
            while (matched == need.size()) {
                // Update result (we want minimum)
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                
                // Try to shrink from left
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        matched--;  // Losing this character match
                    }
                    window.put(leftChar, window.get(leftChar) - 1);
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    
    /**
     * Template: Find all anagrams (fixed window + HashMap)
     * Pattern: Fixed size window that matches a pattern
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        
        // Target frequency map
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        
        // Window frequency map
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // First window
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }
        if (windowMap.equals(pMap)) result.add(0);
        
        // Slide window
        for (int i = p.length(); i < s.length(); i++) {
            // Add new character (right)
            char newChar = s.charAt(i);
            windowMap.put(newChar, windowMap.getOrDefault(newChar, 0) + 1);
            
            // Remove old character (left)
            char oldChar = s.charAt(i - p.length());
            windowMap.put(oldChar, windowMap.get(oldChar) - 1);
            if (windowMap.get(oldChar) == 0) {
                windowMap.remove(oldChar);
            }
            
            // Check if current window is an anagram
            if (windowMap.equals(pMap)) {
                result.add(i - p.length() + 1);
            }
        }
        
        return result;
    }
    
    /**
     * CRITICAL HashMap Operations in Sliding Window:
     * 
     * 1. ADD element (expand right):
     *    map.put(char, map.getOrDefault(char, 0) + 1)
     * 
     * 2. REMOVE element (shrink left):
     *    map.put(char, map.get(char) - 1)
     *    if (map.get(char) == 0) map.remove(char)  // Important!
     * 
     * 3. CHECK distinct count:
     *    map.size()  // Number of distinct elements
     * 
     * 4. CHECK frequency:
     *    map.get(char)  // Count of specific element
     */


    public long maximumSubarraySum(int[] nums, int k) {

        if (k == 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        long sum = 0, max = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // add right element
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];

            if(right - left +1 == k ){

                if(freq.size() == k){
                    max = Math.max(max, sum);
                }
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0)freq.remove(nums[left]);

                sum -= nums[left];
                left++;
            }


        }
        return max;

    }
}
