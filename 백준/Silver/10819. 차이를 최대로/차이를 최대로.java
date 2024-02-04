import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    static int[] arr;
    static int[] num;
    static boolean[] visited;

    static int answer = Integer.MIN_VALUE;

    static void recur(int cur, int[] numbers) {
        if(cur==n) {
            answer = Math.max(answer, calc(numbers));
            return;
        }

        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            numbers[cur] = arr[i];
            visited[i] = true;
            recur(cur+1, numbers);
            visited[i] = false;
        }
    }

    static int calc(int[] arr) {
        int sum = 0;
        for(int i=0;i<n-1;i++) {
            sum+=Math.abs(arr[i]-arr[i+1]);
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        num = new int[n];
        visited = new boolean[n];
        String[] tmp = br.readLine().split(" ");

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        recur(0, num);
        System.out.println(answer);
    }
}
