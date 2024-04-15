import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<String> L = new LinkedList<>();
		Queue<String>[] parrots = new Queue[N];
		for (int i = 0; i < N; i++)
			parrots[i] = new LinkedList<>();
		String[] input;
		boolean flag;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			Queue<String> parrot = new LinkedList<>();
			input = br.readLine().split(" ");
			for (int k = 0; k < input.length; k++) {
				parrot.offer(input[k]);
				cnt++;
			}
			parrots[i] = parrot;
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++)
			L.offer(input[i]);

		while (!L.isEmpty()) {
			flag = false;
			for (int i = 0; i < N; i++) {
				if (parrots[i].isEmpty())
					continue;
				if (L.peek() != null && L.peek().equals(parrots[i].peek())) {
					L.poll();
					parrots[i].poll();
					cnt--;
					flag = true;
				}
			}
			if (flag) {
				continue;
			} else {
				break;
			}
		}
		if (cnt == 0 && L.isEmpty()) {
			System.out.println("Possible");
		} else {
			System.out.println("Impossible");
		}
	}
}