import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		String[] input;
		loop: while(true) {
			str = br.readLine();
			input = str.split("");
			if(str.equals("0"))
				break;
			for(int i=0; i<str.length()/2; i++){
				if(!input[i].equals(input[str.length()-1-i])) {
					System.out.println("no");
					continue loop;
				}
			}
			System.out.println("yes");
		}
	}
}
