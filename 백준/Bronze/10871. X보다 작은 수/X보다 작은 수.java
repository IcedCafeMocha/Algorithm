import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;
		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int X = Integer.parseInt(input[1]);
		int num;
		
		input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			num = Integer.parseInt(input[i]);
			if(num<X) {
				bw.write(num+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}
