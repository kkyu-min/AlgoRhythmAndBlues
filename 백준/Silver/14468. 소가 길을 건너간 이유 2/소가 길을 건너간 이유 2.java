import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmp = br.readLine();
        int[] start = new int[26];
        int[] end = new int[26];

        for(int i=0;i<52;i++) {
            int index= tmp.charAt(i) - 'A';

            if(start[index] == 0) start[index] = i+1;
            else end[index] = i+1;
        }

        int answer = 0;
        for(int i=0;i<26;i++) {
            for(int j=0;j<26;j++) {
                if(start[i] < start[j] && start[j]<end[i] && end[i]<end[j]) answer++;
            }
        }

        System.out.println(answer);
    }
}
