class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int start=-1,end=-1;
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    start=l;
                    end = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return start==-1 ? "" : s.substring(start, end + 1);

        // Map<Character,Integer> smap =new HashMap<>();
        // Map<Character,Integer> tmap =new HashMap<>();

        // for(int i=0;i<t.length();i++){
        //     char c = t.charAt(i);
        //     tmap.put(c,tmap.getOrDefault(c,0)+1);
        // }

        // int l=0,need =t.length(),have=0;
        // int minimum = s.length()+1;
        // int start=-1,end=-1;

        // for(int r=0;r<s.length();r++){
        //     char rc =s.charAt(r);
        //     smap.put(rc,smap.getOrDefault(rc,0)+1);
            
        //     if(tmap.containsKey(rc) && tmap.get(rc).equals(smap.get(rc))){
        //         have++;
        //     }

        //     while(have==need){
        //         if(minimum>(r-l+1)){
        //             minimum =r-l+1;
        //             start =l;
        //             end=r;
        //         }
        //         char lc =s.charAt(l);
        //         smap.put(lc,smap.get(lc)-1);
        //         l++;
        //         if(tmap.containsKey(lc) && smap.get(lc)<tmap.get(lc)){
        //             have--;
        //         }
        //     }

        // }
        // return start==-1?"":s.substring(start,end+1);

    }
}