import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.print(date.getYear()+"-");
		if(date.getMonthValue()<10)
			System.out.print("0"+date.getMonthValue());
		else
			System.out.print(date.getMonthValue());
		System.out.print("-"+date.getDayOfMonth());
	}
}