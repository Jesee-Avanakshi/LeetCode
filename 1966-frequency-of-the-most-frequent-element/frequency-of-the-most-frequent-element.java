class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long windowSum = 0;

        for (int right = 0; right < nums.length; right++) {
            windowSum += nums[right];  // Add new element to window sum
            int windowSize = right - left + 1;

            // Check if we need more than k increments to make all numbers equal to nums[right]
            while ((long) nums[right] * windowSize - windowSum > k) {
                // Shrink window from the left
                windowSum -= nums[left];
                left++;
                windowSize = right - left + 1; // update window size
            }

            ans = Math.max(ans, windowSize);
        }

        return ans;
    }
}
