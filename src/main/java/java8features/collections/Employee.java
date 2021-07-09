package java8features.collections;

public class Employee {
//add a comment. Testing to see 
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	 public Employee(
//			 Integer id, Integer age, String gender, 
			 String fName, String mName, String lName){
//	       this.id = id;
//	       this.age = age;
//	       this.gender = gender;
	       this.firstName = fName;
	       this.middleName = mName;
	       this.lastName = lName;
	   } 
	     
//	   private Integer id;
//	   private Integer age;
//	   private String gender;
	   private String firstName;
	   public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private String middleName;
	   private String lastName;
	   
	   @Override
	    public String toString() {
	        return firstName + " " + middleName + " " + lastName; 
	    }
}
