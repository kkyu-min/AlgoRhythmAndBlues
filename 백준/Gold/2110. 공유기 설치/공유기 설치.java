import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int n = Integer.parseInt(tmp[0]);
        int c = Integer.parseInt(tmp[1]);

        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[n-1]-arr[0];
        int answer = 0;

        while(start<=end) {
            int mid = (start+end)/2;
            int house = arr[0];
            int cnt = 1;

            for(int i=0;i<n;i++) {
                int distance = arr[i] - house;
                if(distance>=mid) {
                    cnt++;
                    house = arr[i];
                }
            }

            if(cnt >= c){
                start=mid+1;
                answer = mid;
            }
            else {
                end=mid-1;
            }
        }
        System.out.println(answer);
    }
}
