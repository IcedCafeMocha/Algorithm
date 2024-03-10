import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Queue<String>> result = new ArrayList<>();
		// 카드 정보 입력받을 큐 생성
		Queue<String> card = new LinkedList<>();
		// 테스트 케이스의 수 T 입력받기.
		int T = Integer.parseInt(br.readLine());
		// T 만큼 테스트 수행
		for (int i = 0; i < T; i++) {
			// 카드 개수 N 입력받기
			int N = Integer.parseInt(br.readLine());
			// 카드 정보 입력받기
			String[] input = br.readLine().split(" ");
			// 입력받은 카드 정보를 card 큐에 저장
			for (int k = 0; k < N; k++)
				card.offer(input[k]);
			// 셔플한 결과를 result 리스트에 저장.
			result.add(shuffle(card));
		}
		// 결과 출력
		for (int i = 0; i < T; i++) {
			int shuffled_card_size = result.get(i).size();
			System.out.printf("#%d", i + 1);
			for (int k = 0; k < shuffled_card_size; k++)
				System.out.printf(" %s", result.get(i).poll());
			System.out.println();
		}
	}

	public static Queue<String> shuffle(Queue<String> q) {
		Queue<String> temp = new LinkedList<>();
		Queue<String> result = new LinkedList<>();
		int tmpSize = q.size();
		// 짝수의 경우
		if (q.size() % 2 == 0) {
			// temp 큐에 기존 q 큐에 있는 값의 절반을 저장
			for (int i = 0; i < tmpSize / 2; i++) {
				String str = q.poll();
				temp.offer(str);
			}
		} else {
			// 홀수의 경우
			// temp 큐에 기존 q 큐에 있는 값의 절반을 저장
			for (int i = 0; i < tmpSize / 2 + 1; i++) {
				temp.offer((String) q.poll());
			}
		}
		// temp 큐에 남는 값이 없을 때까지 번갈아가며 result 큐에 입력
		while (temp.size() != 0) {
			result.offer(temp.poll());
			result.offer((String) q.poll());
			// 홀수인 경우 temp에 하나 더 추가한다.
			if (temp.size() != 0 && q.size() == 0)
				result.offer(temp.poll());
		}
		// 셔플이 완료된 result 큐 리턴.
		return result;
	}
}