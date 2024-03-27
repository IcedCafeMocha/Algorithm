import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static int[] fee;
	public static int[] plan;
	public static int MIN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		String[] input;

		// T만큼 테스트 케이스 수행
		for (int testcase = 1; testcase <= T; testcase++) {
			
			// 가격, 계획 데이터 입력받기
			input = br.readLine().split(" ");
			fee = new int[input.length];

			for (int i = 0; i < input.length; i++)
				fee[i] = Integer.parseInt(input[i]);

			input = br.readLine().split(" ");
			plan = new int[input.length];

			for (int i = 0; i < input.length; i++)
				plan[i] = Integer.parseInt(input[i]);

			// 현재 최소값을 1년 요금제를 사용했을 경우로 설정
			MIN = fee[3];

			check(0, 0);
			
			bw.write("#" + testcase + " " + MIN+"\n");
		}
		bw.flush();
		bw.close();
	}

	public static void check(int idx, int sum) {
		if (idx > 11) {
			if (sum < MIN)
				MIN = sum;
			return;
		}

		// 3달 이용권이 사용 가능한 날짜
		if (idx <= 9) {
			// 일일 이용권을 사용하는 것이 한 달 이용권을 사용하는 경우보다 저렴할 경우
			if (plan[idx] * fee[0] < fee[1]) {
				check(idx + 1, sum+ plan[idx] * fee[0]);
			}
			// 한 달 이용권을 사용하는 것이 더 저렴한 경우
			else {
				check(idx + 1, sum+ fee[1]);
			}
			
			// 3달 이용권을 사용할 경우
			check(idx + 3, sum+ fee[2]);
		}
		// 3달 이용권이 사용 불가능한 날짜
		else {
			// 일일 이용권을 사용하는 것이 한 달 이용권을 사용하는 경우보다 저렴할 경우
			if (plan[idx] * fee[0] < fee[1]) {
				check(idx + 1, sum+ plan[idx] * fee[0]);
			}
			// 한 달 이용권을 사용하는 것이 더 저렴한 경우
			else {
				check(idx + 1, sum+ fee[1]);
			}
		}
	}
}