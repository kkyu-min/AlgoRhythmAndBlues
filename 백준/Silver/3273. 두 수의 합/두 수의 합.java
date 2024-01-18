import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(tmp[i]);
            set.add(arr[i]);
        }

        int x = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0;i<n;i++) {
            if(set.contains(x-arr[i])) answer++;
        }

        System.out.println(answer/2);
    }
}
