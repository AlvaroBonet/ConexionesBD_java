import java.util.Scanner;

/*
 * 		MENU:
 * 
 * - 	insertar
 * - 	actualizar
 * - 	eliminar
 * - 	ver toda la tabla
 * 
 * */


public class PedirDatos {

	public static String pedirNombreTienda() {

		String nombreTienda;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el nombre de la tienda");
		nombreTienda = lector.nextLine();
		
		return nombreTienda;
		
	}

	public static String pedirDireccion() {

		String direccion;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el direccion");
		direccion = lector.nextLine();
		
		return direccion;
		
	}
	
	public static String pedirNombre() {

		String nombre;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el nombre de las zapatillas");
		nombre = lector.nextLine();
		
		return nombre;
		
	}

	public static String pedirCodigoProducto() {

		String codigoProducto;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el codigo del producto");
		codigoProducto = lector.nextLine();
		
		return codigoProducto;
		
	}
	
	public static String pedirMarca() {

		String marca;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el marca");
		marca = lector.nextLine();
		
		return marca;
		
	}

	public static int pedirPrecio() {

		int precio;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime el precio");
		precio = lector.nextInt();
		
		return precio;
		
	}
	
	public static String pedirTienda() {

		String tienda;
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Dime a la tienda a la que van");
		tienda = lector.nextLine();
		
		return tienda;
		
	}

}
