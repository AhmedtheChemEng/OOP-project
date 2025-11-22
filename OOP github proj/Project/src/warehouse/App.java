package warehouse;
import java.time.*;
import java.util.*;

public class App {
	public LocalDate TODAY= LocalDate.of(2025,10,24);
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	StaffMenu.run(sc, null);
}
}

