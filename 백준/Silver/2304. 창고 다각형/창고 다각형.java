import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        int answer = 0;

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");

            arr[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[1]);
        }

        // 높이별 구간 탐색
        for(int i=1;i<=1000;i++) {
            int start = 1001;
            int end = -1;
            for(int j=1;j<1001;j++) {
                if(arr[j] >=i) {
                    start = Math.min(start, j);
                    end = Math.max(end, j);
                }
            }
//            System.out.println(start + " " + end);
            if(start!=1001 && end!=-1){
                answer +=(end-start+1);
            }
        }

        System.out.println(answer);
    }
}
