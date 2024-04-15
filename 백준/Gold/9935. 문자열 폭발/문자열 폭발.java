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
		String str;
		String bomb;
		char[] str_ary;
		char[] bomb_ary;

		str = br.readLine();
		bomb = br.readLine();
		str_ary = str.toCharArray();
		bomb_ary = bomb.toCharArray();
		Stack<Character> stack = new Stack<>();

		int cnt = 0;
		for (int i = 0; i < str_ary.length; i++) {
			stack.push(str_ary[i]);
			if (stack.size() >= bomb.length()) {
				for (int k = 0; k < bomb.length(); k++) {
					if (stack.get(stack.size() - bomb.length() + k) == bomb_ary[cnt]) {
						cnt++;
					} else {
						cnt = 0;
						break;
					}
				}
				if (cnt == bomb.length()) {
					for (int k = 0; k < bomb.length(); k++) {
						stack.pop();
					}
					cnt = 0;
				}
			}
		}

		if (stack.isEmpty())
			bw.write("FRULA");
		else
			for (int i = 0; i < stack.size(); i++)
				bw.write(stack.get(i));
		bw.flush();
		bw.close();
	}
}