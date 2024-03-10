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
		int N, R, C, cnt;
		boolean[][] check;
		int[][] snail;

		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			check = new boolean[N][N];
			snail = new int[N][N];

			R = 0;
			C = 0;
			cnt = 1;
			check[0][0]=true;
			snail[0][0]=1;
			while (true) {
				if(cnt>=N*N)
					break;
				while (cnt <= N * N) {
					if (C + 1 >= N || check[R][C + 1] == true) {
						check[R][C] = true;
						snail[R][C] = cnt;
						break;
					} else {
						check[R][C] = true;
						snail[R][C] = cnt;
						C++;
						cnt++;
					}
				}
				while (cnt <= N * N) {
					if (R + 1 >= N || check[R + 1][C] == true) {
						check[R][C] = true;
						snail[R][C] = cnt;
						break;
					} else {
						check[R][C] = true;
						snail[R][C] = cnt;
						R++;
						cnt++;
					}
				}
				while (cnt <= N * N) {
					if (C - 1 < 0 || check[R][C - 1] == true) {
						check[R][C] = true;
						snail[R][C] = cnt;
						break;
					} else {
						check[R][C] = true;
						snail[R][C] = cnt;
						C--;
						cnt++;
					}
				}
				while (cnt <= N * N) {
					if (R - 1 < 0 || check[R - 1][C] == true) {
						check[R][C] = true;
						snail[R][C] = cnt;
						break;
					} else {
						check[R][C] = true;
						snail[R][C] = cnt;
						R--;
						cnt++;
					}
				}
			}
			
			bw.write("#"+Integer.toString(testcase)+"\n");
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					bw.write(Integer.toString(snail[r][c])+" ");
				}
				bw.write("\n");
			}
			
		}
		bw.flush();
		bw.close();
	}
}