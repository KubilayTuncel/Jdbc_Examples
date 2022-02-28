package tecproeducation.Jdbc_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.internal.ACProxyable;

public class Jdbc4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

		
		Statement st=con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from bolumler");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " "+ rs.getString(2)+ " " + rs.getString(3));
		}
		/*ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') 
		ekleyelim ve eklenen kaydi teyit icin sorgulayalim.*/
		
		st.execute("insert into bolumler values(80, 'ARGE', 'ISTANBUL')");
		
		//ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
		
		  // 1.YONTEM
		// -----------------------------------------------
		// Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin 
		// yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
		  // bu kotu bir yaklasimdir.
		String [] sorgular = {"INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
                "INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')",
                "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')"};
		for (int i = 0; i < sorgular.length; i++) { // ya da foreach ile yapilabilir ama int yerine String yazilmali
			
			st.execute(sorgular[i]);
			
		}
		// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
		// ----------------------------------------------------
		// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
		// metodu ile veritabanina bir kere gonderilebilir.
		// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda 
		// etkilenen satir sayisini gosterir. 
		String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
                "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
                "INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
		for (String w : sorgular1) {
			st.addBatch(w);
		}st.executeBatch();
		con.close();
		rs.close();
		st.close();
		
		
	}

}
