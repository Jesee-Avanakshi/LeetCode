class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int count =0;
        int[] prevInterval = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(prevInterval[1] <=intervals[i][0]){
                prevInterval[0] = intervals[i][0];
                prevInterval[1] = intervals[i][1];
            }else{
                prevInterval[1] = Math.min(intervals[i][1],prevInterval[1]);
                count++;
            }
        }
        return count;

    }
}