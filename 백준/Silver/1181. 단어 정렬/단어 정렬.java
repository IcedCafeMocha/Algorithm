import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String str;
		
		Set<String>[] setarray = new Set[51];
		for(int i=1; i<51; i++)
			setarray[i] = new TreeSet<>();
		
		for(int i=0; i<N; i++) {
			str = br.readLine();
			setarray[str.length()].add(str);
		}
		for(int i=1; i<51; i++) {
			if(!setarray[i].isEmpty()) {
				Iterator<String> it = setarray[i].iterator();
				while(it.hasNext())
					bw.write(it.next()+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}