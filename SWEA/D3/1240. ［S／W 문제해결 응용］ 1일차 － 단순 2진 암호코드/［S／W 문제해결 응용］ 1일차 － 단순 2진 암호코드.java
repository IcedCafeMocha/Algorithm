import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();

		// 테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		String[] input;

		// T만큼 테스트 수행
		for (int test_case = 1; test_case <= T; test_case++) {
			input = br.readLine().split(" ");
			// 세로 크기 N, 가로 크기 M
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			// 암호 코드 분석
			String str;
			code: for (int i = 0; i < N; i++) {
				input = br.readLine().split("");
				// 뒤부터 확인
				for (int k = M - 1; k >= 0; k--) {
					// 1을 만났을 시 암호코드로 인식
					if (input[k].equals("1")) {
						while (true) {
							if (list.size() == 8) {
								for (int q = i+1; q < N; q++) {
									br.readLine();
								}
								break code;
							}
							str = input[k - 6];
							for (int j = 5; j >= 0; j--) {
								str += input[k - j];
							}
							switch (str) {
							case "0001101":
								list.add(0);
								break;
							case "0011001":
								list.add(1);
								break;
							case "0010011":
								list.add(2);
								break;
							case "0111101":
								list.add(3);
								break;
							case "0100011":
								list.add(4);
								break;
							case "0110001":
								list.add(5);
								break;
							case "0101111":
								list.add(6);
								break;
							case "0111011":
								list.add(7);
								break;
							case "0110111":
								list.add(8);
								break;
							case "0001011":
								list.add(9);
								break;
							}
							k -= 7;
						}

					}
				}
			}
			// 결과 출력
			System.out.printf("#%d ", test_case);
			if (((list.get(7) + list.get(5) + list.get(3) + list.get(1)) * 3
					+ (list.get(6) + list.get(4) + list.get(2) + list.get(0))) % 10 == 0) {
				int sum = 0;
				for (int i = 0; i < 8; i++) {
					sum += list.get(i);
				}
				System.out.println(sum);
			} else {
				System.out.println(0);
			}
			// 다음 테스트케이스를 위해 리스트 클리어
			list.clear();
		}
	}
}