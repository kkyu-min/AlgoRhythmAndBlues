import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long m;
    static long[] trees;
    static long max = 0;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        m = Long.parseLong(tmp[1]);
        trees = new long[n];

        tmp = br.readLine().split(" ");

        for(int i=0;i<n;i++){
            trees[i] = Long.parseLong(tmp[i]);
            max = Math.max(max, trees[i]);
        }

        long start = 0; // 자를 최소 높이
        long end = max; // 자를 최대 높이

        while(start<=end) {
            long mid = (start + end)/2;

            long get = 0;
            for(int i=0;i<n;i++){
                if(trees[i] - mid >=0){
                    get += trees[i] - mid;
                }
            }
            if(get >= m) {
                start = mid+1;
                answer = mid;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
