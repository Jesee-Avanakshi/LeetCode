class Solution {
    public int search(int[] nums, int target) {
        int low=0,r=nums.length-1;

        while(low<=r){
            int mid=(low+r)/2;

            if(target==nums[mid]){
                return mid;
            }

            if(nums[low]<=nums[mid]){
                if(target<nums[low]||target>nums[mid]){
                    low=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                if(target>nums[r] || target<nums[mid]){
                    r=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
}