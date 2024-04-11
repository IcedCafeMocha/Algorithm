import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MIN = Integer.MAX_VALUE;
		int MAX = Integer.MIN_VALUE;
		String[] input;
		int N = Integer.parseInt(br.readLine());
		int temp;
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(input[i]);
			if (temp < MIN)
				MIN = temp;
			if (temp > MAX)
				MAX = temp;
		}
		System.out.println(MIN + " " + MAX);
	}
}
