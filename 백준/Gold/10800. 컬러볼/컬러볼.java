import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int sum;
    static int[] color;
    static int[] answer;
    static Ball[] balls;

    static class Ball {
        int index;
        int color;
        int size;

        public Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        balls = new Ball[n];
        color = new int[n+1];
        answer = new int[n];

        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            balls[i] = new Ball(i,Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
        }

        // 공의 크기 순으로 정렬
        Arrays.sort(balls, (o1,o2) -> o1.size - o2.size);

        int idx = 0;
        for(int i=0;i<n;i++){
            Ball tmp = balls[i];
            while(balls[idx].size < tmp.size) {
                sum += balls[idx].size;
                color[balls[idx].color] += balls[idx].size;
                idx++;
            }
            answer[tmp.index] = sum - color[tmp.color];
        }

        for(int i=0;i<n;i++) {
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb);
    }
}
