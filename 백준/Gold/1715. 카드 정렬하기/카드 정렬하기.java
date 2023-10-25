import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = parseInt(br.readLine());
        long answer = 0;

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            queue.add(Long.parseLong(br.readLine()));
        }

        while(queue.size()>=2) {
            long tmp1 = queue.poll();
            long tmp2 = queue.poll();
            queue.add(tmp1 + tmp2);
            answer += tmp1 + tmp2;
        }

        System.out.println(answer);
    }
}
