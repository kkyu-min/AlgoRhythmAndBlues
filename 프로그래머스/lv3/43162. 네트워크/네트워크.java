import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                answer++;
                visited[i] = true;
                // 탐색 시작
                queue.add(i);
                while(!queue.isEmpty()){
                    int tmp = queue.poll();
                    for(int j=0;j<n;j++) {
                        if(!visited[j] && computers[tmp][j]==1){
                                visited[j] = true;
                                queue.add(j);
                        }
                    }
                }
            }
        }
        return answer;
    }
}