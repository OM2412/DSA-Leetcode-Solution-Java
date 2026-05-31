// LC #1 - Two Sum
// Date: May 31, 2026
// Approach: Brute Force - O(n²) time, O(1) space
// TODO: Optimize with HashMap after learning HashMaps → O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}