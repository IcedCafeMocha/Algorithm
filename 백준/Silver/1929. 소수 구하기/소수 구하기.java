import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		boolean[] sosu = new boolean[N+1];
		sosu[1] = true;
		
		for(int i=2; i<=N; i++) {
			for(int j=2; i*j<=N; j++) {
				sosu[i*j] = true;
			}
		}

		for(int i=M; i<=N; i++) {
			if(!sosu[i])
				bw.write(i+"\n");			
		}
		bw.flush();
		bw.close();
	}
}
