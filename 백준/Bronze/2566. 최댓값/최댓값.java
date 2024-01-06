import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];

        for(int i=0;i<9;i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<9;j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int max = -1;
        int[] answer = new int[2];

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(arr[i][j] >= max) {
                    max = arr[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(answer[0]+1 + " " + (answer[1]+1));
    }
}
