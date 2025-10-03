class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int longest = 0;
        for(int r=0; r< s.length();r++){
            char charR = s.charAt(r);
            while(seen.contains(charR)){
                char charL = s.charAt(l);
                seen.remove(charL);
                l++;
            }
            longest = Math.max(longest,r-l+1);
            seen.add(charR);
        }
        return longest;
    }
}