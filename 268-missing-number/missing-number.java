class Solution {
    public int missingNumber(int[] nums) {
        int[] freq = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums.length){
                freq[nums[i]]++; 
            }
        }

        for(int i=0;i<nums.length+1;i++){
            if(freq[i]==0) return i;
        }
        return 0;
    }
}