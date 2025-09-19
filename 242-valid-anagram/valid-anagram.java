class Solution {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] result = new int[26];
        
        for(int i=0;i<s.length();i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            result[charS-'a']++;
            result[charT-'a']--;
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != 0){
                return false;
            }
        }

        return true;
    }
    // public boolean isAnagram(String s, String t) {
    //     if(s.length()!=t.length()) return false;
    //     Map<Character,Integer> mapS = new HashMap<>();
    //     Map<Character,Integer> mapT = new HashMap<>();
    //     for(int i=0;i<s.length();i++){
    //         mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)+1);
    //         mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
    //     }
    //     return mapS.equals(mapT);
    // }
}