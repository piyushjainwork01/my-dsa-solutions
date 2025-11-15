# Sliding Window Templates

## Quick Decision Guide
```
What kind of problem?
│
├─ Fixed window size (k given)
│   ├─ Just sum/max/min → FixedSlidingWindow.java
│   └─ Need frequencies/anagrams → SlidingWindowHashMap.java (findAnagrams)
│
└─ Variable window size
    ├─ Find MAXIMUM length → VariableSlidingWindow.java (expand/shrink)
    ├─ Find MINIMUM length → VariableSlidingWindow.java (shrink when valid)
    └─ Track characters/elements → SlidingWindowHashMap.java
```

## Pattern Comparison

| Pattern | Window Size | Data Structure | When to Use |
|---------|-------------|----------------|-------------|
| **Fixed** | Constant (k) | Array/variables | "k consecutive", "window of size k" |
| **Variable** | Dynamic | Two pointers | "longest/shortest subarray" |
| **HashMap** | Dynamic | Map + pointers | "distinct", "frequency", "anagram" |

## The Golden Rules

### Rule 1: Fixed Window
```
1. Calculate first window
2. Slide: add right, remove left
3. Update result each step
```

### Rule 2: Variable Window (Maximum Length)
```
1. Expand right (always add)
2. Shrink left (when condition violated)
3. Update result after shrinking
```

### Rule 3: Variable Window (Minimum Length)
```
1. Expand right (always add)
2. Shrink left (when condition satisfied)
3. Update result while shrinking
```

### Rule 4: HashMap Operations
```
ADD: map.put(char, map.getOrDefault(char, 0) + 1)
REMOVE: 
  map.put(char, map.get(char) - 1)
  if (map.get(char) == 0) map.remove(char)
```

## Common Mistakes to Avoid

❌ **Mistake 1:** Forgetting to remove from map when count = 0
```java
// Wrong
map.put(leftChar, map.get(leftChar) - 1);

// Correct
map.put(leftChar, map.get(leftChar) - 1);
if (map.get(leftChar) == 0) map.remove(leftChar);
```

❌ **Mistake 2:** Wrong loop for fixed window
```java
// Wrong: recalculating entire window
for (int i = 0; i < arr.length - k + 1; i++) {
    sum = 0;
    for (int j = i; j < i + k; j++) sum += arr[j];  // O(n*k)
}

// Correct: sliding window
windowSum += arr[i] - arr[i - k];  // O(n)
```

❌ **Mistake 3:** Updating result at wrong time
```java
// For MAXIMUM length: update after shrinking
while (invalid) { shrink; }
maxLen = Math.max(maxLen, right - left + 1);  // ✅

// For MINIMUM length: update while shrinking
while (valid) {
    minLen = Math.min(minLen, right - left + 1);  // ✅
    shrink;
}
```

## Practice Problems (By Difficulty)

### Easy - Start Here
1. [643. Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) - Fixed window
2. [1984. Minimum Difference Between Highest and Lowest](https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/) - Fixed window

### Medium - Core Practice
3. [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) - HashMap + Variable
4. [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) - HashMap + Fixed
5. [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) - Variable (minimum)
6. [340. Longest Substring with At Most K Distinct](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) - HashMap + Variable
7. [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) - HashMap + Variable
8. [567. Permutation in String](https://leetcode.com/problems/permutation-in-string/) - HashMap + Fixed

### Hard - Master Level
9. [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) - HashMap + Variable (minimum)
10. [239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) - Deque + Fixed
11. [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) - HashMap + Fixed

## Template Usage Example
```java
// Import template
import templates.slidingwindow.SlidingWindowHashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // Use template directly
        SlidingWindowHashMap template = new SlidingWindowHashMap();
        return template.lengthOfLongestSubstring(s);
    }
    
    // Or write your own based on template
    public int lengthOfLongestSubstringCustom(String s) {
        // Your implementation using template as reference
    }
}
```

## Visual Guide

### Fixed Window (size k=3)
```
[1, 3, -1, -3, 5, 3, 6, 7]
 └──┬──┘           Window 1: sum = 3
    └──┬──┘        Window 2: sum = -1
       └──┬──┘     Window 3: sum = 1
```

### Variable Window (max length, sum ≤ 6)
```
[2, 1, 5, 1, 3, 2]
 └─┬┘              Window: [2,1] sum=3 ✅
 └──┬─┘            Window: [2,1,5] sum=8 ❌ shrink
    └─┬┘           Window: [1,5] sum=6 ✅
    └──┬┘          Window: [1,5,1] sum=7 ❌ shrink
       └┬┘         Window: [5,1] sum=6 ✅
```

## Time Complexity

| Pattern | Time | Space | Why? |
|---------|------|-------|------|
| Fixed | O(n) | O(1) | Single pass, constant operations |
| Variable | O(n) | O(1) | Each element added/removed once |
| HashMap | O(n) | O(k) | Single pass, k = distinct elements |

**Key insight:** Even with nested while loop, each element is processed at most twice (once by right, once by left).
