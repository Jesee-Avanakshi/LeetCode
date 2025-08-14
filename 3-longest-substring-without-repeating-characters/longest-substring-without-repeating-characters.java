class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map =new HashMap<>();

        int l=0,r=0, longest=0;
        while(r<s.length()){
            char rightChar = s.charAt(r);
            while (map.containsKey(rightChar) && map.get(rightChar)>0 && l<=r){
                char leftChar = s.charAt(l);
                map.put(leftChar,map.get(leftChar)-1);
                l++;
            }

            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            System.out.println(r-l+1);
            longest = Math.max(longest,r-l+1);
            r++;
        }
        return longest;
    }
}