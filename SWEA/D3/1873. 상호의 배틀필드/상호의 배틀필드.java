import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		// 테스트케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		int C = 0, R = 0, t = 0;

		// T만큼 테스트 수행
		for (int test_case = 1; test_case <= T; test_case++) {
			input = br.readLine().split(" ");
			// 게임 맵의 높이 H, 너비 W
			int H = Integer.parseInt(input[0]);
			int W = Integer.parseInt(input[1]);

			// HxW 크기의 게임 맵 배열 map
			String[][] map = new String[H][W];

			for (int r = 0; r < H; r++) {
				input = br.readLine().split("");
				for (int c = 0; c < W; c++) {
					map[r][c] = input[c];
					// 현재 전차의 위치 파악
					if(map[r][c].equals("^")||map[r][c].equals("v")||map[r][c].equals("<")||map[r][c].equals(">")) {
						R = r;
						C = c;
					}

				}
			}
			// 사용자가 넣을 입력의 개수 N
			int N = Integer.parseInt(br.readLine());
			String[] order = br.readLine().split("");
			
			// 사용자 입력대로 수행
			for(int i=0; i<N; i++) {
				switch (order[i]) {
				case "U":
					map[R][C] = "^";
					if(R-1 >= 0 && map[R-1][C].equals(".")) {
						map[R][C] = ".";
						map[R-1][C] = "^";
						R = R-1;
					}
					
					break;
				case "D":
					map[R][C] = "v";
					if(R+1 < H && map[R+1][C].equals(".")) {
						map[R][C] = ".";
						map[R+1][C] = "v";
						R = R+1;
					}

					break;
				case "L":
					map[R][C] = "<";
					if(C-1 >= 0 && map[R][C-1].equals(".")) {
						map[R][C] = ".";
						map[R][C-1] = "<";
						C = C-1;
					}
					
					break;
				case "R":
					map[R][C] = ">";
					if(C+1 < W && map[R][C+1].equals(".")) {
						map[R][C] = ".";
						map[R][C+1] = ">";
						C = C+1;
					}
					
					break;
				case "S":
					switch (map[R][C]) {
					case "^": 
						t=1;
						while(R-t>=0 && !(map[R-t][C].equals("#"))) {
							if(map[R-t][C].equals("*")) {
								map[R-t][C] = ".";
								break;
							}
							t++;
						}
						
						break;
					case "v":
						t=1;
						while(R+t<H && !(map[R+t][C].equals("#"))) {
							if(map[R+t][C].equals("*")) {
								map[R+t][C] = ".";
								break;
							}
							t++;
						}
						
						break;
					case "<":
						t=1;
						while(C-t>=0 && !(map[R][C-t].equals("#"))) {
							if(map[R][C-t].equals("*")) {
								map[R][C-t] = ".";
								break;
							}
							t++;
						}
						
						break;
					case ">":
						t=1;
						while(C+t<W && !(map[R][C+t].equals("#"))) {
							if(map[R][C+t].equals("*")) {
								map[R][C+t] = ".";
								break;
							}
							t++;
						}
						
						break;
					}
					
					break;
				}
			}
			// 결과 출력
			System.out.printf("#%d ",test_case);
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			}
		}

	}
}