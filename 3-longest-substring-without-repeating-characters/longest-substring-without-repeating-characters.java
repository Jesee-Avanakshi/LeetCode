class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r<s.length()){
            char charR = s.charAt(r);
            if(map.containsKey(charR)){
                char charL = s.charAt(l);
                l = Math.max(map.get(charR),l);
            }
            map.put(charR,r+1);
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}