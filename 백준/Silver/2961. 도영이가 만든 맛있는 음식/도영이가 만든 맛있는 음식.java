
import java.io.*;
import static java.lang.Integer.parseInt;

public class Main {

	static int N; // 재료 개수
	static int[] visited; // 각 원소가 부분집하의 구성에 포함되었는지 여부
	static int[] sm; // 신 맛 배열
	static int[] bm; // 쓴 맛 배열
	static int min= Integer.MAX_VALUE;
	
	public static void main(String[] args)	throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = parseInt(br.readLine());
		sm = new int[N]; // 신맛 배열
		bm = new int[N]; // 쓴맛 배열
		visited = new int[N];
		
		for(int i=0;i<N;i++) { // 각 맛 배열 채우기
			String[] tmp = br.readLine().split(" ");
			sm[i] = parseInt(tmp[0]);
			bm[i] = parseInt(tmp[1]);
		}
		
		sum(0);
		System.out.println(min);
	}
	
	private static void sum(int count) { // 고려된 원소 번호
		if(count==N) {
			int ssum=1;
			int bsum=0;
			// 신맛의 총합 계산하기
			for(int i=0;i<N;i++) {
				if(visited[i]==1) {
					ssum *= sm[i];
				}
			}
			// 쓴맛의 총합 계산하기
			for(int i=0;i<N;i++) {
				if(visited[i]==1) {
					bsum += bm[i];
				}
			}
			if(ssum==1 && bsum==0) return;
			min = Math.min(min, Math.abs(ssum-bsum));
			return;
		}
		
		visited[count] = 1;
		sum(count+1);
		visited[count] = 0;
		sum(count+1);
	}
	
}
