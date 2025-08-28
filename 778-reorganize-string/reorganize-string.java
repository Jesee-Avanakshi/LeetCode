class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                if(freq[i] > (s.length()+1)/2){
                    return "";
                }
                maxheap.offer(new int[]{i,freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while(maxheap.size()>1){
            int[] first = maxheap.poll();
            int[] second =maxheap.poll();

            result.append((char)(first[0]+'a'));
            result.append((char)(second[0]+'a'));
            first[1]--;
            second[1]--;
            if(first[1]>0){
                maxheap.offer(first);
            }
            if(second[1]>0){
                maxheap.offer(second);
            }
        }
        if(!maxheap.isEmpty()){
            result.append((char)(maxheap.poll()[0]+'a'));
        }
        return result.toString();
    }
}