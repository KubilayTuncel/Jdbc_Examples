package örnek;

public class Employee extends Department{
	 String name;
	 int salary;

	    public int getSalary() {
	    	salary=2000;
		return salary;
	}


		public String getCompanyItem(String companyItem) {
	        return companyItem;
	    }

	    public Employee(String name) {
	        this.name=name;
	    }
	    public Employee(){}
}
