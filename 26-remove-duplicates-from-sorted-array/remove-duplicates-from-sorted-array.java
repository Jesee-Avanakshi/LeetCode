class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int left=1;
        while(left<nums.length){
            if(nums[left]!=nums[k-1]){
                nums[k]=nums[left];
                k++;
            }
            left++;
        }
        return k;
    }
}