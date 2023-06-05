
public class Zapatillas {

	private String nombre;
	private String codigoProducto;
	private int precio;
	private String marca;
	private String tienda;

	
	public Zapatillas(String nombre, String codigoProducto, int precio, String marca, String tienda) {
		super();
		this.nombre = nombre;
		this.codigoProducto = codigoProducto;
		this.precio = precio;
		this.marca = marca;
		this.tienda = tienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	@Override
	public String toString() {
		return "Zapatillas [nombre=" + nombre + ", codigoProducto=" + codigoProducto + ", precio=" + precio + ", marca="
				+ marca + ", tienda=" + tienda + "]";
	}

	public static Zapatillas pedirDatos() {

		return new Zapatillas(PedirDatos.pedirNombre(), PedirDatos.pedirCodigoProducto(), PedirDatos.pedirPrecio(),
				PedirDatos.pedirMarca(), PedirDatos.pedirTienda());
	}

}
