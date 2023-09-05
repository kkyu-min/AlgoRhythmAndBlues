import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
	
	static int M;
	static int N;
	static int[][] arr;
	static int tomatonum; // 토마토 개수
	static int day = Integer.MIN_VALUE;
	
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		// 시작할때 익은 토마토 전부 큐에 넣어둠 => 출발점 n개 이상인 경우를 위해
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==1) {
					queue.add(new int[] {i,j,0});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int tmpx = queue.peek()[0];
			int tmpy = queue.peek()[1];
			int tmpday = queue.peek()[2];
			queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmpx + dx[i];
				int ny = tmpy + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0) {
					arr[nx][ny]=1;
					queue.add(new int[] {nx,ny,tmpday+1});
				}
			}
			day = Math.max(day, tmpday);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		M = parseInt(tmp[0]);
		N = parseInt(tmp[1]);
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			tmp = br.readLine().split(" ");
			for(int j=0;j<M;j++) { // 1 익은 토마토, 0 익지 않은 토마토, -1 빈칸
				arr[i][j] = parseInt(tmp[j]);
				if(arr[i][j]!=-1) tomatonum++;
			}
		}
		bfs();
		
		int flag=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					flag =1;
					break;
				}
			}
		}
		
		if(flag==1) {
			System.out.println(-1);
		}
		else {
			System.out.println(day);
		}
		
	}

}
