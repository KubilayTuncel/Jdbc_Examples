package tecproeducation.Jdbc_Examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				
				Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "hr", "hr");

				
				Statement st=con.createStatement();
				/* ornek1: bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz*/
				
				ResultSet tablo1= st.executeQuery("select * from bolumler");
				while (tablo1.next()) {
				System.out.println(tablo1.getInt(1)+ "\t"+tablo1.getString(2)+ "\t"+tablo1.getString(3));
				}

				System.out.println("================================");
				//ornek2: satis ve muhasebe bolumlerinde calisan personelin isimlerini ve maaslarinim maas ters sirali olarak listeleyiniz
				String a="select personel_isim, maas * from bolumler "
						+ " where bolum_id in(10,30) "
								+ " ordey by maas desc";
				ResultSet tablo2= st.executeQuery(a);
				
				while (tablo2.next()) {
					System.out.println(tablo2.getString(1)+ " \t"+tablo2.getString(2));
				}
				/*RNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini ve
		         * maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa bile
		         * bolum ismi gosterilmelidir.*/
				String b="select personel_isim, bolum_isim, maas * from bolumler "
						+ " left join personel"
						+ " on bolumler.bolum_id=personel-bolum_id "
								+ " ordey by maas, bolum_isim";
				ResultSet tablo3= st.executeQuery(a);
				
				while (tablo3.next()) {
					System.out.println(tablo3.getString(1)+ "      \t"+tablo3.getString(2)+ "      \t"+tablo3.getString(3));
				}
				
				//  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
				String c="select personel_isim, bolum_isim, maas * from personel "
						+ " full join bolumler"
						+ " on bolumler.bolum_id=personel-bolum_id "
								+ " ordey by maas desc fetch next 10 rows only";
				ResultSet tablo4= st.executeQuery(a);
				
				while (tablo4.next()) {
					System.out.println(tablo4.getString(1)+ "      \t"+tablo4.getString(2)+ "      \t"+tablo4.getString(3));
				}
				con.close();
				st.close();
				tablo1.close();
				tablo2.close();
				tablo3.close();
				tablo4.close();
	}

}
