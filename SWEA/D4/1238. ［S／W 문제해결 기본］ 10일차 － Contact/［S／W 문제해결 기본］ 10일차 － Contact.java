import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int E = N / 2;
			int start = Integer.parseInt(st.nextToken());
			
			
			
			List<Integer>[] adjList = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}
			
			
			// bfs
			Deque<Integer> q = new ArrayDeque<>();
			boolean[] visited = new boolean[101];
			int max = -1;
			q.add(start);
			while (!q.isEmpty()) {
				max = -1;
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int idx = q.poll();
					max = Math.max(idx, max);
					for (int next : adjList[idx]) {
						if (!visited[next]) {
							visited[next] = true;
							q.offer(next);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}