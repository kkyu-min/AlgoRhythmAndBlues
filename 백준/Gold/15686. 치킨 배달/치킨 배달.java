
import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {

	static int n;
	static int m;
	static int[] visited;
	static int min = Integer.MAX_VALUE; // 
	static ArrayList<int[]> house = new  ArrayList<>(); // 가정 집 위치 정보
	static ArrayList<int[]> chicken = new  ArrayList<>(); // 치킨 집 위지 정보
	static int [][] chickenWay;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		n = parseInt(tmp[0]); // 도시의 크기
		m = parseInt(tmp[1]); // 최대 남길수 있는 치킨집  == m보다 작거나 같은 수로 치킨 집 만들어야 함
		
		int[][] arr = new int[n][n]; // 도시 정보
		
		for(int i=0;i<n;i++) {
			tmp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				arr[i][j] = parseInt(tmp[j]);
				if(arr[i][j]==1) house.add(new int[] {i,j});
				if(arr[i][j]==2) chicken.add(new int[] {i,j});
			}
		}
		
		// 치킨집 별로 치킨 거리 계산
		chickenWay = new int[chicken.size()][house.size()];
		for(int i=0;i<chicken.size();i++) {
			for(int j=0;j<house.size();j++) {
				chickenWay[i][j] = Math.abs(chicken.get(i)[0] - house.get(j)[0]) + Math.abs(chicken.get(i)[1] - house.get(j)[1]);
			}
		}
		visited = new int[chicken.size()];
		powerset(chickenWay,chicken.size(),0);
		System.out.println(min);
		
	}
	private static void powerset(int[][] arr, int count, int idx) {
		if(idx==count) {
			// 조합별로 치킨거리 구함 -> 최소값 계속 업데이트 시켜줌
			int sum =0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i]==1) sum++;
			}
			if(sum==m) {
				int cw = 0;
				for(int j=0;j<house.size();j++) {
					int tmp = Integer.MAX_VALUE;
					for(int i=0;i<chicken.size();i++) {
						if(visited[i]==1) {
							tmp=Math.min(tmp, arr[i][j]);
						}
					}
					cw+=tmp;
				
				}
				min = Math.min(min, cw);
			}
			return;
		}
		
		
		visited[idx] = 1; // 해당 자리 포함한 부분 집합
		powerset(arr,count,idx+1);
		
		visited[idx] = 0; // 해당 자리 포함 하지 않은 부분 집합
		powerset(arr,count,idx+1);
	}
}
