import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split("");

        int answer = 0;

        for(int i=0;i<tmp.length-answer+1;i++) {
            set = new HashSet<>();
            int sum = 0;
            int index= i;
            while(true) {
                sum++;
                set.add(tmp[index]);
//                System.out.println(tmp[index]);
                index++;
                if(set.size() > n) {
                    sum--;
                    break;
                }
                if(index >=tmp.length) break;
            }
            answer = Math.max(answer, sum);
//            System.out.println(answer + " " + i + " " + index);
        }
        System.out.println(answer);
    }
}
