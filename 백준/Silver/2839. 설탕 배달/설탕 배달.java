import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=N/5; i>=0; i--) {
			if((N-(5*i))%3==0) {
				cnt = i + ((N-(5*i))/3);
				break;
			}
		}
		if(cnt == 0)
			bw.write(-1+"\n");
		else
			bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
}
