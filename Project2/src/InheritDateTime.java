import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class InheritDateTime extends AbstractDateTime {

	/**
	 * This method gets the month and year inputted and then prints out the days of
	 * the week that month will start and end on
	 */
	public void daysOfAnyMonth(int monthOfYear, int theYear) {
		// TODO Auto-generated method stub

		YearMonth date = YearMonth.of(theYear, monthOfYear);
		LocalDate dayOfWeek = date.atDay(1);
		LocalDate lastDateOfMonth = date.atEndOfMonth();
		DayOfWeek dayOne = dayOfWeek.getDayOfWeek();
		DayOfWeek lastDay = lastDateOfMonth.getDayOfWeek();

		System.out.println("In the year " + theYear + ", for the " + monthOfYear + "th month: the first day is "
				+ dayOne + " and the last day is " + lastDay);
	}
}
