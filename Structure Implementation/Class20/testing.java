
public class testing {

	public static void main(String[] args) {
		Person e = new Employee("John", "Google");
		//compile error.  because e is an instance of Peroson.
		//e.setCompany("Company");  
		e.setName("Simith");
		System.out.println(e.getName());
	}

}
