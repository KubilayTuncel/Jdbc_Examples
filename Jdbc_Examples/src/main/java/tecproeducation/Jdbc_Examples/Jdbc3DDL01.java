package tecproeducation.Jdbc_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc3DDL01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*her sorguda öncekileri yoruma al hata vermesin
		   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
		      dondurmeyen metotlar kullanilmalidir.(executeQuery kullanamayız) Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
		       1) execute() metodu 
		       2) excuteUpdate() metodu.  
		       
		   B) - execute() metodu hertur SQL ifadesiyle kullanilabilen genel bir komuttur.
		      - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, 
		        DML islemlerinde true deger dondurur. 
		      - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
		        durumlarda tercih edilmektedir.  
		        
		   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
		      - bu islemlerde islemden etkilenen satir sayisini dondurur.
		      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
		*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
				
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");
		
		Statement st=con.createStatement();
		
		/*ORNEK1:isciler adinda bir tablo olusturunuz id NUMBER(3), 
		birim VARCHAR2(10), maas NUMBER(5)*/
		
		String a= "Create table isciler"
				+ " (id number (3),"
				+ " birim varchar(10),"
				+ " maas number(5))";
		st.execute(a);
		System.out.println("isciler tablosu olusturuldu.");
		
		//isciler tablosunu kalici olarak siliniz
		st.executeUpdate("drop table isciler purge");
		System.out.println("isciler tablosu silindi.");
		
		//ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar2(20)} ekleyiniz. 
		st.executeUpdate("alter table isciler add isim varchar(20)");
		System.out.println("isim sutunu eklendi");
		
		//ornek 4: isciler tablosundaki maas sutununu siliniz
		st.execute("alter tablo isciler drop column maas");
		System.out.println("maas sutunu silindi.");
		
		//ornek 5: isim sutunun ismini degistiriniz
		st.execute("alter table isciler rename column isim to adlar");
		st.execute("alter table isciler rename to calisanlar");
		
		
	}
}
