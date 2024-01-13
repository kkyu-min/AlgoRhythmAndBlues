import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int daSom = Integer.parseInt(br.readLine());
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);

        for(int i=0;i<n-1;i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while(true) {
            if(queue.isEmpty()) {
                break;
            }
            int num = queue.poll();
            if(daSom > num) {
                break;
            }
            else {
                num--;
                answer++;
                daSom++;
                queue.add(num);
            }
        }
        System.out.println(answer);
    }
}
