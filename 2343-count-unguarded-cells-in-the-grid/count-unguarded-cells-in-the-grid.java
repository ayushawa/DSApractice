class Solution {
    public int countUnguarded(int n, int m, int[][] guards, int[][] walls) {
        int visited[][] = new int[n][m];
        for(int i=0;i<walls.length;i++){
            visited[walls[i][0]][walls[i][1]] = -1;
        }

        for(int j=0;j<guards.length;j++){
            visited[guards[j][0]][guards[j][1]] = 2;
        }

        for(int k=0;k<guards.length;k++){
            int i = guards[k][0];
            int j= guards[k][1];

            for(int x = i-1;x>=0;x--){
                if(visited[x][j] == -1 || visited[x][j] == 2) break;
                visited[x][j] = 1;
            }

            for(int x=i+1;x<n;x++){
                if(visited[x][j] == -1 || visited[x][j] == 2) break;
                visited[x][j] = 1;
            }

            for(int x = j-1;x>=0;x--){
                if(visited[i][x] == -1 || visited[i][x] == 2) break;
                visited[i][x] = 1;
            }

            for(int x = j+1;x<m;x++){
                if(visited[i][x]== -1 || visited[i][x] == 2) break;
                visited[i][x] = 1;
            }
        }

        int count =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j] == 0) count++;
            }
        }

        return count;
    }
}