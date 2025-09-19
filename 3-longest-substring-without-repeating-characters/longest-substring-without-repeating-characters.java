class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        while(right<s.length()){
            char charR = s.charAt(right);
            if(seen.contains(charR)){
                while(seen.contains(charR)){
                    char charL = s.charAt(left);
                    seen.remove(charL);
                    left++;
                }
            }
            seen.add(charR);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}