import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N, K, MAX;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TOP, top_que_size, R, C;
		String[] input;
		int[] temp;
		Queue<int[]> top = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase<=T; testcase++) {
			TOP = 0;
			MAX = 0;
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			K = Integer.parseInt(input[1]);
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			// map 데이터 입력받기
			for(int r = 0; r<N; r++) {
				input = br.readLine().split(" ");
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(input[c]);
					TOP = Math.max(Integer.parseInt(input[c]), TOP);
				}
			}
			
			// 최고 높이인 지점들의 좌표를 큐에 저장
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]==TOP)
						top.offer(new int[] {r,c});
				}
			}
			
			// top 큐에 저장된 최고 높이 개수만큼 테스트 수행
			top_que_size = top.size();
			for(int i=0; i<top_que_size; i++) {
				// 최고 높이 좌표 하나를 꺼내 사용
				temp = top.poll();
				R = temp[0];
				C = temp[1];
				visited[R][C] = true;
				
				dfs(R, C, 1, false);
				
				visited[R][C] = false;
			}
			System.out.println("#"+testcase+" "+MAX);
		}
	}
	
	// r, c : 현재 좌표의 r, c 값, cnt : 이동 횟수, used : 지형을 깎는 것의 사용 여부
	static void dfs(int r, int c, int cnt, boolean used) {
		int next_r, next_c;
		int temp;
		
		
		for(int i=0; i<4; i++) {
			next_r = r + dr[i];
			next_c = c + dc[i];
			
			// 경계 조건
			if(next_r < 0) continue;
			if(next_c < 0) continue;
			if(next_r >= N) continue;
			if(next_c >= N) continue;			
			// 방문 여부 확인
			if(visited[next_r][next_c]) continue;
			
			// 다음 칸의 높이가 지금과 같거나 큰 경우
			if(map[r][c]<=map[next_r][next_c]) {
				// 지형을 깎은 적이 있는지 확인
				if(used) continue;
				for(int j=1; j<=K; j++) {
					if(map[r][c]<=map[next_r][next_c]-j) continue;
					temp = map[next_r][next_c];
					map[next_r][next_c] -= j;
					dfs(next_r, next_c, cnt+1, true);
					// map 복구
					map[next_r][next_c] = temp;
				}
			}
			
			// 다음 칸의 높이가 지금보다 작은 경우
			else {
				visited[next_r][next_c] = true;
				dfs(next_r, next_c, cnt+1, used);
				visited[next_r][next_c] = false;
			}
		}
		MAX = Math.max(cnt, MAX);
	}
}