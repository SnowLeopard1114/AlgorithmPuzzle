public class Amazon2DServers {
    public static void main(String[] args) {
        String[] grid = new String[3];
        grid[0] = "aabba";
        grid[1] = "aabba";
        grid[2] = "aaacb";

        System.out.println(findServer(grid, 3));
    }
    public static int findServer(String[] grid, int row){
        if(grid == null || grid.length == 0)
            return 0;
        int res = 0;
        int n = row, m = grid[0].length();
        char[][] arr = new char[n][m];
        boolean[][] visited = new boolean[n][m];


        for(int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                arr[i][j] = grid[i].charAt(j);
            }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false) {
                    DFS(i, j, arr, visited, arr[i][j], n, m);
                    res++;
                }
            }
        }


        return res;
    }

    private static void DFS(int i, int j, char[][] arr, boolean[][] visited, char letter, int n, int m){
        visited[i][j] = true;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for(int k = 0;  k < 4; k++){
            int tx = i + dx[k];
            int ty = j + dy[k];
            if(tx >= 0 && tx < n && ty >= 0 && ty < m && visited[tx][ty] == false && arr[tx][ty] ==  arr[i][j])
                DFS(tx, ty, arr, visited, arr[tx][ty], n, m);
        }
    }
}
