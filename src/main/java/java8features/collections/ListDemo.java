package java8features.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public ListDemo() {
		// TODO Auto-generated constructor stub
		System.out.println("In no arg constructor");
	}

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("Jeevak");
		list1.add("Vishnu");
		list1.add("Gajbhiye");

		List<String> list2 = new ArrayList<String>();
		list2.add("Jeevak");
		list2.add("Vishnu");
		list2.add("Gajbhiye");

		System.out.println("list hash code " + list1.hashCode());

//		Collections.sort(list1);
//		System.out.println(list1);
//		list1.sort(Comparator.reverseOrder());
//		Collections.sort(list);
		// TODO Auto-generated method stub
//		for(int i=0;i<list.size();i++)
//		System.out.println(list.get(i));
		for (Object obj : list1)
			System.out.println(obj);

		System.out.println(list1.equals(list2));

		Iterator<String> it = list1.iterator();
		while (it.hasNext())
			System.out.println(": " + it.next());

		Employee e1 = new Employee("Jeevak", "Gajbhiye", "Vishnu");
		Employee e2 = new Employee("Jeevak", "Gajbhiye", "Vishnu");
		Employee e3 = new Employee("Gajbhiye", "Jeevak", "Vishnu");
		Employee e4 = new Employee("Vishnu", "Jeevak", "Gajbhiye");

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);employees.add(e2);employees.add(e3);employees.add(e4);
//		employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4 }));
		System.out.println(
	EmployeePredicates.filterEmployees(employees, EmployeePredicates.isFirstNameJeevak())
);
		System.out.println(
				EmployeePredicates.filterEmployees(employees, EmployeePredicates.isMiddleNameVishnu())
			);
		
		System.out.println(
				EmployeePredicates.filterEmployees(employees, EmployeePredicates.isLastNameGajbhiye())
			);
	}

}
