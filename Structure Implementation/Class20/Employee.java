
public class Employee extends Person {
	private String company;
	public Employee(String name, String company) {
		this.name = name;
		this.company = company;
	}
	public void setCompany(String company) {
		this.company= company;
	}
	public String getCompany() {
		return company;
	}
	@Override 
	public void setName(String name) {
		this.name = name;
	}
	
}
