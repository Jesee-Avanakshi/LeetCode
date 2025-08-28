class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh=0;
        Queue<int[]> queue =new LinkedList<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==2){
                    queue.offer(new int[]{r,c});
                }else if(grid[r][c]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        
        int min =-1;
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            min++;
            for(int i=0;i<size;i++){
                int[] orange = queue.poll();
                int r = orange[0], c= orange[1];
                for(int[] d:directions){
                    int nr = r+d[0];
                    int nc = c+d[1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                        grid[nr][nc] =2;
                        fresh--;
                        queue.offer(new int[] {nr,nc});
                    }
                }
                
            }  
            System.out.print(min);
            System.out.println(fresh);
            
        }

        return fresh>0?-1:min;
    }
}


















