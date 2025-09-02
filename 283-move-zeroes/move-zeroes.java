class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount =0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==0){
                zeroCount++;
                j++;
            }else{
                nums[i] =nums[j];
                j++;
                i++;
            }
        }
        while(i<nums.length){
            nums[i] =0;
            i++;
        }
    }
}