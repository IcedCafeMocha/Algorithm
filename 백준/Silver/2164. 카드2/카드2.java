import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		int temp;
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++)
			que.offer(i);
		while(que.size()!=1) {
			que.poll();
			temp = que.poll();
			que.offer(temp);
		}
		System.out.println(que.poll());
	}
}
