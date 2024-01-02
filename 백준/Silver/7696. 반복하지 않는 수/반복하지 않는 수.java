import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean[] used = new boolean[10];

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[1000001];
        int num = 1;
        int cnt = 1;

        while(cnt<1000001){
            Arrays.fill(used, false);
            boolean state =true;
            int tmp = num;
            while(tmp>0){
                if(used[tmp%10]) {
                    state=false;
                    break;
                }
                used[tmp%10]=true;
                tmp/=10;
            }
            if(state) arr[cnt++]=num;
            num++;
        }
        while(true) {
            int n = scanner.nextInt();
            if(n==0) return;

            System.out.println(arr[n]);
        }
    }
}
