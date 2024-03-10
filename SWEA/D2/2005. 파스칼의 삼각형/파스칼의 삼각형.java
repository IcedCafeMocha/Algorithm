import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 삼각형 생성
		int[][] triangle = new int[10][10];
		triangle[0][0] = 1;
		for (int r = 1; r < 10; r++) {
			for (int c = 0; c < r + 1; c++) {
				if (r - 1 >= 0) {
					triangle[r][c] += triangle[r - 1][c];
				}
				if (r - 1 >= 0 && c - 1 >= 0) {
					triangle[r][c] += triangle[r - 1][c - 1];
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		int N;
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			bw.write("#" + Integer.toString(testcase));
			bw.newLine();
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < i + 1; k++) {
					bw.write(Integer.toString(triangle[i][k]) + " ");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}