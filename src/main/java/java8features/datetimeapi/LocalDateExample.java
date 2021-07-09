package java8features.datetimeapi;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {

	/*
	 * Before we start looking at the Java 8 Date Time API, let’s see why do we need
	 * a new API for this. There have been several problems with the existing date
	 * and time related classes in java, some of them are:
	 * 
	 * Java Date Time classes are not defined consistently, we have Date Class in
	 * both java.util as well as java.sql packages. Again formatting and parsing
	 * classes are defined in java.text package.
	 * 
	 * java.util.Date contains both date and time, whereas java.sql.Date contains
	 * only date. Having this in java.sql package doesn’t make sense. Also both the
	 * classes have same name, that is a very bad design itself.
	 * 
	 * There are no clearly defined classes for time, timestamp, formatting and
	 * parsing. We have java.text.DateFormat abstract class for parsing and
	 * formatting need. Usually SimpleDateFormat class is used for parsing and
	 * formatting.
	 * 
	 * All the Date classes are mutable, so they are not thread safe. It’s one of
	 * the biggest problem with Java Date and Calendar classes.
	 * 
	 * Date class doesn’t provide internationalization, there is no timezone
	 * support. So java.util.Calendar and java.util.TimeZone classes were
	 * introduced, but they also have all the problems listed above.
	 */
	public LocalDateExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// Current Date
		LocalDate today = LocalDate.now();
		System.out.println("Current Date=" + today);

		// Creating LocalDate by providing input arguments
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("Specific Date=" + firstDay_2014);

		// Try creating date by providing invalid inputs
		// LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
		// Exception in thread "main" java.time.DateTimeException:
		// Invalid date 'February 29' as '2014' is not a leap year

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST=" + todayKolkata);

		// java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		// LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

		// Getting date from the base date i.e 01/01/1970
		LocalDate dateFromBase = LocalDate.ofEpochDay(365);
		System.out.println("365th day from base date= " + dateFromBase);

		LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
		System.out.println("100th day of 2014=" + hundredDay2014);
	}

}
