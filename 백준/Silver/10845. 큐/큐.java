import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		Object[] ary;
		int last = 0;
		
		Queue<Integer> que = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			switch (input[0]) {
			case "push":
				last = Integer.parseInt(input[1]);
				que.offer(last);
				break;
			case "pop":
				if(que.isEmpty()) {
					bw.write(-1+"\n");
					break;
				}
				bw.write(que.poll()+"\n");
				break;
			case "size":
				bw.write(que.size()+"\n");
				break;
			case "empty":
				if(que.isEmpty())
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
				break;
			case "front":
				if(que.isEmpty()) {
					bw.write(-1+"\n");
					break;
				}
				bw.write(que.peek()+"\n");
				break;
			case "back":
				if(que.isEmpty()) {
					bw.write(-1+"\n");
					break;
				}
				bw.write(last+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}
