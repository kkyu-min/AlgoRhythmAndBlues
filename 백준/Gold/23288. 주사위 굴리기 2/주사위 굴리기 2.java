import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Dice {
        int up, down, north, east, south, west;
        public Dice() {
            up = 1; down = 6; north = 2; east = 3; south = 5; west = 4;
            }
        public void roll(int dir) {
            if (dir == 0)
                toNorth();
            else if (dir == 1)
                toEast();
            else if (dir == 2)
                toSouth();
            else
                toWest();
        }
        private void toNorth() {
            int tmp = up;
            up = south;
            south = down;
            down = north;
            north = tmp;
        }
        private void toEast() {
            int tmp = up;
            up = west;
            west = down;
            down = east;
            east = tmp;
        }
        private void toSouth() {
            int tmp = up;
            up = north;
            north = down;
            down = south;
            south = tmp;
        }
        private void toWest() {
            int tmp = up;
            up = east;
            east = down;
            down = west;
            west = tmp;
        }

    }
    static int N, M, K;
    static int[][] arr;
    static int[] dx = {-1,0,1,0}; // 북, 동, 서, 남
    static int[] dy = {0,1,0,-1};


    static int calc(int x,int y, int num) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        int point = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            point++;
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(!visited[nx][ny] && arr[nx][ny]==num) {
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

        return point * num;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        String[] tmp = br.readLine().split(" ");
        N = parseInt(tmp[0]);
        M = parseInt(tmp[1]);
        K = parseInt(tmp[2]);
        arr = new int[N][M];
        for(int i=0;i<N;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int dir = 1;
        int nowx = 0;
        int nowy = 0;
        Dice dice = new Dice();

        for(int k=0;k<K;k++) { // 회전
            // 굴리고 -> 계산 -> 방향 정하기
            if(nowx+dx[dir]<0 || nowy+dy[dir]<0 || nowx+dx[dir]>=N || nowy+dy[dir]>=M) { // 이동할 칸 없음
                dir+=2;
                dir%=4;
                nowx += dx[dir];
                nowy += dy[dir];
            }
            else{ // 이동할 칸 있음
                nowx += dx[dir];
                nowy += dy[dir];
            }

            score += calc(nowx, nowy, arr[nowx][nowy]);
            // 방향 계산
            dice.roll(dir);
            if(dice.down > arr[nowx][nowy]) { // 시계 방향
                dir+=1;
                dir%=4;
            }
            else if(dice.down < arr[nowx][nowy]) { // 반시계 방향
                dir+=3;
                dir%=4;
            }

        }
        System.out.println(score);
    }
}
