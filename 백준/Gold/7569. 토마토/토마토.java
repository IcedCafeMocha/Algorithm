import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 0, 1, 0, 0, 0 };
	static int[] dc = { 0, 1, 0, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int M, N, H;
	static int[][][] map;
	static Queue<int[]> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = 0, day, CR, CC, CH, NR, NC, NH, que_size;
		int[] RCH;
		String[] input;

		input = br.readLine().split(" ");

		// M : 상자의 가로 크기, N : 상자의 세로 크기, H : 쌓아올려지는 상자의 수
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		H = Integer.parseInt(input[2]);

		map = new int[N][M][H];

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < M; c++) {
					map[r][c][h] = Integer.parseInt(input[c]);
					if (map[r][c][h] == 1)
						que.offer(new int[] { r, c, h });
					if (map[r][c][h] == 0)
						cnt++;
				}
			}
		}
		day = 0;
		while (true) {
			if (cnt == 0) {
				System.out.println(day);
				break;
			}
			if (que.isEmpty()) {
				System.out.println(-1);
				break;
			}
			
			que_size = que.size();
			for(int q=0; q<que_size; q++) {
				RCH = que.poll();
				CR = RCH[0];
				CC = RCH[1];
				CH = RCH[2];
				
				for (int i = 0; i < 6; i++) {
					NR = CR + dr[i];
					NC = CC + dc[i];
					NH = CH + dh[i];
					
					if (NR < 0) continue;
					if (NC < 0) continue;
					if (NH < 0) continue;
					if (NR >= N) continue;
					if (NC >= M) continue;
					if (NH >= H) continue;
					
					if (map[NR][NC][NH] != 0) continue;
					map[NR][NC][NH] = 1;
					cnt--;
					que.offer(new int[] { NR, NC, NH });
				}
			}
			day++;
		}
	}
}