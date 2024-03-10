import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		int r = 0;
		int c = 0;
		List<Integer> result = new ArrayList<>(); // 결과값을 저장할 리스트 생성
		for (int i = 0; i < 10; i++) { // 테스트 10회 수행
			rd.readLine(); // 테스트 케이스의 번호 입력 버리기

			int[][] map = new int[100][100]; // 사다리게임 맵 배열 생성
			int[] ary = new int[map.length];
			for (r = 0; r < map.length; r++) {
				String input = rd.readLine(); // 정수로 표현된 사다리게임 맵 입력받기
				String[] str = input.split(" ");
				for (int k = 0; k < str.length; k++)
					ary[k] = Integer.parseInt(str[k]); // 정수로 바꿔 ary 배열에 저장
				for (c = 0; c < map.length; c++)
					map[r][c] = ary[c]; // map 배열에 입력받은 사다리 맵 저장
			}
			for (int k = 0; k < map.length; k++) { // 도착 지점 찾기
				if (map[map.length - 1][k] == 2)
					c = k;
			}
			r = map.length - 1;

			while (true) { // 도착 지점부터 출발 지점까지 이동
				if (r == 0)
					break;
				else if (c>0 && map[r][c - 1] == 1) {
					while (true) {
						c--;
						if (c == 0 || map[r][c - 1] != 1) {
							r--;
							break;
						}
					}
				} else if (c<map.length-1 && map[r][c + 1] == 1) {
					while (true) {
						c++;
						if (c == map.length-1 || map[r][c + 1] == 0) {
							r--;
							break;
						}
					}
				} else
					r--;
			}
			result.add(c);

		}
		for (int i = 0; i < 10; i++)
			System.out.printf("#%d %d\n", i + 1, result.get(i));
	}
}