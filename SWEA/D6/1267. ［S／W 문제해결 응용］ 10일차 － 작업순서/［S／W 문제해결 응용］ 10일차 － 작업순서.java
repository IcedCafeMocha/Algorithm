import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int V, E, A, B, num;
		String[] input;

		Queue<Integer> q = new LinkedList<>();

		// 10개의 테스트케이스
		for (int testcase = 1; testcase <= 10; testcase++) {
			input = br.readLine().split(" ");

			// V : 정점의 개수, E : 간선의 개수
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);

			int[][] adj = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 시작이야
			int[] degree = new int[V + 1]; // 진입차수 저장

			// E개의 간선 정보 입력받기
			input = br.readLine().split(" ");
			for (int i = 0; i + 1 < E * 2; i += 2) {
				A = Integer.parseInt(input[i]);
				B = Integer.parseInt(input[i + 1]);

				adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이니 반대는 처리 X
				// 진입차수를 증가
				degree[B]++;
			}

			// 진입차수가 0인 노드 큐에 넣기
			for (int i = 1; i < degree.length; i++) {
				if (degree[i] == 0)
					q.offer(i);
			}

			bw.write("#" + testcase + " ");

			// 큐가 빌 때까지 반복
			while (!q.isEmpty()) {
				num = q.poll();

				bw.write(num + " ");
				for (int i = 0; i < degree.length; i++) {
					if (adj[num][i] == 1) {
						degree[i]--;
						adj[num][i] = 0;

						if (degree[i] == 0)
							q.offer(i);
					}
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}