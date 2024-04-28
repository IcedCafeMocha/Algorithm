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
		Queue<String>[] arr = new Queue[201];
		for(int i=0; i<201; i++)
			arr[i] = new LinkedList<String>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			arr[Integer.parseInt(input[0])].offer(input[1]);
		}
		
		for(int i=1; i<201; i++) {
			if(arr[i].isEmpty()) continue;
			while(!arr[i].isEmpty())
				bw.write(i+" "+arr[i].poll()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
