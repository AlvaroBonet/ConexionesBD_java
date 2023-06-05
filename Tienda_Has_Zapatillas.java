
public class Tienda_Has_Zapatillas {

	private int idTienda_Has_Zapatillas;
	private String Tienda_idTienda;
	private String Zapatillas_idZapatillas;
	

	public Tienda_Has_Zapatillas(int idTienda_Has_Zapatillas, String tienda_idTienda, String zapatillas_idZapatillas) {
		super();
		this.idTienda_Has_Zapatillas = idTienda_Has_Zapatillas;
		Tienda_idTienda = tienda_idTienda;
		Zapatillas_idZapatillas = zapatillas_idZapatillas;
	}

	public int getIdTienda_Has_Zapatillas() {
		return idTienda_Has_Zapatillas;
	}

	public void setIdTienda_Has_Zapatillas(int idTienda_Has_Zapatillas) {
		this.idTienda_Has_Zapatillas = idTienda_Has_Zapatillas;
	}

	public String getTienda_idTienda() {
		return Tienda_idTienda;
	}

	public void setTienda_idTienda(String tienda_idTienda) {
		Tienda_idTienda = tienda_idTienda;
	}

	public String getZapatillas_idZapatillas() {
		return Zapatillas_idZapatillas;
	}

	public void setZapatillas_idZapatillas(String zapatillas_idZapatillas) {
		Zapatillas_idZapatillas = zapatillas_idZapatillas;
	}

	@Override
	public String toString() {
		return "Tienda_Has_Zapatillas [idTienda_Has_Zapatillas=" + idTienda_Has_Zapatillas + ", Tienda_idTienda="
				+ Tienda_idTienda + ", Zapatillas_idZapatillas=" + Zapatillas_idZapatillas + "]";
	}

}
