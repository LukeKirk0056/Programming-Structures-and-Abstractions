import java.lang.Object;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOne {

	public DateTimeOne() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void dateTimeNow()	{
	LocalDateTime dateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	System.out.println(dateTime.format(formatter));
 
}
	// generate date using LocalDateTime
	public dateTimeOne()	{
		
	//SimpleDateFormat to split seconds,minutes hours
	}
	
	public void valueOfSecondNow()	{
		int vlaueOfSecondNow = dateTimeNow.getValueOfSecond();
	}
}

