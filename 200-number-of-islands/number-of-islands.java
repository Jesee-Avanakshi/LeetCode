class Solution {
    public int numIslands(char[][] grid) {
        int ROWS =grid.length;
        int COLS = grid[0].length;
        int island=0;
        for(int r=0;r<ROWS;r++){
            for(int c=0;c<COLS;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid,int r, int c){

        if(r<0 || r>=grid.length||c<0||c>=grid[0].length|| grid[r][c]=='0'){
            return;
        }

        grid[r][c]='0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);

    }
}