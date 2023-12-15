import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);
        int n = Integer.parseInt(tmp[2]);
        int w = Integer.parseInt(tmp[3]);

        int x = 0;
        int y = 0;

        // 없거나 여러개인 경우 확인
        if( a==b && w!=b*n) { // 직선 평행 없는경우
            System.out.println(-1);
        }
        else if(a==b && w==b*n) { // 직선 같은 경우
            // 여러개 인지 하나인지 확인
            if(n > 2) {
                System.out.println(-1);
            }
            else if(n < 2) {
                System.out.println(-1);
            }
            else {
                System.out.print(1 + " " + 1);
            }
        }
        else {
            if( (a*n-w)%(a-b)==0 && (a*n-w)/(a-b)>=1) {
                y = (a*n-w)/(a-b);
                x = n - y;
                if(x>=1){
                    System.out.println(x + " " + y);
                }
                else {
                    System.out.println(-1);
                }
            }
            else {
                System.out.println(-1);
            }
        }

    }
}
