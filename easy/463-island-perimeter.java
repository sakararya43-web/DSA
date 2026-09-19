class Solution {

    private int dfs(int row, int col, int[][] grid, int[][] vis) {

        vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int perimeter = 0;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++) {

            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            
            if(nrow < 0 || nrow >= n || ncol < 0 || ncol >= m) {
                perimeter++;
            }

            
            else if(grid[nrow][ncol] == 0) {
                perimeter++;
            }

            
            else if(grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                perimeter += dfs(nrow, ncol, grid, vis);
            }
        }

        return perimeter;
    }

    public int islandPerimeter(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    return dfs(i, j, grid, vis);
                }
            }
        }

        return 0;
    }
}