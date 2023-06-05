import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BaseDatos {

	public static String subirTienda() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado = 0;
		String sql = "" ;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																									// la
																									// dirección, el
																									// administrador
																									// y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)

			sql = "INSERT INTO `tienda` (`nombre`, `direccion`) VALUES ('" + PedirDatos.pedirNombreTienda() + "', '" + PedirDatos.pedirDireccion() + "')";

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println();
				System.out.println("Se ha insertado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mostrarIdNombreTienda();

		//System.out.println("Conectado/desconectado");
		return sql;
	}

	public static String subirZapatillas() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado = 0;
		String sql = "" ;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																									// la
																									// dirección, el
																									// administrador
																									// y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)

			sql = "INSERT INTO `zapatillas` (`nombre`, `codigoProducto`, `marca`, `precio`, `tienda`) VALUES ('" + PedirDatos.pedirNombre() + "', '" + PedirDatos.pedirCodigoProducto() + "', '" + PedirDatos.pedirMarca() + "', '" + PedirDatos.pedirPrecio() + "', '" + PedirDatos.pedirTienda() + "')";

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Se ha insertado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mostrarIdNombreZapatillas();

		//System.out.println("Conectado/desconectado");
		return sql;
	}
	
	public static void mostrarIdNombreTienda() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre;
		int id;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM tienda");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			System.out.println("TIENDAS");
			System.out.println("----------------------------");
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				
				id = rs.getInt("idTienda");
				
				nombre = rs.getString("nombre");
				
				System.out.println(id + " |  " + nombre + "\n");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}
	
	public static void mostrarIdNombreZapatillas() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre;
		int id;
		int precio;
		int tienda;
		String codigoProducto;
		String marca;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM zapatillas");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			System.out.println("ZAPATILLAS");
			System.out.println("----------------------------------------");
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				
				id = rs.getInt("idZapatillas");
				
				nombre = rs.getString("nombre");
				
				codigoProducto = rs.getString("codigoProducto");
				
				marca = rs.getString("marca");
				
				precio = rs.getInt("precio");
				
				tienda = rs.getInt("tienda");
				
				System.out.println(id + " |  " + nombre + " | " + precio + "€ | Tienda: " + tienda + "\n");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}
	
	/*public static void elegir() throws ClassNotFoundException {
		
		int opcion = 0;
		int opcion2 = 0;
		mostrarIdNombreTienda();
		Scanner lector = new Scanner(System.in);
		
		System.out.println(" - Dime una pelicula que quieras tocar \n - Presiona `0` para filtrar por decada \n Presiona un numero fuera de la lista para salir.");
		opcion = lector.nextInt();
		
		switch(opcion) { 
			case 1:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 2:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 3:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 4:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 5:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 6:
				System.out.println("Que quieres hacer sobre esta pelicula 1. Actualizar o 2. eliminar");
				opcion2 = lector.nextInt();
				switch(opcion2){
				case 1:
					update(opcion);
				break;
				case 2:
					delete(opcion);
				break;
				}
				elegir();
			break;
			case 0:
				filtrarPorDecada();
				elegir();
			break;
			default: 
				System.out.println("Has salido.");
		}
	}*/
	
	public static void updateTienda() throws ClassNotFoundException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado=0;
		String sql = "";
		int id;
		
		//nombre, direccion
		String nombre;
		String direccion;
		
		Scanner lector = new Scanner(System.in);
		
		mostrarIdNombreTienda();
		
		System.out.println("¿Que ID quieres actualizar?");
		id = lector.nextInt();

		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																										// la
																										// dirección, el
																										// administrador
																										// y
																										// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			nombre = PedirDatos.pedirNombreTienda();
			direccion = PedirDatos.pedirDireccion();
			
			sql = "UPDATE tienda SET idTienda = '" + id + "', nombre = '" + nombre + "', direccion = '" + direccion + "' WHERE idTienda = '" + id + "';";
			System.out.println(sql);
			// System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Se ha actualizado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado \n");
	}

	public static void updateZapatillas() throws ClassNotFoundException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado=0;
		String sql = "";
		int id ;
		
		//nombre, codigoProducto, marca, precio, tienda
		
		String nombre;
		String codigoProducto;
		String marca;
		int precio;
		String tienda;
		
		Scanner lector = new Scanner(System.in);
		
		mostrarIdNombreZapatillas();
		
		System.out.println("¿Que ID quieres actualizar?");
		id = lector.nextInt();
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																										// la
																										// dirección, el
																										// administrador
																										// y
																										// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();
			
			nombre = PedirDatos.pedirNombre();
			codigoProducto = PedirDatos.pedirCodigoProducto();
			marca = PedirDatos.pedirMarca();
			precio = PedirDatos.pedirPrecio();
			
			mostrarIdNombreTienda();
			
			tienda = PedirDatos.pedirTienda();
			
			

			sql = "UPDATE zapatillas SET idZapatillas = '" + id + "', nombre = '" + nombre + "', codigoProducto = '" + codigoProducto + "', marca = '" + marca + "', precio = '" + precio + "', tienda = '" + tienda + "'  WHERE idZapatillas = '" + id + "';";
			System.out.println(sql);
			// System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Se ha actualizado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado \n");
	}
	
	//PENDIENTE HAY QUE HACERLO CON LA TABLA DEL MEDIO
	public static void deleteTienda() throws ClassNotFoundException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado=0;
		String sql = "";
		int id = 0;
		
		mostrarIdNombreTienda();
		
		Scanner lector = new Scanner(System.in);
		
		System.out.println("¿Cual quieres eliminar?");
		id = lector.nextInt();
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																										// la
																										// dirección, el
																										// administrador
																										// y
																										// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			
			sql = "DELETE FROM tienda WHERE idTienda = '" + id + "';";
			System.out.println(sql);
			// System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Se ha eliminado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado \n");
	}

	public static void deleteZapatillas() throws ClassNotFoundException {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		int resultado=0;
		String sql = "";
		int id;
		Scanner lector = new Scanner(System.in);
		
		mostrarIdNombreZapatillas();
		
		System.out.println("¿Cual quieres eliminar?");
		id = lector.nextInt();

		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos
																										// la
																										// dirección, el
																										// administrador
																										// y
																										// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			
			sql = "DELETE FROM zapatillas WHERE idZapatillas = '" + id + "';";
			System.out.println(sql);
			// System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println("Se ha eliminado bien.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				sentenciaSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado \n");
	}

	//CONSULTAS
	
	/*  6.- Ingrediente? Recetas
			  
		7.- Receta? Ingredientes
			  
		8.- Cuantas recetas
			  
		9.- Ingrediente mas usado
			  
		10.- Recetas sin ingredientes*/
	
	public static void mostrarCuantasTiendas() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int suma = 0;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT count(*) FROM tienda");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				
				suma = rs.getInt(1);
			}

			System.out.println("Hay " + suma + " tiendas guardadas.");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}

	public static void mostrarZapasSinTienda() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre ="";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT nombre FROM zapatillas WHERE tienda IS NULL;");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				
				nombre = rs.getString("nombre");
				System.out.println("Las " + nombre + " no tienen tienda asociada.");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}

	public static void buscarTienda(int numero) throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre ="";
		int id = numero;
		String direccion;
		String nombreZapatillas ="";
		

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM tienda WHERE idTienda= '" + id + "';");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			System.out.println("Tienda:");
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				id = rs.getInt("idTienda");
				
				nombre = rs.getString("nombre");
				
				direccion = rs.getString("direccion");
				
				System.out.println(id + " | " + nombre + " | " + direccion + " | ");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}

	public static void buscarZapatillas(int numero) throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre ="";
		int id ;
		int idZapatillas;
		int tienda= numero;
		String nombreZapatillas ="";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM zapatillas WHERE tienda= '" + tienda + "';");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			System.out.println("Zapatillas:");
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				idZapatillas = rs.getInt("idZapatillas");
				
				nombreZapatillas = rs.getString("nombre");
				
				tienda = rs.getInt("tienda");
				
				
				System.out.println(idZapatillas + " | " + nombreZapatillas + " | Tienda: " + tienda);
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}

	public static void filtrarZapatillas() throws ClassNotFoundException {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		String nombre ="";
		int id ;
		int idZapatillas;
		int tienda;
		String nombreZapatillas ="";
		String codigoProducto;
		String marca;
		int precio;
		//(idZapatillas, nombre, codigoProducto, marca, precio, tienda)

		Scanner lector = new Scanner(System.in);
		
		BaseDatos.mostrarIdNombreZapatillas();
		
		System.out.println("¿Que zapatillas quieres ver?");
		id = lector.nextInt();
		
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/practica", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			ResultSet rs = sentenciaSQL.executeQuery("SELECT * FROM zapatillas WHERE idZapatillas= '" + id + "';");
			// chequeo que el result set no sea vacío, moviendo el cursor a la
			// primer fila. (El cursor inicia antes de la primer fila)
			System.out.println("Zapatillas:");
			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				idZapatillas = rs.getInt("idZapatillas");
				
				nombreZapatillas = rs.getString("nombre");
				
				codigoProducto = rs.getString("codigoProducto");
						
				marca = rs.getString("marca");
				
				precio = rs.getInt("precio");
				
				tienda = rs.getInt("tienda");
				
				
				System.out.println(idZapatillas + " | " + nombreZapatillas + " | " + codigoProducto + " | " + marca + " | " + precio + "€ | Tienda: " + tienda);
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//System.out.println("Conectado/desconectado");

	}
}
