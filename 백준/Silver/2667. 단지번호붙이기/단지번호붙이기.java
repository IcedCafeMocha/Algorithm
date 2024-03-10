import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int N;
	static int cnt = 0;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		// 지도의 크기 N 입력받기.
		N = Integer.parseInt(br.readLine());
		// NxN 크기의 지도 배열 map 생성
		map = new int[N][N];
		// 지도에 데이터 입력받기.
		String[] input = new String[N];
		for (int r = 0; r < N; r++) {
			input = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		// 단지 찾기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					complex(r, c);
					result.add(cnt);
					cnt = 0;
				}
			}
		}
		// 결과 출력
		Object[]temp = result.toArray();
		Arrays.sort(temp);
		System.out.println(temp.length);
		for (int i = 0; i < temp.length; i++)
			System.out.println(temp[i]);
	}

	// 단지 만들기 메서드 complex
	private static void complex(int y, int x) {
		int r, c;
		if (map[y][x] != 1) // 방문한 곳은 다시 가지 않는다.
			return;
		else if (map[y][x] == 1) {
			cnt++;
			map[y][x]++; // 방문한 곳은 2로 바꿔서 표시
		}
		for (int i = 0; i < 4; i++) {
			r = dr[i] + y;
			c = dc[i] + x;
			if (r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 1)
				complex(r, c);

		}
	}

}
