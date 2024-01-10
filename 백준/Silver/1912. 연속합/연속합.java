/**
 * 연속합 / 실버 2 / 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = parseInt(br.readLine()); // 정수 개수 입력 받음
		
		int[] arr = new int[num];
		int[] dp = new int[num+1];
		int max = Integer.MIN_VALUE; // 최대값
		
		String[] tmp = br.readLine().split(" ");
		for(int i=0;i<num;i++) {
			arr[i]=parseInt(tmp[i]); // n개의 정수로 이루어진 임의의 수열 주어진 값으로 초기화
		}
		
		dp[0]=arr[0];
		max = dp[0];
		for(int i=1;i<num;i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			
			max = Math.max(max, dp[i]);
		}
			
			
		System.out.println(max);
	}


}
