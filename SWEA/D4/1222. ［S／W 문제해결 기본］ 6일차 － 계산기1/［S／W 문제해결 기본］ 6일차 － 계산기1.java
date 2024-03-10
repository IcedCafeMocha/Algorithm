import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution{
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) { // 테스트 10회 수행
			int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 길이 N 입력받기.
			String str = br.readLine(); // 문자열로 이루어진 계산식 입력받기.

			// 중위표기식을 후위표기식으로 변경
			String cal = ""; // 문자열 변수 cal 선언 및 초기화
			Stack<Character> stack = new Stack<>();
			for (int k = 0; k < str.length(); k++) {
				char c = str.charAt(k);
				if (c >= '0' && c <= '9') { // 0~9 자연수 문자면
					cal += c; // cal 문자열에 추가
				} else { // '+'의 경우
					if (stack.isEmpty()) {
						stack.push(c);
					} else {
						while (!stack.isEmpty()) {
							cal += stack.pop();
						}
						stack.push(c);
					}
				}
			}
			if (stack.isEmpty() != true)
				cal += stack.pop();
			// 계산
			int sum = 0;
			Stack<Integer> temp = new Stack<>();
			for (int k = 0; k < cal.length(); k++) {
				char c = cal.charAt(k);
				if (c >= '0' && c <= '9') { // 피연산자를 만나면 스택에 push
					temp.push(c - '0');
				} else { // 연산자를 만나면 피연산자를 pop하여 연산
					sum = temp.pop() + temp.pop();
					temp.push(sum);
				}
			}
			result.add(temp.pop());
		}
		for (int i = 0; i < 10; i++)
			System.out.printf("#%d %d\n", i + 1, result.get(i)); // 결과 출력
	}
}