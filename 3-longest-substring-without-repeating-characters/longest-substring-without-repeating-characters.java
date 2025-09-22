class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        while(right<s.length()){
            char rightChar = s.charAt(right);
            if(set.contains(rightChar)){
                while(set.contains(rightChar) && left<=right){
                    char leftChar = s.charAt(left);
                    set.remove(leftChar);
                    left++;
                }
            }
            set.add(rightChar);
            longest = Math.max(longest,right-left+1);
            right++;
        }
        return longest;
    }
}