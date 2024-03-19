import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int MAX, M, N;
	static Queue<int[]> q;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<>();
		String[] input;

		input = br.readLine().split(" ");

		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);

		int[][] map = new int[N][M];
		int cnt = 0;
		int cnt_empty = 0;
		// 토마토 정보 입력받기
		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				// 익은 토마토
				if (input[c].equals("1")) {
					q.offer(new int[] { r, c });
					map[r][c] = 1;
					cnt++;
				} // 익지 않은 토마토
				else if (input[c].equals("0")) {
					map[r][c] = 0;
				}
				// 토마토가 없는 칸
				else {
					map[r][c] = -1;
					cnt_empty++;
				}
			}
		}

		// 처음부터 어떤 토마토도 익지 않은 경우
		if (cnt == 0)
			System.out.println(-1);
		// 처음부터 모든 토마토가 익어 있는 경우
		else if (cnt == M * N - cnt_empty)
			System.out.println(0);
		// 그 외의 일반적인 경우
		else {
			MAX = 0;
			check(map);
		}

	}

	public static void check(int[][] map) {
		// 큐에 저장된 익은 토마토가 없어질 때까지 반복
		int R, C;
		int[] temp;
		// 큐에 저장된 익은 토마토 한 개를 꺼내 기준으로 삼는다
		while (!q.isEmpty()) {
			temp = q.poll();
			// 상하좌우 탐색
			for (int d = 0; d < 4; d++) {
				R = dr[d] + temp[0];
				C = dc[d] + temp[1];
				// 익지 않은 토마토를 찾아 익은 상태로 바꾸어 큐에 넣는다.
				if (R < N && C < M && R >= 0 && C >= 0 && map[R][C] == 0) {
					map[R][C] = map[temp[0]][temp[1]] + 1;
					if (map[R][C] - 1 > MAX)
						MAX = map[R][C] - 1;
					q.offer(new int[] { R, C });
				}
			}
		}
		if (check_all_tomato(map))
			System.out.println(-1);
		else
			System.out.println(MAX);
	}

	// 익지 않은 토마토가 있는지 확인
	public static boolean check_all_tomato(int[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0)
					return true;
			}
		}
		return false;
	}
}
