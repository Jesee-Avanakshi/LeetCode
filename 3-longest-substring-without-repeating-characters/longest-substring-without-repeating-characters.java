class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(right<s.length()){
            char charR = s.charAt(right);
            if(map.containsKey(charR)){
                left = Math.max(map.get(charR) + 1,left);
            }
            map.put(charR,right);
            maxLength = Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}