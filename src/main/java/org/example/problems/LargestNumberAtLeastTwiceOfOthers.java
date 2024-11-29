package org.example.problems;

/**
 * 747. Largest Number At Least Twice of Others
 *
 * You are given an integer array nums where the largest integer is unique.
 *
 * Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex_1ms(int[] nums) {
        int result = -1, tmp = -1, ans = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > result) {
                tmp = result;
                result = nums[i];
                ans = i;
            } else if (nums[i] > tmp)
                tmp = nums[i];
        }
        return result >= tmp * 2 ? ans : -1;
    }
}