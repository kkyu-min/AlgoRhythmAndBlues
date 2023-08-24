import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n,c;
    static int[] houses;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");

        n = Integer.parseInt(tmp[0]);
        c = Integer.parseInt(tmp[1]);

        houses = new int[n];

        for(int i=0;i<n;i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        // 정렬 필요
        Arrays.sort(houses);

        int start = 1; // 최소 길이
        int end = houses[n-1]-houses[0]; // 최대 길이

        while(start<=end) {
            int mid = (start + end)/2;
            int prevHouse = houses[0]; // 비교할 마지막으로 설치된 집 좌표
            int count = 1; // 설치된 공유기 수

            for(int i=0;i<n;i++){
                int distance = houses[i] - prevHouse;
                if(distance >= mid){
                    count++;
                    prevHouse = houses[i];
                }
            }
            if(count >= c) {
                start = mid + 1;
                answer = mid;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
