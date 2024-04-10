import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] map;
	static boolean[][] visited;
	static int R, C, cnt;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);

		map = new boolean[R][C];
		visited = new boolean[R][C];

		// map 정보 입력 받기
		for (int r = 0; r < R; r++) {
			input = br.readLine().split("");
			for (int c = 0; c < C; c++) {
				if (input[c].equals("x"))
					map[r][c] = true;
			}
		}

		for (int r = 0; r < R; r++) {
			flag = false;
			buildPipeline(r, 0);
		}
		System.out.println(cnt);
	}

	static void buildPipeline(int r, int c) {
		if(c == C-1) {
//			System.out.println("도착했어!");
			flag = true;
			cnt++;
			return;
		}
		for(int i=0; i<3; i++) {
			int CR = r + dr[i];
			int CC = c + dc[i];
			
			if(flag) return;
			
			if(CR < 0) continue;
			if(CC < 0) continue;
			if(CR >= R) continue;
			if(CC >= C) continue;
			
			if(map[CR][CC]) continue;
			if(visited[CR][CC]) continue;
			
			
//			System.out.println("R: "+CR+" C: "+CC+" 로 이동할게!");
			visited[CR][CC] = true;
			buildPipeline(CR, CC);
		}
	}
}
