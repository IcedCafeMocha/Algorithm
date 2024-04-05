import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		int cnt = 0;
		for(int i=0; i<input.length; i++)
			if(input[i].equals(""))
				cnt++;
		System.out.println(input.length-cnt);
	}
}