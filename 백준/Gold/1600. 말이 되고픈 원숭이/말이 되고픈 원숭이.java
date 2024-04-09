import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] horse_dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] horse_dc = { -2, -1, 1, 2, -2, -1, 1, 2 };
	
	static Queue<int[]> que = new LinkedList<>();
	static boolean[][] map;
	static boolean[][][] visited;
	
	static int W, H, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		int R, C, que_size, Jump, cnt;
		int[] RCJ;
		
		
		K = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");

		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);

		map = new boolean[H][W];
		visited = new boolean[H][W][K+1];

		for (int r = 0; r < H; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < W; c++) {
				if (input[c].equals("1"))
					map[r][c] = true;
			}
		}
		
		que.offer(new int[] {0, 0, K});
		visited[0][0][K] = true;
		
		cnt = 0;
		loop: while(true) {
			if(que.isEmpty()) {
				System.out.println(-1);
				break;
			}
			
			que_size = que.size();
			for(int i=0; i<que_size; i++) {
				
				RCJ = que.poll();
				
				R = RCJ[0];
				C = RCJ[1];
				Jump = RCJ[2];
				
				if(R== H-1 && C== W-1) {
					System.out.println(cnt);
					break loop;
				}

				move(R, C, Jump);
			}
			cnt++;
		}
		
	}
	
	static void move(int r, int c, int k) {
		int R, C;
		
		for(int i=0; i<4; i++) {
			R = r + dr[i];
			C = c + dc[i];
			
			if(R<0) continue;
			if(C<0) continue;
			if(R>=H) continue;
			if(C>=W) continue;
			
			if(map[R][C]) continue;
			if(visited[R][C][k]) continue;
			
			visited[R][C][k]=true;
			que.offer(new int[] {R, C, k});
		}
		if(k != 0) {
			for(int i=0; i<8; i++) {
				R = r+horse_dr[i];
				C = c+horse_dc[i];
				
				if(R<0) continue;
				if(C<0) continue;
				if(R>=H) continue;
				if(C>=W) continue;
				
				if(map[R][C]) continue;
				
				if(visited[R][C][k]) continue;
				if(visited[R][C][k-1]) continue;
				for(int j=k; j<K; j++)
					if(visited[R][C][k+1]) continue;
				
				visited[R][C][k-1]=true;
				que.offer(new int[] {R,C,k-1});
			}
			
		}

	}
}