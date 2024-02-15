import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = parseInt(tmp[0]); // 물건 개수
		int K = parseInt(tmp[1]); // 버틸 수 있는 무게
		
		int[] weight = new int[N+1]; // 각 물건 무게
		int[] price = new int[N+1]; // 각 물건의 가치
		
		// 물건 정보 입력
		for(int i=0;i<N;i++) {
			tmp = br.readLine().split(" ");
			weight[i+1] = parseInt(tmp[0]);
			price[i+1] = parseInt(tmp[1]);
		}
		
		int[][] dp = new int[N+1][K+1]; // 
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				if(weight[i] > j) { // 현재 물건을 넣을 수 없는 경우
					dp[i][j] = dp[i-1][j];
				}
				else { // 현재 물건 넣는 경우
					dp[i][j] = Math.max(dp[i-1][j], price[i]+dp[i-1][j-weight[i]]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}
