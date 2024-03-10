import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Solution{
	public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
		int N, M, MAX;
		List<Integer> result = new ArrayList<>(); // 결과를 저장할 result 리스트 생성
		int T = sc.nextInt(); // 테스트 케이스의 수 T 입력받기.
		for (int i = 0; i < T; i++) {
			N = sc.nextInt(); // 정수 N 입력받기
			M = sc.nextInt(); // 정수 M 입력받기
			int[] count = new int[N + M + 1]; // N 이하의 자연수와 M 이하의 자연수를 더한 값이 나오는 횟수를 카운팅할 배열 생성
			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= M; m++) {
					count[n + m]++; // 더한 값을 센다.
				}
			}
			MAX = 0;
			for (int k = 2; k < N + M + 1; k++) { // count 배열의 최대값을 찾는다.
				if (count[k] > MAX) {
					MAX = count[k];
				}
			}
			for (int k = 0; k < N + M + 1; k++) { // 최대값을 갖는 count 배열의 인덱스들을 찾아 result리스트에 저장한다.
				if (count[k] == MAX)
					result.add(k);
			}
			result.add(-1); // 다음 테스트 케이스와의 구분을 위해 -1을 마지막에 넣어준다.
		}
		int cnt = 0;
		for (int i = 0; i < T; i++) { // 결과 출력
			System.out.printf("#%d ", i + 1);
			while (true) {
				if (result.get(cnt) == -1) {
					cnt++;
					break;
				} else {
					System.out.printf("%d ", result.get(cnt));
					cnt++;
				}
			}
			System.out.println();
		}
    }
}