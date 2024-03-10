import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		List<Integer> result = new ArrayList<>(); // 죽은 파리 개수의 최대값을 저장할 리스트 생성
		int sum;
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt(); // 영역 크기를 정하기 위한 정수 N 입력받기.
			int M = sc.nextInt(); // 파리채의 크기를 정하기 위한 정수 M 입력받기.
			int[][] map = new int[N][N];
			for (int r = 0; r < N; r++) { // map 배열에 각 영역별 파리 개수 저장.
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			List<Integer> kill = new ArrayList<>(); // 잡은 파리의 개수를 합한 값을 저장할 리스트 생성
			for (int r = 0; r <= N - M; r++) { // 탐색 현 위치의 행과 열
				for (int c = 0; c <= N - M; c++) {
					sum = 0;
					for (int r2 = r; r2 < r+M; r2++) { // 현 위치를 기준으로 파리채 크기만큼 파리 수를 합한다.
						for (int c2 = c; c2 < c+M; c2++)
							sum += map[r2][c2];
					}
					kill.add(sum); // 잡은 총 파리 수를 kill 리스트에 저장.
				}
			}
			// 정렬하여 최대값 찾기
			int[] kill_ary = new int[kill.size()];
			for (int k = 0; k < kill.size(); k++)
				kill_ary[k] = kill.get(k);
			Arrays.sort(kill_ary);
			result.add(kill_ary[kill_ary.length-1]); // 찾은 최대값을 result 리스트에 저장.
		}
		// 결과 출력
		for(int i=0; i<T; i++)
			System.out.printf("#%d %d\n", i+1, result.get(i));
	}
}