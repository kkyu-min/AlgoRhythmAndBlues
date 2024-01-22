import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[4000001];

        for(int i=2;i*i<=4000000;i++) {
            for(int j=i*i;j<=4000000;j+=i) {
                prime[j] = true;
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i<=4000000;i++) {
            if(!prime[i]) arr.add(i);
        }

        int start=0;
        int end=0;
        int answer=0;
        int sum=0;

        while(end <= n) {
            if(sum == n) {
                answer++;
                sum-=arr.get(start);
                start++;
            }
            if(sum < n) {
                if(end ==arr.size()) break;
                sum+=arr.get(end);
                end++;
            }
            else {
                sum -= arr.get(start);
                start++;
            }
        }
        System.out.println(answer);
    }
}
