import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		String[] input;
		input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		boolean[][] map = new boolean[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			input = br.readLine().split("");
			for (int c = 0; c < M; c++) {
				if (input[c].equals("1"))
					map[r][c] = true;
			}
		}

		int cnt = 1;
		int R, C, size;
		que.offer(new int[] { 0, 0 });
		test: while (!que.isEmpty()) {
			size = que.size();
			for (int i = 0; i < size; i++) {
				int temp[] = que.poll();
				R = temp[0];
				C = temp[1];
				if (visited[R][C])
					continue;
				if (R == N - 1 && C == M - 1) {
					System.out.println(cnt);
					break test;
				}

				if (map[R][C] == true) {
					visited[R][C] = true;
					for (int k = 0; k < 4; k++) {
						if (R + dr[k] < 0)
							continue;
						if (R + dr[k] >= N)
							continue;
						if (C + dc[k] < 0)
							continue;
						if (C + dc[k] >= M)
							continue;

						que.offer(new int[] { R + dr[k], C + dc[k] });
					}
				}
			}

			cnt++;
		}
	}
}