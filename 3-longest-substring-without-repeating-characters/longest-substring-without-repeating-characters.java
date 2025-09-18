class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right=0;
        Set<Character> seen = new HashSet<>();
        int max = Integer.MIN_VALUE;
        while(right<s.length()){
            char rchar = s.charAt(right);
            if(seen.contains(rchar)){
                while(seen.contains(rchar)){
                    char lchar = s.charAt(left);
                    seen.remove(lchar);
                    left++;
                }
            }
            seen.add(rchar);
            max = Math.max(max,right-left+1);
            right++;
            
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}