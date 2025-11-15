package week1;

import java.util.*;

public class Week1 {

    // Contains Duplicate Revision

    /*Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

*/

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;

    }


    //219. Contains Duplicate II
    /*Given an integer array nums and an integer k, return true if
    there are two distinct indices i and j in the array such
     that nums[i] == nums[j] and abs(i - j) <= k.

     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int previosIndex = map.get(nums[i]);
                if ((i - previosIndex) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // Valid Anagram
    /*Given two strings s and t, return true if t is an anagram of s, and false otherwise.*/

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                int value = map.get(ch);
                if (value == 0) {
                    return false;
                } else {
                    map.put(ch, value - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // 49. Group Anagrams

    /*Given an array of strings strs, group the anagrams together.
     You can return the answer in any order.*/

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }


    //1. Two Sum

    /*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.*/

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // Work like everyone is watching you let's do this buddy

    // Isomorphic Strings

    /*Given two strings s and t, determine if they are isomorphic.
    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
    All occurrences of a character must be replaced with another character while preserving
    the order of characters. No two characters may map to the same character, but a character may map to itself.*/


    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;
        Map<Character, Character> stot = new HashMap<>();
        Map<Character, Character> ttos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (stot.containsKey(sc)) {
                if (stot.get(sc) != tc) {
                    return false;
                }
            } else {
                stot.put(sc, tc);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (ttos.containsKey(tc)) {
                if (ttos.get(tc) != sc) {
                    return false;
                }
            } else {
                ttos.put(tc, sc);
            }
        }
        return true;
    }

    public int firstUniqChar(String s) {
        // ye wala question mere se hua nhi tha ek bar mai so i am going to solve this again

        Map<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i =0;i<arr.length;i++){
            if(map.get(arr[i])== 1){
                return i;
            }
        }
        return -1;
    }

    // Happy Number.


    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            if(seen.contains(n)){
                return false;
            }
            seen.add(n);
            int sumOfSquare = 0;
            while(n >0){
                int ld = n %10;
                sumOfSquare += ld*ld;
                n = n / 10;
            }
            n = sumOfSquare;


        }
        return true;
    }


}



