class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] interval:intervals){
            int start =0;
            int end=1;
            if(newInterval== null || interval[end]<newInterval[start]){
                res.add(interval);
            }else if(interval[start]>newInterval[end]){
                res.add(newInterval);
                res.add(interval);
                newInterval= null;
            }else{
                newInterval[start] = Math.min(newInterval[start],interval[start]);
                newInterval[end] = Math.max(newInterval[end],interval[end]);
            }
        }
        if(newInterval!=null){
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}