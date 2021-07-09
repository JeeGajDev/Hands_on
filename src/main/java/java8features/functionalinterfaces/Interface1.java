package java8features.functionalinterfaces;

@FunctionalInterface
public interface Interface1 {

    final int i = 0;
    static int j=0;
    public int k = 0;
    public final static String str = "Jeevak";
    
	void method1(String str);
	
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
		System.out.println("Printing "+str);
	}
	
	public static void main(String [] args) {
		System.out.println("Main method in interface!!!");
		// \u000d System.out.println("after");
		// \n System.out.println("after");
		String s = "adsa"+1+2+"fsfsdf"+"dssdsd"+2+3+4+ "fdsdfsf";
		System.out.println(s);
		
		System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));
		System.out.println(1000*60*60*24*365L);
		System.out.println(1000*60*60*24*365);
	}
	
	//trying to override Object method gives compile-time error as
	//"A default method cannot override a method from java.lang.Object"
	
//	public String toString(){
//		return "i1";
//	}
	
//	public default boolean equals() {
//		return "sfsdff";
//	}
	
}
;