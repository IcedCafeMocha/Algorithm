import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] count = new int[60];
		int num;
		
		for(int i=0; i<str.length(); i++) {
			num = (int)(str.charAt(i)-65);
			if(!Character.isUpperCase(str.charAt(i)))
				num-=32;
			count[num]++;
		}
		
		int[] temp = new int[count.length];
		System.arraycopy(count, 0, temp, 0, count.length);
		Arrays.sort(temp);
		if(temp[temp.length-1]==temp[temp.length-2])
			System.out.println("?");
		else {
			for(int i=0; i<count.length; i++) {
				if(count[i]==temp[temp.length-1]) {
					System.out.println((char)(i+65));
				}
			}
		}
	}
}
