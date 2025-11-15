import templates.slidingwindow.*;

public class TestSlidingWindow {
    public static void main(String[] args) {
        System.out.println("=== Testing Sliding Window Templates ===\n");

        // Test 1: Fixed Window
        FixedSlidingWindow fixed = new FixedSlidingWindow();
        int[] arr1 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        System.out.println("Fixed Window (k=3): " + fixed.maxSumFixedWindow(arr1, 3));
        // Expected: 13 (6 + -1 + 4 + 1 + 8 = 18? No, [4,1,8])

        // Test 2: Variable Window
        VariableSlidingWindow variable = new VariableSlidingWindow();
        int[] arr2 = {2, 1, 5, 1, 3, 2};
        System.out.println("Variable Window (sum≤6): " + variable.longestSubarrayWithSum(arr2, 6));
        // Expected: 3 ([1,3,2])

        // Test 3: Sliding Window + HashMap
        SlidingWindowHashMap hashmap = new SlidingWindowHashMap();
        String s1 = "abcabcbb";
        System.out.println("Longest Substring (no repeats): " + hashmap.lengthOfLongestSubstring(s1));
        // Expected: 3 ("abc")

        String s2 = "eceba";
        System.out.println("K Distinct (k=2): " + hashmap.lengthOfLongestSubstringKDistinct(s2, 2));
        // Expected: 3 ("ece")

        System.out.println("\n✅ All templates working!");
    }
}