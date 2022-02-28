package tecproeducation.Jdbc_Examples;

public class Urun {

	//POJO class (encapsulation class i demek)
	
	private int id;
	private String isim;
	private double fiyat;
	public Urun(int id, String isim, double fiyat) {
		super();
		this.id = id;
		this.isim = isim;
		this.fiyat = fiyat;
	}
	public int getId() {
		return id;
	}
	public String getIsim() {
		return isim;
	}
	public double getFiyat() {
		return fiyat;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}
	@Override
	public String toString() {
		return "Urun [id=" + id + ", isim=" + isim + ", fiyat=" + fiyat + "]";
	}
	
	
}
