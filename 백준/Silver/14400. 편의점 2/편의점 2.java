import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for(int i=0;i<n;i++) {
            String[] tmp = br.readLine().split(" ");
            xList.add(Integer.parseInt(tmp[0]));
            yList.add(Integer.parseInt(tmp[1]));
        }

        Collections.sort(xList, (o1, o2) -> o1 - o2);
        Collections.sort(yList, (o1, o2) -> o1 - o2);

        int xAnswer = 0;
        int yAnswer = 0;
        long answer = 0;

        if(n%2==0) {
            xAnswer = xList.get(n/2-1);
            yAnswer = yList.get(n/2-1);
        }
        else {
            xAnswer = xList.get(n/2);
            yAnswer = yList.get(n/2);
        }

        for(int i=0;i<n;i++) {
            answer += Math.abs(xList.get(i) - xAnswer);
            answer += Math.abs(yList.get(i) - yAnswer);
        }
        System.out.println(answer);
    }
}
