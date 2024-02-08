import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    static int n;
    static int[] arr;
    static HashSet<Integer> answer = new HashSet<>();

    static void recur(int cur, int total) {
        if(cur==n) {
            answer.add(total);
            return;
        }

        // 고르는 경우
        recur(cur+1, total+arr[cur]);
        // 고르지 않는 경우
        recur(cur+1, total);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        recur(0,0);

        int num = 1;
        while(answer.contains(num)) {
            num++;
        }
        System.out.println(num);
    }
}
