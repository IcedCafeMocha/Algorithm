import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int time;
		Queue<Integer> snack = new LinkedList<>(); // 붕어빵을 저장할 큐 생성
		int T = Integer.parseInt((br.readLine())); // 테스트케이스 개수 T 입력받기.
		for (int i = 0; i < T; i++) { // T 만큼 테스트 수행
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]); // 손님의 수 N
			int M = Integer.parseInt(input[1]); // 붕어빵을 만드는데 필요한 시간 M초
			int K = Integer.parseInt(input[2]); // M초에 만들 수 있는 붕어빵의 개수 K

			int[] cus = new int[N]; // 손님 배열
			boolean[] cus_rec = new boolean[N]; // 손님이 붕어빵을 받았다면 true, 받지 못했다면 false를 입력받을 배열 생성 및 초기화. 기본값은 false
			
			String[] input2 = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				cus[j] = Integer.parseInt(input2[j]); // 손님 배열에 손님 데이터 입력받기
			}
			Arrays.sort(cus); // 손님 배열 정렬
			time = 1;
			while (true) { // 1초마다 붕어빵과 손님 상태 확인
				if (time % M == 0) { // M초마다
					for (int k = 0; k < K; k++) // 붕어빵 K개 추가
						snack.offer(1); // 붕어빵 = 1
				} else
					snack.offer(0); // 만들지 못함 = 0

				for (int j = 0; j < N; j++) { // 손님 수 N만큼 반복
					if (snack.isEmpty() == false && cus[j] == time) { // 손님이 도착한 시간이 됐으면,
						while (true) { // 만든 붕어빵을 하나 빼서 손님에게 준다.
							if (snack.peek() == 1) {
								snack.poll();
								cus_rec[j] = true;
								break;
							} else {
								snack.poll();
							}
							if (snack.isEmpty() == true) // 만든 붕어빵이 없다면 반복문을 나간다.
								break;
						}
					}
				}
				time++; // 시간이 1초 지난다.
				if (time > cus[cus.length - 1]) // 가장 마지막 손님까지 도착했다면 붕어빵 프로그램을 종료한다.
					break;
			}
			// 결과 출력
			System.out.print("#" + (i + 1));
			for (int j = 0; j < N; j++) {
				if (cus_rec[j] == false) {
					System.out.print(" Impossible\n");
					break;
				} else if (j == N - 1 && cus_rec[j] == true) {
					System.out.print(" Possible\n");
				}
			}
			snack.clear(); // 붕어빵 큐에 남은 데이터를 삭제하여 정리해준다.
		}
	}
}