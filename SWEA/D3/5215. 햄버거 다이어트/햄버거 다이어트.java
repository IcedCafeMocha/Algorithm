import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	// 결과값으로 출력할 햄버거 점수의 최대값 MAX
	static int MAX, N, L;
	static int[] score;
	static int[] cal;
	static boolean[] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input[];
		// 테스트 케이스 T
		int T = Integer.parseInt(br.readLine());
		// T만큼 테스트 수행
		for (int test_case = 1; test_case <= T; test_case++) {
			MAX = 0;
			input = br.readLine().split(" ");
			// 재료의 수 N
			// 제한 칼로리 L
			N = Integer.parseInt(input[0]);
			L = Integer.parseInt(input[1]);

			// 재료의 맛에 대한 점수와 칼로리 정보
			score = new int[N];
			cal = new int[N];

			for (int i = 0; i < N; i++) {
				input = br.readLine().split(" ");
				score[i] = Integer.parseInt(input[0]);
				cal[i] = Integer.parseInt(input[1]);
			}

			// 조합 찾기 함수 수행
			sel = new boolean[N];
			comb(0);
			
			// 결과 출력
			bw.write("#");
			bw.write(Integer.toString(test_case));
			bw.write(" ");
			bw.write(Integer.toString(MAX));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
	
	// 최적의 조합 찾기
	public static void comb(int idx) {
		if (idx >= N) {
			int cal_sum = 0;
			int score_sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					cal_sum += cal[i];
					score_sum += score[i];
				}
			}

			if (cal_sum <= L && score_sum > MAX) {
				MAX = score_sum;
			}
			return;
		}

		sel[idx] = true;
		comb(idx + 1);

		sel[idx] = false;
		comb(idx + 1);
	}
}