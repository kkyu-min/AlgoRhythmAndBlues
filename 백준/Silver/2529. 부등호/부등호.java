import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int k;
    static String[] sign;
    static int[] arr;
    static boolean[] visited;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;

    static void recur(int cur) {
        if(cur == k+1){
            long num = 0;
            for(int i=0;i<k+1;i++) {
                num+=(long)(arr[i]*Math.pow(10,k-i));
            }

            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        if(cur==0){
            for(int i=0;i<10;i++) {
                if(!visited[i]){
                    arr[cur] = i;
                    visited[i]=true;
                    recur(cur+1);
                    visited[i]=false;
                }
            }
        }
        else {
            for(int i=0;i<10;i++) {
                if(sign[cur-1].equals("<")){
                    if(!visited[i] && arr[cur-1] < i) {
                        arr[cur] = i;
                        visited[i]=true;
                        recur(cur+1);
                        visited[i]=false;
                    }
                }
                else {
                    if(!visited[i] && arr[cur-1] > i) {
                        arr[cur] = i;
                        visited[i]=true;
                        recur(cur+1);
                        visited[i]=false;
                    }
                }
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        sign = new String[k];
        arr = new int[k+1];
        visited = new boolean[10];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<k;i++) {
            sign[i] = tmp[i];
        }


        recur(0);
        System.out.println(max);
        int cnt = 0;
        long n = min;
        while(n>0) {
            cnt++;
            n/=10;
        }
        if(cnt<=k){
            System.out.print(0);
        }
        System.out.println(min);
    }
}
