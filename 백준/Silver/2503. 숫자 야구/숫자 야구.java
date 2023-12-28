import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
            arr[i][2] = Integer.parseInt(tmp[2]);
        }

        int answer = 0;
        for(int i=111;i<=999;i++) {
            // 서로 다른 숫자일 경우에만
            int a = i/100;
            int b = (i/10)%10;
            int c = i%10;
            if(b==0 || c==0) continue;
            if(a==b || b==c || c==a) continue;

            int[] num1 = new int[3];
            int[] num2 = new int[3];
            int cnt = 0;
            for(int j=0;j<n;j++){
                int strike = 0;
                int ball = 0;
                num1[0] = arr[j][0]/100;
                num1[1] = (arr[j][0]/10)%10;
                num1[2] = arr[j][0]%10;

                num2[0] = i/100;
                num2[1] = (i/10)%10;
                num2[2] = i%10;

                // 스트라이크 개수 구하기
                for(int k=0;k<3;k++){
                    if(num1[k] == num2[k]) strike++;
                }

                // 볼 개수 구하기
                for(int i1=0;i1<3;i1++) {
                    for(int j1=0;j1<3;j1++) {
                        if(i1!=j1) {
                            if(num1[i1]==num2[j1]) ball++;
                        }
                    }
                }
//                System.out.println(strike + " " + ball);
                if(strike==arr[j][1] && ball==arr[j][2]) {
                    cnt++;
                }
            }
            if(cnt == n) answer++;
        }
        System.out.println(answer);
    }
}
