import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");

        N = parseInt(tmp[0]);
        H = parseInt(tmp[1]);

        int[] bot = new int[H+1];
        int[] top = new int[H+1];

        for(int i=0;i<N;i+=2) {
            bot[parseInt(br.readLine())]++;
            top[H-parseInt(br.readLine())+1]++;
        }
//        for(int i=1;i<H+1;i++){
//            System.out.print(bot[i]);
//        }
//        System.out.println();
//        for(int i=1;i<H+1;i++){
//            System.out.print(top[i]);
//        }
//        System.out.println();

        for(int i=1;i<H+1;i++) {
            bot[i] += bot[i-1];
            top[i] += top[i-1];
        }

//        for(int i=1;i<H+1;i++){
//            System.out.print(bot[i]);
//        }
//        System.out.println();
//        for(int i=1;i<H+1;i++){
//            System.out.print(top[i]);
//        }
//        System.out.println();

        int min = N;
        int count = 0;

        for(int i=1;i<H+1;i++){
            int sum = (bot[H]-bot[i-1]) + (top[i]);
            if(sum<min){
                min = sum;
                count = 1;
            }
            else if(sum==min){
                count++;
            }
        }
        sb.append(min).append(" ").append(count);
        System.out.println(sb);
    }
}
