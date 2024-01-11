import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        long answer = 0;
        int[] prefix = new int[n+1];
        HashMap<Integer, Integer> map = new HashMap<>(); // 누적합, 횟수

        tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            prefix[i+1] = prefix[i] + Integer.parseInt(tmp[i]);
        }

        map.put(0,1);
        for(int j=1;j<=n;j++) {
            if(map.containsKey(prefix[j]-k)) {
                // prefix[j]-k인 경우가 존재할 경우 ++
                answer += map.get(prefix[j]-k);
            }
            // 해당 누적합 map에 추가
            if(map.containsKey(prefix[j])){
                int count = map.get(prefix[j]);
                map.put(prefix[j], count+1);
            }
            else {
                map.put(prefix[j], 1);
            }
        }

        System.out.println(answer);
    }
}
