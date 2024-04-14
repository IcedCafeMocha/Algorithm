import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		Queue<int[]> que = new LinkedList<>();
		boolean map[][];
		boolean visited[][];
		int[] temp;
		int M, N, K, CR, CC, cnt;
		int R, C, R2, C2;
		String[] input;
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			cnt = 0;
			input = br.readLine().split(" ");

			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			K = Integer.parseInt(input[2]);

			map = new boolean[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");

				R = Integer.parseInt(input[1]);
				C = Integer.parseInt(input[0]);

				map[R][C] = true;
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] && !visited[r][c]) {
						cnt++;
						que.offer(new int[] { r, c });
						visited[r][c] = true;
						while (!que.isEmpty()) {
							temp = que.poll();
							R2 = temp[0];
							C2 = temp[1];
							for (int k = 0; k < 4; k++) {
								CR = R2 + dr[k];
								CC = C2 + dc[k];

								if (CR < 0)
									continue;
								if (CC < 0)
									continue;
								if (CR >= N)
									continue;
								if (CC >= M)
									continue;

								if (map[CR][CC] && !visited[CR][CC]) {
									visited[CR][CC] = true;
									que.offer(new int[] { CR, CC });
								}
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}