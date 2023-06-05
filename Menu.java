import java.util.Scanner;

/*
 * Mi T1 son tienda y mi T2 son zapatillas
 * 
 * Tiene que tener:
 * 
 *1.- Insertar T1 
 * 
 *2.- Insertar T2 vinculando T1
 * 
 *3.- Borrar T2
 *    Borrar T1 si se borra T1 se borra T2
 * 
 *4.- Modificar T1 y T2 menos ID, nunca se modifica
 * 
 *5.- Se puede asociar T2 a un nuevo T1
 * 
 * Consultas:
 * 
 * 6.- Ingrediente? Recetas
 * 
 * 7.- Receta? Ingredientes
 * 
 * 8.- Cuantas recetas
 * 
 * 9.- Ingrediente mas usado
 * 
 * 10.- Recetas sin ingredientes
 * 
 * */
public class Menu {
	
	public static void tabla() throws ClassNotFoundException {
		
		Scanner lector = new Scanner(System.in);
		int opcion;
		int numero;
		
		System.out.println(); 
		System.out.println(" --------------------------------");
		System.out.println("|               MENU             |");
		System.out.println(" --------------------------------");
		System.out.println("|    1.- Insertar Tienda         |");
		System.out.println("|    2.- Insertar Zapatillas     |");
		System.out.println("|    3.- Borrar Zapatillas       |");
		System.out.println("|    4.- Borrar Tienda           |");
		System.out.println("|    5.- Modificar Tienda        |");
		System.out.println("|    6.- Modificar Zapatillas    |");
		System.out.println("|    7.- Buscar por Zapatillas   |");
		System.out.println("|    8.- Buscar por Tienda       |");
		System.out.println("|    9.- Cuantas Tiendas Hay     |");
		System.out.println("|   10.- Zapatillas sin Tienda   |");
		System.out.println(" --------------------------------");
		System.out.println(" -----Presiona '0' para salir---- "); 
		opcion = lector.nextInt();
		
		switch(opcion) {
			case 0:
				
			break;
			case 1:
				BaseDatos.subirTienda();
				tabla();
			break;
			case 2:
				BaseDatos.subirZapatillas();
				tabla();
			break;
			case 3:
				BaseDatos.deleteZapatillas();
				tabla();
			break;
			case 4:
				BaseDatos.deleteTienda();
				tabla();
			break;
			case 5:
				BaseDatos.updateTienda();
				tabla();
			break;
			case 6:
				BaseDatos.updateZapatillas();
				tabla();
			break;
			case 7:
				BaseDatos.filtrarZapatillas();
				tabla();
			break;
			case 8:
				BaseDatos.mostrarIdNombreTienda();
				
				System.out.println("¿Que tienda quieres ver?");
				numero = lector.nextInt();
				
				BaseDatos.buscarTienda(numero);
				BaseDatos.buscarZapatillas(numero);
				
				tabla();
			break;
			case 9:
				BaseDatos.mostrarCuantasTiendas();
				tabla();
			break;
			case 10:
				BaseDatos.mostrarZapasSinTienda();
				tabla();
			break;
		}

	}
	
}
