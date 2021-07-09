package java8features.functionalinterfaces;

public class MyClass implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
		
	}
	
	public static void main(String [] args) {
		Interface1.print("teststeteeet");
		Interface1 i1 = (s) -> System.out.println(s);
		i1.method1("jee");
		
	}
}
