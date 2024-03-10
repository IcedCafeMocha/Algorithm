import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
		int N, cnt;
		List<Integer> result = new ArrayList<>(); // 각 케이스 답을 저장할 리스트 생성
		for (int i = 0; i < 10; i++) { // 10회의 테스트 케이스 반복 진행
			N = sc.nextInt(); // 건물의 개수 N 입력
			int[][] map = new int[255][N + 4]; // 건물 지도 역할의 배열 map 생성
			cnt = 0; // 조망권 확보된 세대 수 카운팅 위한 변수 선언
			for (int j = 2; j < N + 2; j++) {
				int l = sc.nextInt();
				for (int k = 254; k > 254 - l; k--) {
					if (k < 0 || k > 254)
						continue;
					map[k][j] = 1;
				}
			}
			for (int k = 0; k < 255; k++) {
				for (int j = 2; j < N + 2; j++) {
					if ((map[k][j] == 1)) {
						if (map[k][j - 1] + map[k][j - 2] + map[k][j + 1] + map[k][j + 2] == 0) {
							cnt++;
						}
					}
				}
			}
			result.add(cnt);
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("#%d %d\n", i + 1, result.get(i));
		}
    }
}