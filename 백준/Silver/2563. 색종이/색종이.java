import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];
        int n = Integer.parseInt(br.readLine());
        for(int k=0;k<n;k++) {
            String[] tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            for(int i=0;i<10;i++) {
                for(int j=0;j<10;j++) {
                    arr[i+x][j+y] +=1;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++) {
                if(arr[i][j]>=1) answer++;
            }
        }
        System.out.println(answer);
    }
}
