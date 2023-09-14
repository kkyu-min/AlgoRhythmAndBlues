import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static String[] words;
    static int[] alpha = new int[26];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new String[n];

        for(int i=0;i<n;i++) {
            String tmp = br.readLine();
            words[i] = tmp;
        }

        for(int i=0;i<n;i++) {
            String math = words[i];
            for(int j=math.length()-1;j>=0;j--) {
                // 알파벳
                int idx = math.charAt(j) - 65;
                alpha[idx] += Math.pow(10, (math.length()-1)-j);
            }
        }

        Arrays.sort(alpha);
        for(int i=0;i<10;i++){
            answer += (9-i) * alpha[25-i];
        }

        System.out.println(answer);
    }
}
