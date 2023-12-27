import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000];
        int[][] time = new int[n][2];
        int answer = 0;

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            time[i][0] = Integer.parseInt(tmp[0]);
            time[i][1] = Integer.parseInt(tmp[1]);
            for(int j=time[i][0];j<time[i][1];j++){
                arr[j]++;
            }
        }

        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<1000;j++) {
                if(time[i][0]>j || time[i][1]<=j){
                    if(arr[j]>=1) num++;
                }
                else {
                    if(arr[j]>=2) num++;
                }
            }
            answer = Math.max(answer, num);
        }

        System.out.println(answer);
    }
}
