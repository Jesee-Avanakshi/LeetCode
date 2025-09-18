class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k%l;
        //reverse the array
        reverse(nums,0,l-1);
        //reverse first k elements
        reverse(nums,0,k-1);
        // reverse remaining elements
        reverse(nums,k,l-1);
    }
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}