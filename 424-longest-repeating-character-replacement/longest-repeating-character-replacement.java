class Solution {
    public int characterReplacement(String s, int k) {
        int left =0, right = 0, maxfreq = 0, longest = 0, lengthSubString=0 ;
        Map<Character,Integer> freqMap = new HashMap<>();
        while(right<s.length()){
            char ch = s.charAt(right);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            maxfreq = Math.max(maxfreq,freqMap.get(ch)); 
            lengthSubString = right-left+1;
            if(lengthSubString - maxfreq <=k){
                longest = Math.max(longest,lengthSubString);
            }else{
                char leftch = s.charAt(left);
                freqMap.put(leftch,freqMap.get(leftch)-1);
                left++;
            }
            right++;
        }
    return longest;
    }
}