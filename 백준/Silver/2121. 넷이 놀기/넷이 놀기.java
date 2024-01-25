import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int n,w,l;
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x != o.x ? this.x - o.x : this.y - o.y;
        }
    }

    static ArrayList<Point> arr = new ArrayList<>();

    static boolean check(Point target) {
        int start =0;
        int end = n-1;

        while(start <= end) {
            int mid = (start+end)/2;

            Point midpoint = arr.get(mid);

            if(target.x == midpoint.x) {
                if(target.y == midpoint.y) {
                    return true;
                }
                else if(target.y < midpoint.y) {
                    end = mid-1;
                }
                else start=mid+1;
            }
            else if(target.x < midpoint.x) {
                end=mid-1;
            }
            else start=mid+1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        w = Integer.parseInt(tmp[0]);
        l = Integer.parseInt(tmp[1]);

        int answer = 0;

        for(int i=0;i<n;i++) {
            tmp = br.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);

            Point point = new Point(x,y);
            arr.add(point);
        }

        Collections.sort(arr);

        for (Point point : arr) {
            Point p1 = new Point(point.x+w, point.y);
            Point p2 = new Point(point.x, point.y+l);
            Point p3 = new Point(point.x+w, point.y+l);

            if(check(p1) && check(p2) && check(p3)) answer++;
        }

        System.out.println(answer);
    }
}
