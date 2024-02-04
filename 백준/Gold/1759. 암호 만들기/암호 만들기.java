import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int l,c;
    static String[] arr;
    static String[] secret;
    static StringBuilder sb = new StringBuilder();

    static void recur(int cur, int start, String[] str) {
        if(cur==l) {
            int cnt=0;
            for(int i=0;i<l;i++) {
                if(str[i].equals("a") || str[i].equals("i") || str[i].equals("e") || str[i].equals("o") || str[i].equals("u")){
                    cnt++;
                }
            }
            if(l-cnt>=2 && cnt>=1) {
                for(int i=0;i<l;i++) {
                    sb.append(str[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start;i<c;i++) {
            str[cur] = arr[i];
            recur(cur+1, i+1, str);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        l = Integer.parseInt(tmp[0]);
        c = Integer.parseInt(tmp[1]);

        arr = br.readLine().split(" ");
        secret = new String[l];
        Arrays.sort(arr);


        recur(0,0,secret);
        System.out.println(sb);
    }
}
