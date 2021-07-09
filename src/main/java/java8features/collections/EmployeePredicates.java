package java8features.collections;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

	public EmployeePredicates() {
		// TODO Auto-generated constructor stub
	}

	public static Predicate<Employee> isFirstNameJeevak() {
		return p -> p.getFirstName().equalsIgnoreCase("Jeevak");
	}

	public static Predicate<Employee> isMiddleNameVishnu() {
		return p -> p.getMiddleName().equalsIgnoreCase("Vishnu");
	}

	public static Predicate<Employee> isLastNameGajbhiye() {
		return p -> p.getLastName().equalsIgnoreCase("Gajbhiye");
	}

	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}

}
