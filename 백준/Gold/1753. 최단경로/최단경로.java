
import java.io.*;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {

	static int V, E; // 노드 개수, 간선 개수
	static ArrayList<ArrayList<Node>> arr = new ArrayList<>(); // 인접 리스트
	static int[] distance; // 거리 담을 배열

	public static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		V = parseInt(tmp[0]);
		E = parseInt(tmp[1]);

		int start = parseInt(br.readLine());

		for (int i = 0; i < V + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			tmp = br.readLine().split(" ");
			int s = parseInt(tmp[0]);
			int e = parseInt(tmp[1]);
			int w = parseInt(tmp[2]);
			arr.get(s).add(new Node(e, w));
		}

		final int INF = Integer.MAX_VALUE;
		distance = new int[V + 1];

		Arrays.fill(distance, INF);
		distance[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			int cur = pq.peek().to;
			int min = pq.peek().weight;
			pq.poll();

			if (distance[cur] < min) {
				continue;
			}
			for (int i = 0; i < arr.get(cur).size(); i++) {
				Node n = arr.get(cur).get(i);
				if(distance[n.to] > n.weight+distance[cur]) {
					distance[n.to] = n.weight+distance[cur];
					pq.offer(new Node(n.to,distance[n.to]));
				}
				
//				if (distance[cur] > distance[cur] + arr.get(cur).get(i).weight) {
//					distance[cur] = distance[cur] + arr.get(cur).get(i).weight;
//					pq.offer(new Node(i, distance[i]));
//				}
			}

		}

		for (int i = 1; i <= V; i++) {
			if (distance[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}

}
