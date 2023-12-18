import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
	
	static int N,M,K;
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
	static long distance[][];
	static long answer = Long.MAX_VALUE;
	static final long INF = Long.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int to;
		long weight;
		int cnt;
		
		public Node(int to, long weight, int cnt) {
			super();
			this.to = to;
			this.weight = weight;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		
		N = parseInt(tmp[0]);
		M = parseInt(tmp[1]);
		K = parseInt(tmp[2]);
		
		distance = new long[N+1][K+1];

		for(int i=0;i<N+1;i++) {
			Arrays.fill(distance[i], INF);
			arr.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			tmp = br.readLine().split(" ");
			int s = parseInt(tmp[0]);
			int t = parseInt(tmp[1]);
			int w = parseInt(tmp[2]);
			
			arr.get(s).add(new Node(t,w,0));
			arr.get(t).add(new Node(s,w,0));
		}
		
		distance[1][0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(1,0,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(distance[cur.to][cur.cnt] < cur.weight) {
				continue;
			}
			for(int i=0;i<arr.get(cur.to).size();i++) {
				Node n = arr.get(cur.to).get(i);
				// 도로를 포장 했을 경우 -> 가줃치 0
				if(cur.cnt < K && distance[n.to][cur.cnt+1] > distance[cur.to][cur.cnt]) {
					distance[n.to][cur.cnt+1] = distance[cur.to][cur.cnt];
					pq.offer(new Node(n.to, distance[n.to][cur.cnt+1], cur.cnt+1));
				}
				// 도로를 포장하지 않았을 경우
				if(distance[n.to][cur.cnt] > distance[cur.to][cur.cnt]+ n.weight) {
					distance[n.to][cur.cnt] = distance[cur.to][cur.cnt]+ n.weight;
					pq.offer(new Node(n.to, distance[n.to][cur.cnt], cur.cnt));
				}
			}
		}
		
		for(int i=0;i<K+1;i++) {
			answer = Math.min(answer, distance[N][i]);
		}
		
		System.out.println(answer);
	}

}
