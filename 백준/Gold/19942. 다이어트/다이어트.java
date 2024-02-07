import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int n;
    static int[] required;
    static int[][] arr;
    static int sum = Integer.MAX_VALUE;
    static ArrayList<String> answer = new ArrayList<>();

    static void recur(int cur, int protein, int fat, int carbohydrate, int vitamin, int price, String str) {
        if(cur==n) {
            if(protein>=required[0] && fat>=required[1] && carbohydrate>=required[2] && vitamin>=required[3]) {
                if(price < sum) {
                    sum = price;
                    answer.clear();
                    answer.add(str);
                }
                else if(price==sum) {
                    answer.add(str);
                }
            }
            return;
        }

        // 고르는 경우
        recur(cur+1, protein+arr[cur][0], fat+arr[cur][1], carbohydrate+arr[cur][2], vitamin+arr[cur][3], price+arr[cur][4], str+(cur+1)+" ");
        // 고르지 않는 경우
        recur(cur+1, protein, fat, carbohydrate, vitamin, price, str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        required = new int[4];
        arr = new int[n][5];

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<4;i++) {
            required[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            for(int j=0;j<5;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        recur(0,0,0,0,0,0,"");
        Collections.sort(answer);
        if(sum==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(sum);
            System.out.println(answer.get(0));
        }
    }
}
