package registros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import animales.Cabra;


public class RegistroDeCabra {
	static long numeroDeCabra=0;
	static Scanner input;
	static long totalDeCabras;
	static Cabra cabra[];
	static float mLeche = 0;
	
	//Este metodo es para saber cuantas vacas fueron ingresadas al archivo
	static void numeroDeCabras() throws Exception{
		      Path inputCabra = Paths.get("inputCabras.txt");
		      totalDeCabras = Files.lines(inputCabra).count();
	}
	
	//Este metodo esta leyendo los datos de las vacas
	
	static void leeDatos() throws FileNotFoundException {
		byte   edad, mesDelProducto;
		float litrosDeLeche;
		String codigoRegistro, fechaAdquisicion, raza;
		int   yearDelProducto;
		cabra = new Cabra[(int) totalDeCabras];
		
		input=new Scanner(new FileInputStream("inputCabras.txt"));
		input.useDelimiter(";");
		
		while(input.hasNext()) {
			
			codigoRegistro = input.next();
			edad = input.nextByte();
			fechaAdquisicion = input.next();
			raza = input.next();
			yearDelProducto =input.nextInt();
			mesDelProducto = input.nextByte();
			litrosDeLeche = input.nextFloat();
			cabra[(int) numeroDeCabra] = new Cabra( codigoRegistro, edad, fechaAdquisicion, 
					 		raza,  yearDelProducto,  mesDelProducto, litrosDeLeche);
			numeroDeCabra++;
		}
		input.close();
	}
	
	//Metodo para saber las Cantidades totales de leche
	
	static int cantidadTotalSemanal() {
		 int productoTotal = 0;
		for(int i=0; i<totalDeCabras; i++) {
			productoTotal+=cabra[i].getLitroDeLeche();
		}
		return productoTotal;
	}
	
	//Metodo para saber el promedio de litros por semana

	static int cantidadLecheProm() {
		int promedioSemanalCabra;
		promedioSemanalCabra= cantidadTotalSemanal()/7;
		return promedioSemanalCabra;
	}
	
	//Metodo para saber cual es la vaca con mayor produccion en la semana
	static String calculaMaxLeche() {
		float maxLeche = cabra[0].getLitroDeLeche();
		String codigoDeMaxLeche = null;
		for(int i=1;i<totalDeCabras;i++)
			if(cabra[i].getLitroDeLeche()>maxLeche) {
				codigoDeMaxLeche=cabra[i].getCodigoRegistro();
				mLeche = maxLeche;
			}
		return codigoDeMaxLeche;
	}
	//Metodo mostrar datos
	
	static void mostrarDatos() {
		System.out.println("   -----REGISTRO CABRAS-----  ");
		System.out.println(" La cantidad Total de litros esta semana fue: \n"+ cantidadTotalSemanal());
		System.out.println("\n La cabra con mayor cantidad producidad es: "+ calculaMaxLeche()+" con "+mLeche+" Litros ");
		System.out.println("\n El promedio de leche producidad esta semana es: \n"+ cantidadLecheProm());
		System.out.println("+----------------------------------------------------------------------------------+");
	}
	
	//Metodo Run para porcesar nuestro programa
	public void runCabra() throws Exception {
		numeroDeCabras();
		leeDatos();
		mostrarDatos();
	}
}
