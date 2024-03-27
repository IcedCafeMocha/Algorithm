import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	// 집합의 대표를 저장할 배열 P
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input;
		int m, n;

		// 입력값 T 만큼 테스트케이스 수행
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			System.out.print("#" + testcase + " ");

			input = br.readLine().split(" ");

			// n : 집합의 개수 , m : 연산의 개수
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);

			// n개의 초기 집합
			P = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				P[i] = i;
			}

			// m 개의 연산 데이터 입력
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");

				// union 수행
				if (input[0].equals("0")) {
					union(findset(Integer.parseInt(input[1])), findset(Integer.parseInt(input[2])));
				}
				// findset 수행
				else {
					if (findset(Integer.parseInt(input[1])) == findset(Integer.parseInt(input[2]))) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}

			}
			System.out.println();
		}

	}

	// union
	public static void union(int x, int y) {
		P[y] = x;	
	}

	public static int findset(int x) {
		if (x != P[x]) {
			P[x] = findset(P[x]);
		}

		return P[x];
	}
}