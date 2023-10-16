import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i=0;i<n;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                if(queue.size() == 0){
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            else {
                queue.add(tmp);
            }
        }

        System.out.println(sb);
    }
}
