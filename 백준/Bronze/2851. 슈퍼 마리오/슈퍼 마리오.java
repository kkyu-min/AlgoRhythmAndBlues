import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        for(int i=0;i<10;i++) {
            int tmp = Integer.parseInt(br.readLine());
            for(int j=i;j<10;j++){
                arr[j]+=tmp;
            }
        }
        int answer = arr[0];
        for(int i=1;i<10;i++){
            if(Math.abs(arr[i]-100)<= Math.abs(answer-100)) {
                answer = arr[i];
            }
        }

        System.out.println(answer);
    }
}
