import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int D, W, K, result;
	static boolean[][] map;
	static boolean[] A;
	static boolean[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			input = br.readLine().split(" ");

			// D : 필름의 두께, W : 가로 크기, K : 합격 기준
			D = Integer.parseInt(input[0]);
			W = Integer.parseInt(input[1]);
			K = Integer.parseInt(input[2]);

			map = new boolean[D][W];

			// A 약품을 사용했을 경우 (false)
			A = new boolean[W];
			// B 약품을 사용했을 경우 (true)
			B = new boolean[W];
			Arrays.fill(B, true);

			// 맵 데이터 입력
			for (int r = 0; r < D; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < W; c++) {
					if (input[c].equals("1"))
						map[r][c] = true;
				}
			}
			
			result = -1;
			// 투약 횟수를 최소로 하고 테스트 합격이 가능한 경우를 찾기 위해 0부터 K회까지 테스트 수행
			for (int i = 0; i <= K; i++) {
				mk(0,0,i);
				// 답이 나왔다면 테스트를 멈추고 결과 출력
				if(result!=-1)
					break;
			}
			System.out.println("#"+testcase+" "+result);
		}
	}

	// 약품을 사용한 필름 생성 메서드
	// cnt : 현재 약품 투입 횟수
	// idx : 현재 인덱스 (row)
	// k : 약품 투입이 가능한 최대 횟수
	static void mk(int cnt, int idx, int k) {
		// 기저조건
		// 약품 투입 제한 횟수만큼 투입한 경우
		if (cnt == k) {
			// 이 필름이 합격 조건에 부합하는지 확인
			if (check()) {
				// 결과에 반영
//				result = Math.min(result, k); // 어차피 최솟값부터 찾으므로 굳이 비교해줄 필요 없다.
				result = k;
			}
			return;
		}
		
		// 마지막 층까지 넣었으면 종료
		if(idx>=D)
			return;

		// map의 해당 부분 원본 저장
		boolean[] temp = new boolean[W];
		System.arraycopy(map[idx],0,temp,0,W);

		// 약품 A를 사용한 경우
		System.arraycopy(A, 0, map[idx], 0, W);
		mk(cnt+1, idx+1, k);

		// 약품 B를 사용한 경우
		System.arraycopy(B, 0, map[idx], 0, W);
		mk(cnt+1, idx+1, k);
		
		// 약품을 사용하지 않은 경우 (복원)
		System.arraycopy(temp, 0, map[idx], 0, W);
		mk(cnt, idx+1, k);
	}

	// 필름의 합격 조건 부합 여부 확인 메서드
	static boolean check() {
		int cnt;
		boolean flag;
		for (int c = 0; c < W; c++) {
			flag = false;
			for (int r = 0; r <= D - K; r++) {
				cnt=0;
				// 현재 칸부터 K칸 만큼 동일 여부 확인
				for (int i = 0; i < K; i++) {
					if (map[r][c] != map[r + i][c]) {
						break;
					}
					cnt++;
				}
				if(cnt==K) {
					flag = true;
				}
			}
			// 불합격!!
			if(!flag) {
				return false;
			}
		}
		return true;
	}
}