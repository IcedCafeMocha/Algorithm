import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N];
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++)
			ary[i] = Integer.parseInt(input[i]);
		Arrays.sort(ary);
		int M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for(int i=0; i<M; i++) {
			if(Arrays.binarySearch(ary, Integer.parseInt(input[i]))>=0)
				bw.write(1+"\n");
			else
				bw.write(0+"\n");
		}
		bw.flush();
		bw.close();
	}
}
