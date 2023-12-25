import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int[] arr = new int[20];
    static int num;
    static HashSet<Integer> set = new HashSet<>();

    static void make(int i, int sum) {
        set.add(sum);
        if (i == 20 || sum < 0) return;

        make(i + 1, sum + arr[i]);
        make(i + 1, sum);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr[0] = 1;
        for (int i = 1; i < 20; i++) {
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