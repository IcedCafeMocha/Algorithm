import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int W, H;
	static boolean[][] map;
	static boolean[][] visited;
	static Queue<int[]> fire = new LinkedList<>();
	static Queue<int[]> man = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R, C, time;
		String[] input;
		int[] temp;
		int T = Integer.parseInt(br.readLine());
		for(int testcase=1; testcase<=T; testcase++) {
			fire.clear();
			man.clear();
			input = br.readLine().split(" ");
			W = Integer.parseInt(input[0]);
			H = Integer.parseInt(input[1]);
			map = new boolean[H][W];
			visited = new boolean[H][W];
			for(int r=0; r<H; r++) {
				input = br.readLine().split("");
				for(int c=0; c<W; c++) {
					// 빈 공간
					if(input[c].equals("."))
						continue;
					// 벽
					if(input[c].equals("#"))
						map[r][c] = true;
					// 불
					if(input[c].equals("*")) {
						fire.offer(new int[] {r,c});
						map[r][c] = true;
					}
					// 상근
					if(input[c].equals("@")) {
						man.offer(new int[] {r,c});
						visited[r][c] = true;
					}
				}
			}
			
			temp = man.peek();
			R = temp[0];
			C = temp[1];
			if(R==0 || R==H-1 || C==0 || C==W-1) {
				System.out.println(1);
				continue;
			}
			
			int fire_size;
			int man_size;
			time = 1;
			loop: while(true) {
				// 탈출 불가
				if(man.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
				
				fire_size = fire.size();
				man_size = man.size();
				
				// 불 번짐
				for(int i=0; i<fire_size; i++) {
					temp = fire.poll();
					for(int j=0; j<4; j++) {
						R = temp[0] + dr[j];
						C = temp[1] + dc[j];
						
						if(R<0) continue;
						if(C<0) continue;
						if(R>=H) continue;
						if(C>=W) continue;
						if(map[R][C]) continue;
						map[R][C] = true;
						fire.offer(new int[] {R, C});
					}
				}
				
				// 상근 이동
				for(int i=0; i<man_size; i++) {
					temp = man.poll();
					if(temp[0]==0 || temp[0]==H-1 || temp[1]==0 || temp[1]==W-1) {
						System.out.println(time);
						break loop;
					}
					for(int j=0; j<4; j++) {
						R = temp[0] + dr[j];
						C = temp[1] + dc[j];
						
						if(R<0) continue;
						if(C<0) continue;
						if(R>=H) continue;
						if(C>=W) continue;
						if(map[R][C]) continue;
						if(visited[R][C]) continue;
						visited[R][C] = true;
						man.offer(new int[] {R, C});
					}
				}
				time++;
			}
		}
	}
}