
public class Tienda {

	private String nombre;
	private String direccion;
	

	public Tienda(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	public static Tienda pedirDatos() {
		
		return new Tienda(PedirDatos.pedirNombreTienda(), PedirDatos.pedirDireccion());
	}

}
