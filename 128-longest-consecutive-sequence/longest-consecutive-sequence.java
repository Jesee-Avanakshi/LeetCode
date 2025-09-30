class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num:nums){
            num_set.add(num);
        }

        int longestStreak = 0;
        for(int num:num_set){
            if(!num_set.contains(num-1)){
                int curr_num = num;
                int curr_streak = 1;
                while(num_set.contains(curr_num+1)){
                    curr_num++;
                    curr_streak++;
                }

                longestStreak = Math.max(longestStreak,curr_streak);
            }
        }
        return longestStreak;
    }
}