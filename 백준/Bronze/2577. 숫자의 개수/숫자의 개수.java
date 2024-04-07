import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int num = A*B*C;
		
		String str = String.valueOf(num);
		
		String[] temp = str.split("");
		int[] count = new int[10];
		
		for(int i=0; i<temp.length; i++)
			count[Integer.parseInt(temp[i])]++;
		
		for(int i=0; i<10; i++)
			System.out.println(count[i]);
	}
}
