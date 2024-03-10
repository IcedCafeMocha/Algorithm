import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> result = new ArrayList<>();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 T 입력받기.
		for(int i=0; i<T; i++) { // T 만큼 테스트 수행.
			int K = Integer.parseInt(br.readLine()); // 입력값이 몇 줄인지 결정하는 정수 K 입력받기.
			Stack<Integer> stack = new Stack<>();
			for(int k=0; k<K; k++) { // K만큼 반복 수행
				stack.add(Integer.parseInt(br.readLine()));
				if(stack.get(stack.size()-1)==0) {
					stack.pop(); // 0 pop
					stack.pop(); // 0 이전의 값 pop
				}
			}
			int sum=0;
			for(int k=0; k<stack.size(); k++) {
				sum+=stack.get(k); // 스택에 저장된 값을 모두 더한다.
			}
			result.add(sum); // 더한 값을 result 리스트에 저장한다.
		}
		for(int i=0; i<T; i++)
			System.out.printf("#%d %d\n", i+1, result.get(i)); // result 리스트에 저장된 결과값을 출력.
	}
}