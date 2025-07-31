class Solution {
    public int characterReplacement(String s, int k) {
        int left =0, right = 0, maxfreq = 0, longest = 0 ;
       int[] freq = new int[26]; 
        while(right<s.length()){
            char ch = s.charAt(right);
            freq[ch-'A']++;
            maxfreq = Math.max(maxfreq,freq[ch-'A']); 
            int lengthSubString = right-left+1;
            if(lengthSubString - maxfreq <=k){
                longest = Math.max(longest,lengthSubString);
            }else{
                char leftch = s.charAt(left);
                freq[leftch -'A']--;
                left++;
            }
            right++;
        }
    return longest;
    }
}