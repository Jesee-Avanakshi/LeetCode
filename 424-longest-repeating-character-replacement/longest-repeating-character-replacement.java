class Solution {
    public int characterReplacement(String s, int k) {
        int left =0,right=0,longest=0,maxfreq=0;

        Map<Character,Integer> freqMap = new HashMap<>();

        while(right<s.length()){
            char rightChar = s.charAt(right);
            freqMap.put(rightChar,freqMap.getOrDefault(rightChar,0)+1);
            maxfreq =Math.max(maxfreq,freqMap.get(rightChar));
            int lengthSubstring = right-left+1;
            if(lengthSubstring-maxfreq <=k){
                longest =Math.max(longest,lengthSubstring);
            }else{
                char leftChar = s.charAt(left);
                freqMap.put(leftChar,freqMap.get(leftChar)-1);
                left++;
            }
            right++;
        }
        return longest;
    }
}