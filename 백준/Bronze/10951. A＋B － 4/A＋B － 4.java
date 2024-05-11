import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		String[] input;
		while(true) {
			str = br.readLine();
			if(str == null || str.isBlank() || str.isEmpty())
				break;
			input = str.split(" ");
			System.out.println(Integer.parseInt(input[0])+Integer.parseInt(input[1]));
		}
	}
}
