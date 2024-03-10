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
		String[][] ary, ary90, ary180, ary270;
		int N;
		String[] input;

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			ary = new String[N][N];
			ary90 = new String[N][N];
			ary180 = new String[N][N];
			ary270 = new String[N][N];

			for (int r = 0; r < N; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					ary[r][c] = input[c];
				}
			}

			for (int c = N - 1; c >= 0; c--) {
				for (int r = 0; r < N; r++) {
					ary90[r][c] = ary[N - 1 - c][r];
				}
			}

			for (int r = N - 1; r >= 0; r--) {
				for (int c = N - 1; c >= 0; c--) {
					ary180[r][c] = ary[N - 1 - r][N - 1 - c];
				}
			}

			for (int c = 0; c < N; c++) {
				for (int r = N - 1; r >= 0; r--) {
					ary270[r][c] = ary[c][N - 1 - r];
				}
			}

			bw.write("#" + Integer.toString(testcase) + "\n");
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < N; k++) {
					bw.write(ary90[i][k]);
				}
				bw.write(" ");
				for (int k = 0; k < N; k++) {
					bw.write(ary180[i][k]);
				}
				bw.write(" ");
				for (int k = 0; k < N; k++) {
					bw.write(ary270[i][k]);
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}