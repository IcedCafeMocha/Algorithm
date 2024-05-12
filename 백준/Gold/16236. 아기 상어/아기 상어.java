import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static Queue<int[]> find_que = new LinkedList<>();
	static int N, babySize, babyR, babyC, eatCnt, result;
	static int map[][];
	static int find_map[][];
	static boolean[][] visited_find;
	static boolean callMom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		babySize = 2;
		eatCnt = 0;
		result = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		find_map = new int[N][N];
		visited_find = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] == 9) {
					map[r][c] = 0;
					babyR = r;
					babyC = c;
				}
			}
		}

		while (!callMom) {
			visited_find[babyR][babyC] = true;
			find(babyR, babyC);
			
		}
		System.out.println(result);
	}

	// 다음으로 먹을 물고기 찾기
	static void find(int R, int C) {
		int find_que_size , CR, CC, distance=1;
		int[] temp;
		find_que.offer(new int[] {R, C});
		reset(find_map);
		reset(visited_find);
		// 현재 위치 기준 각 칸까지의 최단 거리 구하기
		while(true) {
			if(find_que.isEmpty()) {
				break;
			}
			find_que_size = find_que.size();
			for(int i=0; i<find_que_size; i++) {
				temp = find_que.poll();
				for(int j=0; j<4; j++) {
					CR = temp[0] + dr[j];
					CC = temp[1] + dc[j];
					
					if(CR<0) continue;
					if(CC<0) continue;
					if(CR>=N) continue;
					if(CC>=N) continue;
					if(map[CR][CC]>babySize) continue;
					if(visited_find[CR][CC]) continue;
					
					visited_find[CR][CC] = true;
					if(map[CR][CC] != 0) {
						find_map[CR][CC] = distance;
					}
					find_que.offer(new int[] {CR, CC});
				}
			}
			distance++;
		}
		
		reset(visited_find);
		
		for(int d=1; d<N*N; d++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!visited_find[r][c] && find_map[r][c]==d) {
						visited_find[r][c] = true;
						if(map[r][c]<babySize) {
							map[r][c] = 0;
							eatCnt++;
							if (eatCnt == babySize) {
								babySize++;
								eatCnt = 0;
							}
							babyR = r;
							babyC = c;
							result += find_map[r][c];
							find_que.clear();
							return;
						}
					}
				}
			}			
		}
		callMom = true;
		return;
	}

	// visited 배열 리셋
	static void reset(boolean[][] arr) {
		for (int r = 0; r < N; r++)
			Arrays.fill(arr[r], false);
	}
	
	static void reset(int[][] arr) {
		for (int r = 0; r < N; r++)
			Arrays.fill(arr[r], 0);
	}
}