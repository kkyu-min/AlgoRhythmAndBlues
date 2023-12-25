import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static long[] arr = new long[40]; 
    static long num;
    static HashSet<Long> set = new HashSet<>();

    static void make(int i, long sum) {
        if (i == 40 || sum > Integer.MAX_VALUE || sum < 0) return;

        set.add(sum);
        make(i + 1, sum + arr[i]);
        make(i + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Long.parseLong(br.readLine());

        arr[0] = 1;
        for (int i = 1; i < 40; i++) {
            arr[i] = arr[i - 1] * 3;
        }

        make(0, 0);

        if (set.contains(num) && num != 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
