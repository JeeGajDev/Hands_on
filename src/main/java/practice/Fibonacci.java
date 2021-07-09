package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {
	static int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String args[]) {
		
		 if (args.length > 0) {
	            System.out.println(
	                "The command line arguments are:");
	 
	            // iterating the args array and printing
	            // the command line arguments
	            for (String val : args)
	                System.out.println(val);
		 }
		 // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
 
        // Reading data using readLine
        String name=null;
		try {
			name = reader.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
        // Printing the read line
        System.out.println(name);
        System.out.println();
        Scanner in = new Scanner(System.in);
        
        String s = in.nextLine();
        System.out.println("You entered string " + s);
		
		HashMap hm = new HashMap();
		hm.put("Suyog" , "yes");
		hm.put("Suyog" , "yes1");
		hm.put("SuyoG" , "yes2");
//		hm.put(new MyStringKeyWrapper("Suyog" , "yes"),"1");
//		hm.put(new MyStringKeyWrapper("Suyog" , "yes"),"11");
//		hm.put(new MyStringKeyWrapper("Suyog" , "yes"),"111");
		System.out.println(hm.size());
		// Initialize ConcurrentHashMap instance
		ConcurrentHashMap<String, Integer> m = new ConcurrentHashMap<String, Integer>();

		// Print all values stored in ConcurrentHashMap instance
		for (Entry<String, Integer> e : m.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
		int n = 3;
		System.out.println(fib(n));
	}

}

class MyStringKeyWrapper {
	private String key;
	private String value;

	MyStringKeyWrapper(String key, String value) {
		this.key = key.toLowerCase();
		this.value = value.toLowerCase();
	}
}