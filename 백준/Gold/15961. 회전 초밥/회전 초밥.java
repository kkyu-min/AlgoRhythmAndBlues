import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int d = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        int c = Integer.parseInt(tmp[3]);

        int[] arr = new int[n+k-1];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=n;i<n+k-1;i++) {
            arr[i] = arr[i-n];
        }

        int answer = 0;
        int sum = 0; // 초밥 종류

        ArrayDeque<Integer> list= new ArrayDeque<>();
        int[] cnt = new int[d+1];
        boolean coupon = false; // 먹을 초밥에 쿠폰 있는지 없는지

        for(int i=0;i<k;i++) {
            list.add(arr[i]);
            if(cnt[arr[i]] == 0) {
                sum++;
                cnt[arr[i]]++;
            }
            else {
                cnt[arr[i]]++;
            }
        }

        if(cnt[c] == 0) {
            answer = sum+1;
        }
        else {
            coupon=true;
            answer=sum;
        }

        for(int i=1;i<n;i++) {
            // 빼기
            int out = list.removeFirst();
            if(out == c && cnt[out]==1) {
                coupon=false;
            }
            cnt[out]--;
            if(cnt[out] == 0) {
                sum--;
            }
            // 더하기
            if(arr[i+k-1] == c) {
                coupon=true;
            }
            list.add(arr[i+k-1]);
            cnt[arr[i+k-1]]++;
            if(cnt[arr[i+k-1]] == 1) {
                sum++;
            }

            if(coupon) {
                answer = Math.max(answer, sum);
            }
            else {
                answer = Math.max(answer,sum+1);
            }
        }

        System.out.println(answer);
    }
}
