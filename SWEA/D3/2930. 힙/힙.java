import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 연산 정보를 입력받을 정수형 변수 input 선언
		int input;
		
		// Comparator로 내림차순 정렬. compare 구현
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		
		// 테스트 케이스의 수 T 입력받기
		int T = sc.nextInt();
		// T 만큼 테스트 수행
		for (int i = 0; i < T; i++) {
			System.out.print("#"+(i+1));

			// 수행해야 하는 연산의 수 N 입력받기
			int N = sc.nextInt();

			// N줄의 연산 정보 입력받기.
			for (int k = 0; k < N; k++) {
				// input에 연산 정보를 입력받는다.
				input = sc.nextInt();
				// 1이면 다음 입력값을 우선순위 큐 pq 에 추가한다.
				if (input == 1) {
					pq.add(sc.nextInt());
				// 2면 루트 노드의 값을 출력하고 해당 노드를 삭제한다.
				}else if(pq.isEmpty()==false){
					System.out.print(" " + pq.poll());
				// 힙이 비어있다면 -1을 출력한다.
				}else {
					System.out.print(" " + -1);
				}
			}
			System.out.println();
			pq.clear();
		}
	}
}