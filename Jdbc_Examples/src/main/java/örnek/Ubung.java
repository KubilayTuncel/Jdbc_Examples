package örnek;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JSpinner.ListEditor;
import javax.swing.text.StyledEditorKit.ForegroundAction;


public class Ubung {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		Department company = new Department("Company");
        Department d12 = new Department("D12");
        Employee mm1 = new Employee("Marshall Mathers");
        Employee mm2 = new Employee("Marshall Mathers");
        Employee mm3 = new Employee("Marshall Mathers");
        Employee mm4 = new Employee("Marshall Mathers");
        int departmanNo=10;
       
        HashMap<Integer, List<Employee>> company1 = new HashMap<>();
       // System.out.println("departman eklemek istiyor musunuz?");
       // String cevap=scan.nextLine();
        System.out.println("kac tane departman eklemek istioyrsunuz?");
        int ekleme=scan.nextInt();
        
			
			
			  for (int j = 10; j < 10+ekleme; j++) {	
				
			List<Employee> liste = new ArrayList<>();
			company1.put(++departmanNo,liste);
			  }
        
        System.out.println(company1);
        for (Map.Entry<Integer, List<Employee>> wMap : company1.entrySet()) {
        	
    		System.out.println(wMap.getKey());
    		}
      System.out.println("Isci eklemek istediginiz departman noyu yaziniz");
      int departman=scan.nextInt();
      System.out.println("Kac isci eklemek istiyorsunuz:");
      int isciSayisi = scan.nextInt();
      
     
      
      
		for (Map.Entry<Integer, List<Employee>> wMap : company1.entrySet()) {
			if (departman==wMap.getKey()) {
				 for (int i = 1; i <= isciSayisi; i++) {
			    	  System.out.println(i+"."+"iscinin ismini giriniz");
			          String name=scan.nextLine();
				
				Employee mm = new Employee(name);
				wMap.getValue().add(mm);
				 }
			}
			
		}
		
		System.out.println("hangi departmanin maas toplamini görmek istiyorsunuz:");
		for (Map.Entry<Integer, List<Employee>> wMap : company1.entrySet()) {
		System.out.println(wMap.getKey());
		}
		
			int departman1=scan.nextInt();
			int toplamSalary=0;
			for (Map.Entry<Integer, List<Employee>> wMap : company1.entrySet()) {
				if (departman1==wMap.getKey()) {
					List<Employee> liste= wMap.getValue();
					
					for (Employee e : liste) {
						toplamSalary+=e.getSalary();
					}
				}
			}
			System.out.println(departman1+"."+" Departman maas toplami : "+toplamSalary);
			
			System.out.println("Maasini ögrenmek istediginiz iscinin ismini giriniz:");
			String name1=scan.nextLine();
			
			boolean flag = true;
	        for (Map.Entry<Integer, List<Employee>> w : company1.entrySet()) {
	            List<Employee> isciBilgisi = w.getValue();
	            for (Employee s : isciBilgisi) {
	                if (s.name.equals(name1)) {
	                    System.out.println(name1+" isimli iscinin maasi : "+s.getSalary());
	                    flag = false;
	                }
	            }
	        }
	        if (flag) {
	            System.out.println("Bu bilgilerle eslesen bir isci bulunamadi.");
	        }
	}
        
        
        

        //d12.add(mm);
        //company.add(d12);


        // Folgende Berechnungen sollen möglich sein:

        // Gesamtgehalt der Firma berechenen
       // int companySalary = company.getSalary("Company");
        // Gehalt der Abteilung D12 berechnen
       // int departmentSalary = d12.getSalary("D12");
        // Gehalt des Mitarbeiters Marschall Mathers berechnen
       // int employeeSalary = mm.getSalary("Marshall Mathers");
        
     // Gesamtgehalt der Firma berechenen
      //  int companySalary1 = company.getSalary();
        // Gehalt der Abteilung D12 berechnen
       // int departmentSalary1 = company.getCompanyItem("D12").getSalary();
        // Gehalt des Mitarbeiters Marschall Mathers berechnen
       // int employeeSalary1 = company.getCompanyItem("D12").
              //  getCompanyItem("Marshall Mathers").getSalary();

       // System.out.println("Sirket ismi "+company.department+" sirket maasi "+companySalary);
       // System.out.println("Departman ismi "+d12.department+" Departman maasi "+departmentSalary);
       // System.out.println("iscinin ismi "+mm.name+" maasi "+employeeSalary);
	}
	
	


