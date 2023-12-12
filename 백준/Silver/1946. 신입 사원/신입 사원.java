import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static class Grade {
        int document; // 서류
        int interview; // 면접

        public Grade(int doc, int in){
            this.document = doc;
            this.interview = in;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int t=0;t<testcase;t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Grade> arr = new ArrayList<>();

            for(int i=0;i<n;i++) {
                String[] tmp = br.readLine().split(" ");
                arr.add(new Grade(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
            }

//            Collections.sort(arr, (g1,g2) -> g1.document != g2.document ? g1.document - g2.document : g1.interview - g2.interview);
            // 서류 순으로 정렬
            Collections.sort(arr, (g1, g2) -> g1.document - g2.document);

            int answer = 1; // 서류 1등
            int minInterview = arr.get(0).interview;
            for(int i=1;i<n;i++) {
                // 서류 2등부터
                // 면접 결과가 더 높다면 -> 서류 면접 둘다 높은 관계로 전 사람 탈락 -> 따라서 낮은 경우에만 추가
                if(arr.get(i).interview < minInterview) {
                    answer++;
                    minInterview = arr.get(i).interview;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
