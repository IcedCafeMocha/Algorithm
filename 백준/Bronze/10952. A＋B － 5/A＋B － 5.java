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
		while(true) {
			input = br.readLine().split(" ");
			if(input[0].equals("0")&&input[1].equals("0"))
				break;
			bw.write(Integer.parseInt(input[0])+Integer.parseInt(input[1])+"\n");			
		}
		bw.flush();
		bw.close();
	}
}
