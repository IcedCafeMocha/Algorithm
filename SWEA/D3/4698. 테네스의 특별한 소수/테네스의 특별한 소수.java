import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		String[] input;
		String D;
		int A, B;
		int cnt;

		// 미리 소수 구해놓기
		// 소수가 아니면 true
		int t;
		boolean[] sosu = new boolean[1000001];
		for (int i = 2; i <= 1000000; i++) {
			t = 2;
			while (i * t <= 1000000) {
				sosu[i * t] = true;
				t++;
			}
		}
		sosu[0] = true;
		sosu[1] = true;

		for (int testcase = 1; testcase <= T; testcase++) {
			input = br.readLine().split(" ");
			// 조건 1. 구하고자 하는 특별한 소수는 D를 포함하고 있어야 한다.
			D = input[0];
			// 조건 2. 구하고자 하는 특별한 소수는 A 이상 B 이하의 범위에 속한다.
			A = Integer.parseInt(input[1]);
			B = Integer.parseInt(input[2]);

			cnt = 0;
			// 특별한 소수의 개수 찾기
			// A 이상 B 이하의 정수 i
			for (int i = A; i <= B; i++) {
				// i가 소수인지 확인
				if (sosu[i] == false) {
					// i가 D를 포함한 특별한 소수라면 cnt를 증가시켜 카운팅
					if (Integer.toString(i).contains(D))
						cnt++;
				}
			}

			bw.write("#" + Integer.toString(testcase) + " " + Integer.toString(cnt) + "\n");
		}
		bw.flush();
		bw.close();
	}
}