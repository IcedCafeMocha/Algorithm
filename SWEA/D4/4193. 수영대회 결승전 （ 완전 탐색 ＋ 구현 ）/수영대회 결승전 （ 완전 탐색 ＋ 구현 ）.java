import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> q;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] input;

		q = new LinkedList<>();
		int SR, SC, DR, DC, time, R, C, q_size;

		for (int testcase = 1; testcase <= T; testcase++) {
			time = 0;
			q.clear();
			
			N = Integer.parseInt(br.readLine());
			int[] now;

			map = new int[N][N];
			visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				input = br.readLine().split(" ");
				// map 정보 입력
				for (int c = 0; c < N; c++) {
					if (input[c].equals("1")) {
						map[r][c] = 1;
					}
					if (input[c].equals("2")) {
						map[r][c] = 2;
					}
				}
			}

			// 시작 위치
			input = br.readLine().split(" ");
			SR = Integer.parseInt(input[0]);
			SC = Integer.parseInt(input[1]);

			// 도착 위치
			input = br.readLine().split(" ");
			DR = Integer.parseInt(input[0]);
			DC = Integer.parseInt(input[1]);

			// 시작 좌표 큐에 삽입
			q.offer(new int[] { SR, SC });

			test: while (true) {
				// 도착점에 도달이 불가능하다면 -1 출력
				if (q.isEmpty()) {
					System.out.println("#"+testcase+" -1");
					break;
				}
				q_size = q.size();
				for (int i = 0; i < q_size; i++) {
					// R : 현재 위치의 r 좌표
					// C : 현재 위치의 c 좌표
					now = q.poll();
					R = now[0];
					C = now[1];
					if(visited[R][C]==true)
						continue;

					// 도착점에 도달하면 종료
					if (R == DR && C == DC) {
						System.out.println("#"+testcase+" "+time);
						break test;
					}

					// 빈 칸이라면 이동
					if (map[R][C] == 0) {
						visited[R][C] = true;
						go(R, C);
					}

					// 소용돌이일 경우
					if (map[R][C] == 2) {
						// 소용돌이가 사라졌을 때면 지나간다
						if (time % 3 == 0 && time > 0) {
							visited[R][C] = true;
							go(R, C);
						}
						// 소용돌이가 존재한다면 대기한다
						else {
							stay(R, C);
						}
					}
				}
				time++;
			}
		}

	}

	static void go(int R, int C) {
		for (int i = 0; i < 4; i++) {
			if (R + dr[i] >= 0 && R + dr[i] < N && C + dc[i] >= 0 && C + dc[i] < N && map[R + dr[i]][C + dc[i]] != 1) {
				q.offer(new int[] { R + dr[i], C + dc[i] });
			}
		}
	}

	static void stay(int R, int C) {
		q.offer(new int[] { R, C });
	}
}