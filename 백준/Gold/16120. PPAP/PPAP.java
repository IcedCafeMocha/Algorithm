import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray(); // 입력받은 문자열을 문자 단위로 쪼개 배열에 저장.
        Stack<Character> stack = new Stack<>(); 
        
        // 문자열에서 PPAP를 P로 치환
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'P') // P를 만나면 스택에 넣는다.
                stack.push(input[i]); 
            else { // A를 만났고, 현재 PPAP 순서라면,
                if (i+1<input.length && stack.size() >= 2 && stack.peek() == 'P' && input[i + 1] == 'P') {
                    stack.pop(); // PPAP에서 PPA는 빼고 마지막 P만 스택에 저장.
                    i++;
                    continue;
                } else {
                    stack.push(input[i]); // A를 만났지만 PPAP 조건이 아니라면 그냥 스택에 저장
                }
            }
            if(i+1>=input.length)
            	break;
        }
        
        // PPAP 문자열인지 판별 후 결과 출력
        if (stack.size() == 1 && stack.peek() == 'P') // 연산 후 스택에 P 하나만 들어있다면
            System.out.println("PPAP"); // PPAP 문자열이다.
        else {
            System.out.println("NP"); // 그렇지 않다면 PPAP 문자열이 아니다.
        }
    }
}