package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
public class StringSort {

	public StringSort() {
		// TODO Auto-generated constructor stub
	}

	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		
		
		// return new sorted string
		return new String(tempArray);
		
		
		 
		
	}

	public static void main(String[] args) {
		
		String input1 = "jeevak";
		 
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = input1.getBytes();
 
        byte[] result = new byte[strAsByteArray.length];
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
 
        System.out.println(new String(result));
        
        
		justLikeTaht();
		
		Map<String, String> langMap = new HashMap<String, String>();

	    langMap.put("ENG", "English");
	    langMap.put("NLD", "Dutch");
	    langMap.put("ZHO", "Chinese");
	    langMap.put("BEN", "Bengali");
	    langMap.put("ZUL", "Zulu");
	    langMap.put("FRE", "French");
	    
	    //Getting Map.Entry elements using entrySet()
	    Set<Map.Entry<String, String>> langSet = langMap.entrySet();
	    // Looping the set of Map.Entry values
	    for(Map.Entry<String, String> entry : langSet){
	        System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());    
	    }
	    
	    
		char arr[] = new String("jeevak").toCharArray();
		System.out.println("arr-->"+ arr.toString());
		Arrays.sort(arr);
		System.out.println("after sorting-->" + new String(arr));
		String inputString = "geeksforgeeks";
		String outputString = sortString(inputString);

		System.out.println("Input String : " + inputString);
		System.out.println("Output String : " + outputString);
		for(int i=5;i<10000000;i++)
		perfectNumbers(i);
		
		
		
	}

	static void justLikeTaht()
	{
		Hashtable ht=new Hashtable();
	      ht.put(101,"John");
	      ht.put(102,"Jhony");
	      ht.put(102,"Smith");
	      ht.put(103,"Andy");
	      System.out.println("-------------Hash table--------------");
	      Set<Integer> keySet = ht.keySet();
	      for (Integer key:keySet) {
	          System.out.println(key + " "+ht.get(key));
	       }
	      
	      
	      HashMap hm=new HashMap();
	      hm.put(100,"John");
	      hm.put(104,"John"); // hash map allows duplicate values
	      hm.put(101,"Smith");
	      hm.put(102,"Andy");
	      System.out.println("-----------Hash map-----------");
	      Set<Integer> keySet1 = hm.keySet();
	      for (Integer key:keySet1) {
	         System.out.println(key + " "+hm.get(key));
	      }
	}
	public static String sortString_1(String input) {
		
		
		try
        {
            System.out.println ("::Try Block::");
            int data = 125 / 5;
            System.out.println ("Result:" + data);
        } 
        //catch block
        catch (NullPointerException e) {
            System.out.println ("::Catch Block::");
            System.out.println (e);
        } 
        //finally block
        finally {
            System.out.println (":: Finally Block::");
            System.out.println ("No Exception::finally block executed");
        } 
		
		//1 +7 + 4 + 14 +2 
//		convert input string to char array
		Character arr[] = new Character[input.length()];
		
		for (int i=0; i<input.length();i++)
			arr[i] = input.charAt(i);
		
		// Sort, ignoring case during sorting
		Arrays.sort(arr, new Comparator<Character>() {
			
			@Override
			public int compare(Character c1, Character c2) {
				return Character.compare(c1, c2);
			}
		});
		
		// using StringBuilder to convert Character array to String
		StringBuilder sb = new StringBuilder(arr.length);
		for(Character c: arr)
			sb.append(c.charValue());
		
		
		return sb.toString();
	}
	
	public static void perfectNumbers(int n) {
//		System.out.println("--" + 6%1 + " -- "+ 6%2 + "--" + 6%3 + " -- "+ 6%4 + "--" + 6%5 + " -- "+ 6%6);
		int addNumbers = 0;
		
		
		for (int i=1;i<n;i++) {
			if(n%i == 0) {
				addNumbers = addNumbers + i;
			}
		}
		if (addNumbers==n) {
			System.out.println("Bingo !!  " + n + " is the perfect number");
		}
		
		
	}
}
