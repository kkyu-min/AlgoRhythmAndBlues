import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n+1];
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arrA[i+1] = Integer.parseInt(tmp[i]) + arrA[i];
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m+1];
        tmp = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            arrB[i+1] = Integer.parseInt(tmp[i]) + arrB[i];
        }

        HashMap<Integer, Long> mapA = new HashMap<>(); // 누적합 , 횟수
        long answer = 0;

        // map 채우기
        for(int i=1;i<=n;i++) {
            for(int j=i;j<=n;j++) {
                int key = arrA[j]-arrA[i-1];
                if(mapA.containsKey(key)) {
                    long count = mapA.get(key);
                    mapA.put(key, count+1);
                }
                else {
                    mapA.put(key, 1L);
                }
            }
        }

        for(int i=1;i<=m;i++) {
            for(int j=i;j<=m;j++) {
                int key = t-(arrB[j] -arrB[i-1]);
                if(mapA.containsKey(key)) {
                    answer+=mapA.get(key);
                }
            }
        }

        System.out.println(answer);
    }
}
