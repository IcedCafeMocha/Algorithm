import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		char C;
		int cnt, MIN;
		// Test Case 수 T 입력받기
		int T = Integer.parseInt(br.readLine());
		// T 만큼 테스트 수행
		for (int test_case = 1; test_case <= T; test_case++) {
			input = br.readLine();
			String[] input_ary = input.split(" ");
			cnt = 0;
			// N행
			int N = Integer.parseInt(input_ary[0]);
			// M열
			int M = Integer.parseInt(input_ary[1]);

			// 각 행의 색 수를 카운팅할 배열 생성
			int[][] counter = new int[N][3];
			// 문자열 입력 받기
			for (int r = 0; r < N; r++) {
				// 한 행씩 입력받는다
				input = br.readLine();
				// 입력받은 문자열을 문자 단위로 나눠서 카운팅
				for (int c = 0; c < M; c++) {
					C = input.charAt(c);
					// index 0 : W, 1 : B, 2 : R
					if (C == 'W')
						counter[r][0]++;
					else if (C == 'B')
						counter[r][1]++;
					else
						counter[r][2]++;
				}
			}
			
			// Blue가 칠해질 첫 행 i와 Red가 칠해질 첫 행 k를 바꿔가며 최솟값을 찾는다.
			MIN = 3000;
			for (int i = 1; i < N-1; i++) {
				cnt = 0;
				for (int k = i + 1; k < N; k++) {
					cnt = 0;
					// W
					// i행 전까지 White
					for (int r = 0; r < i; r++) {
						cnt += counter[r][1];
						cnt += counter[r][2];
					}
					// B
					// i행부터 k행 전까지 Blue
					for (int r = i; r < k; r++) {
						cnt += counter[r][0];
						cnt += counter[r][2];
					}
					// R
					// k행부터 N-1행까지 Red
					for (int r = k; r < N; r++) {
						cnt += counter[r][0];
						cnt += counter[r][1];
					}
					// 결과값 cnt가 현재 저장된 최솟값보다 작다면 최솟값으로 저장.
					if (cnt < MIN)
						MIN = cnt;
				}
			}
			System.out.print("#" + test_case + " ");
			System.out.print(MIN + "\n");
		}
	}
}
