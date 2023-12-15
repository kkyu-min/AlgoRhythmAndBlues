import java.util.*;

class Solution {
    
    static int[][] info;
    static boolean[][] checked;
    static HashMap<Integer, Integer> arr = new HashMap<>();
    
    static int check(int x, int y, int[][] land, int num) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[] {-1,0,1,0};
        int[] dy = new int[] {0,1,0,-1};
        
        queue.add(new int[]{x,y});
        checked[x][y] = true;
        int cnt = 1;
        info[x][y] = num;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowx = now[0];
            int nowy = now[1];
            
            for(int i=0;i<4;i++){
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];
                if(nx>=0 && nx<land.length && ny>=0 && ny<land[0].length 
                   && land[nx][ny]==1 && !checked[nx][ny]){
                        queue.add(new int[]{nx, ny});
                        cnt++;
                        info[nx][ny] = num;
                        checked[nx][ny]=true;
                }
            }
        }
        return cnt;
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        info = new int[land.length][land[0].length];
        checked = new boolean[land.length][land[0].length];
        
        int num = 1;
        
        for(int i=0;i<land.length;i++) {
            for(int j=0;j<land[0].length;j++) {
                if(land[i][j]==1 && !checked[i][j]){
                    checked[i][j] = true;
                    int cnt = check(i,j,land,num);
                    arr.put(num, cnt);
                    num++;
                }
            }
        }
        
        
        for(int j=0;j<land[0].length;j++) {
            HashSet<Integer> oil = new HashSet<>();
            int sum = 0;
            for(int i=0;i<land.length;i++) {
                if(info[i][j] !=0) {
                    oil.add(info[i][j]);
                }
            }
            for(int id:oil) {
                sum+=arr.get(id);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}