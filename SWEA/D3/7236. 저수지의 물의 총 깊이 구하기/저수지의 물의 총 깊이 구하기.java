import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		int N, cnt, MAX;
		boolean[][] map;
		String[] input;
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				for (int k = 0; k < N; k++) {
					if (input[k].equals("W"))
						map[i][k] = true;
				}
			}
			MAX = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == true) {
						cnt = 0;
						for (int i = 0; i < 8; i++) {
							if (r + dr[i] < N && r + dr[i] >= 0 && c + dc[i] < N && c + dc[i] >= 0
									&& map[r + dr[i]][c + dc[i]] == true)
								cnt++;
						}
						if (cnt == 0)
							cnt = 1;
						if (cnt > MAX)
							MAX = cnt;
					}
				}
			}
			bw.write("#" + Integer.toString(testcase) + " " + Integer.toString(MAX) + "\n");
		}
		bw.flush();
		bw.close();
	}
}