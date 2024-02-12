import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static ArrayList<ArrayList<int[]>> info = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    static void recur(int cur, int sum, int[] price) {
        if(cur==n) {
            answer = Math.min(answer, sum);
            return;
        }

        for(int i=0;i<n;i++) {
            if(visited[i]) continue;
            if(price[i]<=0) sum+=1;
            else sum+=price[i];
            for(int j=0;j<info.get(i).size();j++) {
                int a = info.get(i).get(j)[0];
                int d = info.get(i).get(j)[1];
                price[a]-=d;
            }
            visited[i]=true;
            recur(cur+1, sum, price);
            visited[i]=false;
            if(price[i]<=0) sum-=1;
            else sum-=price[i];
            for(int j=0;j<info.get(i).size();j++) {
                int a = info.get(i).get(j)[0];
                int d = info.get(i).get(j)[1];
                price[a]+=d;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=0;i<n;i++) {
            info.add(new ArrayList<>());
            int p = Integer.parseInt(br.readLine());
            for(int j=0;j<p;j++) {
                tmp = br.readLine().split(" ");
                int a = Integer.parseInt(tmp[0])-1;
                int d = Integer.parseInt(tmp[1]);
                info.get(i).add(new int[] {a,d});
            }
        }

        visited = new boolean[n];

        recur(0,0, arr);
        System.out.println(answer);
    }
}
