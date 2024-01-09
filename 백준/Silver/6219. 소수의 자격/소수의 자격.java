import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean check(int num, int n){
        while (num > 0) {
            if(num%10==n) return true;
            num/=10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        boolean[] arr = new boolean[4000001];
        arr[1] = true;

        for(int i=2;i*i<=4000000;i++){
            for(int j=i*i;j<=4000000;j+=i){
                arr[j]=true;
            }
        }

        String[] tmp = br.readLine().split(" ");
        int start = Integer.parseInt(tmp[0]);
        int end = Integer.parseInt(tmp[1]);
        int num = Integer.parseInt(tmp[2]);

        int answer = 0;
        for(int k=start;k<=end;k++){
            if(!arr[k]){
                if(check(k, num)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
