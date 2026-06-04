class Solution {
    public int firstMissingPositive(int[] nums) {

        // Start from index 0
        int i = 0;

        // Place every valid positive number at its correct index
        while (i < nums.length) {

            // Correct index of current number
            int correct = nums[i] - 1;

            // Swap only if:
            // 1. Number is positive
            // 2. Number is within array range
            // 3. Number is not already at its correct position
            if (nums[i] > 0 &&
                nums[i] <= nums.length &&
                nums[i] != nums[correct]) {

                swap(nums, i, correct);
            } else {
                i++;
            }
        }

        // Find first index where number is incorrect
        for (int index = 0; index < nums.length; index++) {

            // Missing positive number found
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        // If all positions are correct
        return nums.length + 1;
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
