import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 학생의 수 N
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int[] num = new int[N];
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(input[i]);
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		stack.push(1);
		int n;

		for (int i = 1; i < N; i++) {
			if (num[i] == 0)
				stack.push(i + 1);
			else {
				temp.clear();
				for (int k = 0; k < num[i]; k++)
					temp.push(stack.pop());
				stack.push(i + 1);
				for (int k = 0; k < num[i]; k++)
					stack.push(temp.pop());
			}
		}
		Object[] result;
		result = stack.toArray();
		for (int i = 0; i < N; i++)
			System.out.print(result[i] + " ");
	}
}
