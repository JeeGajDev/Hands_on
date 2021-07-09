package java8features.functionalinterfaces;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class Shape {
	
}
class dada{}
class sfsfs{}
public class MyDataImpl implements MyData {
//
	
	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public static void main(String args[]){
		MyDataImpl obj = new MyDataImpl();
		obj.print("");
		obj.isNull("abc");
		
		//If you look at the below code, the actual part that is of use is the code inside run() method. 
		//Rest all of the code is because of the way java programs are structured
		Runnable r = new Runnable(){
		@Override
		public void run() {
			System.out.println("My Runnable");
		}};
		r.run();
		
		//Java 8 Functional Interfaces and Lambda Expressions help us in writing smaller 
		//and cleaner code by removing a lot of boiler-plate code.
		Runnable r1 = () -> {
			System.out.println("My Runnable");

		};
		r1.run();
		
	}
	
	//Traditional approach
			private static boolean isPrime_Traditional(int number) {		
				if(number < 2) return false;
				for(int i=2; i<number; i++){
					if(number % i == 0) return false;
				}
				return true;
			}
			

			//Declarative approach
			private static boolean isPrime_Declarative(int number) {		
				return number > 1
						&& IntStream.range(2, number).noneMatch(
								index -> number % index == 0);
			}
			
			

private static boolean isPrime_(int number) {
	IntPredicate isDivisible = index -> number % index == 0;
	
	return number > 1
			&& IntStream.range(2, number).noneMatch(
					isDivisible);
}

		
}
