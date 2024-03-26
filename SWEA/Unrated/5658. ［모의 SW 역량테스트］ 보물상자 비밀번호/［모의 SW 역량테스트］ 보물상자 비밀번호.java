import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트의 개수 T
		int T = Integer.parseInt(br.readLine());

		int N, K, L, temp;

		String[] input;

		// 리스트 생성
		List<Integer> list = new ArrayList<>();

		for (int testcase = 1; testcase <= T; testcase++) {
			int idx;
			input = br.readLine().split(" ");

			// 숫자의 개수 N
			N = Integer.parseInt(input[0]);
			// 크기 순서 K
			K = Integer.parseInt(input[1]);

			// 한 변의 숫자의 개수 L
			L = N / 4;

			// 스택 생성
			Stack<Integer> q = new Stack<>();

			// 보물상자에 적힌 숫자 저장할 배열 생성
			int[] nums = new int[N];

			// 16진수 문자열 입력받기
			input = br.readLine().split("");

			// 입력받은 16진수 문자열을 10진수로 바꿔 nums 배열에 저장
			for (int i = 0; i < N; i++) {
				nums[i] = trans(input[i]);
			}

			// nums에 저장된 값을 이용하여 L자리 숫자를 만들어 리스트 list에 저장
			// 다이얼은 L-1번 까지 돌려본다. 그 이후는 처음으로 돌아오기 때문.
			for (int i = 0; i < L; i++) {
				// i부터 인덱스 시작
				idx = i;

				// 4개 변의 숫자를 만드므로 4번 수행
				test:for (int k = 0; k < 4; k++) {
					// L개의 숫자 스택에 저장
					for (int t = 0; t < L; t++) {
						if (idx >= nums.length)
							idx = 0;
						q.push(nums[idx++]);
					}

					temp = 0;
					// 저장된 스택에서 하나씩 꺼내 L자리 수 만들어 리스트에 저장
					for (int t = 0; t < L; t++) {
						temp += q.pop() * (int) (Math.pow(16, t));
					}
					
					for(int t=0; t<list.size(); t++) {
						if(list.get(t)==temp)
							continue test;
					}
					list.add(temp);
				}
			}
			
			list.sort(null);

			System.out.println("#"+testcase+" "+list.get(list.size() - K));

			// 초기화
			list.clear();
		}
	}

	// 16진수 -> 10진수
	public static int trans(String num) {
		int val = num.charAt(0);
		if (val >= 65 && val <= 70) {
			return val - 55;
		}
		return val - 48;
	}
}
