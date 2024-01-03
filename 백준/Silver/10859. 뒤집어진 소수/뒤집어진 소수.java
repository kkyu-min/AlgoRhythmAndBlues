import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split("");
        int[] arr = new int[tmp.length];
        long num = 0;
        for(int i=0;i<tmp.length;i++) {
            num+=Integer.parseInt(tmp[i]) * Math.pow(10,tmp.length-1-i);
        }
        for(long i=2;i*i<=num;i++){
            if(num%i == 0){
                System.out.println("no");
                return;
            }
        }
        // 뒤집기
        for(int i=0;i<tmp.length;i++) {
            if(tmp[i].equals("3") || tmp[i].equals("4") || tmp[i].equals("7")){
                System.out.println("no");
                return;
            }
            else if(tmp[i].equals("6")) {
                arr[tmp.length-1-i] = 9;
            }
            else if(tmp[i].equals("9")) {
                arr[tmp.length-1-i] = 6;
            }
            else {
                arr[tmp.length-1-i] = Integer.parseInt(tmp[i]);
            }
        }

        // 정수로 만들기
        long n = 0;
        for(int i=0;i<tmp.length;i++){
            n+=arr[i] * Math.pow(10,tmp.length-1-i);
        }
        // 소수 판별
        if(n==1){
            System.out.println("no");
            return;
        }
        for(long i=2;i*i<=n;i++){
            if(n%i == 0){
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }
}
