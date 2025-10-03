class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Set<Character> seen = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int longest = 0;
        for(int r=0; r< s.length();r++){
            char charR = s.charAt(r);
            if(map.containsKey(charR)){
                l = Math.max(map.get(charR) + 1,l);
            }
            longest = Math.max(longest,r-l+1);
            map.put(charR,r);
        }
        return longest;
    }
}