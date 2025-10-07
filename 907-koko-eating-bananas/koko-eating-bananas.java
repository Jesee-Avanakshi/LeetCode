class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while(l<=r){
            int speed = (l+r)/2;
            long totalTime = 0;
            for(int p:piles){
                totalTime+=(Math.ceil((double)p/speed));
            }
            if(totalTime<=h){
                res = speed;
                r = speed-1;
            }else{
                l = speed+1;
            }
        }
        return res;
        
    }
}