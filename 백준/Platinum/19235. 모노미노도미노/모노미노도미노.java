import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int score = 0;
	static int[][] green;
	static int[][] blue;
	static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int x, y;

		green = new int[6][4];
		blue = new int[6][4];
		// 검사 후 사라질 부분 체크해 놓을 배열 생성
		check = new boolean[6][4];

		String[] input;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			y = Integer.parseInt(input[1]);
			x = Integer.parseInt(input[2]);

			switch (Integer.parseInt(input[0])) {
			case 1:
				block1(x, 1, green);
				block1(y, 1, blue);
				check_line(green);
				check_line(blue);
				erase(green);
				erase(blue);
				break;
			case 2:
				block2(x, -(i + 1), green);
				block3(y, 1, blue);
				check_line(green);
				check_line(blue);
				erase(green);
				erase(blue);
				break;
			case 3:
				block3(x, 1, green);
				block2(y, -(i + 1), blue);
				check_line(green);
				check_line(blue);
				erase(green);
				erase(blue);
				break;
			}
		}

		System.out.println(score);

		int sum = 0;
		for (int r = 0; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if (green[r][c] != 0)
					sum++;
				if (blue[r][c] != 0)
					sum++;
			}
		}

		System.out.println(sum);
	}

	// 블럭1 (한 칸 블럭)
	static void block1(int x, int val, int[][] map) {
		int R = 0;
		while (true) {
			if (R + 1 < 6 && map[R + 1][x] == 0) {
				R++;
				continue;
			} else {
				map[R][x] = val;
				break;
			}
		}
	}

	// 블럭2 (가로로 2칸)
	static void block2(int x, int val, int[][] map) {
		int R = 0;
		// 가장 먼저 걸려 멈출 때의 행 값 확인
		for (int r = 0; r < 6; r++) {
			if (r == 5 || map[r + 1][x] != 0 || map[r + 1][x + 1] != 0) {
				R = r;
				break;
			}
		}
		map[R][x] = val;
		map[R][x + 1] = val;
	}

	// 블럭3 (세로로 2칸)
	static void block3(int x, int val, int[][] map) {
		int R = 0;
		while (true) {
			if (R + 1 < 6 && map[R + 1][x] == 0) {
				R++;
				continue;
			} else {
				map[R][x] = val;
				map[R - 1][x] = val;
				break;
			}
		}
	}

	// 한 줄 true 검사
	static void check_line(int[][] map) {
		// 가로 검사
		int cnt;
		boolean flag = false;
		for (int r = 2; r < 6; r++) {
			cnt = 0;
			for (int c = 0; c < 4; c++) {
				if (map[r][c] != 0)
					cnt++;
			}
			if (cnt >= 4) {
				score++;
				flag = true;
				for (int c = 0; c < 4; c++)
					check[r][c] = true;
			}
		}
		// 검사 결과를 대상에 반영
		for (int r = 2; r < 6; r++) {
			for (int c = 0; c < 4; c++) {
				if (check[r][c] == true) {
					map[r][c] = 0;
					check[r][c] = false;
				}
			}
		}
		// 중력 연산
		gravity(map);
		// 만약 변경 사항이 있다면 다시 한 번 체크
		if (flag == true) {
			check_line(map);
		}
	}

	// 중력 연산
	static void gravity(int[][] map) {
		for (int t = 0; t < 5; t++) {
			for (int r = 5; r >= 1; r--) {
				for (int c = 0; c < 4; c++) {
					if (map[r][c] == 0) {
						// 빈 칸 위의 블럭이 가로로 붙어 있는 블럭이라면, (음수이면서 옆 블럭과 같은 값이라면)
						if (map[r - 1][c] < 0 && ((c - 1 >= 0 && map[r][c - 1] != 0)
								&& ((c - 1 >= 0) && (map[r - 1][c - 1] == map[r - 1][c]))
								|| ((c + 1 < 4 && map[r][c + 1] != 0)
										&& ((c + 1 < 4) && (map[r - 1][c + 1] == map[r - 1][c]))))) {
							continue;
						} else {
							map[r][c] = map[r - 1][c];
							map[r - 1][c] = 0;
						}
					}
				}
			}
		}

	}

	// 0, 1행에 블럭이 있을 시 수행할 연산
	// 블럭이 몇 행에 걸쳐 있는지에 따라 아래부터 줄 삭제
	static void erase(int[][] map) {
		int cnt = 0;
		loop: for (int r = 1; r >= 0; r--) {
			for (int c = 0; c < 4; c++) {
				if (cnt >= 2) {
					break loop;
				}
				if (map[r][c] != 0) {
					cnt++;
					break;
				}
			}
		}
		for (int r = 0; r < cnt; r++) {
			for (int c = 0; c < 4; c++)
				map[5][c] = 0;
			gravity(map);
		}
	}
}