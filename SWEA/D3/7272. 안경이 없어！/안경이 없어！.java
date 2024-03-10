import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		String[] input;
		char[] str1;
		char[] str2;
		int str1_lookslike = 0, str2_lookslike = 0;

		// T 만큼 테스트 수행
		test: for (int testcase = 1; testcase <= T; testcase++) {
			// 주어진 두 문자열을 input 배열에 저장
			input = br.readLine().split(" ");

			// 두 문자열의 길이 검사
			// 길이가 다르다면 DIFF 출력 후 다음 테스트 케이스로 이동
			if (input[0].length() != input[1].length()) {
				bw.write("#" + Integer.toString(testcase) + " DIFF\n");
				continue test;
			} else {
				// 길이가 같은 경우
				// 각 문자열을 문자 단위로 나누어 str1, str2 배열에 저장
				str1 = input[0].toCharArray();
				str2 = input[1].toCharArray();

				// 한 문자씩 비교
				for (int i = 0; i < str1.length; i++) {
					switch (str1[i]) {
					case 'C':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
						str1_lookslike = 0;
						break;
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						str1_lookslike = 1;
						break;
					case 'B':
						str1_lookslike = 2;
						break;
					}
					switch (str2[i]) {
					case 'C':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
						str2_lookslike = 0;
						break;
					case 'A':
					case 'D':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
						str2_lookslike = 1;
						break;
					case 'B':
						str2_lookslike = 2;
						break;
					}
					// 두 문자의 판별 결과가 다르다면 DIFF 출력 후 다음 테스트 케이스로 이동
					if (str1_lookslike != str2_lookslike) {
						bw.write("#" + Integer.toString(testcase) + " DIFF\n");
						continue test;
					}

				}
			}
			// 모든 검사 후에도 DIFF가 아니라면 SAME 출력
			bw.write("#" + Integer.toString(testcase) + " SAME\n");
		}
		bw.flush();
		bw.close();
	}
}