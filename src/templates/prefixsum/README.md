# Prefix Sum + HashMap Templates

## Quick Decision Guide
```
Question asks for:
├─ "How many" / "Count" / "Number of"
│   └─> Use PrefixSumCount.java
│
├─ "Maximum length" / "Longest" / "Length of"  
│   └─> Use PrefixSumLength.java
│
└─ "Check if exists" / "Does there exist" / "Return true/false"
    └─> Use PrefixSumExists.java
```

## Pattern Comparison

| Feature | COUNT | LENGTH | EXISTS |
|---------|-------|--------|--------|
| **Data Structure** | `Map<Integer, Integer>` | `Map<Integer, Integer>` | `Set<Integer>` or Map |
| **Map stores** | Frequency | First Index | Presence |
| **Base case** | `{0: 1}` | `{0: -1}` | `add(0)` |
| **Update** | Always | Only first time | Always |
| **Return** | int (count) | int (max length) | boolean |

## Practice Problems

### COUNT Pattern
- [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
- [930. Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/)
- [974. Subarray Sums Divisible by K](https://leetcode.com/problems/subarray-sums-divisible-by-k/)

### LENGTH Pattern
- [525. Contiguous Array](https://leetcode.com/problems/contiguous-array/)
- [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)

### EXISTS Pattern
- [523. Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/)

## Usage Example
```java
// Import the template
import templates.prefixsum.PrefixSumCount;

// Use it in your solution
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        PrefixSumCount template = new PrefixSumCount();
        return template.countSubarrays(nums, k);
    }
}
```
