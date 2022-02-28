package örnek;

import java.util.ArrayList;
import java.util.List;

public class Department {
	 String department;
	    String companyItem;
	    int salary;

	    public String getCompanyItem(String companyItem) {
	    	this.companyItem=companyItem;
	        return companyItem;
	    }

	    public int getSalary(String companyItem) {
	    	
	    	if (companyItem=="D12") {
				salary=3000;
			}else if (companyItem=="Company") {
				salary=4000;
			}else {
				salary=0;
			}
	    	
	        return salary;
	    }
	    



	    public Department (String department) {
	        this.department=department;

	    }
	    public Department (){}

}
