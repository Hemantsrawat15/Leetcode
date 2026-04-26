class Solution {
    public boolean containsCycle(char[][] grid) {
        // Step 1: Initialize your instance variables
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // Step 2: Iterate over every cell
        //         Why do we need to iterate all cells and not just start from (0,0)?
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(i,j,grid,visited,-1,-1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col,char[][] grid, boolean[][] visited, int parentRow, int parentCol) {
        int m = grid.length;
        int n = grid[0].length;
        visited[row][col] = true;
        
            // up
            if(row-1>=0 && grid[row-1][col] == grid[row][col] && !(row-1 == parentRow && col == parentCol)){
                if(visited[row-1][col]) return true;
                if(dfs(row-1,col,grid,visited,row,col)) return true;
            }
            // right
            if(col+1<n && grid[row][col+1] == grid[row][col] && !(row == parentRow && col+1 == parentCol)){
                if(visited[row][col+1]) return true;
                if(dfs(row,col+1,grid,visited,row,col)) return true;
            }
            // down
            if(row+1<m && grid[row+1][col] == grid[row][col] && !(row+1 == parentRow && col==parentCol)){
                if(visited[row+1][col]) return true;
                if(dfs(row+1,col,grid,visited,row,col)) return true;
            }
            // left
            if(col-1>=0 && grid[row][col-1] == grid[row][col] && !(row == parentRow && col-1 == parentCol)){
                if(visited[row][col-1]) return true;
                if(dfs(row,col-1,grid,visited,row,col)) return true;
            }
        return false;
    }
}