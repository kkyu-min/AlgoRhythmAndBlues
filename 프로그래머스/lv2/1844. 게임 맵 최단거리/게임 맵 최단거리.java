import java.util.*;

class Solution {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    int bfs(int[][] maps,int n,int m) {
        boolean visited[][] = new boolean[n+1][m+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,0});
        visited[0][0]=true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int px = tmp[0];
            int py = tmp[1];
            int count = tmp[2];
            if(px==n && py==m) {
                return count+1;
            }
            else{
                for(int i=0;i<4;i++){
                    int nx = px+dx[i];
                    int ny = py+dy[i];
                    if(nx>=0 && nx<=n && ny>=0 && ny<=m){
                        if(!visited[nx][ny] && maps[nx][ny]==1){
                            visited[nx][ny]=true;
                            queue.add(new int[]{nx,ny,count+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length-1;
        int m = maps[0].length-1;
        answer = bfs(maps, n, m);
        return answer;
    }
}