
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]); // 표의 크기
		int m = Integer.parseInt(tmp[1]); // 합을  구해야 하는 횟수
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[n+1][n+1]; // 구간합을 담을 배열
		for(int i=1;i<=n;i++) {
			tmp = br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				arr[i][j]= Integer.parseInt(tmp[j-1])+arr[i][j-1]; // 행별로 구간합을 가지도록 배열 완성
			}
		}
		for(int i=0;i<m;i++) {
			tmp = br.readLine().split(" ");
			int startx = Integer.parseInt(tmp[0]);
			int starty = Integer.parseInt(tmp[1]);
			int endx = Integer.parseInt(tmp[2]);
			int endy = Integer.parseInt(tmp[3]);
			
			int sum =0;
			for(int j=0;j<=endx-startx;j++) {
				sum += arr[startx+j][endy]-arr[startx+j][starty-1];
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

}
